package com.nkidol.command.album;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AlbumCommand {

	void execute(HttpServletRequest request,HttpServletResponse response);
}
