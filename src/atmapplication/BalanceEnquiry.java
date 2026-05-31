
package atmapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String cardnumber;
    
   BalanceEnquiry(String cardnumber){
       this.cardnumber = cardnumber;
       setLayout(null);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/set-re.jpg"));
       Image i2 =i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT );
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0, 0, 900, 900);
       add (image);
       
       back = new JButton("Back");
       back.setBounds(355, 480,150, 30);
       back.addActionListener(this);
       image.add(back);
       
       Conn c = new Conn();
       int balance = 0;
       try{
           ResultSet rs = c.s.executeQuery("select * from bankTransfer where cardnumber ='"+cardnumber+"'");
           while(rs.next()){
               

                String type = rs.getString("type").trim();
                

                if(type.equalsIgnoreCase("Deposit") || type.equalsIgnoreCase("Transfer Received")){
                    
                    balance += Integer.parseInt(rs.getString("amount"));
                    

                } else if(type.equalsIgnoreCase("Withdraw") || type.equalsIgnoreCase("Transfer Sent")){
                    
                     balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
       }catch(Exception e){
           System.out.println(e);
       }
       
       JLabel text =new JLabel("Your Current Account balance is USD "+balance);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD, 14));
       text.setBounds(300, 400, 400, 30);
       image.add(text);
       
       setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
   
   }
   
   public void actionPerformed(ActionEvent ae){
       setVisible(false);
       new Transactions(cardnumber).setVisible(true);
   }
 public static void main(String[]args){
     
     new BalanceEnquiry("");
  }   
}
