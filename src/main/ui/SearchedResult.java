package ui;

import studyplace.library.AbstractLibrary;
import studyplace.store.Booking;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// Construct a SearchedResult panel that show the user the result of the search
public class SearchedResult extends JFrame implements ActionListener {
    private JPanel topOuterPane;
    private JScrollPane topPane;
    private DefaultListModel listModel;
    private JList<DefaultListModel> visualList;
    private List<String> timeSlots;

    // EFFECTS: Construct a SearchedResult panel that show the user the result of the search
    public SearchedResult() {
        super("Your Booked TimeSlots");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(300, 200));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(2, 2, 2, 2));

        topOuterPane = new JPanel();
        add(topOuterPane);
        topOuterPane.setLayout(new BorderLayout());
        topPane = new JScrollPane();
        this.listModel = new DefaultListModel();

        timeSlots = Search.searchedTimeSlots;
        for (String timeSlot : timeSlots) {
            listModel.addElement(timeSlot);
        }

        visualList = new JList(listModel);
        visualList.setVisibleRowCount(-1);
        visualList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        visualList.setVisible(true);
        topPane.setViewportView(visualList);
        topOuterPane.add(topPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
    }

    @Override
    // EFFECTS: take action according to the action event.
    public void actionPerformed(ActionEvent e) {
        //
    }
}
