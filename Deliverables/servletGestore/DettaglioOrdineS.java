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

import databaseGomme.AccessoDatabase;
import databaseOrdini.DettagliOrdine;

/**
 * Servlet implementation class DettaglioOrdineS in questa classe è un riepilogo
 * dei dati per effettuare una evasione del' ordine
 */
@WebServlet("/DettaglioOrdineS")
public class DettaglioOrdineS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DettaglioOrdineS() {
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
		try {
			dataBase = new AccessoDatabase("127.0.0.1", 3306, "root", "");
			DettagliOrdine.getDettagliOrdini(dataBase, "Ordini.ordine", "tutto").toString();

			output.println("<!DOCTYPE HTML> <html> <head> <title>Il Mondo della Gomma - Gestionale</title>"
					+ "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>"
					+ "<link rel='stylesheet' type='text/css' href='style.css'>"
					+ "<link href='favicon.ico' rel='icon' type='image/x-icon' /> </head> <body>"

					+ "     <h2>Dettaglio Ordine:</h2>"
					// +" <div id='ordini'>"
					// +" <div class='item'>"
					+ "    " + "" + "<form action='EvasioneS'>" + "<p> Id: " + request.getParameter("cf") + "</p>"
					+ "<p> Nome: " + request.getParameter("nome") + "</p>" + "<p> Cognome: "
					+ request.getParameter("cognome") + "</p>" + "<p> Email: " + request.getParameter("email") + "</p>"
					+ "<p> Indirizzo: " + request.getParameter("indirizzo") + "</p>" + "<p> Civico: "
					+ request.getParameter("civico") + "</p>" + "<p> Citta: " + request.getParameter("citta") + "</p>"
					+ "<p> Provincia: " + request.getParameter("provincia") + "</p>" + "<p> Cap: "
					+ request.getParameter("cap") + "</p>" + "<p> Paese: " + request.getParameter("paese") + "</p>"
					+ "<p> Metodo Pagamento: " + request.getParameter("metodoPagamento") + "</p>"
					+ "<p> Intestatario Carta: " + request.getParameter("intestatarioCarta") + "</p>"
					+ "<p> Numero Carta: " + request.getParameter("numeroCarta") + "</p>" + "<p> Data Scadenza: "
					+ request.getParameter("dataScadenza") + "</p>" + "<p> Quantita: "
					+ request.getParameter("quantita") + "</p>" + "<p> Prezzo: " + request.getParameter("prezzo")
					+ "</p>" + "<p> Nome Pneumatico: " + request.getParameter("nomePneumatico") + "</p>"
					+ "<input type='text' name ='id' value='" + request.getParameter("cf") + "'>"

					+ "<input type='submit' value='evadi'>"

					+ " </form>     </body> </html>");

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
