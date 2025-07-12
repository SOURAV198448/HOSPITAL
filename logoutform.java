package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class logoutform extends JFrame implements ActionListener {

    JButton logoutButton, cancelButton;
    JPanel panel;

    public logoutform() {

        setTitle("Logout");
        setSize(750, 300);
        setLocation(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(27, 195, 172));
        panel.setBounds(0, 0, 100, 150);
        add(panel);

        JLabel label = new JLabel("DO YOU WANT TO LOG OUT ?");
        label.setBounds(200, 20, 400, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));

        panel.add(label);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(230, 90, 100, 30);
        logoutButton.setBackground(Color.BLACK);
        logoutButton.setForeground(Color.white);
        logoutButton.setFont(new Font("serif", Font.BOLD, 15));
        logoutButton.addActionListener(this);
        panel.add(logoutButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(350, 90, 100, 30);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.white);
        cancelButton.setFont(new Font("serif", Font.BOLD, 15));
        cancelButton.addActionListener(this);
        panel.add(cancelButton);
        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == logoutButton) {
            new login();
            setVisible(false);
        } else if (ae.getSource() == cancelButton) {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new logoutform();
    }
}
