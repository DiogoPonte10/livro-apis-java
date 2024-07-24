package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	/**
	 *
	 * @return conex�o com o banco de dados
	 */
	public Connection getConnection() {
		String url = "jdbc:mysql://localhost/livraria";
		try {
			return DriverManager.getConnection(url, "root", "cursomysql");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
