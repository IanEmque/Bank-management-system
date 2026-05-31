package atmapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transfer extends JFrame implements ActionListener {

    JTextField account, amount;
    JButton transfer, back;
    String cardnumber;

    Transfer(String cardnumber){

        this.cardnumber = cardnumber;

        setLayout(null);

        JLabel text = new JLabel("Transfer Money");
        text.setFont(new Font("System", Font.BOLD, 20));
        text.setBounds(170, 40, 300, 30);
        add(text);

        JLabel acc = new JLabel("Receiver Card Number:");
        acc.setBounds(50, 100, 150, 30);
        add(acc);

        account = new JTextField();
        account.setBounds(200, 100, 200, 30);
        add(account);

        JLabel amt = new JLabel("Amount:");
        amt.setBounds(50, 160, 150, 30);
        add(amt);

        amount = new JTextField();
        amount.setBounds(200, 160, 200, 30);
        add(amount);

        transfer = new JButton("Transfer");
        transfer.setBounds(90, 250, 120, 30);
        transfer.addActionListener(this);
        add(transfer);

        back = new JButton("Back");
        back.setBounds(240, 250, 120, 30);
        back.addActionListener(this);
        add(back);

        setSize(500, 400);
        setLocation(400, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == transfer){

            try{

                String receiver = account.getText();
                String money = amount.getText();

                if(receiver.equals("") || money.equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill all fields");
                    return;
                }

                Conn c = new Conn();

                // deduct from sender
                String q1 = "insert into bankTransfer values('"+cardnumber+"', 'Transfer Sent', '"+money+"')";
                c.s.executeUpdate(q1);

                // add to receiver
                String q2 = "insert into bankTransfer values('"+receiver+"', 'Transfer Received', '"+money+"')";
                c.s.executeUpdate(q2);

                JOptionPane.showMessageDialog(null, "Transfer Successful");

                setVisible(false);
                new Transactions(cardnumber).setVisible(true);

            }catch(Exception e){
                System.out.println(e);
            }

        }else if(ae.getSource() == back){

            setVisible(false);
            new Transactions(cardnumber).setVisible(true);
        }
    }

    public static void main(String[] args){
        new Transfer("");
    }
}