package hospital.management.system;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Patient_discharge extends JFrame {
   Patient_discharge(){
       JPanel panel = new JPanel();
       panel.setBounds(5,5,790,390);
       panel.setBackground(new Color(27,195,172));
       panel.setLayout(null);
       add(panel);

       JLabel label = new JLabel("CHECK-OUT");
       label.setBounds(100,20,150,20);
       label.setFont(new Font("Tahoma",Font.BOLD,20));
       label.setForeground(Color.black);
       panel.add(label);

       JLabel label2 = new JLabel("PATIENT ID :");
       label2.setBounds(30,80,150,20);
       label2.setFont(new Font("Tahoma",Font.BOLD,14));
       label2.setForeground(Color.black);
       panel.add(label2);

       Choice choice = new Choice();
       choice.setBounds(200,80,150,25);
       panel.add(choice);

       try{
           data c = new data();
           ResultSet resultSet = c.statement.executeQuery("select * from Patient_Info");
           while (resultSet.next()){
               choice.add(resultSet.getString("NUMBER"));
           }
       }catch (Exception e){
           e.printStackTrace();
       }

       JLabel label3= new JLabel("ROOM NUMBER :");
       label3.setBounds(30,130,150,20);
       label3.setFont(new Font("Tahoma",Font.BOLD,14));
       label3.setForeground(Color.black);
       panel.add(label3);

       JLabel RNO = new JLabel();
       RNO.setBounds(200,130,150,20);
       RNO.setFont(new Font("Tahoma",Font.BOLD,14));
       RNO.setForeground(Color.black);
       panel.add(RNO);

       JLabel label4 = new JLabel("IN TIME :");
       label4.setBounds(30,180,150,20);
       label4.setFont(new Font("Tahoma",Font.BOLD,14));
       label4.setForeground(Color.black);
       panel.add(label4);

       JLabel INTIME = new JLabel();
       INTIME.setBounds(200,180,250,20);
       INTIME.setFont(new Font("Tahoma",Font.BOLD,14));
       INTIME.setForeground(Color.black);
       panel.add(INTIME);

       JLabel label5 = new JLabel("OUT TIME :");
       label5.setBounds(30,230,150,20);
       label5.setFont(new Font("Tahoma",Font.BOLD,14));
       label5.setForeground(Color.black);
       panel.add(label5);

       Date date = new Date();

       JLabel OUTTIME = new JLabel(""+date);
       OUTTIME.setBounds(200,230,250,20);
       OUTTIME.setFont(new Font("Tahoma",Font.BOLD,14));
       OUTTIME.setForeground(Color.black);
       panel.add(OUTTIME);

       JButton DISCHARGE = new JButton("DISCHARGE");
       DISCHARGE.setBounds(150,300,120,30);
       DISCHARGE.setBackground(Color.BLACK);
       DISCHARGE.setForeground(Color.white);
       panel.add(DISCHARGE);
       DISCHARGE.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               data c = new data();
               try{
                   c.statement.executeUpdate("delete from Patient_Info where number = '"+choice.getSelectedItem()+"'");
                   c.statement.executeUpdate("Update ROOM set Availability = 'Availabil' where room_no = '"+RNO.getText()+"'");
                   JOptionPane.showMessageDialog(null,"Done");
                   setVisible(false);
               }catch (Exception E){
                   E.printStackTrace();
               }


           }
       });
       JButton check = new JButton("CHECK");
       check.setBounds(300,300,120,30);
       check.setBackground(Color.BLACK);
      check.setForeground(Color.white);
       panel.add(check);
       check.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               data c = new data();
               try{
                   ResultSet resultSet = c.statement.executeQuery("select * from Patient_Info where NUMBER = '"+choice.getSelectedItem()+"'");
                   while (resultSet.next()){
                       RNO.setText(resultSet.getString("ROOM_NUMBER"));
                       INTIME.setText(resultSet.getString("TIME"));

                   }
               }catch (Exception E){
                   E.printStackTrace();
               }
           }
       });
       JButton BACK = new JButton("BACK");
       BACK.setBounds(450,300,120,30);
       BACK.setBackground(Color.BLACK);
       BACK.setForeground(Color.white);
       panel.add(BACK);
       BACK.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               setVisible(false);
           }
       });
       setUndecorated(true);
       setSize(800,400);
       setLayout(null);
       setLocation(300,150);
       setVisible(true);
   }

    public static void main(String[] args) {
        new Patient_discharge();
    }
}
