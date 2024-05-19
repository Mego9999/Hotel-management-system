package hotel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Dashboard extends JFrame{

    public Dashboard() {
        setForeground(Color.CYAN);
        setLayout(null); 
        setTitle("Dashboard");
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
		JLabel NewLabel = new JLabel(i3);
		NewLabel.setBounds(0, 0, 1950, 1000); 
        add(NewLabel);
        
        JLabel AirlineManagementSystem = new JLabel("Al-Ula GROUP WELCOMES YOU");
        AirlineManagementSystem.setForeground(Color.WHITE);
        AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 46));
        AirlineManagementSystem.setBounds(600, 60, 1000, 85);
        NewLabel.add(AirlineManagementSystem);
        
        JButton btnReciption = new JButton("Reciption");
        btnReciption.setBounds(600, 300, 235, 140);
        btnReciption.setFont(new Font("Tahoma", Font.PLAIN, 46));
        btnReciption.setBackground(Color.WHITE);
        btnReciption.setForeground(Color.BLACK);
		add(btnReciption);
		btnReciption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				Reception r= new Reception();
				r.setVisible(true);
			}catch(Exception e1){
				e1.printStackTrace();
			}
			}
		});
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setBounds(1200, 300, 200, 140);
		btnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 46));
		btnAdmin.setBackground(Color.WHITE);
		btnAdmin.setForeground(Color.BLACK);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				addlogin a= new addlogin();
				a.setVisible(true);
			}catch(Exception e1){
				e1.printStackTrace();
			}
			}
		});
		add(btnAdmin);
        setSize(1950,1090);
	setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
}
