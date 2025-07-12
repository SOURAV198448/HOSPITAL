package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BillInvoice extends JFrame implements ActionListener {

    JTextField tfPatientName, tfRoomCharge, tfMedicineCharge, tfLabCharge, tfOtherCharge;
    JButton btnGenerate, btnClear;
    JTextArea billArea;

    public BillInvoice() {
        setTitle("Patient Bill Invoice");
        setUndecorated(true);
        setSize(600, 600);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(new Color(27, 195, 172));

        JLabel lblTitle = new JLabel("HOSPITAL BILL INVOICE");
        lblTitle.setBounds(180, 10, 300, 30);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblTitle);

        JLabel lblPatient = new JLabel("PATIENT NAME:");
        lblPatient.setBounds(50, 60, 150, 30);

        add(lblPatient);

        tfPatientName = new JTextField();
        tfPatientName.setBounds(200, 60, 200, 30);
        add(tfPatientName);

        JLabel lblRoom = new JLabel("ROOM CHARGES:");
        lblRoom.setBounds(50, 100, 150, 30);
        add(lblRoom);

        tfRoomCharge = new JTextField();
        tfRoomCharge.setBounds(200, 100, 200, 30);
        add(tfRoomCharge);

        JLabel lblMedicine = new JLabel("MEDICINE CHARGES:");
        lblMedicine.setBounds(50, 140, 150, 30);
        add(lblMedicine);

        tfMedicineCharge = new JTextField();
        tfMedicineCharge.setBounds(200, 140, 200, 30);
        add(tfMedicineCharge);

        JLabel lblLab = new JLabel("LAB TEST CHARGES:");
        lblLab.setBounds(50, 180, 150, 30);
        add(lblLab);

        tfLabCharge = new JTextField();
        tfLabCharge.setBounds(200, 180, 200, 30);
        add(tfLabCharge);

        JLabel lblOther = new JLabel("OTHER CHARGES:");
        lblOther.setBounds(50, 220, 150, 30);
        add(lblOther);

        tfOtherCharge = new JTextField();
        tfOtherCharge.setBounds(200, 220, 200, 30);
        add(tfOtherCharge);

        btnGenerate = new JButton("Generate Bill");
        btnGenerate.setBounds(100, 270, 150, 30);
        btnGenerate.addActionListener(this);
        btnGenerate.setBackground(Color.BLACK);
        btnGenerate.setForeground(Color.white);
        add(btnGenerate);

        btnClear = new JButton("Clear");
        btnClear.setBounds(270, 270, 100, 30);
        btnClear.addActionListener(this);
        btnClear.setBackground(Color.BLACK);
        btnClear.setForeground(Color.white);
        add(btnClear);

        JButton button = new JButton("BACK");
        button.setBounds(390,270,100,30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        billArea = new JTextArea();
        billArea.setBounds(50, 320, 480, 200);
        billArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(billArea);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnGenerate) {
            String name = tfPatientName.getText();
            double room = Double.parseDouble(tfRoomCharge.getText());
            double medicine = Double.parseDouble(tfMedicineCharge.getText());
            double lab = Double.parseDouble(tfLabCharge.getText());
            double other = Double.parseDouble(tfOtherCharge.getText());
            double total = room + medicine + lab + other;
            try {
                data db = new data(); //
                String query = "INSERT INTO patient_bills(patient_name, room_charges, medicine_charges, lab_charges, other_charges, total_amount) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = db.connection.prepareStatement(query);
                ps.setString(1, name);
                ps.setDouble(2, room);
                ps.setDouble(3, medicine);
                ps.setDouble(4, lab);
                ps.setDouble(5, other);
                ps.setDouble(6, total);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Bill saved successfully to database!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
            }


            StringBuilder bill = new StringBuilder();
            bill.append("---------- HOSPITAL BILL ----------\n");
            bill.append("Patient Name: ").append(name).append("\n");
            bill.append("-----------------------------------\n");
            bill.append(String.format("Room Charges      : ₹%.2f\n", room));
            bill.append(String.format("Medicine Charges  : ₹%.2f\n", medicine));
            bill.append(String.format("Lab Test Charges  : ₹%.2f\n", lab));
            bill.append(String.format("Other Charges     : ₹%.2f\n", other));
            bill.append("-----------------------------------\n");
            bill.append(String.format("TOTAL BILL        : ₹%.2f\n", total));
            bill.append("-----------------------------------");

            billArea.setText(bill.toString());

        } else if (ae.getSource() == btnClear) {
            tfPatientName.setText("");
            tfRoomCharge.setText("");
            tfMedicineCharge.setText("");
            tfLabCharge.setText("");
            tfOtherCharge.setText("");
            billArea.setText("");
        }
    }

    public static void main(String[] args) {
        new BillInvoice();
    }
}
