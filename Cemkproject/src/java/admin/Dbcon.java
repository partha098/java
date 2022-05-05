package admin;

import java.sql.*;
public class Dbcon {
    protected static Connection getcon()
        throws SQLException, ClassNotFoundException
    {
        
          Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cemkproject","root",""); 

  return con;
    }
    
}