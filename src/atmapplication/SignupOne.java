
package atmapplication;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;




public class SignupOne extends JFrame implements ActionListener {
    
    long random;
    JTextField nameTF , dobTF,emailTF, cityTF, countryTF;
    JButton next;
    JRadioButton male, female, single, married;
    
    SignupOne(){
        
        setLayout(null);
                
        Random ran = new Random();
         random =Math.abs(ran.nextLong()%80000L + 10000L);
        
        JLabel formno =new JLabel("APPLICATION FORM NO."+ random);
        formno.setFont(new Font("Raleway", Font.BOLD,38));
        formno.setBounds(140, 20 ,600, 40);
        add(formno);
        
        JLabel PDetails =new JLabel("Personal Details");
        PDetails.setFont(new Font("Raleway", Font.BOLD,24));
        PDetails.setBounds(290, 80 ,400, 30);
        add(PDetails);
                
        JLabel name =new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100, 140 ,100, 30);
        add(name);
        
        nameTF = new JTextField();
        nameTF.setFont(new Font("Raleway", Font.BOLD,14));
        nameTF.setBounds(300, 140,280,30);
        add(nameTF);
        
        JLabel dob =new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100, 210 ,200, 30);
        add(dob);
        
        dobTF = new JTextField();
        dobTF.setFont(new Font("Raleway", Font.BOLD,14));
        dobTF.setBounds(300, 210,280,30);
        add(dobTF);
        
        
        JLabel gender =new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100, 280, 100, 30);
        add(gender);
        
        male =new JRadioButton("Male");
        male.setBounds(300,280,90,30);
        male.setBackground(Color.WHITE);
        add (male);
        female =new JRadioButton("Female");
        female.setBounds(400,280,90,30);
        female.setBackground(Color.WHITE);
        add(female);
                
        
        JLabel email =new JLabel("E-Mail:");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100, 350 ,200, 30);
        add(email);
        
        emailTF = new JTextField();
        emailTF.setFont(new Font("Raleway", Font.BOLD,14));
        emailTF.setBounds(300, 350,280,30);
        add(emailTF);
        
        JLabel mstatus =new JLabel("Marital Status:");
        mstatus.setFont(new Font("Raleway", Font.BOLD,20));
        mstatus.setBounds(100, 430 ,200, 30);
        add(mstatus);
        
        single = new JRadioButton("Single");
        single.setBounds(300,430,90,30);
        single.setBackground(Color.WHITE);
        add(single);
        married = new JRadioButton("Married");
        married.setBounds(400,430,90,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        JLabel city =new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100, 500 ,200, 30);
        add(city);
        
        cityTF = new JTextField();
        cityTF.setFont(new Font("Raleway", Font.BOLD,14));
        cityTF.setBounds(300, 500,280,30);
        add(cityTF);
        
        JLabel country =new JLabel("Country:");
        country.setFont(new Font("Raleway", Font.BOLD,20));
        country.setBounds(100, 570 ,200, 30);
        add(country);
        
        countryTF = new JTextField();
        countryTF.setFont(new Font("Raleway", Font.BOLD,14));
        countryTF.setBounds(300, 570,280,30);
        add(countryTF);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(480, 620, 100, 40);
        next.addActionListener(this);
        add(next);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = nameTF.getText();
        String dob = dobTF.getText();
        String gender = null;
        if (male.isSelected()){
            gender = "male";
        }else if (female.isSelected()){
            gender = "female";
        }
        String email= emailTF.getText();
        String mstatus = null;
        if(single.isSelected()){
            mstatus = "single";        
        }else if (married.isSelected()){
            mstatus = "married";
            }
        String city = cityTF.getText();
        String country =countryTF.getText();
        
        try{
        if (name.equals("")){
            JOptionPane.showMessageDialog(null, "Name is required");
        }else{
            Conn c = new Conn();
            String query= "insert into signup values('"+formno+"','"+name+"','"+dob+"','"+gender+"','"+email+"','"+mstatus+"','"+city+"','"+country+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
         
             new SignupTwo(formno).setVisible(true);
            } 
        }catch(Exception e){
            System.out.println(e);
        }
            
    }
    
    public static void main(String[]args){
    new SignupOne();
    }
}
