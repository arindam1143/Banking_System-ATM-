package BankingSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transaction extends JFrame implements ActionListener {
	JButton deposit,withdrawl,fastcase,ministatement,pinChange,balanceenquiry,exit;
	String pinnumber;
	 Transaction(String pinnumber){
		 this.pinnumber=pinnumber;
		 setLayout(null);
		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Image/atm.jpg"));
		 Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		 ImageIcon i3=new ImageIcon(i2);
		 JLabel image=new JLabel(i3);
		 image.setBounds(0,0,900,900);
		 add(image);
		 
		 JLabel text=new JLabel("Place select your Transaction");
		 text.setBounds(210,300,700,35);
		 text.setForeground(Color.WHITE);
		 text.setFont(new Font("System",Font.BOLD,16));
		 image.add(text);
		 
		  deposit=new JButton("Deposit");
		 deposit.setBounds(170,415,150,30);
		 deposit.addActionListener(this);
		 image.add(deposit);
		 
		  withdrawl=new JButton("withdrawl case");
		 withdrawl.setBounds(355,415,150,30);
		 withdrawl.addActionListener(this);
		 image.add(withdrawl);
		 
		  fastcase=new JButton("fast case");
		 fastcase.setBounds(170,450,150,30);
		 fastcase.addActionListener(this);
		 image.add(fastcase);
		 
		 ministatement=new JButton("Mini Statement");
		 ministatement.setBounds(355,450,150,30);
		 ministatement.addActionListener(this);
		 image.add(ministatement);
		 
		  pinChange=new JButton("Pin Change");
		 pinChange.setBounds(170,485,150,30);
		 pinChange.addActionListener(this);
		 image.add(pinChange);
		 
		  balanceenquiry=new JButton("Balance Enquiry");
		 balanceenquiry.setBounds(355,485,150,30);
		 balanceenquiry.addActionListener(this);
		 image.add(balanceenquiry);
		 
		  exit=new JButton("Exit->");
		 exit.setBounds(355,520,150,30);
	     exit.addActionListener(this);
		 image.add(exit);
		 
		 setSize(900,900);
		 setLocation(300,0);
		 setUndecorated(true);
		 setVisible(true);
	 }
	 public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==exit) {
			 System.exit(0);
		 }
		 else if(e.getSource()==deposit) {
			 setVisible(false);
			 new Deposit(pinnumber).setVisible(true);
		 }
		 else if(e.getSource()==withdrawl) {
			 setVisible(false);
			 new Withdral(pinnumber).setVisible(true);
		 }
		 else if(e.getSource()==fastcase) {
			 setVisible(false);
			 new FastCase(pinnumber).setVisible(true);
		 }
		 else if(e.getSource()==pinChange) {
			 setVisible(false);
			 new PinChange(pinnumber).setVisible(true);
		 }
		 else if(e.getSource()== balanceenquiry) {
			 setVisible(false);
			 new  BalanceEnquiry(pinnumber).setVisible(true);
		 }
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Transaction("");
	}

}
