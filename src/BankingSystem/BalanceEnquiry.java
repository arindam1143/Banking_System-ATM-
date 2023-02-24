package BankingSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class BalanceEnquiry extends JFrame implements ActionListener{
	String pinnumber;
	JButton back;
	BalanceEnquiry(String pinnumber){
		this.pinnumber=pinnumber;
		setLayout(null);
		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Image/atm.jpg"));
		 Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		 ImageIcon i3=new ImageIcon(i2);
		 JLabel image=new JLabel(i3);
		 image.setBounds(0,0,900,900);
		 add(image);
		 
		 back=new JButton("back");
		 back.setBounds(355,520,150,30);
	     back.addActionListener(this);
		 image.add(back);
		 
		 Conn conn=new Conn();
		 int balance=0;
		 try {
		    ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
			 
			 while (rs.next()) {
		               if (rs.getString("type").equals("Deposit")) {
		                   balance += Integer.parseInt(rs.getString("amount"));
		               } else {
		                   balance -= Integer.parseInt(rs.getString("amount"));
		                }
		            } 
			}catch(Exception a){
				System.out.println(a);
			}
		 
		 JLabel text=new JLabel("your current balance is "+balance+" RS");
		 text.setForeground(Color.white);
		 text.setBounds(170,300,400,30);
		 image.add(text);
		 setSize(900,900);
		 setLocation(300,0);
		 setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Transaction(pinnumber).setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BalanceEnquiry("");

	}

}
