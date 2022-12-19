package com.nkidol.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {

	public static void back(HttpServletResponse response,String msg) {
		
		PrintWriter out;
		try {
			out = response.getWriter();
			out.append("<script> alert('"+msg+"'); history.back(); </script>");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void save(HttpServletResponse response, String msg,String location) {
		PrintWriter out;
		try {
			out = response.getWriter();
			out.append("<script> alert('"+msg+"'); location.href='"+location+"';</script>");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
