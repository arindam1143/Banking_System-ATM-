package BankingSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener{
	JPasswordField pin,repin;
	JButton change,back;
	String pinnumber;
	PinChange(String pinnumber){
		this.pinnumber=pinnumber;
		 setLayout(null);
		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Image/atm.jpg"));
		 Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		 ImageIcon i3=new ImageIcon(i2);
		 JLabel image=new JLabel(i3);
		 image.setBounds(0,0,900,900);
		 add(image);
		 
		 JLabel text=new JLabel(" Change Your Pin !!");
		 text.setFont(new Font("System",Font.BOLD,16));
		 text.setForeground(Color.white);
		 text.setBounds(250,280,500,35);
		 image.add(text);
		 
		 JLabel newpin=new JLabel("Enter New Pin :");
		 newpin.setFont(new Font("System",Font.BOLD,16));
		 newpin.setForeground(Color.white);
		 newpin.setBounds(165,320,180,25);
		 image.add(newpin);
		 
		 pin =new JPasswordField();
		 pin.setFont(new Font("Raleway",Font.BOLD,25));
		 pin.setBounds(330,320,180,25);
		 image.add(pin);
		 
		 
		 JLabel reEnterpin=new JLabel(" Re-Enter Pin :");
		 reEnterpin.setFont(new Font("System",Font.BOLD,16));
		 reEnterpin.setForeground(Color.white);
		 reEnterpin.setBounds(165,360,180,25);
		 image.add(reEnterpin);
		 
		 repin = new JPasswordField();
		 repin.setFont(new Font("Raleway",Font.BOLD,25));
		 repin.setBounds(330,360,180,25);
		 image.add(repin);
		 
		 change=new JButton("Change");
		 change.setBounds(355,485,150,30);
		 change.addActionListener(this);
		 image.add(change);
		 
		  back=new JButton("Back");
		 back.setBounds(355,520,150,30);
		 back.addActionListener(this);
		 image.add(back);
		 
		 
		 setSize(900,900);
		 setLocation(300,0);
		 setUndecorated(true);
		 setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==change) {
			try {
				String npin=pin.getText();
				String rpin=repin.getText();
				if(!npin.equals(rpin) || npin.equals("") || rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Enter pin dose not match");
					return;
				}
				else if(npin.length()==4 && npin.equals(rpin)) {
					Conn conn= new Conn();
					String qu1="update bank set pin= '"+rpin+"' where pin='"+pinnumber+"'";
					String qu2="update login set pin= '"+rpin+"' where pin='"+pinnumber+"'";
					String qu3="update signupThree set pin= '"+rpin+"' where pin='"+pinnumber+"'";
					
					conn.s.executeUpdate(qu1);
					conn.s.executeUpdate(qu2);
					conn.s.executeUpdate(qu3);
					
					JOptionPane.showMessageDialog(null, "pin change successfull");
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "please enter 4 disite pin");
					return;
				}
				
				}catch(Exception err) {
				System.out.println(err);
			}
		}
		else {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PinChange("").setVisible(true);

	}

}
