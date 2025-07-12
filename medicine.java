package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class medicine extends JFrame {
    medicine(){
        JPanel panel = new JPanel();
        panel.setBounds(4,5,800,650);
        panel.setLayout(null);
        panel.setBackground(new Color(27,195,172));
        add(panel);

        JLabel labelName = new JLabel("All Medicine Details");
        labelName.setBounds(300, -5, 260, 50);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelName.setForeground(Color.black);
        panel.add(labelName);

        JTable table = new JTable();
        table.setBackground(new Color(27,195,172));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(5, 40, 790, 430);
        scrollPane.setBackground(Color.white);
        panel.add(scrollPane);

        try{
            data c = new data();
            String q = "select * from medicine";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }


        JButton b1 = new JButton("BACK");
        b1.setBounds(290,500,130,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(800,550);
        setLayout(null);
        setLocation(270,100);
        setVisible(true);

    }

public static void main(String[] args) {
        new medicine();
}

}
