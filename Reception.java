package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    Reception() {

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/reception.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(1300, 700, Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0, 0, 1300, 700);
        label.setLayout(null);


        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setPreferredSize(new Dimension(1900, 1050));
        contentPanel.setBackground(new Color(27, 195, 172));

        setContentPane(new JScrollPane(contentPanel));

        contentPanel.add(label);


        JButton btn1 = new JButton("Patient All Details");
        btn1.setBounds(200, 15, 200, 30);
        btn1.setBackground(new Color(58, 131, 243));
        contentPanel.add(btn1);
        btn1.addActionListener(e -> new PatientDetailsWindow());

        JButton btn2 = new JButton("Room All Details");
        btn2.setBounds(200, 58, 200, 30);
        btn2.setBackground(new Color(58, 131, 243));
        contentPanel.add(btn2);
        btn2.addActionListener(e -> new RoomDetails());

        JButton btn3 = new JButton("Department");
        btn3.setBounds(430, 58, 200, 30);
        btn3.setBackground(new Color(58, 131, 243));
        contentPanel.add(btn3);
        btn3.addActionListener(e -> new Department());

        JButton btn4 = new JButton("All Employee Info");
        btn4.setBounds(430, 15, 200, 30);
        btn4.setBackground(new Color(58, 131, 243));
        contentPanel.add(btn4);
        btn4.addActionListener(e -> new Employee_info());

        JButton btn8 = new JButton("Ambulance All Details");
        btn8.setBounds(200, 140, 200, 30);
        btn8.setBackground(new Color(58, 131, 243));
        contentPanel.add(btn8);
        btn8.addActionListener(e -> new AmbulanceDetails());

        JButton btn11 = new JButton("Available Medicine");
        btn11.setBounds(200, 100, 200, 30);
        btn11.setBackground(new Color(58, 131, 243));
        contentPanel.add(btn11);
        btn11.addActionListener(e -> new medicine());

        JButton btn12 = new JButton("Bill Invoice");
        btn12.setBounds(430, 100, 200, 30);
        btn12.setBackground(new Color(58, 131, 243));
        contentPanel.add(btn12);
        btn12.addActionListener(e -> new BillInvoice());

        JButton btn13 = new JButton("Log Out");
        btn13.setBounds(430, 140, 200, 30);
        btn13.setBackground(new Color(58, 131, 243));
        contentPanel.add(btn13);
        btn13.addActionListener(e -> {
            setVisible(false);
            new logoutform();
        });

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(null);
        footerPanel.setBounds(0, 700, 1900, 800); // updated Y position
        footerPanel.setBackground(Color.BLACK);
        contentPanel.add(footerPanel);

        JLabel aboutTitle = new JLabel("About Us");
        aboutTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        aboutTitle.setForeground(Color.yellow);
        aboutTitle.setBounds(100, 10, 200, 35);
        footerPanel.add(aboutTitle);

        JLabel aboutText = new JLabel("<html>CARE BRIDGE Hospital is a modern, multi-specialty healthcare facility dedicated to providing compassionate, patient-centered care.  \n" +
                "We offer 24/7 emergency services, advanced medical technology, and highly qualified doctors to serve our community with excellence.</html>");
        aboutText.setFont(new Font("Tahoma", Font.PLAIN, 15));
        aboutText.setForeground(Color.WHITE);
        aboutText.setBounds(100, 50, 250, 170);
        footerPanel.add(aboutText);

        JLabel contactTitle = new JLabel("Contact Us");
        contactTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        contactTitle.setForeground(Color.yellow);
        contactTitle.setBounds(530, 10, 200, 25);
        footerPanel.add(contactTitle);

        JLabel contactText = new JLabel("<html>Email: hospitalcarebridge@gmail.com<br>Phone: +91-9876543210<br>Address: Gobindapur, Shibtala, Howrah<br>Pin: 711414, West Bengal</html>");
        contactText.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contactText.setForeground(Color.white);
        contactText.setBounds(530, 40, 300, 100);
        footerPanel.add(contactText);

        JLabel followTitle = new JLabel("Follow Us");
        followTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        followTitle.setForeground(Color.yellow);
        followTitle.setBounds(900, 10, 200, 25);
        footerPanel.add(followTitle);

        int iconX = 900;
        String[] icons = {"facebook.jpg", "twitter.jpg", "instagram.jpg", "youtube.jpg"};
        for (String icon : icons) {
            ImageIcon iconImage = new ImageIcon(ClassLoader.getSystemResource("icon/" + icon));
            Image scaled = iconImage.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            JLabel iconLabel = new JLabel(new ImageIcon(scaled));
            iconLabel.setBounds(iconX, 50, 30, 30);
            footerPanel.add(iconLabel);
            iconX += 40;
        }

        setSize(1900, 1050);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}