package hotel;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddDrivers extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField name,age,company,brand, location;
    private JComboBox gender, available;
    JButton b1,b2;
    Choice c1;

    public static void main(String[] args) {
        new AddDrivers().setVisible(true);
    }


    public AddDrivers() {
        setBounds(450, 200, 1000, 500);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("eleven.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l15 = new JLabel(i2);
                l15.setBounds(400,30,500,370);
                add(l15);
        
        JLabel l10 = new JLabel("Add Drivers");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
	l10.setBounds(194, 10, 120, 22);
	contentPane.add(l10);
        
	
        
	JLabel l1 = new JLabel("Name");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(64, 70, 102, 22);
	contentPane.add(l1);
        
        
        name = new JTextField();
	name.setBounds(174, 70, 156, 20);
	contentPane.add(name);
        

	JLabel l2 = new JLabel("Age");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(64, 110, 102, 22);
	contentPane.add(l2);
        
        age = new JTextField();
	age.setBounds(174, 110, 156, 20);
	contentPane.add(age);


	JLabel l3 = new JLabel("Gender");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(64, 150, 102, 22);
	contentPane.add(l3);
        
        gender = new JComboBox(new String[] { "Male", "Female" });
	gender.setBounds(176, 150, 154, 20);
	contentPane.add(gender);

	JLabel l4 = new JLabel("Car Company");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(64, 190, 102, 22);
	contentPane.add(l4);
        
        company = new JTextField();
	company.setBounds(174, 190, 156, 20);
	contentPane.add(company);

        JLabel l5 = new JLabel("Car Brand");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(64, 230, 102, 22);
	contentPane.add(l5);


        brand = new JTextField();
	brand.setBounds(174, 230, 156, 20);
	contentPane.add(brand);

	
        JLabel l6 = new JLabel("Available");
	l6.setForeground(new Color(25, 25, 112));
	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
	l6.setBounds(64, 270, 102, 22);
	contentPane.add(l6);


        available = new JComboBox(new String[] { "Yes", "No" });
	available.setBounds(176, 270, 154, 20);
	contentPane.add(available);

        
        JLabel l7 = new JLabel("Location");
	l7.setForeground(new Color(25, 25, 112));
	l7.setFont(new Font("Tahoma", Font.BOLD, 14));
	l7.setBounds(64, 310, 102, 22);
	contentPane.add(l7);


        location = new JTextField();
	location.setBounds(174, 310, 156, 20);
	contentPane.add(location);
        
	

	b1 = new JButton("Add");
	b1.addActionListener(this);
	b1.setBounds(64, 380, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBounds(198, 380, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	
        contentPane.setBackground(Color.WHITE);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                try{
                conn c = new conn();
                String namee = name.getText();
                String agee = age.getText();
                String genderr = (String)gender.getSelectedItem();
                String companyy  = company.getText();
                String brandd = brand.getText();
                String availablee = (String)available.getSelectedItem();
                String locationn = location.getText();
                if (namee.isEmpty() || agee.isEmpty() || genderr.isEmpty() || companyy.isEmpty() || brandd.isEmpty() || availablee.isEmpty()  || locationn.isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "Please fill in all the required fields", "Missing Data", JOptionPane.WARNING_MESSAGE);
                return;
            }
                String str = "INSERT INTO driver values( '"+namee+"', '"+agee+"', '"+genderr+"','"+companyy+"', '"+brandd+"', '"+availablee+"','"+locationn+"')";
              
                
		c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Driver Successfully Added");               
                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == b2){
                this.setVisible(false);
            }
        }catch(Exception eee){
            
        }
    }
}
