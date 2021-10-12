/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.List;

// Help the user to view the libraries photos
public class ViewLibraryPhotos extends JFrame {

    private JLabel photographLabel = new JLabel();
    private JToolBar buttonBar = new JToolBar();

    private String imagedir = "images/";

    private MissingIcon placeholderIcon = new MissingIcon();

    // EFFECTS: List of all the descriptions of the image files. These correspond one to
    // one with the image file names
    private String[] imageCaptions = {"Asian Library", "Biomedical Branch Library",
            "David Lam Library", "Education Library", "Irving K.Barber Learning Center", "Koerner Library",
            "Law Library", "Woodward Library", "Xwi7xwa Library"};

    // EFFECTS: List of all the image files to load.
    private String[] imageFileNames = {"Asian_Library.jpg", "Biomedical_Branch_Library.jpg",
            "David-Lam-Library.jpg", "Education-Library.jpg", "IKB.jpg", "Koerner-Library.jpg",
            "Law-Library.jpg", "Woodward-Library.jpg", "Xwi7xwa-Library.jpg"};


    // EFFECTS: Default constructor for the demo.
    public ViewLibraryPhotos() {

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setTitle("You can click and view the libraries");

        // A label for displaying the pictures
        photographLabel.setVerticalTextPosition(JLabel.BOTTOM);
        photographLabel.setHorizontalTextPosition(JLabel.CENTER);
        photographLabel.setHorizontalAlignment(JLabel.CENTER);
        photographLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // We add two glue components. Later in process() we will add thumbnail buttons
        // to the toolbar inbetween thease glue compoents. This will center the
        // buttons in the toolbar.
        buttonBar.add(Box.createGlue());
        buttonBar.add(Box.createGlue());

        add(buttonBar, BorderLayout.SOUTH);
        add(photographLabel, BorderLayout.CENTER);

        setSize(820, 800);

        // this centers the frame on the screen
        setLocationRelativeTo(null);

        // start the image loading SwingWorker in a background thread
        loadimages.execute();
    }

    // EFFECTS: SwingWorker class that loads the images a background thread and calls publish
    // when a new one is ready to be displayed.
    private SwingWorker<Void, ThumbnailAction> loadimages = new SwingWorker<Void, ThumbnailAction>() {

        // EFFECTS: Creates full size and thumbnail versions of the target image files.
        @Override
        protected Void doInBackground() throws Exception {
            for (int i = 0; i < imageCaptions.length; i++) {
                ImageIcon icon;
                icon = createImageIcon(imagedir + imageFileNames[i], imageCaptions[i]);

                ThumbnailAction thumbAction;
                if (icon != null) {

                    ImageIcon thumbnailIcon = new ImageIcon(getScaledImage(icon.getImage(), 32, 32));

                    thumbAction = new ThumbnailAction(icon, thumbnailIcon, imageCaptions[i]);

                } else {
                    // the image failed to load for some reason
                    // so load a placeholder instead
                    thumbAction = new ThumbnailAction(placeholderIcon, placeholderIcon, imageCaptions[i]);
                }
                publish(thumbAction);
            }
            // unfortunately we must return something, and only null is valid to
            // return when the return type is void.
            return null;
        }

        // EFFECTS: Process all loaded images.
        @Override
        protected void process(List<ThumbnailAction> chunks) {
            for (ThumbnailAction thumbAction : chunks) {
                JButton thumbButton = new JButton(thumbAction);
                // add the new button BEFORE the last glue
                // this centers the buttons in the toolbar
                buttonBar.add(thumbButton, buttonBar.getComponentCount() - 1);
            }
        }
    };

    // EFFECTS: Creates an ImageIcon if the path is valid.
    protected ImageIcon createImageIcon(String path,
                                        String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    // EFFECTS: Resizes an image using a Graphics2D object backed by a BufferedImage.
    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }

    // Action class that shows the image specified in it's constructor.
    private class ThumbnailAction extends AbstractAction {

         // The icon if the full image we want to display.
        private Icon displayPhoto;

        // EFFECTS: Shows the image specified in it's constructor.
        public ThumbnailAction(Icon photo, Icon thumb, String desc) {
            displayPhoto = photo;

            // The short description becomes the tooltip of a button.
            putValue(SHORT_DESCRIPTION, desc);

            // The LARGE_ICON_KEY is the key for setting the
            // icon when an Action is applied to a button.
            putValue(LARGE_ICON_KEY, thumb);
        }

        // EFFECTS: Shows the full image in the main area and sets the application title.
        public void actionPerformed(ActionEvent e) {
            photographLabel.setIcon(displayPhoto);
            setTitle("Icon Demo: " + getValue(SHORT_DESCRIPTION).toString());
        }
    }
}
