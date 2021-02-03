package com.example.demo.email;

import java.util.Arrays;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class RecuperarMx {

	public static String[] getMX(String domainName) {
		String[] sortedHostNames = null;
		try {
					
			Hashtable<String, Object> env = new Hashtable<>();

			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.dns.DnsContextFactory");
			env.put(Context.PROVIDER_URL, "dns:");

			DirContext ctx = new InitialDirContext(env);
			Attributes attribute = ctx.getAttributes(domainName, new String[] { "MX" });
			Attribute attributeMX = attribute.get("MX");
			// if there are no MX RRs then default to domainName (see: RFC 974)
			if (attributeMX == null) {
				return (new String[] { domainName });
			}

			// split MX RRs into Preference Values(pvhn[0]) and Host Names(pvhn[1])
			String[][] pvhn = new String[attributeMX.size()][2];
			for (int i = 0; i < attributeMX.size(); i++) {
				pvhn[i] = ("" + attributeMX.get(i)).split("\\s+");
			}

			// sort the MX RRs by RR value (lower is preferred)
			Arrays.sort(pvhn, (o1, o2) -> Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]));

			sortedHostNames = new String[pvhn.length];
			for (int i = 0; i < pvhn.length; i++) {
				sortedHostNames[i] = pvhn[i][1].endsWith(".") ? pvhn[i][1].substring(0, pvhn[i][1].length() - 1) : pvhn[i][1];
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return sortedHostNames;
	}

}
