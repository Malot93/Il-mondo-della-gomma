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
import databaseGomme.Pneumatico;
import databaseOrdini.DettagliOrdine;
import databaseOrdini.Ordine;

/**
 * Servlet implementation class AcquistoS questa classe fa
 * un riepilogo dell' acquisto in contrassegno modifiche effettuate da
 */
@WebServlet("/AcquistoS")
public class AcquistoS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcquistoS() {
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

		output.println("<!DOCTYPE HTML> <html> <head>" + " <title>Il Mondo della Gomma - Acquisto Prodotto</title>"
				+ "   <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>"
				+ " <link rel='stylesheet' type='text/css' href='style.css'>       "
				+ " <link href='favicon.ico' rel='icon' type='image/x-icon' />"
				+ "</head> <body>    <div id='navbar'><h3> 089/1565482 </h3></div>"
				+ " <div id='acquisto'> <h2>Riepilogo acquisto:</h2>" + "");

		/**
		 * questo if ha come condizione: 'se l' utente vuole comprare con
		 * contrassegno allora si apre una pagina web di riepilogo che gli
		 * permetterà in un altra pagina l' acquisto'
		 */
		if (request.getParameter("pag").equals("contrassegno")) {

			try {

				AccessoDatabase dataBase = new AccessoDatabase("127.0.0.1", 3306, "root", "");

				output.print("<p>Quntit&agrave;: " + Double.parseDouble(request.getParameter("quantita")) + "</p> "
						+ "<p>Prezzo: " + request.getParameter("prezzo") + "</p>" + " prezzo tot  "
						+ Integer.parseInt(request.getParameter("quantita"))
								* Double.parseDouble(request.getParameter("prezzo"))
						+ "<p>Nome: " + request.getParameter("nomeC") + "</p>" + "<p>Cognome: "
						+ request.getParameter("cognomeC") + "</p>" + "<p>Codice fiscale: " + request.getParameter("CF")
						+ "</p>" + "<p>Email: " + request.getParameter("mail") + "</p>" + "<p>Indirizzo: "
						+ request.getParameter("indirizzo") + "</p>" + "<p>Civico: " + request.getParameter("civico")
						+ "</p>" + "<p>Citt&agrave;: " + request.getParameter("citta") + "</p>" + "<p>Provincia: "
						+ request.getParameter("prov") + "</p>" + "<p>Cap: " + request.getParameter("cap") + "</p>"
						+ "<p>Paese: " + request.getParameter("paese") + "</p>" + "<p>Metodo di pagamento: "
						+ request.getParameter("pag") + "<p> larghezza pneumatico " + request.getParameter("larghezza")
						+ "</p>" + "<p> altezza pneumatico " + request.getParameter("altezza") + "</p>"
						+ "<p> diametro pneumatico " + request.getParameter("diametro") + "</p>" + "</p><br><h1>"
						+ "<a href='ConfermaAcquistoContrassegnoS'>acquista</a>" + "</h1>"

						+ "</div>");

				output.println("</body> </html>");

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

				System.out.println(quantita);

				DettagliOrdine dettagliOrdine = new DettagliOrdine(nome, cognome, cf, email, indirizzo, civico, citta,
						provincia, cap, paese, metodoPagamento, " ", " ", " ", quantita, prezzo, nomePneumatico);
				dettagliOrdine.inserisciOrdine(dataBase, "Ordini.ordine");
				System.out.println(metodoPagamento);
				dataBase.close();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else

			/**
			 * questo if ha come condizione: 'se l' utente vuole comprare con
			 * carta di credito allora si apre una pagina web di riepilogo che gli
			 * permetterà in un altra pagina l' acquisto'
			 */	
		if (request.getParameter("pag").equals("carta di credito")) {
			output.print("<p>Quntit&agrave;: " + Double.parseDouble(request.getParameter("quantita")) + "</p> "
					+ "<p>Prezzo: " + request.getParameter("prezzo") + "</p>" + " prezzo tot  "
					+ Integer.parseInt(request.getParameter("quantita"))
							* Double.parseDouble(request.getParameter("prezzo"))
					+ "<p>Nome: " + request.getParameter("nomeC") + "</p>" + "<p>Cognome: "
					+ request.getParameter("cognomeC") + "</p>" + "<p>Codice fiscale: " + request.getParameter("CF")
					+ "</p>" + "<p>Email: " + request.getParameter("mail") + "</p>" + "<p>Indirizzo: "
					+ request.getParameter("indirizzo") + "</p>" + "<p>Civico: " + request.getParameter("civico")
					+ "</p>" + "<p>Citt&agrave;: " + request.getParameter("citta") + "</p>" + "<p>Provincia: "
					+ request.getParameter("prov") + "</p>" + "<p>Cap: " + request.getParameter("cap") + "</p>"
					+ "<p>Paese: " + request.getParameter("paese") + "</p>" + "<p>Metodo di pagamento: "
					+ request.getParameter("pag") + "</p>" + "<p> larghezza pneumatico "
					+ request.getParameter("larghezza") + "</p>" + "<p> altezza pneumatico "
					+ request.getParameter("altezza") + "</p>" + "<p> diametro pneumatico "
					+ request.getParameter("diametro") + "</p>" + "<p>nome marca " + request.getParameter("nome")
					+ "</p>");

			output.println("<form action='ConfermaAcquistoCartaS' method='post'><p>CARTE DI CREDITO SUPPORTATE</h1><br>"
					+ "<img src='Credit-cards-with-maestro-beacon.gif' style='width:188px;height:48px;'>"
					+ "<input style='display:none' type='text' name='quantita' value='"
					+ request.getParameter("quantita") + "'>"
					+ "<input style='display:none' type='text' name='prezzo' value='" + request.getParameter("prezzo")
					+ "'>" + "<input style='display:none' type='text' name='CF' value='" + request.getParameter("CF")
					+ "'>" + "<input style='display:none' type='text' name='nomeC' value='"
					+ request.getParameter("nomeC") + "'>"
					+ "<input style='display:none' type='text' name='cognomeC' value='"
					+ request.getParameter("cognomeC") + "'>"
					+ "<input style='display:none' type='text' name='mail' value='" + request.getParameter("mail")
					+ "'>" + "<input style='display:none' type='text' name='indirizzo' value='"
					+ request.getParameter("indirizzo") + "'>"
					+ "<input style='display:none' type='text' name='civico' value='" + request.getParameter("civico")
					+ "'>" + "<input style='display:none' type='text' name='prov' value='"
					+ request.getParameter("prov") + "'>" + "<input style='display:none' type='text' name='cap' value='"
					+ request.getParameter("cap") + "'>"
					+ "<input style='display:none' type='text' name='paese' value='" + request.getParameter("paese")
					+ "'>" + "<input style='display:none' type='text' name='pag' value='" + request.getParameter("pag")
					+ "'>" + "<input style='display:none' type='text' name='altezza' value='"
					+ request.getParameter("altezza") + "'>"
					+ "<input style='display:none' type='text' name='larghezza' value='"
					+ request.getParameter("larghezza") + "'>"
					+ "<input style='display:none' type='text' name='diametro' value='"
					+ request.getParameter("diametro") + "'>"
					+ "<input style='display:none' type='text' name='nome' value='" + request.getParameter("nome")
					+ "'>" + "<input style='display:none' type='text' name='citta' value='"
					+ request.getParameter("citta") + "'>"

					+ " Intestatario carta: <input type='text' name='intestatarioCarta'> "
					+ " Numero carta: <input type='text' name='numeroCarta'> "
					+ "Data scadenza carta:  <select name='dataScadenzaMese' >"
					+ "<option value='1' selected='selected'> 1 </option>" + "<option value='2'> 2 </option>"
					+ "<option value='3'> 3 </option>" + "<option value='4'> 4 </option>"
					+ "<option value='5'> 5 </option>" + "<option value='6'> 6 </option>"
					+ "<option value='7'> 7 </option>" + "<option value='8'> 8 </option>"
					+ "<option value='9'> 9 </option>" + "<option value='10'> 10 </option>"
					+ "<option value='11'> 11 </option>" + "<option value='12'> 12 </option>" + "</select> "

					+ "<select name='dataScadenzaAnno' >" + "<option value='2017' selected='selected'> 2017 </option>"
					+ "<option value='2018'> 2018 </option>" + "<option value='2019'> 2019 </option>"
					+ "<option value='2020'> 2020 </option>" + "<option value='2021'> 2021 </option>"
					+ "<option value='2022'> 2022 </option>" + "<option value='2023'> 2023 </option>"
					+ "<option value='2024'> 2024 </option>" + "<option value='2025'> 2025 </option>"
					+ "<option value='2026'> 2026 </option>" + "<option value='2027'> 2027 </option>"
					+ "<option value='2028'> 2028 </option>" + "<option value='2029'> 2029 </option>"
					+ "<option value='2030'> 2030 </option>" + "<option value='2031'> 2031 </option>"
					+ "<option value='2032'> 2032 </option>" + "<option value='2033'> 2033 </option>"
					+ "<option value='2034'> 2034 </option>" + "<option value='2035'> 2035 </option>"
					+ "<option value='2036'> 2036 </option>" + "<option value='2037'> 2037 </option>" + "</select> "
					+ "<input type='submit' value='paga'></form>" + "</div>" + "</body> </html>");

		} else


			/**
			 * questo if ha come condizione: 'se l' utente vuole comprare con
			 * pay pal allora si apre una pagina web di riepilogo che gli
			 * permetterà in un altra pagina l' acquisto'
			 */	
		if (request.getParameter("pag").equals("paypal")) {
			output.print(

					"<p>Quntit&agrave;: " + Double.parseDouble(request.getParameter("quantita")) + "</p> "
							+ "<p>Prezzo: " + request.getParameter("prezzo") + "</p>" + " prezzo tot  "
							+ Integer.parseInt(request.getParameter("quantita"))
									* Double.parseDouble(request.getParameter("prezzo"))
							+ "<p>Nome: " + request.getParameter("nomeC") + "</p>" + "<p>Cognome: "
							+ request.getParameter("cognomeC") + "</p>" + "<p>Codice fiscale: "
							+ request.getParameter("CF") + "</p>" + "<p>Email: " + request.getParameter("mail") + "</p>"
							+ "<p>Indirizzo: " + request.getParameter("indirizzo") + "</p>" + "<p>Civico: "
							+ request.getParameter("civico") + "</p>" + "<p>Citt&agrave;: "
							+ request.getParameter("citta") + "</p>" + "<p>Provincia: " + request.getParameter("prov")
							+ "</p>" + "<p>Cap: " + request.getParameter("cap") + "</p>" + "<p>Paese: "
							+ request.getParameter("paese") + "</p>" + "<p>Metodo di pagamento: "
							+ request.getParameter("pag") + "</p><br>"

							+ "<form action='PaypalS' method='post'>"
							+ "<input style='display:none' type='text' name='quantita' value='"
							+ request.getParameter("quantita") + "'>"
							+ "<input style='display:none' type='text' name='prezzo' value='"
							+ request.getParameter("prezzo") + "'>"
							+ "<input style='display:none' type='text' name='mail' value='"
							+ request.getParameter("mail") + "'>" + "<p> larghezza pneumatico "
							+ request.getParameter("larghezza") + "</p>" + "<p> altezza pneumatico "
							+ request.getParameter("altezza") + "</p>" + "<p> diametro pneumatico "
							+ request.getParameter("diametro") + "</p>"

							+ "<img src='Credit-cards-with-maestro-beacon.gif' style='width:88px;height:58px;'><br>"
							+ "<input style='display:none' type='text' name='quantita' value='"
							+ request.getParameter("quantita") + "'>"
							+ "<input style='display:none' type='text' name='prezzo' value='"
							+ request.getParameter("prezzo") + "'>"
							+ "<input style='display:none' type='text' name='CF' value='" + request.getParameter("CF")
							+ "'>" + "<input style='display:none' type='text' name='nomeC' value='"
							+ request.getParameter("nomeC") + "'>"
							+ "<input style='display:none' type='text' name='cognomeC' value='"
							+ request.getParameter("cognomeC") + "'>"
							+ "<input style='display:none' type='text' name='mail' value='"
							+ request.getParameter("mail") + "'>"
							+ "<input style='display:none' type='text' name='indirizzo' value='"
							+ request.getParameter("indirizzo") + "'>"
							+ "<input style='display:none' type='text' name='civico' value='"
							+ request.getParameter("civico") + "'>"
							+ "<input style='display:none' type='text' name='prov' value='"
							+ request.getParameter("prov") + "'>"
							+ "<input style='display:none' type='text' name='cap' value='" + request.getParameter("cap")
							+ "'>" + "<input style='display:none' type='text' name='paese' value='"
							+ request.getParameter("paese") + "'>"
							+ "<input style='display:none' type='text' name='pag' value='" + request.getParameter("pag")
							+ "'>" + "<input style='display:none' type='text' name='altezza' value='"
							+ request.getParameter("altezza") + "'>"
							+ "<input style='display:none' type='text' name='larghezza' value='"
							+ request.getParameter("larghezza") + "'>"
							+ "<input style='display:none' type='text' name='diametro' value='"
							+ request.getParameter("diametro") + "'>"
							+ "<input style='display:none' type='text' name='nome' value='"
							+ request.getParameter("nome") + "'>"
							+ "<input style='display:none' type='text' name='citta' value='"
							+ request.getParameter("citta") + "'>"

							+ "<input type='image' src='paga.jpeg' style='width:240px; height:100px; ' border='0' name='submit' "
							+ "alt='Make payments with PayPal - it's fast, free and secure!'>"

							+ "</body> </html>");

		}
	}
}
