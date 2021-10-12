package ui;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

// Construct a load frame
public class Load extends JFrame implements ActionListener {
    JLabel label;

    // EFFECTS: Construct a load frame
    public Load() {
        super("Load Your Status");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(200, 60));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(2, 2, 2, 2));
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new FlowLayout());
        label = new JLabel("Status Loaded Successfully");
        panel.add(label);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Load Your Status")) {
            try {
                BookingApp app = new BookingApp();
                app.processCommand("load");

            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();

            }
        }

    }
}
