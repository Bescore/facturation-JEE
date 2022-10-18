package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBDD {
	public  Connection getConnection() {
	Connection connect = null;
		
	String url = "jdbc:mysql://localhost/";
    String dbName = "invoices_contact";
    String user="root";
    String pwd="";

		
    try {
    Class.forName("com.mysql.cj.jdbc.Driver");

         try {
    connect = DriverManager.getConnection(url+dbName,user,pwd);
    System.out.println("connect ok");

    } catch (SQLException e) {
   
    e.printStackTrace();
    }
    } catch (ClassNotFoundException e) {e.printStackTrace();
    }
    return connect;
    }
}
