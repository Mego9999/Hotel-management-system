package hotel;

import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateRoom extends JFrame {
	private JPanel contentPane;
	private JTextField txt_Room;
    Choice c1;
    Choice c2;
    Choice c3;

	

	public UpdateRoom() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 1000, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		JLabel lblUpdateRoomStatus = new JLabel("Update Room Status");
		lblUpdateRoomStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateRoomStatus.setBounds(85, 11, 206, 34);
		contentPane.add(lblUpdateRoomStatus);
		
		JLabel lblNewLabel = new JLabel("Guest ID:");
		lblNewLabel.setBounds(27, 87, 90, 14);
		contentPane.add(lblNewLabel);
                
                c1 = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                        c1.add(rs.getString("number"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(160, 84, 140, 20);
		contentPane.add(c1);
		
		JLabel lblroom = new JLabel("Room number:");
		lblroom.setBounds(27, 133, 100, 14);
		contentPane.add(lblroom);
		
		JLabel lblAvailability = new JLabel("Availability:");
		lblAvailability.setBounds(27, 187, 90, 14);
		contentPane.add(lblAvailability);
		
		JLabel lblCleanStatus = new JLabel("Clean Status:");
		lblCleanStatus.setBounds(27, 240, 90, 14);
		contentPane.add(lblCleanStatus);
		
		
		c2 = new Choice();
		c2.setBounds(160, 184, 140, 20);
		c2.add("");
		c2.add("Available");
		c2.add("Occupied");
		contentPane.add(c2);
		
		c3 = new Choice();
		c3.setBounds(160, 237, 140, 20);
		c3.add("");
		c3.add("Cleaned");
		c3.add("Dirty");
		contentPane.add(c3);
                
        txt_Room = new JTextField();
		txt_Room.setBounds(160, 130, 140, 20);
		contentPane.add(txt_Room);
		txt_Room.setColumns(10);
		
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("seventh.jpg"));
        Image i3 = i1.getImage().getScaledInstance(550, 250,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(400,80,600,250);
        add(l1);
		
        JButton b1 = new JButton("Check");
        b1.setBounds(120, 315, 89, 23);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);
        b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String s1 = c1.getSelectedItem();
					conn c = new conn();
                    ResultSet rs1 = c.s.executeQuery("select * from customer where number = "+s1);
                    
                    while(rs1.next()){
                        txt_Room.setText(rs1.getString("room"));    
                        
                    }
                    ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = "+txt_Room.getText());
                    while(rs2.next()){
//                        txt_Ava.setText(rs2.getString("availability"));
                    	c2.select(rs2.getString("availability"));
                        c3.select(rs2.getString("cleaning_status"));
                    }

				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
				
			}
		});
        
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(60, 355, 89, 23);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        contentPane.add(btnUpdate);
        btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) throws NumberFormatException {
				
				try{
                conn c = new conn();
                String str = "update room set availability = '"+c2.getSelectedItem() +"',cleaning_status = '"+c3.getSelectedItem()+"' where roomnumber = "+txt_Room.getText();
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Update Sucessful");
                
				}catch (Exception ee){
					ee.printStackTrace();
				}
				
			
			}
		});
        
        JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(180, 355, 89, 23);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit); 
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateRoom frame = new UpdateRoom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
