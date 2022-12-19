package com.nkidol.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nkidol.command.album.AlbumCommand;
import com.nkidol.command.album.AlbumDelete;
import com.nkidol.command.album.AlbumLikeAdd;
import com.nkidol.command.album.AlbumLikeCancel;
import com.nkidol.command.album.AlbumList;
import com.nkidol.command.album.AlbumUpload;
import com.nkidol.command.album.AlbumView;

@WebServlet("/album/*")
public class AlbumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AlbumController() { }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);

	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String URI = request.getRequestURI();
		String cmd = URI.replaceAll("/album", "");
		AlbumCommand command;
		
		if(cmd.equals("/korea")) {
			command = new AlbumView();
			command.execute(request, response);
			request.getRequestDispatcher("/WEB-INF/view/album/korea.jsp").forward(request, response);
		}else if(cmd.equals("/japan")) {
			command = new AlbumView();
			command.execute(request, response);
			request.getRequestDispatcher("/WEB-INF/view/album/japan.jsp").forward(request, response);
		}else if(cmd.equals("/likeAdd")) {
			command = new AlbumLikeAdd();
			command.execute(request, response);
		}else if(cmd.equals("/likeCancel")) {
			command = new AlbumLikeCancel();
			command.execute(request, response);
		}
		
		else if(cmd.contains("/upload")) {
			try {
				command = new AlbumUpload();
				command.execute(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.contains("/delete")) {
			
			
		}
		
		
//		if(URI.contains("/upload")) {
//			command = new AlbumUpload();
//			command.execute(request, response);
//		}else if(URI.contains("/delete")) {
//			
//		  command = new AlbumDelete();
//		  command.execute(request, response);
//		  response.sendRedirect(URI.replaceAll("delete", ""));
//		}else if(URI.contains("/likeAdd")) {
//			command = new AlbumLikeAdd();
//			command.execute(request, response);
//		}else if(URI.contains("/likeCancel")) {
//			command = new AlbumLikeCancel();
//			command.execute(request, response);
//		}else if(URI.contains("/list")) {
//			command = new AlbumList();
//			command.execute(request, response);
//		}
//		
//		else {
//			command = new AlbumView();
//			command.execute(request, response);
//			if(URI.contains("/korea")) {
//				request.getRequestDispatcher("/WEB-INF/view/album/korea.jsp").forward(request, response);
//			}else if(URI.contains("/japan")){
//				request.getRequestDispatcher("/WEB-INF/view/album/japan.jsp").forward(request, response);
//			}
//		}

	}
}
