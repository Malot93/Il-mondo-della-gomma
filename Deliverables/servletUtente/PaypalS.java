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
 * Servlet implementation class ConfermaAcquistoContrassegnoS questa classe è
 * una simulazione della pagina 'originale' di pay pal modifiche effettuate da
 */
@WebServlet("/PaypalS")
public class PaypalS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaypalS() {
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

		try {

			AccessoDatabase dataBase = new AccessoDatabase("127.0.0.1", 3306, "root", "");

			output.println("<!DOCTYPE HTML> <html> <head>" + " <title>Il Mondo della Gomma - Acquisto Prodotto</title>"
					+ "   <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>"
					// + " <link rel='stylesheet' type='text/css'
					// href='style.css'>
					// "
					// + " <link href='favicon.ico' rel='icon'
					// type='image/x-icon'
					// />"
					+ "</head> <body>" // <div id='navbar'><h3> 089/1565482
										// </h3></div>"
					+ "<form action='ConfermaAcquistoPaypalS' method='post'> <div id='acquisto'> "

					+ "<h2 style='text-align:center'> IlmondoDellaGomma@gmail.com </h2>"
					+ "<div id='pay' style='text-align:center'>"
					+ "<p><img src='paypal.png' width='80px' height='50px'> TOTALE: "
					+ Integer.parseInt(request.getParameter("quantita"))
							* Double.parseDouble(request.getParameter("prezzo"))
					+ "</p>"
					// + " "+request.getParameter("quantita")
					// + " "+request.getParameter("prezzo")
					+ "<h3>Paga con paypal</h3>"
					+ "<p>I tuoi acquisti idonei sono tutelati dalla Protezione acquisti PayPal.</p>"
					+ "Email: <input type='email' value='" + request.getParameter("mail") + "'><br><br>"
					+ "Password: <input type='password' name='password' value='password'><br>"
					+ "<input type='submit' value='Accedi'><br>" + "" + "</div></form>" + "");

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
			// String intestatarioCarta =
			// request.getParameter("intestatarioCarta");
			// String dataScadenzaMese =
			// request.getParameter("dataScadenzaMese");
			// String dataScadenzaAnno =
			// request.getParameter("dataScadenzaAnno");

			DettagliOrdine dettagliOrdine = new DettagliOrdine(nome, cognome, cf, email, indirizzo, civico, citta,
					provincia, cap, paese, metodoPagamento, "", "", "", quantita, prezzo, nomePneumatico);
			dettagliOrdine.inserisciOrdine(dataBase, "Ordini.ordine");
			System.out.println(metodoPagamento);
			dataBase.close();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
