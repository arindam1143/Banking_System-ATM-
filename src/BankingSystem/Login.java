package BankingSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
	JButton signup,cBtn,sBtn;
	 JTextField cardText;
	 JPasswordField pinText;
      Login(){
    	  setTitle("All Time Money");
    	  setLayout(null);
    	  ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("Image/bankLogo.jpg"));
    	  Image i1=i.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    	  ImageIcon i2=new ImageIcon(i1);
    	  JLabel label=new JLabel(i2);
    	  label.setBounds(70,10,100,100);
    	  add(label);
    	  
    	  JLabel text= new JLabel("wellcome to ATM");
    	  text.setFont(new Font("Osward",Font.BOLD,38));
    	  text.setBounds(200, 40, 400, 40);
    	  add(text);
    	  
    	  JLabel CardNo= new JLabel("Card No :- ");
    	  CardNo.setFont(new Font("Osward",Font.BOLD,28));
    	  CardNo.setBounds(120, 150, 150, 30);
    	  add( CardNo);
    	  
    	  cardText=new JTextField();
    	  cardText.setBounds(300,150,250,30);
    	  cardText.setFont(new Font("Arial",Font.BOLD,14));
    	  add(cardText);
    	  
    	  JLabel Pin= new JLabel("Pin No:- ");
    	  Pin.setFont(new Font("Osward",Font.BOLD,28));
    	  Pin.setBounds(120, 220, 400, 30);
    	  add(Pin);
    	  
    	  pinText=new JPasswordField();
    	  pinText.setBounds(300,220,250,30);
    	  pinText.setFont(new Font("Arial",Font.BOLD,14));
    	  add(pinText);
    	  
    	  sBtn=new JButton("Login");
    	  sBtn.setBounds(300,270,100,30);
    	  sBtn.setBackground(Color.BLACK);
    	  sBtn.setForeground(Color.white);
    	  sBtn.addActionListener(this);
    	  add(sBtn);
    	  
    	  cBtn=new JButton("CLEAR");
    	  cBtn.setBounds(450,270,100,30);
    	  cBtn.setBackground(Color.BLACK);
    	  cBtn.setForeground(Color.white);
    	  cBtn.addActionListener(this);
    	  add(cBtn);
    	  
    	  signup=new JButton("SIGN UP");
    	  signup.setBounds(300,310,250,30);
    	  signup.setBackground(Color.BLACK);
    	  signup.setForeground(Color.white);
    	  signup.addActionListener(this);
    	  add(signup);
    	  
    	  getContentPane().setBackground(Color.white);
    	 
    	  setSize(800,400);
    	  setVisible(true);
    	  setLocation(350,200);
      }
      @Override
      public void actionPerformed(ActionEvent ae) {
    	  if(ae.getSource()==cBtn) {
    		  cardText.setText("");
    		  pinText.setText("");
    	  }
    	  else if(ae.getSource()==sBtn) {
    		  Conn conn=new Conn();
    		  String cardnumber=cardText.getText();
    		  String pinnumber=pinText.getText();
    		  String queary="select * from login  where cardno ='"+cardnumber+"' and pin='"+pinnumber+"'";
    		  try {
    			  ResultSet rs=conn.s.executeQuery(queary);
    			  if(rs.next()) {
    				  setVisible(false);
        			  new Transaction(pinnumber).setVisible(true);
    			  }
    			  else {
    				  JOptionPane.showMessageDialog(null, "incrrect card no or pin");
    			  }
    		  }catch(Exception e) {
    			  System.out.println(e);
    		  }
    	  }
    	  else if(ae.getSource()==signup) {
    		  setVisible(false);
    		  new SignupOne().setVisible(true);
    	  }
      }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}

}
