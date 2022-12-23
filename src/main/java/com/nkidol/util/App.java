package com.nkidol.util;

public class App {
	
	public static String getSiteName() {
		return "NKIDOL";
	}
	
	public static String getSiteMainUrl() {
		return "http://" + getSiteDomain() + ":" +getSitePort() + "/main";
	}
	
	public static String getSiteHostUrl() {
		return "http://" + getSiteDomain() + ":" +getSitePort();
	}
	
	private static int getSitePort() {
		
		return 8181;
	}

	private static String getSiteDomain() {
		
		return "localhost";
	}
}
