package hotel;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddRoom extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField Price,Roon;
    private JComboBox Available, Status, Type;
    JButton b1,b2;
    Choice c1;

    public static void main(String[] args) {
        new AddRoom().setVisible(true);
    }


    public AddRoom() {
        setBounds(450, 200, 1000, 450);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("twelve.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l15 = new JLabel(i2);
                l15.setBounds(400,30,500,370);
                add(l15);
        
        JLabel l10 = new JLabel("Add Rooms");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
	l10.setBounds(194, 10, 120, 22);
	contentPane.add(l10);
        
	
        
	JLabel l1 = new JLabel("Room Number");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(64, 70, 102, 22);
	contentPane.add(l1);
        
        
        Roon = new JTextField();
	Roon.setBounds(174, 70, 156, 20);
	contentPane.add(Roon);
        

	JLabel l2 = new JLabel("Availability");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(64, 110, 102, 22);
	contentPane.add(l2);
        
        Available = new JComboBox(new String[] { "Available", "Occupied" });
	Available.setBounds(176, 110, 154, 20);
	contentPane.add(Available);


	JLabel l3 = new JLabel("Cleaning Status");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(64, 150, 102, 22);
	contentPane.add(l3);
        
        Status = new JComboBox(new String[] { "Cleaned", "Dirty" });
	Status.setBounds(176, 150, 154, 20);
	contentPane.add(Status);

	JLabel l4 = new JLabel("Price");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(64, 190, 102, 22);
	contentPane.add(l4);
        
        Price = new JTextField();
	Price.setBounds(174, 190, 156, 20);
	contentPane.add(Price);

        JLabel l5 = new JLabel("Bed Type");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(64, 230, 102, 22);
	contentPane.add(l5);


        Type = new JComboBox(new String[] { "Single Bed", "Double Bed","Triple Bed"});
	Type.setBounds(176, 230, 154, 20);
	contentPane.add(Type);

	

	

	b1 = new JButton("Add");
	b1.addActionListener(this);
	b1.setBounds(64, 321, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBounds(198, 321, 111, 33);
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
                String room = Roon.getText();
                String available = (String)Available.getSelectedItem();
                String status = (String)Status.getSelectedItem();
                String price  = Price.getText();
                String type = (String)Type.getSelectedItem();
                if (room.isEmpty() || available.isEmpty() || status.isEmpty() || price.isEmpty() || type.isEmpty() ) 
            {
                JOptionPane.showMessageDialog(null, "Please fill in all the required fields", "Missing Data", JOptionPane.WARNING_MESSAGE);
                return;
            }
                String str = "INSERT INTO room values( '"+room+"', '"+available+"', '"+status+"','"+price+"', '"+type+"')";
		c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Room Successfully Added");               
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
