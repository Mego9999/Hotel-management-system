package hotel;

import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener{ //Third Frame

    
	JTextField Name,salary,Phone,Securitynumber,Email;
        JComboBox c1;
        JRadioButton rdmale,rdfemale;
        public AddEmployee(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("ADD EMPLOYEE DETAILS");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
			
            JLabel Passportno = new JLabel("NAME");
            Passportno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Passportno.setBounds(60, 30, 150, 27);
            add(Passportno);
            
            Name = new JTextField();
            Name.setBounds(200, 30, 150, 27);
            add(Name);
			
            JButton Next = new JButton("SAVE");
            Next.setBounds(200, 420, 150, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            add(Next);
            Next.addActionListener(this);
            
            JLabel Pnrno = new JLabel("AGE");
            Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Pnrno.setBounds(60, 80, 150, 27);
            add(Pnrno);
			
            Name = new JTextField();
            Name.setBounds(200, 80, 150, 27);
            add(Name);
            
            JLabel Gender = new JLabel("GENDER");
            Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Gender.setBounds(60, 120, 150, 27);
            add(Gender);
		
            rdmale = new JRadioButton("MALE");
            rdmale.setBackground(Color.WHITE);
            rdmale.setBounds(200, 120, 70, 27);
            add(rdmale);
	
            rdfemale = new JRadioButton("FEMALE");
            rdfemale.setBackground(Color.WHITE);
            rdfemale.setBounds(280, 120, 70, 27);
            add(rdfemale);
            
            
            JLabel Address = new JLabel("JOB");
            Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Address.setBounds(60, 170, 150, 27);
            add(Address);
			
            String course[] = {"Front Desk ","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
            c1 = new JComboBox(course);
            c1.setBackground(Color.WHITE);
            c1.setBounds(200,170,150,30);
            add(c1);
            		
            JLabel SALARY = new JLabel("SALARY");
            SALARY.setFont(new Font("Tahoma", Font.PLAIN, 17));
            SALARY.setBounds(60, 220, 150, 27);
            add(SALARY);
			
            salary = new JTextField();
            salary.setBounds(200, 220, 150, 27);
            add(salary);
	
            JLabel PHONE = new JLabel("PHONE");
            PHONE.setFont(new Font("Tahoma", Font.PLAIN, 17));
            PHONE.setBounds(60, 270, 150, 27);
            add(PHONE);
	
            Phone = new JTextField();
            Phone.setBounds(200, 270, 150, 27);
            add(Phone);
	
            JLabel securitynumber = new JLabel("security no.");
            securitynumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
            securitynumber.setBounds(60, 320, 150, 27);
            add(securitynumber);
			
            Securitynumber = new JTextField();
            Securitynumber.setBounds(200, 320, 150, 27);
            add(Securitynumber);
	
            
            JLabel email = new JLabel("EMAIL");
            email.setFont(new Font("Tahoma", Font.PLAIN, 17));
            email.setBounds(60, 370, 150, 27);
            add(email);
			
            Email = new JTextField();
            Email.setBounds(200, 370, 150, 27);
            add(Email);
	
            setVisible(true);
	
            JLabel AddPassengers = new JLabel("ADD EMPLOYEE DETAILS");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddPassengers.setBounds(450, 24, 442, 35);
            add(AddPassengers);
			
     
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tenth.jpg"));
            Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(410,80,480,410);
            add(image);

            
			
            setSize(900,600);
            setVisible(true);
            setLocation(530,200);
			
	}
        public void actionPerformed(ActionEvent ae)
        {
            String name = Name.getText();
             String age = Name.getText();
             String salaryY = salary.getText();
             String phone = Phone.getText();
             String securitynumber = Securitynumber.getText();
             String email = Email.getText();
            String gender = null;
            if (name.isEmpty() || age.isEmpty() || salaryY.isEmpty() || phone.isEmpty() || securitynumber.isEmpty() || email.isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "Please fill in all the required fields", "Missing Data", JOptionPane.WARNING_MESSAGE);
                return;
            }
             if(rdmale.isSelected()){
                 gender = "male";
             
             }else if(rdfemale.isSelected()){
                 gender = "female";
             }

                     
             String s6 = (String)c1.getSelectedItem();
             
             try {
                 conn c = new conn();
                 String str = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+s6+"', '"+salaryY+"', '"+phone+"','"+securitynumber+"', '"+email+"')";
                 
                 c.s.executeUpdate(str);
                 JOptionPane.showMessageDialog(null,"Employee Added");             
             } catch (Exception e) {
                 e.printStackTrace();
 	    }
	}
    public static void main(String[] args){
        new AddEmployee();
    }   
}
