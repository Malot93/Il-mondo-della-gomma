package servletGestore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseGomme.AccessoDatabase;
import databaseOrdini.DettagliOrdine;

/**
 * Servlet implementation class EvasioneEffettuataConSuccessoS in questa classe
 * si effettua la 'vera evasione dell' acquisto'
 */
@WebServlet("/EvasioneEffettuataConSuccessoS")
public class EvasioneEffettuataConSuccessoS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EvasioneEffettuataConSuccessoS() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		PrintWriter output = response.getWriter();

		try {
			// uso la classe DataBase da me creata
			AccessoDatabase dataBase = new AccessoDatabase("127.0.0.1", 3306, "root", "");
			// uso la classe Pneumatico da me creata
			// Pneumatico pneumatico = new Pneumatico(2, "", "", larghezza,
			// "estivo", "mich", "aaaaaaaaa", 20, 20);

			// inserisco e salvo il pneumatico nel database Pneumatico
			// pneumatico.inserisciPneumatico(dataBase,
			// "Pneumatico.pneumatici");
			String cf = request.getParameter("id");
			// String nome = request.getParameter("nome");
			// String quantita = request.getParameter("quantita");
			// String marca = request.getParameter("marca");
			// String larghezza = request.getParameter("larghezza");
			// String altezza = request.getParameter("altezza");
			// String diametro = request.getParameter("diametro");
			// String stagionalita = request.getParameter("stagionalita");
			// String prezzo = request.getParameter("prezzo");
			// int cf = Integer.parseInt(cF);
			// double prezzoF = Double.parseDouble(prezzo);
			// int quantitaI = Integer.parseInt(quantita);
			// String foto = request.getParameter("foto");
			DettagliOrdine dettagliOrdine = new DettagliOrdine();
			dettagliOrdine.setcF(cf);
			dettagliOrdine.eliminaOrdine(dataBase, "Ordini.ordine");
			output.println("<!DOCTYPE HTML>" + "<html>" + "<head>"

					+ " <title>Il Mondo della Gomma - Successo</title>"
					+ "  <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>"
					+ "  <link rel='stylesheet' type='text/css' href='style.css'>"
					+ " <link href='img/favicon.ico' rel='icon' type='image/x-icon' />"
					+ "<meta http-equiv='refresh' content='3;URL=GestionaleS'>" + "</head>"

					+ "<body>"

					+ "<div id='navbar'></div>" + "<div id='centrale'>"
					+ "   <h2 align='center' style='position:relative;top:-40px;'>Ordine evaso con successo!</h2>"
					+ "  </div>"

					+ "</body>" + "</html>");

			dataBase.close();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// output.println(" ");

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
