package org.afdemp.bootcamp.sofos.controllers;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.afdemp.bootcamp.sofos.dao.StudentDAO;
import org.afdemp.bootcamp.sofos.domain.Student;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		//PrintWriter out = new PrintWriter(response.getWriter(), true);

		//reading parameters from request
		String name = request.getParameter("studentname");
		String surname = request.getParameter("studentsurname");
		String am = request.getParameter("studentam");

		//define RequestDispatcher object to forward any errors
		RequestDispatcher errodis = getServletContext().getRequestDispatcher("/errorprinter.jsp");
		
		//define RequestDispatcher object to forward if data are correct and successfully stored in database
		RequestDispatcher succdis = getServletContext().getRequestDispatcher("/registerdone.jsp");
		
		String errormsg = "";
		int ercounter = 0;

		try {

			if(name == null || name.length() == 0) {
				
				errormsg += ++ercounter + ") Το πεδίο όνομα δεν είναι έγκυρο<br>";
				
			}
			
			if(surname == null || surname.length() == 0) {
				
				errormsg += ++ercounter + ") Το πεδίο Επώνυμο δεν είναι έγκυρο<br>";
				
			}
			
			if(am == null || am.length() == 0) {
				
				errormsg += ++ercounter + ") Το πεδίο Αρ.Μητρώου δεν είναι έγκυρο<br>";
				
			}
			
			if(ercounter > 0) {
				
				if(ercounter == 1) 
					errormsg = "<h3>Βρέθηκε " + ercounter + " λάθος</h3>" + errormsg;
				else 
					errormsg = "<h3>Βρέθηκαν " + ercounter + " λάθη</h3>" + errormsg;
				
				//adding error message (String) to request
				request.setAttribute("errormessage", errormsg);
				
				errodis.forward(request, response);							
				
				return;
			}

			Student student = new Student(name, surname, am);

			StudentDAO sdao = new StudentDAO();

			sdao.open(); // open connection

			sdao.registerStudent(student); //store student to database

			sdao.close(); // close connection

			request.setAttribute("studentobj", student); //adding Student object to request

			succdis.forward(request, response);
			return;

		} catch (Exception e) {
			
			request.setAttribute("errormessage", e.getMessage());
			
			errodis.forward(request, response);	
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
