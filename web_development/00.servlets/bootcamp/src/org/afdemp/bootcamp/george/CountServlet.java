package org.afdemp.bootcamp.george;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountServlet
 */
@WebServlet("/count")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Counter mCounter = new Counter();   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (mCounter.increment() % 2 == 0) {
			request.getRequestDispatcher("/EvenCountServlet").forward(request, response);
		} else {
			request.getRequestDispatcher("/OddCountServlet").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
