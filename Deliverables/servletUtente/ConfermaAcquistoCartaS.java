package servletUtente;

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
 * Servlet implementation class ConfermaAcquistoContrassegnoS by Barone
 * ferdinando in questa classe si effettua il 'vero acquisto' con carta di
 * credito
 */
@WebServlet("/ConfermaAcquistoCartaS")
public class ConfermaAcquistoCartaS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfermaAcquistoCartaS() {
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

		try {

			AccessoDatabase dataBase = new AccessoDatabase("127.0.0.1", 3306, "root", "");

			output.println("<!DOCTYPE HTML>" + "<html>" + "<head>"

					+ " <title>Il Mondo della Gomma - Successo</title>"
					+ "  <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>"
					+ "  <link rel='stylesheet' type='text/css' href='style.css'>"
					+ " <link href='img/favicon.ico' rel='icon' type='image/x-icon' />"
					+ "<meta http-equiv='refresh' content='5;URL=index.jsp'>" + "</head>"

					+ "<body>"

					+ "<div id='navbar'></div>" + "<div id='centrale'>"
					+ "   <h2 align='center' style='position:relative;top:-40px;'>Acquisto pneumatico effettuato con succeso!</h2>"
					+ "<p>Scadenza mese: " + request.getParameter("dataScadenzaMese") + "</p>" + "<p>scadenza anno:  "
					+ request.getParameter("dataScadenzaAnno") + "</p>" + "<p>Intestatario: "
					+ request.getParameter("intestatarioCarta") + "</p>" + "<p>Numero carta: "
					+ request.getParameter("numeroCarta") + "</p>" + "<p>Quantita: " + request.getParameter("quantita")
					+ "</p>"

					+ "  </div>");

			output.println("</body>" + "</html>");

			String nome = request.getParameter("nomeC");
			String cognome = request.getParameter("cognomeC");
			String cf = request.getParameter("CF");
			String email = request.getParameter("mail");
			String indirizzo = request.getParameter("indirizzo");
			String civico = request.getParameter("civico");
			String citta = request.getParameter("citta");
			String provincia = request.getParameter("prov");
			String cap = request.getParameter("cap");
			String paese = request.getParameter("paese");
			String metodoPagamento = request.getParameter("pag");
			String larghezza = request.getParameter("larghezza");
			String altezza = request.getParameter("altezza");
			String diametro = request.getParameter("diametro");
			int quantita = Integer.parseInt(request.getParameter("quantita"));
			double prezzo = Double.parseDouble(request.getParameter("prezzo"));
			String nomePneumatico = request.getParameter("nome");
			String intestatarioCarta = request.getParameter("intestatarioCarta");
			String numeroCarta = request.getParameter("numeroCarta");
			String dataScadenzaMese = request.getParameter("dataScadenzaMese");
			String dataScadenzaAnno = request.getParameter("dataScadenzaAnno");

			DettagliOrdine dettagliOrdine = new DettagliOrdine(nome, cognome, cf, email, indirizzo, civico, citta,
					provincia, cap, paese, metodoPagamento, intestatarioCarta, numeroCarta,
					dataScadenzaMese + " / " + dataScadenzaAnno, quantita, prezzo, nomePneumatico);
			dettagliOrdine.inserisciOrdine(dataBase, "Ordini.ordine");
			System.out.println(metodoPagamento);
			dataBase.close();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
