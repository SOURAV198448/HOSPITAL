package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AmbulanceDetails extends JFrame implements ActionListener {

    JButton btnAllAmbulance, btnBooking, btnBack;

    public AmbulanceDetails() {
        setTitle("Ambulance Details");
        setLayout(null);
        getContentPane().setBackground(new Color(122, 243, 226));
        setUndecorated(true);
        setSize(500, 400);
        setLocationRelativeTo(null);

        JLabel heading = new JLabel("AMBULANCE ALL DETAILS");
        heading.setBounds(100, 30, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.BLACK);
        add(heading);

        btnAllAmbulance = new JButton("All Ambulance Details");
        btnAllAmbulance.setBounds(140, 100, 200, 30);
        btnAllAmbulance.setBackground(new Color(58, 131, 243));
        btnAllAmbulance.setForeground(Color.BLACK);
        btnAllAmbulance.addActionListener(this);
        btnAllAmbulance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance();
            }
        });
        add(btnAllAmbulance);

        btnBooking = new JButton("Ambulance Booking");
        btnBooking.setBounds(140, 150, 200, 30);
        btnBooking.setBackground(new Color(58,131,243));
        btnBooking.setForeground(Color.BLACK);
        btnBooking.addActionListener(this);
        btnBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance_book();
            }
        });
        add(btnBooking);

        btnBack = new JButton("Back");
        btnBack.setBounds(190, 210, 100, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.addActionListener(this);
        add(btnBack);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnBack) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AmbulanceDetails();
    }
}