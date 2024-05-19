package hotel;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;


import java.sql.*;	
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class CheckOut extends JFrame{
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField Roomnumber,checkintime;
        Choice c1;

	public CheckOut() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 800, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("sixth.jpg"));
                Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(300,0,500,225);
                add(l1);
		
		JLabel lblCheckOut = new JLabel("Check Out ");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCheckOut.setBounds(70, 11, 140, 35);
		contentPane.add(lblCheckOut);
		
		JLabel lblName = new JLabel("Number :");
		lblName.setBounds(20, 85, 80, 14);
		contentPane.add(lblName);
		JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setBounds(20, 132, 86, 20);
		contentPane.add(lblRoomNumber);
		
		Roomnumber = new JTextField();
                Roomnumber.setBounds(130, 132, 170, 20);
		contentPane.add(Roomnumber);
		
		JLabel checkin = new JLabel("check in time:");
		checkin.setBounds(20, 170, 80, 14);
		contentPane.add(checkin);
        
		checkintime = new JTextField();
                checkintime.setBounds(130, 170, 180, 20);
		contentPane.add(checkintime);
        
		
		c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));    
            }
        }catch(Exception e){ }
        c1.setBounds(130, 82, 150, 20);
		contentPane.add(c1);
                
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JButton l2 = new JButton(i6);
        l2.setBounds(290,82,20,20);
        add(l2);
                
        l2.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae){
                System.out.println("Hi");
                try{
                	conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from customer where number="+c1.getSelectedItem());
                    while(rs.next()){
                      System.out.println("clicked");
                      Roomnumber.setText(rs.getString("room"));
                      checkintime.setText(rs.getString("checkintime"));
                    }
                }catch(Exception e){ }
            }
        });
                
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String id = c1.getSelectedItem();
                String roomnumber = Roomnumber.getText();
				String deleteSQL = "Delete from customer where number = "+id;
                String q2 = "update room set availability = 'Available' where roomnumber = "+roomnumber;
                                
                                
				conn c = new conn();

	    		try{
	    			
	    			
	    			c.s.executeUpdate(deleteSQL);
	    			c.s.executeUpdate(q2);
	    			JOptionPane.showMessageDialog(null, "Check Out Successful");
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
			}
		});
		btnCheckOut.setBounds(50, 200, 100, 25);
                btnCheckOut.setBackground(Color.BLACK);
                btnCheckOut.setForeground(Color.WHITE);
		contentPane.add(btnCheckOut);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(160, 200, 100, 25);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                
                getContentPane().setBackground(Color.WHITE);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut frame = new CheckOut();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
