package servletGestore;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class LoginEffettuatoConSuccessoS
 */
@WebServlet("/LoginEffettuatoConSuccessoS")
public class LoginEffettuatoConSuccessoS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginEffettuatoConSuccessoS() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter output = response.getWriter();
		if (!(request.getParameter("user").equals("admin") && request.getParameter("passww").equals("admin"))) {
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showMessageDialog(null, "errore login errato");
			response.sendRedirect("login.jsp");
		}
		output.println("<!DOCTYPE HTML>" + "<html>" + "<head>"

				+ " <title>Il Mondo della Gomma - Successo</title>"
				+ "  <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>"
				+ "  <link rel='stylesheet' type='text/css' href='style.css'>"
				+ " <link href='img/favicon.ico' rel='icon' type='image/x-icon' />"
				+ "<meta http-equiv='refresh' content='3;URL=GestionaleS'>" + "</head>"

				+ "<body>"

				+ "<div id='navbar'></div>" + "<div id='centrale'>"
				+ "   <h2 align='center' style='position:relative;top:-40px;'>"
				+ "Ciao "+request.getParameter("user")+" ti sei loggato con successo!</h2>"
				+ "  </div>");

		output.println("</body>" + "</html>");

	}

}
