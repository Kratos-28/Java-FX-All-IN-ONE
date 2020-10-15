/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllInOne.Admin;

/**
 *
 * @author 91988
 */
import AllInOne.connnection;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
public class login extends JFrame implements ActionListener{
    JLabel l1;
    JLabel l2;
    JTextField t1;
    JTextField t2;
    JButton b1,b2;
   
    
    public login(){
      
        l1=new JLabel("Username");
      l1.setBounds(40,20,100,30);
      add(l1);
      
        l1=new JLabel("Password");
      l1.setBounds(40,70,100,30);
      add(l1);
      
      
      t1=new JTextField();
      t1.setBounds(150,20,150,30);
      add(t1);
      
      t2=new JTextField();
      t2.setBounds(150,70,150,30);
      add(t2);
      
      
      b1=new JButton("Login To View Feedback");
      b1.setBackground(Color.BLACK);
      b1.setForeground(Color.WHITE);
       b1.addActionListener(this);
      b1.setBounds(30,150,175,30);
      add(b1);
      
      b2=new JButton("Cancel");
      b2.setBackground(Color.BLACK);
      b2.setForeground(Color.WHITE);
      b2.setBounds(200,150,85,30);
      b2.addActionListener(this);
      add(b2);
      
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("AllInOne/Admin/icon/second.jpg"));
      Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel l3=new JLabel(i3);
      l3.setBounds(350,10,200,200);
      add(l3);
      
      getContentPane().setBackground(Color.WHITE);
     setLayout(null);
      setBounds(700,300,600,300);
      setVisible(true);
    }
   
    
    public static void main(String[] args){
       
        new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==b1){
        try{
            connnection c1 = new connnection();
            String u = t1.getText();
            String v = t2.getText();
            
            String q = "select * from logindatabase where AdminName='"+u+"' and Password='"+v+"'";
            
            ResultSet rs = c1.s.executeQuery(q); 
            if(rs.next()){ 
                JOptionPane.showMessageDialog(null,"Sucessfully login");
                new showFeedback().setVisible(true);
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(false);
            }
        }catch(Exception ec){
            ec.printStackTrace();
        }
        }else if(e.getSource()==b2){
           
        setVisible(false);
        
    }
    }
}
