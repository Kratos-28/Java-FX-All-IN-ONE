/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllInOne.Admin;

import AllInOne.connnection;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

import net.proteanit.sql.*;

/**
 *
 * @author 91988
 */
public class showFeedback  extends JFrame implements ActionListener{
    JTable t1;
    JButton b1,b2;
   
    
    
    showFeedback(){
        t1=new JTable();
        t1.setBounds(0,40,1000,500);
        add(t1);
        
        JLabel l1=new JLabel("NAME");
        l1.setBounds(70,10,70,20);
        
        l1.setForeground(Color.BLACK);
        add(l1);
        JLabel l2=new JLabel("EMAIL ID");
        l2.setBounds(350,10,70,20);
        
        l2.setForeground(Color.BLACK);
        add(l2);
        JLabel l3=new JLabel("FEEDBACKS");
        l3.setBounds(670,10,70,20);
       
        l3.setForeground(Color.BLACK);
        add(l3);
        
        
        
        
        b1=new JButton("Load Feedback");
        b1.setBounds(350,560,120,30); 
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(530,560,120,30);
        b2.addActionListener(this);
        add(b2);    
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);
        setBounds(450,200,1000,650);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                    connnection c=new connnection();
                    String str="select * from feedback";
                    ResultSet rs=c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                    
            }
            catch(Exception e){
                System.out.print(e);
            }
        }
        else  if(ae.getSource()==b2){
                this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
    new showFeedback();
    }
    
}
