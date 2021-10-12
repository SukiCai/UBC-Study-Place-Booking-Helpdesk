package ui;

import studyplace.library.AbstractLibrary;
import studyplace.store.Booking;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// Construct a view booking status panel that provide the user to view the booked libraries and timeslots
public class ViewStatus extends JFrame implements ActionListener {
    private JPanel topOuterPane;
    private JScrollPane topPane;
    private DefaultListModel listModel;
    private JList<DefaultListModel> visualList;
    private Booking booking;
    private List<AbstractLibrary> libraries;

    // EFFECTS: Construct a view booking status panel that provide the user to view the booked libraries and timeslots
    public ViewStatus() {
        super("Your Booking Status");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(300, 300));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(2, 2, 2, 2));
        topOuterPane = new JPanel();
        add(topOuterPane);
        topOuterPane.setLayout(new BorderLayout());
        topPane = new JScrollPane();
        this.listModel = new DefaultListModel();
        booking = BookingApp.booking;
        libraries = booking.getLibraries();
        for (AbstractLibrary lib : libraries) {
            listModel.addElement(lib);
        }
        visualListModified();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
    }

    private void visualListModified() {
        visualList = new JList(listModel);
        visualList.setVisibleRowCount(-1);
        visualList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        visualList.setVisible(true);
        topPane.setViewportView(visualList);
        topOuterPane.add(topPane, BorderLayout.CENTER);
    }


    @Override
    // EFFECTS: take action according to the action event
    public void actionPerformed(ActionEvent e) {
        //
    }

}
