package com.practical10;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double amount = Double.parseDouble(request.getParameter("amount"));
		DepositBean.depositAmount(amount);
		response.sendRedirect("success.html");
	}
}