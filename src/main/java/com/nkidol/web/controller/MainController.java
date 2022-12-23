package com.nkidol.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nkidol.domain.album.dto.ImageDTO;
import com.nkidol.domain.user.User;
import com.nkidol.service.AlbumService;

@WebServlet("/main")
public class MainController extends HttpServlet{
		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession sesstion = request.getSession();
//		User user = null;
//		if(sesstion.getAttribute("principal") != null) {
//			user = (User)sesstion.getAttribute("principal");
//			System.out.println("user.getUserID(): "+user.getUserID());
//		}
		AlbumService albumService = new AlbumService();
		ArrayList<ImageDTO> kList = albumService.getImageList("korea");
		ArrayList<ImageDTO> jList = albumService.getImageList("japan");
		request.setAttribute("kList", kList);
		request.setAttribute("jList", jList);
//		String koreaImages = "/images/total/korea/";
//		String japanImages = "/images/total/japan/";
//		String koreaRealPath = request.getServletContext().getRealPath(koreaImages);
//		String japanRealPath = request.getServletContext().getRealPath(japanImages);
//		File fileKorea = new File(koreaRealPath);
//		File fileJapan = new File(japanRealPath);
//		String[] korea = fileKorea.list();
//		String[] japan = fileJapan.list();
//		ArrayList<String> koreaList = new ArrayList<>();
//		ArrayList<String> japanList = new ArrayList<>();
//		Random ran = new Random();
//		for(int i =0;i<3;i++) {
//			koreaList.add(koreaImages+korea[ran.nextInt(korea.length)]);
//		}
//		for(int i =0;i<3;i++) {
//			japanList.add(japanImages+japan[ran.nextInt(japan.length)]);
//		}
//		request.setAttribute("koreaList", koreaList);
//		request.setAttribute("japanList", japanList);
//		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(request, response);
	}
	
}
