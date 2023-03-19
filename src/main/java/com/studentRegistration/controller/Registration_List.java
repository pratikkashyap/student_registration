package com.studentRegistration.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentRegistration.model.DAOService;
import com.studentRegistration.model.DAOServiceImpl;


@WebServlet("/AllList")
public class Registration_List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Registration_List() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
		
	DAOService service = new DAOServiceImpl();
	service.connectionDB();
	ResultSet result = service.RegistrationList();
	
	request.setAttribute("result", result); 
	
	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/View/List.jsp");
	rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
