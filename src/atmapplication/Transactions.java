
package atmapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    
    JButton deposit,withdraw,changepin,balance,transfer ,exit;
    String cardnumber;
    String pinnumber;

    Transactions(String cardnumber){
        this.cardnumber = cardnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/set-re.jpg"));
        Image i2 =i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Select your Transaction");
        text.setBounds(360, 350,700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        deposit =new JButton ("Deposit");
        deposit.setBounds(280,415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdraw=new JButton ("Withdraw");
        withdraw.setBounds(450,415, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        changepin =new JButton ("Change Pin");
        changepin.setBounds(280,475, 150, 30);
        changepin.addActionListener(this);
        image.add(changepin);
                
        balance =new JButton ("Balance Enquiry");
        balance.setBounds(450,475, 150, 30);
        balance.addActionListener(this);
        image.add(balance);
        
        transfer =new JButton ("Transfer");
        transfer.setBounds(280,520, 150, 30);
        transfer.addActionListener(this);
        image.add(transfer);
     
        
        exit =new JButton ("Exit");
        exit.setBounds(450,520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(cardnumber).setVisible(true);
        }else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdraw(cardnumber).setVisible(true);
        }else if (ae.getSource()== changepin ){
            setVisible(false);
            new PinChange(cardnumber).setVisible(true);
        }else if (ae.getSource()== balance){
            new BalanceEnquiry(cardnumber).setVisible(true);
        }else if(ae.getSource() == transfer){
            setVisible(false);
            new Transfer(cardnumber).setVisible(true);
}
        
    }
    
    
    public static void main(String[]args){
        new Transactions("");
    
    }
}
