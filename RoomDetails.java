package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RoomDetails extends JFrame implements ActionListener {

    JButton allRoomDetails, searchRoom, back;

    public RoomDetails() {
        setLayout(null);
        setTitle("Room All Details");
        setUndecorated(true);
        setSize(600, 400);
        setLocation(300, 150);
        getContentPane().setBackground(new Color(122, 243, 226));

        JLabel heading = new JLabel("ROOM ALL DETAILS");
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setForeground(Color.black);
        heading.setBounds(170, 30, 300, 30);
        add(heading);

        allRoomDetails = new JButton("All Room Details");
        allRoomDetails.setBounds(180, 90, 200, 40);
        allRoomDetails.setBackground(new Color(58,131,243)); // dark pink
        allRoomDetails.setForeground(Color.BLACK);
        allRoomDetails.addActionListener(this);
        allRoomDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new room();
            }
        });
        add(allRoomDetails);

        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(180, 150, 200, 40);
        searchRoom.setBackground(new Color(58,131,243));
        searchRoom.setForeground(Color.BLACK);
        searchRoom.addActionListener(this);
        searchRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchRoom();
            }
        });
        add(searchRoom);

        back = new JButton("Back");
        back.setBounds(180, 210, 200, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new RoomDetails();
    }
}
