package poker;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PokerServlet
 */
@WebServlet("/PokerServlet")
public class PokerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * A String with all available cards (52 total).
	 */
	private String[] cards = { "ֱ Diamonds", "ֱ Hearts", "ֱ Clubs", "ֱ Spades", "2 Diamonds", "2 Hearts", "2 Clubs",
			"2 Spades", "3 Diamonds", "3 Hearts", "3 Clubs", "3 Spades", "4 Diamonds", "4 Hearts", "4 Clubs",
			"4 Spades", "5 Diamonds", "5 Hearts", "5 Clubs", "5 Spades", "6 Diamonds", "6 Hearts", "6 Clubs",
			"6 Spades", "7 Diamonds", "7 Hearts", "7 Clubs", "7 Spades", "8 Diamonds", "8 Hearts", "8 Clubs",
			"8 Spades", "9 Diamonds", "9 Hearts", "9 Clubs", "9 Spades", "10 Diamonds", "10 Hearts", "10 Clubs",
			"10 Spades", "J Diamonds", "J Hearts", "J Clubs", "J Spades", "Q Diamonds", "Q Hearts", "Q Clubs",
			"Q Spades", "K Diamonds", "K Hearts", "K Clubs", "K Spades" };

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PokerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=ISO-8859-7");
		PrintWriter out = new PrintWriter(response.getWriter(), true);

		try {
			int card1 = 0;
			int card2 = 0;
			int card3 = 0;
			int card4 = 0;
			int card5 = 0;
			while ((card1 == card2) || (card1 == card3) || (card1 == card4) || (card1 == card5) || (card2 == card3)
					|| (card2 == card4) || (card2 == card5) || (card3 == card4) || (card3 == card5)
					|| (card4 == card5)) {
				card1 = (int) (Math.random() * 52);
				card2 = (int) (Math.random() * 52);
				card3 = (int) (Math.random() * 52);
				card4 = (int) (Math.random() * 52);
				card5 = (int) (Math.random() * 52);
			}
			out.println("<html>");
			out.println("<head>");
			out.println("  <title>PokerServlet</title>");
			out.println("    <meta http-equiv='Content-Type' content='text/html; charset=windows-1253'>");
			out.println("</head>");
			out.println("  <bodybgcolor='#FFFF99'>");
			out.println("  <h1>PokerServlet is running...</h1><br>");
			out.println("<b>You have the cards below:</b><br>");
			out.println("<hr>");
			out.println("1ן צ‎ככן: <b>" + cards[card1] + "</b><br>");
			out.println("2ן צ‎ככן: <b>" + cards[card2] + "</b><br>");
			out.println("3ן צ‎ככן: <b>" + cards[card3] + "</b><br>");
			out.println("4ן צ‎ככן: <b>" + cards[card4] + "</b><br>");
			out.println("5ן צ‎ככן: <b>" + cards[card5] + "</b><br>");
			out.println("<hr>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception ex) {
			out.println("Exception: " + ex.getMessage());
			out.println("  </body>");
			out.println("</html>");
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
