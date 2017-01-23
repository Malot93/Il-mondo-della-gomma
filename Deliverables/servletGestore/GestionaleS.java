package servletGestore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.catalina.servlet4preview.RequestDispatcher;

import databaseGomme.AccessoDatabase;
import databaseGomme.Pneumatico;
import databaseOrdini.DettagliOrdine;

/**
 * Servlet implementation class GestionaleS
 */
@WebServlet("/GestionaleS")
public class GestionaleS extends HttpServlet {
	@Override
	public String toString() {
		return "GestionaleS [getInitParameterNames()=" + getInitParameterNames() + ", getServletConfig()="
				+ getServletConfig() + ", getServletContext()=" + getServletContext() + ", getServletInfo()="
				+ getServletInfo() + ", getServletName()=" + getServletName() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionaleS() {
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
		response.setContentType("text/html");
		PrintWriter output = response.getWriter();
		AccessoDatabase dataBase;
		System.out.println(request.getParameter("user") + " " + request.getParameter("passww"));
		try {
			dataBase = new AccessoDatabase("127.0.0.1", 3306, "root", "");

			output.println("<!DOCTYPE HTML> <html> <head> <title>Il Mondo della Gomma - Gestionale</title>");

			output.println("<meta http-equiv='refresh' content='15;'>");

			output.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>"
					+ "<link rel='stylesheet' type='text/css' href='style.css'>"
					+ "<link href='favicon.ico' rel='icon' type='image/x-icon' /> ");

			output.println("</head> <body>");

			output.println("<form action='LogOutS'>"
					+ "<div id='navbar'><input class='bottone' type='submit' value='Logout'></form></div><br>"
					+ "<div id='gestionale'>"
					+ "<h2>Inventario Pneumatici:</h2><a id='aggiungi' href='AggiungiPneumaticoS'>Aggiungi pneumatico</a>"
					+ "<div id='inventario' style='color:#8e8a8a;'>");

			output.println(PneumaticoGestore.queryDatabasePneumaticoTutto(dataBase, "Pneumatico.pneumatici").toString()

					+ "    </div> <h2>Lista Ordini:</h2>");

			output.println("<br><div id='inventario' style='color:#8e8a8a;'>"
					+ DettagliOrdine.getDettagliOrdini(dataBase, "Ordini.ordine", "tutto").toString()
					// +"<input type='text'name='id'
					// value='"+request.getParameter("id")+"'>"
					+ "" + "" + "" + "");

			output.println("    </div>  </div> </div> </body> </html>");

		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
