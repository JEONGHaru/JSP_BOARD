package com.nkidol.util;

public class Util {

	public static String getTempPassword(int length) {
		int index = 0;
		char[] charArr = new char[] {'1','2','3','4','5','6','7','8','9','0',
				'a','b','c','d','e','f','g','h','i','j','k','l','n','m','o',
				'p','q','r','s','t','u','v','w','x','y','z'};
		
		StringBuffer sb = new StringBuffer();
		
		for(int i =0;i<length;i++) {
			index = (int)(charArr.length * Math.random());
			sb.append(charArr[index]);
		}
		return sb.toString();
	}
}
