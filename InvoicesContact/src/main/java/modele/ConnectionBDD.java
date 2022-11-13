package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBDD {
	public Connection getConnection() {
		try {
		Connection connect = null;

		String url = "jdbc:mysql://localhost/";
		String dbName = "invoices_contact";
		String user = "root";
		String pwd = "";

		
			Class.forName("com.mysql.cj.jdbc.Driver");

			try {
				connect = DriverManager.getConnection(url + dbName, user, pwd);
				System.out.println("connect ok");

			} catch (SQLException e) {

				e.printStackTrace();
			}
			return connect;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
