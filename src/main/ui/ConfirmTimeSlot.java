package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Construct a time slot chosen confirmation frame
public class ConfirmTimeSlot extends JFrame implements ActionListener {
    JLabel label;

    // EFFECTS: Construct a time slot chosen confirmation frame
    public ConfirmTimeSlot() {
        super("Congratulations");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(200, 60));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(2, 2, 2, 2));
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new FlowLayout());
        label = new JLabel("Booked Successfully!!!");
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
