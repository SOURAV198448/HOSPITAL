package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {
    Choice choice;
    JTable table;
    SearchRoom(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(27,195,172));
        panel.setLayout(null);
        add(panel);

        JLabel For = new JLabel("SEARCH FOR ROOM");
        For.setBounds(240,11,206,31);
        For.setForeground(Color.black);
        For.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(For);

        JLabel status = new JLabel("STATUS :");
        status.setBounds(70,70,80,20);
        status.setForeground(Color.black);
        status.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(status);

        choice = new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(27,195,172));
        table.setForeground(Color.black);
        panel.add(table);

        try{
            data c = new data();
            String q = "select * from ROOM";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel Roomno = new JLabel("ROOM NUMBER");
        Roomno.setBounds(5,162,150,20);
        Roomno.setForeground(Color.black);
        Roomno.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Roomno);

        JLabel available = new JLabel("AVAILABILITY");
        available.setBounds(175,162,150,20);
        available.setForeground(Color.black);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(available);

        JLabel price = new JLabel("PRICE");
        price.setBounds(350,162,150,20);
        price.setForeground(Color.black);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(price);

        JLabel bed = new JLabel("BED TYPE");
        bed.setBounds(525,162,150,20);
        bed.setForeground(Color.black);
        bed.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(bed);

        JButton Search = new JButton("SEARCH");
        Search.setBounds(200,420,120,25);
        Search.setBackground(Color.BLACK);
        Search.setForeground(Color.white);
        panel.add(Search);

        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from ROOM where Availability = '"+ choice.getSelectedItem()+"'";
                try{
                    data c = new data();
                    ResultSet resultSet = c.statement.executeQuery(q);

                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(350,420,120,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(320,120);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SearchRoom();
    }
}
