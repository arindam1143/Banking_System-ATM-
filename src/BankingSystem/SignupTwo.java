package BankingSystem;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener{
	JTextField  panText,adharText,educationText,occuoation;
	JRadioButton syes,sno,eyes,eno;
	JButton next;
	String fno="";
	JComboBox religion,category,income;
	SignupTwo(String fno){
		this.fno=fno;
		setLayout(null);
		
		setTitle("New Application Form Page-2");
		
		
		JLabel personalDetails=new JLabel("page 2: Additional Details");
		personalDetails.setFont(new Font("Raleway",Font.BOLD,20));
		personalDetails.setBounds(290,80,400,30);
		add(personalDetails);
		
		JLabel name=new JLabel("Religion: ");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		
		String rearr[]= {"Hindu"," Muslim","Sikh","Christan","Other"};
	    religion=new JComboBox(rearr); 
		religion.setBounds(300,140,300,30);
		religion.setBackground(Color.WHITE);
		add(religion);
		
		JLabel fname=new JLabel("Category: ");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		String[] caarr= {"General","SC","ST","OBC","Other"};
	    category=new JComboBox(caarr);
		category.setBackground(Color.WHITE);
		category.setBounds(300,190,300,30);
		add(category);
		
		JLabel incom=new JLabel("Incom: ");
		incom.setFont(new Font("Raleway",Font.BOLD,20));
		incom.setBounds(100,240,200,30);
		add(incom);
		String inarr[]= {"above 10laks","above 7laks"," above 5lask","above 3laks","above 1laks","above 50K"};
		income=new JComboBox(inarr);
		income.setBounds(300,240,300,30);
		income.setBackground(Color.WHITE);
		add(income);
		
		JLabel gender=new JLabel("Educational Quali: ");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100,290,200,30);
		add(gender);
	    educationText=new JTextField();
		educationText.setBounds(300,290,300,30);
		educationText.setBackground(Color.WHITE);
		add(educationText);
		
		
		JLabel occuoa=new JLabel("Occupation: ");
		occuoa.setFont(new Font("Raleway",Font.BOLD,20));
		occuoa.setBounds(100,340,200,30);
		add(occuoa);
		
	     occuoation=new JTextField();
	     occuoation.setFont(new Font("Realway",Font.BOLD,14));
	     occuoation.setBounds(300,340,300,30);
		add( occuoation);
		
		
		JLabel pan=new JLabel("Pan Number ");
		pan.setFont(new Font("Raleway",Font.BOLD,20));
		pan.setBounds(100,390,200,30);
		add(pan);
		
	    panText=new JTextField();
		panText.setFont(new Font("Realway",Font.BOLD,14));
		panText.setBounds(300,390,300,30);
		add(panText);
		
		JLabel adhar=new JLabel("Adhar Number ");
		adhar.setFont(new Font("Raleway",Font.BOLD,20));
		adhar.setBounds(100,440,200,30);
		add(adhar);
		
		adharText=new JTextField();
		adharText.setFont(new Font("Realway",Font.BOLD,14));
		adharText.setBounds(300,440,300,30);
		add(adharText);
		
		JLabel pin=new JLabel("Senior Citizen: ");
		pin.setFont(new Font("Raleway",Font.BOLD,20));
		pin.setBounds(100,490,200,30);
		add(pin);
		syes=new JRadioButton("Yes");
		syes.setBounds(300,490,60,30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno=new JRadioButton("No");
		sno.setBounds(450,490,120,30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup seci=new ButtonGroup();
		seci.add(syes);
		seci.add(sno);
		
		
		JLabel state=new JLabel("Exisiting Account:");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(100,540,200,30);
		add(state);
		eyes=new JRadioButton("Yes");
		eyes.setBounds(300,540,60,30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno=new JRadioButton("No");
		eno.setBounds(450,540,120,30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup exac=new ButtonGroup();
		exac.add(eyes);
		exac.add(eno);
		
	   
		
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
		 String fno="";
		 String Religion=(String)religion.getSelectedItem();
		 String Category=(String)category.getSelectedItem();
		 String incom=(String)income.getSelectedItem();
		 String seniorCitizon=null;
		 if(syes.isSelected()) {
			 seniorCitizon="Yes";
		 }else if(sno.isSelected()) {
			 seniorCitizon="No";
		 }
		 String occu= occuoation.getText();
		 String pan=panText.getText();
		 String education=educationText.getText();
		 String adhar=adharText.getText();
		 String Exuser=null;
		 if(eyes.isSelected()) {
			 Exuser="Yes";
		 }else if(eno.isSelected()) {
			 Exuser="No";
		 }
		 
		  try {
			  
				   Conn c=new Conn();
				   
				   String query="insert into signupTwo values ('"+fno+"','"+Religion+"','"+Category+"','"+incom+"','"+education+"','"+occu+"','"+pan+"','"+seniorCitizon+"','"+adhar+"','"+Exuser+"')";
				   c.s.executeUpdate(query);
				   setVisible(false);
				   new SignupThree(fno).setVisible(true);
			  
			  
		  }catch(Exception e){
			  System.out.println(e);
		  }
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignupTwo("");
	}

}

