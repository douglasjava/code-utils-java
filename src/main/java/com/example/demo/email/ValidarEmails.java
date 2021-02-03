package com.example.demo.email;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class ValidarEmails {

	public static void main(String args[]) {
		List<String> emails = new ArrayList<>();
		emails.add("douglasmarquesdias@hotmail.com");

		for (String address : emails) {
			System.out.println(String.format("Email %s é %s", address, isAddressValid(address)));
		}

	}

	public static boolean isAddressValid(String address) {
		// Find the separator for the domain name
		int pos = address.indexOf('@');

		// If the address does not contain an '@', it's not valid
		if (pos == -1) {
			return false;

		}

		// Isolate the domain/machine name and get a list of mail exchangers
		String domain = address.substring(++pos);
		List<String> mxList = new ArrayList<>();
		try {
			mxList = getMX(domain);
		} catch (NamingException ex) {
			return false;
		}

		// Just because we can send mail to the domain, doesn't mean that the
		// address is valid, but if we can't, it's a sure sign that it isn't
		if (mxList.isEmpty()) {
			return false;

		}

		for (int mx = 0; mx < mxList.size(); mx++) {
			String addressMail = mxList.get(mx);

			int res = 0;
			try (Socket skt = new Socket(addressMail, 25)) {

				try (BufferedReader rdr = new BufferedReader(new InputStreamReader(skt.getInputStream()))) {

					try (BufferedWriter wtr = new BufferedWriter(new OutputStreamWriter(skt.getOutputStream()))) {

						res = hear(rdr);
						if (res != 220) {
							throw new IllegalArgumentException("Invalid header");

						}

						say(wtr, "HELO " + addressMail);
						res = hear(rdr);
						if (res != 250) {
							throw new IllegalArgumentException("Not ESMTP");

						}

						// validate the sender address
						say(wtr, "MAIL FROM: <tim@orbaker.com>");
						res = hear(rdr);
						if (res != 250) {
							throw new IllegalArgumentException("Sender rejected");

						}

						say(wtr, "RCPT TO: <" + address + ">");
						res = hear(rdr);

						say(wtr, "RSET");
						hear(rdr);
						say(wtr, "QUIT");
						hear(rdr);
						if (res != 250) {
							throw new IllegalArgumentException("Address is not valid!");

						}

					}
				}

				return true;

			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());

			} catch (Exception e) {
				e.printStackTrace();

			}

		}
		
		return false;

	}

	private static int hear(BufferedReader in) throws IOException {
		String line = null;
		int res = 0;

		while ((line = in.readLine()) != null) {
			String pfx = line.substring(0, 3);

			try {
				res = Integer.parseInt(pfx);
			} catch (Exception ex) {
				res = -1;
			}

			if (line.charAt(3) != '-') {
				break;
			}

		}

		return res;
	}

	private static void say(BufferedWriter wr, String text) throws IOException {
		wr.write(text + "\r\n");
		wr.flush();
	}

	private static List<String> getMX(String hostName) throws NamingException {

		Hashtable<String, String> env = new Hashtable<>();
		env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
		DirContext ictx = new InitialDirContext(env);
		Attributes attrs = ictx.getAttributes(hostName, new String[] { "MX" });
		Attribute attr = attrs.get("MX");

		// if we don't have an MX record, try the machine itself
		if ((attr == null) || (attr.size() == 0)) {
			attrs = ictx.getAttributes(hostName, new String[] { "A" });
			attr = attrs.get("A");
			if (attr == null) {
				throw new NamingException("No match for name '" + hostName + "'");
			}
		}

		List<String> res = new ArrayList<>();
		NamingEnumeration<?> en = attr.getAll();

		while (en.hasMore()) {
			String mailhost;
			String x = (String) en.next();
			String f[] = x.split(" ");

			if (f.length == 1) {
				mailhost = f[0];

			} else if (f[1].endsWith(".")) {
				mailhost = f[1].substring(0, (f[1].length() - 1));

			} else {
				mailhost = f[1];

			}

			res.add(mailhost);
		}

		return res;
	}

}
