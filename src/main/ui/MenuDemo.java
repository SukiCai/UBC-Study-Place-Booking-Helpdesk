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
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

public class MenuDemo extends JFrame implements ActionListener {
    JTextArea output;
    JScrollPane scrollPane;
    private static JLabel labelImage;
    private static ImageIcon imageIcon;
    JMenuBar menuBar = new JMenuBar();
    ButtonGroup group = new ButtonGroup();
    JMenu menu;
    JRadioButtonMenuItem rbMenuItem;


    // EFFECTS: Draw A MenuBar
    public JMenuBar createMenuBar() {
        buildFirstMenu();

        buildSecondMenu();

        buildThirdMenu();

        buildFourthMenu();

        buildFifthMenu();

        return menuBar;
    }

    // EFFECTS: Build "Book A Place" as the first Menu in the Menu Bar
    // MODIFIES: this
    public void buildFirstMenu() {
        //Build the first menu.
        menu = new JMenu("Book A Place");
        menu.setMnemonic(KeyEvent.VK_A);
        menuBar.add(menu);

        menu.addSeparator();
        ButtonGroup group = new ButtonGroup();

        rbMenuItem = new JRadioButtonMenuItem("Book A Library");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        rbMenuItem.addActionListener(this);
        menu.add(rbMenuItem);
    }

    // EFFECTS: Build "Find A Place" as the second Menu in the Menu Bar
    // MODIFIES: this
    public void buildSecondMenu() {
        //Build second menu in the menu bar.
        menu = new JMenu("Find A Place");
        menu.setMnemonic(KeyEvent.VK_N);
        menuBar.add(menu);

        menu.addSeparator();
        ButtonGroup group2 = new ButtonGroup();

        rbMenuItem = new JRadioButtonMenuItem("View Library Photos");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group2.add(rbMenuItem);
        rbMenuItem.addActionListener(this);
        menu.add(rbMenuItem);

    }

    // EFFECTS: Build "View Status" as the third Menu in the Menu Bar
    // MODIFIES: this
    public void buildThirdMenu() {
        menu = new JMenu("View Status");
        menu.setMnemonic(KeyEvent.VK_N);
        menuBar.add(menu);

        rbMenuItem = new JRadioButtonMenuItem("Load Previous Booking Status");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        rbMenuItem.addActionListener(this);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Save Your Booking Status");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(rbMenuItem);
        rbMenuItem.addActionListener(this);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("View Your Booking Status");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(rbMenuItem);
        rbMenuItem.addActionListener(this);
        menu.add(rbMenuItem);
    }

    // EFFECTS: Build "Search" as the forth Menu in the Menu Bar
    // MODIFIES: this
    public void buildFourthMenu() {
        menu = new JMenu("Search");
        menu.setMnemonic(KeyEvent.VK_N);
        menuBar.add(menu);

        rbMenuItem = new JRadioButtonMenuItem("Search Your Booking");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        rbMenuItem.addActionListener(this);
        menu.add(rbMenuItem);
    }



    // EFFECTS: Build The "Play Music" Menu as the fifth menu in the Menu Bar
    // MODIFIES: this
    public void buildFifthMenu() {
        menu = new JMenu("Play Music");
        menu.setMnemonic(KeyEvent.VK_N);
        menuBar.add(menu);

        rbMenuItem = new JRadioButtonMenuItem("Click To Play");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        rbMenuItem.addActionListener(this);
        menu.add(rbMenuItem);
    }

    // EFFECTS: Create A Pane with Content
    public Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);

        //Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);

        //Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER);

        return contentPane;
    }

    // EFFECTS: Play the background music for the user
    public void playSound(String soundName) {
        try {
            File file = new File(soundName).getAbsoluteFile();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    // EFFECTS: Take Action According to the ActionEvent
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Book A Library")) {
            new BookAPlace();
        }

        if (e.getActionCommand().equals("View Library Photos")) {
            ViewLibraryPhotos app = new ViewLibraryPhotos();
            app.setVisible(true);
        }

        actionPerformViewStatus(e);

        if (e.getActionCommand().equals("Search Your Booking")) {
            new Search();
        }

        if (e.getActionCommand().equals("Click To Play")) {
            playSound("/Users/sukicai/Desktop/old/CPSC210/project_x1k3b（2）/data/background1.wav");
        }


    }

    // EFFECTS: take action according to the action event in view status menu
    private void actionPerformViewStatus(ActionEvent e) {
        if (e.getActionCommand().equals("Load Previous Booking Status")) {
            try {
                BookingApp bookingApp = new BookingApp();
                bookingApp.processCommand("load");
                new Load();
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            }
        }

        if (e.getActionCommand().equals("Save Your Booking Status")) {
            InformationManager.bookingApp.processCommand("save");
            new Save();
        }

        if (e.getActionCommand().equals("View Your Booking Status")) {
            new ViewStatus();
        }
    }

    // EFFECTS: Create the GUI and show it.  For thread safety, this method should be invoked from the
    // event-dispatching thread.
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("MenuDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        MenuDemo demo = new MenuDemo();
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(demo.createContentPane());

        imageIcon = new ImageIcon(MenuDemo.class.getResource("./images/front.jpg"));
        labelImage = new JLabel(imageIcon);
        frame.add(labelImage);
        frame.add(labelImage);

        //Display the window.
        frame.setSize(1024, 580);
        frame.setVisible(true);
    }

    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
