package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Build The Save Frame
public class Save extends JFrame implements ActionListener {
    JLabel label;

    // EFFECTS: Build The Save Frame
    public Save() {
        super("Save Your Status");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(200, 60));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(2, 2, 2, 2));
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new FlowLayout());
        label = new JLabel("Status Saved Successfully");
        panel.add(label);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);

    }


    // EFFECTS: Take action according to the action event
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Save Your Status")) {
            InformationManager.bookingApp.processCommand("save");
        }
    }
}
