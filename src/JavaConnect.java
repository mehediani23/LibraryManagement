/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mehedi
 */
import java.sql.*;
import javax.swing.JOptionPane;
public class JavaConnect {
    Connection con;
   public static Connection connectdb(){  
try{  
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
  
//step2 create  the connection object  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","mehedi","kuet1259");
return con;
}catch(Exception e)
{
    JOptionPane.showMessageDialog(null, e);
    return null;
}  
}  
}