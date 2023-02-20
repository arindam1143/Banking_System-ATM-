package BankingSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener{
	JButton deposit,back;
	JTextField amount;
	
	String pinnumber;
	Deposit(String pinnumber){
		this.pinnumber=pinnumber;
		setLayout(null);
		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Image/atm.jpg"));
		 Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		 ImageIcon i3=new ImageIcon(i2);
		 JLabel image=new JLabel(i3);
		 image.setBounds(0,0,900,900);
		 add(image);
		 
		 JLabel text=new JLabel("Enter the amount you want to Deposit");
		 text.setForeground(Color.WHITE);
		 text.setFont(new Font("System",Font.BOLD,16));
		 text.setBounds(170,300,400,20);
		 image.add(text);
		 
		 amount=new JTextField();
		 amount.setFont(new Font("Railway",Font.BOLD,22));
		 amount.setBounds(170,350,320,25);
		 image.add(amount);
		 
		  deposit=new JButton("Deposit");
		 deposit.setBounds(355,485,150,30);
		 deposit.addActionListener(this);
		 image.add(deposit);
		 
		  back=new JButton("<- Back");
		 back.setBounds(355,520,150,30);
		 back.addActionListener(this);
		 image.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent a) {
		if(a.getSource()==deposit) {
			String number=amount.getText();
			Date date=new Date();
			if(number.equals("")) {
				 JOptionPane.showMessageDialog(null,"please enter amy amount to deposit");
			}
			else {
				try {
					Conn conn=new Conn();
					String qu="insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";
					conn.s.executeUpdate(qu);
					JOptionPane.showMessageDialog(null,number+" rs deposit Successfully");
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			
		}else if(a.getSource()==back){
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Deposit("");
	}

}
