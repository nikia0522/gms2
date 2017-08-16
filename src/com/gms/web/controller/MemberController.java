package com.gms.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gms.web.util.DispatcherServlet;
import com.gms.web.util.Separator;

@WebServlet({"/member.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController 진입");
		Separator.init(request);
		switch (request.getParameter("action")) {
		case "move":
			DispatcherServlet.send(request, response);
			break;

		case "add":
			DispatcherServlet.send(request, response);
			
		default:
			break;
		}
	}

}
