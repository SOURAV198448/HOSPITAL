package hospital.management.system;

import  javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Expression;
import java.sql.ResultSet;
import java.util.Date;

public class NEW_PATIENT extends javax.swing.JFrame implements ActionListener {
    JComboBox combobox;
    JTextField textfieldNumber, textName, textFieldFieldDisease, textFieldDeposite;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    JButton b1, b2;


    NEW_PATIENT() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(27, 195, 172));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon1);
        imageLabel.setBounds(550, 150, 200, 200);
        panel.add(imageLabel);

        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelName.setForeground(Color.BLACK);

        panel.add(labelName);

        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(35, 76, 200, 14);
        labelID.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelID.setForeground(Color.BLACK);
        panel.add(labelID);

        combobox = new JComboBox(new String[]{"Aadhar Card", "Voter Id", "Driving License"});
        combobox.setBounds(271, 73, 150, 20);
        combobox.setBackground(Color.white);
        combobox.setForeground(Color.black);
        combobox.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(combobox);

        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setBounds(35, 111, 200, 14);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelNumber.setForeground(Color.BLACK);
        panel.add(labelNumber);

        textfieldNumber = new JTextField();
        textfieldNumber.setBounds(271, 111, 150, 20);
        panel.add(textfieldNumber);

        JLabel labelName1 = new JLabel("Name :");
        labelName1.setBounds(35, 151, 200, 14);
        labelName1.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelName1.setForeground(Color.BLACK);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(271, 151, 150, 20);
        panel.add(textName);

        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35, 191, 200, 14);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelGender.setForeground(Color.BLACK);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 14));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(109, 164, 170));
        r1.setBounds(271, 191, 80, 15);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 14));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(109, 164, 170));
        r2.setBounds(355, 191, 80, 15);
        panel.add(r2);


        JLabel labelDisease = new JLabel("Disease :");
        labelDisease.setBounds(35, 231, 200, 14);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDisease.setForeground(Color.BLACK);
        panel.add(labelDisease);

        textFieldFieldDisease = new JTextField();
        textFieldFieldDisease.setBounds(271, 231, 150, 20);
        panel.add(textFieldFieldDisease);

        JLabel labelRoom = new JLabel("Room :");
        labelRoom.setBounds(35, 274, 200, 14);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelRoom.setForeground(Color.BLACK);
        panel.add(labelRoom);

        c1 = new Choice();
        try {
            data c = new data();
           ResultSet resultSet = c.statement.executeQuery("select * from Room");
           while (resultSet.next()){
               c1.add(resultSet.getString("room_no"));
           }

        } catch (Exception e) {
           e.printStackTrace();
        }

        c1.setBounds(271, 274, 150, 20);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(3, 45, 48));
        panel.add(c1);

        JLabel labelDate = new JLabel("Time :");
        labelDate.setBounds(35, 316, 200, 14);
        labelDate.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDate.setForeground(Color.BLACK);
        panel.add(labelDate);

        Date date1 = new Date();
        date = new JLabel("" + date1);
        date.setBounds(271, 316, 250, 15);
        date.setForeground(Color.BLACK);
        date.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(date);

        JLabel labelDeposite = new JLabel("Deposite :");
        labelDeposite.setBounds(35, 359, 200, 17);
        labelDeposite.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDeposite.setForeground(Color.BLACK);
        panel.add(labelDeposite);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(271, 359, 150, 20);
        panel.add(textFieldDeposite);

        b1 = new JButton("Add");
        b1.setBounds(100, 430, 120, 30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(260, 430, 120, 30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        panel.add(b2);

        setUndecorated(true);
        setSize(850, 550);
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (textfieldNumber.getText().isEmpty() || textName.getText().isEmpty() ||
                    (!r1.isSelected() && !r2.isSelected()) ||
                    textFieldFieldDisease.getText().isEmpty() ||
                    textFieldDeposite.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please fill all fields");
                return;
            }
            data c = new data();
            String radioBTN = null;
            if (r1.isSelected()) {
                radioBTN = "Male";
            }else if (r2.isSelected()) {
                radioBTN = "Female";
            }
            String s1=(String)combobox.getSelectedItem();
            String s2=textfieldNumber.getText();
            String s3=textName.getText();
            String s4=radioBTN;
            String s5=textFieldFieldDisease.getText();
            String s6=c1.getSelectedItem();
            String s7=date.getText();
            String s8=textFieldDeposite.getText();

            try {
                String q="insert into patient_info values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1="update room set availability = 'occupied' where room_no = "+s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Added Successfully");
                setVisible(false);
            }catch (Exception E) {
                E.printStackTrace();
            }


        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NEW_PATIENT();
    }
}
