
package BankingSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCase extends JFrame implements ActionListener {
	JButton deposit,withdrawl,fastcase,ministatement,pinChange,balanceenquiry,back;
	String pinnumber;
	FastCase(String pinnumber){
		 this.pinnumber=pinnumber;
		 setLayout(null);
		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Image/atm.jpg"));
		 Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		 ImageIcon i3=new ImageIcon(i2);
		 JLabel image=new JLabel(i3);
		 image.setBounds(0,0,900,900);
		 add(image);
		 
		 JLabel text=new JLabel("please select amount ");
		 text.setBounds(210,300,700,35);
		 text.setForeground(Color.WHITE);
		 text.setFont(new Font("System",Font.BOLD,16));
		 image.add(text);
		 
		  deposit=new JButton("Rs 500");
		 deposit.setBounds(170,415,150,30);
		 deposit.addActionListener(this);
		 image.add(deposit);
		 
		  withdrawl=new JButton("Rs 1000");
		 withdrawl.setBounds(355,415,150,30);
		 withdrawl.addActionListener(this);
		 image.add(withdrawl);
		 
		  fastcase=new JButton("Rs 1500");
		 fastcase.setBounds(170,450,150,30);
		 fastcase.addActionListener(this);
		 image.add(fastcase);
		 
		 ministatement=new JButton("Rs 2000");
		 ministatement.setBounds(355,450,150,30);
		 ministatement.addActionListener(this);
		 image.add(ministatement);
		 
		  pinChange=new JButton("Rs 5000");
		 pinChange.setBounds(170,485,150,30);
		 pinChange.addActionListener(this);
		 image.add(pinChange);
		 
		  balanceenquiry=new JButton("Rs 10000");
		 balanceenquiry.setBounds(355,485,150,30);
		 balanceenquiry.addActionListener(this);
		 image.add(balanceenquiry);
		 
		  back=new JButton("<-Back");
		 back.setBounds(355,520,150,30);
	     back.addActionListener(this);
		 image.add(back);
		 
		 setSize(900,900);
		 setLocation(300,0);
		 setUndecorated(true);
		 setVisible(true);
	 }
	 public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==back) {
			 setVisible(false);
			 new Transaction(pinnumber).setVisible(true);
		 }
		 
		 else{
			 String amount =((JButton)e.getSource()).getText().substring(3);
			 Conn conn=new Conn();
			try {
				 ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
				 int balance=0;
				 while (rs.next()) {
		                if (rs.getString("type").equals("Deposit")) {
		                    balance += Integer.parseInt(rs.getString("amount"));
		                } else {
		                    balance -= Integer.parseInt(rs.getString("amount"));
		                }
		            } 
				 String num = "";
		            if (e.getSource() != back && balance < Integer.parseInt(amount)) {
		                JOptionPane.showMessageDialog(null, "Insuffient Balance");
		                return;
		            }

		            if (e.getSource() == back) {
		                this.setVisible(false);
		                new Transaction(pinnumber).setVisible(true);
		            }else{
		                Date date = new Date();
		                conn.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
		                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
		                    
		                setVisible(false);
		                new Transaction(pinnumber).setVisible(true);
		            }
			}catch(Exception a){
				System.out.print(a);
			}
		 }
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FastCase("");
	}

}

