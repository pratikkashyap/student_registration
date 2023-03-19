package com.studentRegistration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentRegistration.model.DAOService;
import com.studentRegistration.model.DAOServiceImpl;

@WebServlet("/verifyLogin")
public class Login_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login_Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		DAOService service = new DAOServiceImpl();
		service.connectionDB();
		
		boolean status = service.verifyDetails(email, password);
		
		if (status==true) {
			/*PrintWriter out = response.getWriter();
			out.println("Welcome");*/
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/View/Registration.jsp");
			rd.forward(request, response);
			
		} else {
			request.setAttribute("error", "Invalid Username/Password"); 
		
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			
			rd.forward(request, response);
		}
	}

}
