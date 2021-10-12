package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class ChoosingTimeSlot extends JFrame implements ActionListener {
    private JLabel labelGuide;
    private JTextField text;
    private String userInput;
    private String chosenLibrary;

    // EFFECTS: Construct a timeslot choosing frame
    public ChoosingTimeSlot() {
        super("Time Slot Choosing");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(250, 250));
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

    // EFFECTS: Add the button based on the given text to the given container
    private void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
        button.setActionCommand(text);
        button.addActionListener(this);
    }

    // EFFECTS: Add the components to the given container
    public void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        labelGuide = new JLabel("Type In Your Prefer Timeslot");
        labelGuide.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(labelGuide);

        addAButton("Type 0 to choose 9:00 - 12:00", pane);
        addAButton("Type 1 to choose 12:00 - 14:00", pane);
        addAButton("Type 2 to choose 14:00 - 16:00", pane);
        addAButton("Type 3 to choose 16:00 - 18:00", pane);
        addAButton("Type 4 to choose 18:00 - 20:00", pane);
        addAButton("Confirm", pane);
    }

    @Override
    // EFFECTS: Take action according to the action event.
    // MODIFIES: this
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Confirm")) {
            userInput = text.getText();
            InformationManager info = null;
            chosenLibrary = BookAPlace.chosenLibrary;
            try {
                InformationManager.setChosenLibraryName(chosenLibrary);
                info = new InformationManager(userInput);
                info.parseInputView();
                new ConfirmTimeSlot();
            } catch (FileNotFoundException exception) {
                System.out.println("Unable to run application: file not found");
            }
        }
    }
}
