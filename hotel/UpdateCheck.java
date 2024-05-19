package hotel;
import java.awt.BorderLayout;
import java.awt.*;

import java.sql.*;	
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateCheck extends JFrame{
	private JPanel contentPane;
	private JTextField txt_Room;
	private JTextField txt_name;
	private JTextField txt_Date;
	private JTextField txt_deposit;
	private JTextField txt_Payment;

        Choice c1, c2;
	public UpdateCheck() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 950, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdateCheckStatus = new JLabel("Check-In Details");
		lblUpdateCheckStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateCheckStatus.setBounds(124, 11, 222, 25);
		lblUpdateCheckStatus.setForeground(Color.BLUE);
		contentPane.add(lblUpdateCheckStatus);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("nine.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(450,70,476,270);
        add(l1);
		
		JLabel lblNewLabel = new JLabel("Customer ID:");
		lblNewLabel.setBounds(25, 88, 200, 30);
		contentPane.add(lblNewLabel);
                
                c1 = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                        c1.add(rs.getString("number"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(248, 85, 140, 20);
		contentPane.add(c1);
		
		JLabel lblNewLabel_1 = new JLabel("Room Number :");
		lblNewLabel_1.setBounds(25, 129, 107, 14);
		contentPane.add(lblNewLabel_1);
                
                
		txt_Room = new JTextField();
		txt_Room.setBounds(248, 126, 140, 20);
		contentPane.add(txt_Room);
		
		JLabel lblNewLabel_2 = new JLabel("Name : ");
		lblNewLabel_2.setBounds(25, 174, 97, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Checked-in :");
		lblNewLabel_3.setBounds(25, 216, 107, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Amount Paid : ");
		lblNewLabel_4.setBounds(25, 261, 107, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Pending Amount : ");
		lblNewLabel_5.setBounds(25, 302, 150, 14);
		contentPane.add(lblNewLabel_5);

		
		txt_name = new JTextField();
		txt_name.setBounds(248, 171, 140, 20);
		contentPane.add(txt_name);
		
		txt_Date = new JTextField();
		txt_Date.setBounds(248, 216, 140, 20);
		contentPane.add(txt_Date);
		
		txt_deposit = new JTextField();
		txt_deposit.setBounds(248, 258, 140, 20);
		contentPane.add(txt_deposit);
		
		txt_Payment = new JTextField();
		txt_Payment.setBounds(248, 299, 140, 20);
		contentPane.add(txt_Payment);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(168, 378, 89, 23);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) { 
                            try{
                                conn c = new conn();
                                
                                String s1 = c1.getSelectedItem();
                                String s2 = txt_Room.getText(); //room_number;    
                                String s3 = txt_name.getText(); //name    
                                String s4 = txt_Date.getText(); //status;    
                                String s5 = txt_deposit.getText(); //deposit    
				
                                c.s.executeUpdate("update customer set deposit = '"+s5+"' where number = '"+s1+"'");
                                
                                JOptionPane.showMessageDialog(null, "Data Updated Successfully");   
                            }catch(Exception ee){
                                System.out.println(ee);
                            }				
				
				
				
			}
		});

		
		JButton btnExit = new JButton("Back");
		btnExit.setBounds(281, 378, 89, 23);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});

		
		JButton btnCheck = new JButton("Check");
		btnCheck.setBounds(56, 378, 89, 23);
        btnCheck.setBackground(Color.BLACK);
        btnCheck.setForeground(Color.WHITE);
		contentPane.add(btnCheck);
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String s1 = c1.getSelectedItem();
					conn c = new conn();
                    ResultSet rs1 = c.s.executeQuery("select * from customer where number = "+s1);
                    
                    while(rs1.next()){
                        txt_Room.setText(rs1.getString("room"));    
                        txt_name.setText(rs1.getString("name"));    
                        txt_Date.setText(rs1.getString("checkintime"));    
                        txt_deposit.setText(rs1.getString("deposit"));    
                    }

				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
			}
		});
		JButton btnpay = new JButton("Payment Check");
		btnpay.setBounds(390, 378, 130, 23);
		btnpay.setBackground(Color.BLACK);
		btnpay.setForeground(Color.WHITE);
		contentPane.add(btnpay);
		btnpay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					conn c = new conn();
                    ResultSet rs1 = c.s.executeQuery("select * from room where roomnumber = "+txt_Room.getText());
                    while(rs1.next()){
                    	String total = rs1.getString("price"); 
                    	int am_p=Integer.parseInt(total)-Integer.parseInt(txt_deposit.getText());
                        txt_Payment.setText(Integer.toString(am_p));
                    }

				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
			}
		});
        getContentPane().setBackground(Color.WHITE);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCheck frame = new UpdateCheck();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
