package com.nkidol.command.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardCommand {

	void execute(HttpServletRequest request,HttpServletResponse response) throws IOException;
}
