package hotel;

import javax.swing.*;

import java.sql.*;	
import java.awt.event.*;
import java.awt.*;

public class Admin extends JFrame {

	private JPanel contentPane;
	
	public Admin(){
		
        setBounds(920, 350, 230, 190);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
        setTitle("Admin");

		
		JButton btnADD_EMPLOYEE = new JButton("ADD EMPLOYEE");
		btnADD_EMPLOYEE.setBounds(10, 30, 200, 30);
        btnADD_EMPLOYEE.setBackground(Color.BLACK);
        btnADD_EMPLOYEE.setForeground(Color.WHITE);
		contentPane.add(btnADD_EMPLOYEE);
		btnADD_EMPLOYEE.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent ae){
          try{
              new AddEmployee().setVisible(true);
          }catch(Exception e ){}
	      }
		});
		
		JButton btnADD_ROOMS = new JButton("ADD ROOMS");
		btnADD_ROOMS.setBounds(10, 70, 200, 30);
                btnADD_ROOMS.setBackground(Color.BLACK);
                btnADD_ROOMS.setForeground(Color.WHITE);
                contentPane.add(btnADD_ROOMS);
                btnADD_ROOMS.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent ae){
                  try{
                      new AddRoom().setVisible(true);
                  }catch(Exception e ){}
              }
                });
		
		JButton btnADD_DRIVERS = new JButton("ADD DRIVERS");
		btnADD_DRIVERS.setBounds(10, 110, 200, 30);
		btnADD_DRIVERS.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent ae){
          try{
              new AddDrivers().setVisible(true);
          }catch(Exception e ){}
      }});
        btnADD_DRIVERS.setBackground(Color.BLACK);
        btnADD_DRIVERS.setForeground(Color.WHITE);

		contentPane.add(btnADD_DRIVERS);
		
                getContentPane().setBackground(Color.WHITE);
                
                setVisible(true);
	}
	public static void main(String[] args) {
		new Admin();
	}
}
