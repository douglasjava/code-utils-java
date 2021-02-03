package com.example.demo.connection;

import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class Sftp {

	private static final int SESSION_TIMEOUT = 10000;
	private static final int CHANNEL_TIMEOUT = 5000;

	public static void main(String[] args) {

		uploadJsch();

		//downloadJsch();

	}

	public static void uploadJsch() {

		String localFile = "src/main/resources/testesftp.txt";
		String remoteDir = "/usr_neo/jschFile.txt";
		Connection connection = new Connection();
		try {

			connection = connection();

			if (connection.getSftp().isConnected()) {
				connection.getSftp().put(localFile, remoteDir);

				connection.getSftp().exit();

			}

		} catch (SftpException e) {

			e.printStackTrace();

		} finally {
			if (connection.getSession() != null) {
				connection.getSession().disconnect();
			}
		}

		System.out.println("Upload!");

	}

	public static void downloadJsch() {

		String remoteDir = "src/main/resources/testesftp4.txt";
		String localFile = "/usr_neo/welcome.txt";
		Connection connection = new Connection();

		try {

			connection = connection();

			if (connection.getSftp().isConnected()) {
				connection.getSftp().get(localFile, remoteDir);

				connection.getSftp().exit();

			}

		} catch (SftpException e) {

			e.printStackTrace();

		} finally {
			if (connection.getSession() != null) {
				connection.getSession().disconnect();
			}
		}

		System.out.println("Done");

	}

	public static Connection connection() {
		Connection connection = new Connection();
		Session jschSession = null;
		try {

			JSch jsch = new JSch();
			jschSession = jsch.getSession("usr_neo", "10.2.250.10", 62228);
			jschSession.setPassword("5ftpN3O2020");

			Properties config = new java.util.Properties();

			// Linha para correção de falha ao conectar em sftp mais novos link https://stackoverflow.com/questions/30077327/jschexception-algorithm-negotiation-fail-diffie-hellman-group14-sha1
			config.put("kex", "diffie-hellman-group1-sha1,diffie-hellman-group14-sha1,diffie-hellman-group-exchange-sha1,diffie-hellman-group-exchange-sha256");
			config.put("StrictHostKeyChecking", "no");
			
			jschSession.setConfig(config);
			jschSession.connect(SESSION_TIMEOUT);

			Channel sftp = jschSession.openChannel("sftp");
			sftp.connect(CHANNEL_TIMEOUT);
			ChannelSftp channelSftp = (ChannelSftp) sftp;

			connection.setSession(jschSession);
			connection.setSftp(channelSftp);

		} catch (JSchException e) {
			e.printStackTrace();

		}

		return connection;

	}

}
