package ui;

import studyplace.library.AbstractLibrary;
import studyplace.store.Booking;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// Construct a Search Panel for the user to search the library they booked and get the booked timeslots back
public class Search extends JFrame implements ActionListener {
    private JLabel labelGuide;
    private JTextField text;
    private String userInput;
    private Booking booking;
    public static List<String> searchedTimeSlots;

    // EFFECTS: Construct a Search Panel for the user to search the library they booked and
    // get the booked timeslots back
    public Search() {
        super("Search Booking");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(200, 200));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(2, 2, 2, 2));

        JSplitPane panel = new JSplitPane();
        add(panel);
        panel.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        panel.setDividerLocation(250);
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        panel.setTopComponent(topPanel);
        panel.setBottomComponent(bottomPanel);
        text = new JTextField(10);
        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(text);
        addComponentsToPane(topPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);

    }

    // EFFECTS: Add the components to the given container
    public void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        labelGuide = new JLabel("Type In Library Name");
        labelGuide.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(labelGuide);
        addAButton("Confirm", pane);
    }

    // EFFECTS: Add the button based on the given text to the given container
    private void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
        button.setActionCommand(text);
        button.addActionListener(this);
    }


    // EFFECTS: removes white space and quotation marks around s
    // MODIFIES: this
    private String makePrettyString(String s) {
        s = s.toLowerCase();
        s = s.trim();
        s = s.replaceAll("\"|\'", "");
        return s;
    }


    @Override
    // EFFECTS: take actions according to the action events
    // MODIFIES: this
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Confirm")) {
            userInput = text.getText();
            booking = BookingApp.booking;
            for (AbstractLibrary abstractLibrary : booking.getLibraries()) {
                if (makePrettyString(abstractLibrary.getName()).equals(makePrettyString(userInput))) {
                    searchedTimeSlots = abstractLibrary.getBookedTimeSlots();
                }
            }
            new SearchedResult();
        }
    }
}
