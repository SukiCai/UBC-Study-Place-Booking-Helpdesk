package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;


public class BookAPlace extends JFrame implements ActionListener {
    private JLabel labelImage;
    private ImageIcon image1;
    private JTextField text;
    private JLabel label1;
    public String userInput1;

    public static String chosenLibrary;

    // EFFECTS: make a button based on the given text to the given container
    private void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
        button.setActionCommand(text);
        button.addActionListener(this);
    }

    // EFFECTS: add the components to the given container
    public void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        label1 = new JLabel("Type in Your Library");
        pane.add(label1);
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        text = new JTextField(10);
        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(text);
        addAButton("Confirm", pane);
        addAButton("Asian Library", pane);
        addAButton("Biomedical Branch Library", pane);
        addAButton("David Lam Library", pane);
        addAButton("Education Library", pane);
        addAButton("Irving K Barber Learning Center", pane);
        addAButton("Koerner Library", pane);
        addAButton("Law Library", pane);
        addAButton("Woodward Library", pane);
        addAButton("Xwi7wa Library", pane);
        addAButton("Choose Booking TimeSlot", pane);
    }

    // EFFECTS: Construct a Book Frame.
    public BookAPlace() {
        super("UBC Study Place Helpdesk");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(1100, 650));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(2, 2, 2, 2));

        JSplitPane panel = new JSplitPane();
        add(panel);
        panel.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        panel.setDividerLocation(250);
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        panel.setTopComponent(topPanel);
        panel.setBottomComponent(bottomPanel);

        addComponentsToPane(topPanel);

        setLayout(new FlowLayout());
        image1 = new ImageIcon(getClass().getResource("./images/sukicai.jpg"));
        labelImage = new JLabel(image1);
        bottomPanel.add(labelImage);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);

    }

    // EFFECTS: removes white space and quotation marks around s
    // MODIFIES: this
    private String makePrettyString(String s) {
        s = s.toLowerCase();
        s = s.trim();
        s = s.replaceAll("\"|\'", "");
        return s;
    }

    // EFFECTS: The method that is called when the the JButton btn is clicked
    // MODIFIES: this
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Confirm")) {
            InformationManager info = null;
            try {
                userInput1 = text.getText();
                info = new InformationManager(makePrettyString(userInput1));
                chosenLibrary = makePrettyString(userInput1);
                new ConfirmLibrary();
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            }
        }

        if (e.getActionCommand().equals("Choose Booking TimeSlot")) {
            new ChoosingTimeSlot();
        }
    }



}
