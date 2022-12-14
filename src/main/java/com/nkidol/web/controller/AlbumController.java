package com.nkidol.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nkidol.command.album.AlbumCommand;
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
		
		String URI = request.getRequestURI();
		AlbumCommand command;
		if(URI.contains("/upload")) {
			command = new AlbumUpload();
			command.execute(request, response);
		}else {
			command = new AlbumView();
			command.execute(request, response);
			if(URI.contains("/korea")) {
				request.getRequestDispatcher("/WEB-INF/view/album/korea.jsp").forward(request, response);
			}else if(URI.contains("/japan")){
				request.getRequestDispatcher("/WEB-INF/view/album/japan.jsp").forward(request, response);
			}
		}

	}
}
