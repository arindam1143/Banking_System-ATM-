package BankingSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class MiniStatement extends JFrame implements ActionListener {
	String pinnumber;
	JButton cancle;
	MiniStatement(String pinnumber){
		this.pinnumber=pinnumber;
		setTitle("Mini Statement");
		setLayout(null);
		
		JLabel mini=new JLabel();
		add(mini);
		
		JLabel bank=new JLabel("Arindam Bank");
		bank.setBounds(150,20,100,20);
		add(bank);
		
		JLabel card=new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		JLabel money=new JLabel();
		money.setBounds(20,400,300,20);
		add(money);
		
		 cancle=new JButton("cancle");
		cancle.setBounds(250,500,100,30);
		//cancle.setBackground(Color.BLACK);
		cancle.setFont(new Font("System" ,Font.BOLD,15));
		cancle.addActionListener(this);
		add(cancle);
		
		try {
			Conn conn=new Conn();
			
			ResultSet rs=conn.s.executeQuery("select * from login where pin ='"+pinnumber+"'");
			while(rs.next()) {
				card.setText("Card Number is  "+rs.getString("cardno").substring(0,4)+"xxxxxxxx"+rs.getString("cardno").substring(12));
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			Conn conn=new Conn();
			int balance=0;
			ResultSet rs=conn.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
			while(rs.next()) {
				mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
				if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
			}
			money.setText("your current amount is "+balance);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		mini.setBounds(20,140,400,200);
		
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.white);
		setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cancle) {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MiniStatement("");

	}

}
