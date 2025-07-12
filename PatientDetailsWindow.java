package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientDetailsWindow extends JFrame {

    public PatientDetailsWindow() {
        setTitle("Patient All Details");
        setUndecorated(true);
        setSize(500, 370);
        setBounds(5,5,550,370);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(122, 243, 226));
        panel.setBounds(5,5,550,370);
        panel.setLayout(null);

        JLabel labelName = new JLabel("ALL PATIENT DETAILS");
        labelName.setBounds(150, 0, 260, 50);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelName.setForeground(Color.black);
        panel.add(labelName);


        JButton btnAdd = new JButton("New Patient Add Form");
        btnAdd.setBounds(30, 60, 200, 40);
        btnAdd.setBackground(new Color(58,131,243));
        btnAdd.setForeground(Color.BLACK);
        panel.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NEW_PATIENT();
            }
        });

        JButton btnInfo = new JButton("All Patient Info");
        btnInfo.setBounds(250, 60, 200, 40);
        btnInfo.setBackground(new Color(58,131,243));
        btnInfo.setForeground(Color.BLACK);
        panel.add(btnInfo);
        btnInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new All_Patient_Info();
            }
        });

        JButton btnDischarge = new JButton("Patients Discharge");
        btnDischarge.setBounds(30, 150, 200, 40);
        btnDischarge.setBackground(new Color(58,131,243));
        btnDischarge.setForeground(Color.BLACK);
        panel.add(btnDischarge);
        btnDischarge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_discharge();
            }
        });

        JButton btnUpdate = new JButton("Update Patient Details");
        btnUpdate.setBounds(250, 150, 200, 40);
        btnUpdate.setBackground(new Color(58,131,243));
        btnUpdate.setForeground(Color.BLACK);
        panel.add(btnUpdate);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new update_patient_details();
            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(180, 250, 140, 35);
        btnBack.setBackground(Color.black);
        btnBack.setForeground(Color.white);
        panel.add(btnBack);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PatientDetailsWindow();
    }
}