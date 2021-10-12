package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Construct a library booking confirmation frame
public class ConfirmLibrary extends JFrame implements ActionListener {
    JLabel label;

    // EFFECTS: Construct a library booking confirmation frame
    public ConfirmLibrary() {
        super("Booking In Process");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(420, 60));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(2, 2, 2, 2));
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new FlowLayout());
        label = new JLabel("Library Chosen! Please Go To Choose Your Booking Timeslot :D");
        panel.add(label);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);

    }

    @Override
    // EFFECTS: Take action if the action event was detected
    public void actionPerformed(ActionEvent e) {
        //
    }
}
