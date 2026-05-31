
package atmapplication;


import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmapplication", "root","miba04iaN");
            s = c.createStatement();
        
        }catch(Exception e){
        System.out.println(e);
        }
    }
}
