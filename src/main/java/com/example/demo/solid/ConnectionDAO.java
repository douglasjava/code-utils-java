package com.example.demo.solid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConnectionDAO {

	private static final Logger logger = Logger.getLogger(ConnectionDAO.class);

	private Properties connectionProps;
	private Connection conn;
	private String dbms;
	private String dbName;
	private String serverName;
	private String portNumber;

	private static final String JDBC = "jdbc:";

	public ConnectionDAO() {
		super();
	}

	public ConnectionDAO(String username, String password) {
		super();
		connectionProps = new Properties();
		connectionProps.put("user", username);
		connectionProps.put("password", password);
	}

	public Connection createConnection() {
		Connection newConnection = null;
		try {

			if (getDbms().equals("mysql")) {
				newConnection = DriverManager
						.getConnection(JDBC + getDbms() + "://" + getServerName() + ":" + getPortNumber() + "/" + getDbName() + "?useSSL=false", getConnectionProps());
				
			} else if (getDbms().equals("postgreSQL")) {				
				newConnection = DriverManager
						.getConnection(JDBC + getDbms() + "://" + getServerName() + ":"+ getPortNumber() + "/" + getDbName() + "?useSSL=false", getConnectionProps());
				
			} else if (getDbms().equals("derby")) {
				newConnection = DriverManager
						.getConnection(JDBC + getDbms() + ":" + getDbName() + ";create=true",getConnectionProps());
				
			}
			
			setConn(newConnection);
			logger.info("Connected to database");
			
		} catch (SQLException e) {
			logger.error(e);
		}

		return newConnection;
	}
}
