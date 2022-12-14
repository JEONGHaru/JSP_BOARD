package com.nkidol.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {

	public static String getSHA256(String input) {
		
		StringBuffer result = new StringBuffer(); 
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] chars = digest.digest(input.getBytes("UTF-8"));
			for(int i =0;i<chars.length;i++) {
				String hex = Integer.toHexString(0xff & chars[i]);
				if(hex.length() == 1) result.append("0");
				result.append(hex);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return result.toString();
	}
}
