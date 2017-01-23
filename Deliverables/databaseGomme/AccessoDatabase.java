package databaseGomme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccessoDatabase {
	private Connection connessione;

	public AccessoDatabase(String host, int porta, String user, String password)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// 1) caricamento
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		// 2) connessione e collegamento
		connessione = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta, user, password);
	}

	public ResultSet effetuaQuery(String query) throws SQLException {
		// 4) statement
		Statement statement = connessione.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		return resultSet;

	}

	public void effettuaUpdate(String query) throws SQLException {
		Statement statement = connessione.createStatement();
		if (statement.executeUpdate(query) <= 0) {
			throw new SQLException();
		}

	}

	public void close() throws SQLException {
		connessione.close();
	}
}
