package com.example.demo.padraocodigo.facadepattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {

	protected Connection conn;
	protected Statement stmt;

	public DBUtil() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public Connection openConnection() {

		try {

			return DriverManager.getConnection(
					"jdbc:mysql://localhost/algafood?createDatabaseIfNotExist=true&serverTimezone=UTC", "root",
					"12345");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public boolean executeUpdate(String sql) {
		this.conn = openConnection();

		try {

			Statement stmt = this.conn.createStatement();

			if (stmt.executeUpdate(sql) > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (this.conn != null) {
				try {
					this.conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}

		return false;

	}

	public ResultSet executeQuery(String sql) {

		this.conn = openConnection();

		try {

			Statement stmt = this.conn.createStatement();
			return stmt.executeQuery(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public void DBClose() {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
