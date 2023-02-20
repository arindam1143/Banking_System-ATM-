package BankingSystem;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener{
	long random;
	JTextField nameText,fnameText,emailText,phoneText,addressText,pinText,stateText;
	JDateChooser dateChoose;
	JRadioButton male,female;
	JButton next;
	SignupOne(){
		
		setLayout(null);
		
		Random ran=new Random();
	    random=Math.abs((ran.nextLong()%9000L)+1000L);
		
		JLabel formNo=new JLabel("Applicatin Form No :"+ random);
		formNo.setFont(new Font("Raleway",Font.BOLD,38));
		formNo.setBounds(140,20,600,40);
		add(formNo);
		
		JLabel personalDetails=new JLabel("page 1: Personal Details");
		personalDetails.setFont(new Font("Raleway",Font.BOLD,20));
		personalDetails.setBounds(290,80,400,30);
		add(personalDetails);
		
		JLabel name=new JLabel("Name: ");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		
		nameText=new JTextField();
		nameText.setFont(new Font("Realway",Font.BOLD,14));
		nameText.setBounds(300,140,300,30);
		add(nameText);
		
		JLabel fname=new JLabel("Father's Name: ");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		fnameText=new JTextField();
		fnameText.setFont(new Font("Realway",Font.BOLD,14));
		fnameText.setBounds(300,190,300,30);
		add(fnameText);
		
		JLabel dob=new JLabel("Date Of Birth: ");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		
		dob.setBounds(100,240,200,30);
		add(dob);
		
	     dateChoose=new JDateChooser();
		dateChoose.setBounds(300,240,300,30);
		//dateChoose.setBackground(Color.BLACK);
		dateChoose.setForeground(new Color(0,0,0));
		add(dateChoose);
		
		JLabel gender=new JLabel("Gender: ");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		male=new JRadioButton("Male");
		male.setBounds(300,290,60,30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female=new JRadioButton("Female");
		female.setBounds(450,290,120,30);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup genderGroup=new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		
		JLabel email=new JLabel("Email: ");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(100,340,200,30);
		add(email);
		
		emailText=new JTextField();
		emailText.setFont(new Font("Realway",Font.BOLD,14));
		emailText.setBounds(300,340,300,30);
		add(emailText);
		
		
		JLabel phone=new JLabel("Phone No: ");
		phone.setFont(new Font("Raleway",Font.BOLD,20));
		phone.setBounds(100,390,200,30);
		add(phone);
		
	    phoneText=new JTextField();
		phoneText.setFont(new Font("Realway",Font.BOLD,14));
		phoneText.setBounds(300,390,300,30);
		add(phoneText);
		
		JLabel address=new JLabel("Address: ");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(100,440,200,30);
		add(address);
		
		addressText=new JTextField();
		addressText.setFont(new Font("Realway",Font.BOLD,14));
		addressText.setBounds(300,440,300,30);
		add(addressText);
		
		JLabel pin=new JLabel("Pin Code: ");
		pin.setFont(new Font("Raleway",Font.BOLD,20));
		pin.setBounds(100,490,200,30);
		add(pin);
		
		pinText=new JTextField();
		pinText.setFont(new Font("Realway",Font.BOLD,14));
		pinText.setBounds(300,490,300,30);
		add(pinText);
		
		JLabel state=new JLabel("State:");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(100,540,200,30);
		add(state);
		
	    stateText=new JTextField();
		stateText.setFont(new Font("Realway",Font.BOLD,14));
		stateText.setBounds(300,540,300,30);
		add(stateText);
		
		
	    next=new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway",Font.BOLD,20));
		next.setBounds(620,660,80,30);
		next.addActionListener(this);
		add(next);
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
	}
	 @Override
	 public void actionPerformed(ActionEvent ae) {
		 String fno=""+random;
		 String name=nameText.getText();
		 String fname=fnameText.getText();
		 String dob=((JTextField) dateChoose.getDateEditor().getUiComponent()).getText();
		 String gender=null;
		 if(male.isSelected()) {
			 gender="Male";
		 }else if(female.isSelected()) {
			 gender="Female";
		 }
		 String email=emailText.getText();
		 String phone=phoneText.getText();
		 String pin=pinText.getText();
		 String address=addressText.getText();
		 String state=stateText.getText();
		 
		  try {
			  if(name.equals("")) {
				  JOptionPane.showMessageDialog(null,"please fill your name");
			  }
			  else {
				   Conn c=new Conn();
				   
				   String query="insert into signup values ('"+fno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+phone+"','"+pin+"','"+address+"','"+state+"')";
				   c.s.executeUpdate(query);
				   
				   setVisible(false);
				   new SignupTwo(fno).setVisible(true);
			  }
			  
		  }catch(Exception e){
			  System.out.println(e);
		  }
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignupOne();
	}

}
