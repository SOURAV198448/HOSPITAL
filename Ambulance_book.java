package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Ambulance_book extends JFrame implements ActionListener {

    JTextField tfName, tfAddress, tfPhone;
    JComboBox<String> cbAmbulanceNumber;
    JButton submit, cancel;

    public Ambulance_book() {

       setUndecorated(true);
        setSize(700, 400);
        setLocation(300, 200);
        setLayout(null);
        getContentPane().setBackground(new Color(27, 195, 172));

        JLabel heading = new JLabel("AMBULANCE BOOKING FORM");
        heading.setBounds(190, 20, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.black);
        add(heading);

        JLabel lblName = new JLabel("PATIENT NAME:");
        lblName.setBounds(60, 80, 150, 25);
        lblName.setForeground(Color.black);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(230, 80, 200, 25);
        add(tfName);

        JLabel lblAddress = new JLabel("ADDRESS:");
        lblAddress.setBounds(60, 120, 150, 25);
        lblAddress.setForeground(Color.black);
        lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(230, 120, 200, 25);
        add(tfAddress);

        JLabel lblPhone = new JLabel("PHONE NUMBER:");
        lblPhone.setBounds(60, 160, 150, 25);
        lblPhone.setForeground(Color.black);
        lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(230, 160, 200, 25);
        add(tfPhone);

        JLabel lblAmbulance = new JLabel("AMBULANCE NUMBER:");
        lblAmbulance.setBounds(60, 200, 200, 25);
        lblAmbulance.setForeground(Color.black);
        lblAmbulance.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblAmbulance);

        cbAmbulanceNumber = new JComboBox<>();
        cbAmbulanceNumber.setBounds(230, 200, 200, 25);
        add(cbAmbulanceNumber);


        try {
            data c = new data();
            ResultSet resultSet = c.statement.executeQuery("SELECT Car_Number FROM ambulance");
            while (resultSet.next()) {
                cbAmbulanceNumber.addItem(resultSet.getString("Car_Number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        submit = new JButton("SUBMIT");
        submit.setBounds(190, 270, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 13));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBounds(340, 270, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 13));
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfName.getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String ambulance = (String) cbAmbulanceNumber.getSelectedItem();

            if (name.isEmpty() || address.isEmpty() || phone.isEmpty() || ambulance == null) {
                JOptionPane.showMessageDialog(null, "Please fill all fields.");
                return;
            }

            try {
                data c = new data();
                Connection conn = c.connection;
                
                String checkQuery = "SELECT Available FROM ambulance WHERE Car_Number = ?";
                PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
                checkStmt.setString(1, ambulance);
                ResultSet resultSet = checkStmt.executeQuery();

                if (resultSet.next()) {
                    String available = resultSet.getString("Available");
                    if ("Not Available".equalsIgnoreCase(available)) {
                        JOptionPane.showMessageDialog(null, "This ambulance is already booked.");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ambulance not found in database.");
                    return;
                }

                String insertQuery = "INSERT INTO ambulance_booking(patient_name, address, phone_number, ambulance_number) VALUES (?, ?, ?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setString(1, name);
                insertStmt.setString(2, address);
                insertStmt.setString(3, phone);
                insertStmt.setString(4, ambulance);
                insertStmt.executeUpdate();

                String updateQuery = "UPDATE ambulance SET Available = 'Not Available' WHERE Car_Number = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                updateStmt.setString(1, ambulance);
                updateStmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Ambulance booked successfully.");
                tfName.setText("");
                tfAddress.setText("");
                tfPhone.setText("");

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error");
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }

        }
        public static void main(String[] args) {
        new Ambulance_book();
    }
}