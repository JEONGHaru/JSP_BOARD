package com.nkidol.web.controller;

import java.io.File;
import java.util.Random;

public class RandomImage {
	public static void main(String[] args) {
		
    File file = new File("/Users/jeong-gwang-yeong/eclipse/nkidol/src/main/webapp/images/korea");
	String[] fileimage = file.list();
	for (String string : fileimage) {
		System.out.println(string.replace("^[.]$", ""));
	}
}
}