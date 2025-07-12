package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class All_Patient_Info extends JFrame {
    All_Patient_Info(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(27,195,172));
        panel.setLayout(null);
        add(panel);

        JLabel labelName = new JLabel("All Patient Details");
        labelName.setBounds(350, 0, 260, 50);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelName.setForeground(Color.black);
        panel.add(labelName);

        JTable table = new JTable();
        table.setBounds(10,100,900,450);
        table.setBackground(new Color(27,195,172));
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(table);

        try{
            data c = new data();
            String q = "select * from Patient_Info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("ID");
        label1.setBounds(31,70,100,14);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("NUMBER");
        label2.setBounds(130,70,100,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("NAME");
        label3.setBounds(250,70,100,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4= new JLabel("GENDER");
        label4.setBounds(350,70,100,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5= new JLabel("DISEASE");
        label5.setBounds(470,70,100,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label6= new JLabel("ROOM");
        label6.setBounds(580,70,100,14);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

        JLabel label7 = new JLabel("TIME");
        label7.setBounds(690,70,100,14);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label7);

        JLabel label8 = new JLabel("DEPOSITE");
        label8.setBounds(800,70,100,14);
        label8.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label8);

        JButton button = new JButton("BACK");
        button.setBounds(350,550,120,30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(170,70);
        setVisible(true);

    }
    public static void main(String[] args) {
        new All_Patient_Info();
    }
}