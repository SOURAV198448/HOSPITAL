package hospital.management.system;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class room extends JFrame {
    JTable table;


    room(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(27,195,172));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/rooms.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon1);
        imageLabel.setBounds(550, 200, 200, 200);
        panel.add(imageLabel);

        JLabel labelName = new JLabel("All Room Details");
        labelName.setBounds(200, 0, 260, 50);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelName.setForeground(Color.black);
        panel.add(labelName);

        table = new JTable();
        table.setBounds(10,100,500,400);
        table.setBackground(new Color(27,195,172));
        panel.add(table);

        try{
            data c = new data();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();

        }
        JLabel label1 = new JLabel("Room No");
        label1.setBounds(12,75,80,15);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2= new JLabel("Availability");
        label2.setBounds(135,75,80,15);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3= new JLabel("Price");
        label3.setBounds(260,75,80,15);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4= new JLabel("Bed type");
        label4.setBounds(385,75,80,17);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JButton Back = new JButton("Back");
        Back.setBounds(200,550,120,30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        setUndecorated(true);
        setSize(800,600);
        setLayout(null);
        setLocation(300,80);
        setVisible(true);
    }
    public static void main(String[] args) {
        new room();

    }
}
