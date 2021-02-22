package com.example.demo.padraocodigo.facadepattern;

import java.sql.ResultSet;

public class TestDBUtil {

	public static void main(String[] args) {

		DBUtil db = new DBUtil();

		try {

			String sql = "insert into tabela () values ()";

			db.executeUpdate(sql);

			sql = "update tabela set campo = '' where campo = 1";

			db.executeUpdate(sql);

			sql = "select * from tabela";

			ResultSet rs = db.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				System.out.println(id);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			db.DBClose();

		}

	}

}
