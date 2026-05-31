package atmapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Withdraw extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdraw, back;
    String cardnumber;
    String pinnumber;
    
    Withdraw(String cardnumber){
        
    this.cardnumber =  cardnumber;
    setLayout(null);
    
    ImageIcon i1 =new ImageIcon (ClassLoader.getSystemResource("icons/set-re.jpg"));
    Image i2 =i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
    ImageIcon i3 =new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,900,900);
    add(image);
    
    JLabel text = new JLabel ("Enter the amount you want to withdraw");
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System",Font.BOLD, 14));
    text.setBounds(330, 350,400, 20);
    image.add(text);
    
    amount = new JTextField();
    amount.setFont(new Font("Raleway", Font.BOLD,22));
    amount.setBounds(300, 400,320, 25);
    image.add(amount);
    
    withdraw = new JButton("Withdraw");
    withdraw.setBounds(355, 485,150,30);
    withdraw.addActionListener(this);
    image.add(withdraw);
    
    back = new JButton("Back");
    back.setBounds(355, 520,150,30);
    back.addActionListener(this);
    image.add(back);
    
    setSize(900,900);
    setLocation(300,0);
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
            if (ae.getSource()== withdraw){
                String number = amount.getText();
                if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount to withdraw");
                }else{
                    try{
                        
                       Conn conn=new Conn();
                       String query1="insert into bankTransfer values('"+cardnumber+"','Withdraw','"+number+"')";
                       conn.s.executeUpdate(query1);
                       
                       String query2 = "update bank set amount = amount - '" + number + "' where cardnumber = '" + cardnumber + "'";
                       conn.s.executeUpdate(query2);
                       
                       JOptionPane.showMessageDialog(null, "USD "+number+"  Withdrawl  Successfully");
                       
                       setVisible(false);
                       new Transactions(cardnumber).setVisible(true);
                        }catch(Exception e){
                             System.out.println(e);
                         }
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(cardnumber).setVisible(true);
            }
    
    }
    
    public static void main(String[]args){
    
        new Withdraw("");
    }
}
