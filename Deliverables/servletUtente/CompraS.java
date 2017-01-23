package servletUtente;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseGomme.Pneumatico;

/**
 * Servlet implementation class CompraS questa
 * classe non fa altro dei far effettuare un acquisto al utente 
 */
@WebServlet("/CompraS")
public class CompraS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompraS() {
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
		double prezzo = (Double.parseDouble(request.getParameter("prezzo")));

		output.println(" <!DOCTYPE HTML>" + "<html>"

				+ "<head>"

				+ "    <title>Il Mondo della Gomma - Acquisto Prodotto</title>"
				+ "    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>"
				+ "    <link rel='stylesheet' type='text/css' href='style.css'>"
				+ "    <link href='favicon.ico' rel='icon' type='image/x-icon' />"

				+ "</head><body>"

				+ "    <div id='navbar'><h3> 089/1565482 </h3></div>    <div id='acquisto'>"
				+ "        <h2>Stai per acquistare:</h2>"

				+ " <form action='AcquistoS' method='post'>       <div class='risultato'>"
				+ "            <img src='gomma.png' height='200'>" + "            <h2 class='nomepneumatico'>"
				+ request.getParameter("nome") + "</h2>" + "            <h2 class='specifichetec'>"
				+ request.getParameter("larghezza") + " / " + request.getParameter("altezza") + " / "
				+ request.getParameter("diametro") + "</h2>"

				+ "         <p class='prezzosing'>Quantit&agrave;: <input style='width:35px;' size='2' value='1' type='number' name='quantita' id='quantita' "
				+ "</p> " + "         <p id='prezzo_t'>Prezzo singolo: <b>&euro; <span id='p' > " + prezzo
				+ "</span></b></p>" + "<input  name='prezzo' type='text' value='" + request.getParameter("prezzo")
				+ "' style='display:none'>" + "<input  name='nome' type='text' value='" + request.getParameter("nome")
				+ "' style='display:none'>" + "</span></b></p>"

				+ "        </div> <fieldset id='acquirente'>" + ""
				+ "          <legend style='font-size: 20px;font-weight: bold;'>Informazioni acquirente</legend><br>"
				+ "          <p><span>Nome</span><span style='position:relative;left:240px;'>Cognome</span><br>"
				+ "          <input style='width:255px' type='text' name='nomeC'>"
				+ "<input name='cognomeC' size='21' style='width:255px; margin-left:30px;' type='text'><br><br>"
				+ "          <span>Codice Fiscale</span><span style=' position:relative;left:175px;'>Email</span><br>"
				+ "         <input style='width:255px' type='text' name='CF'>"
				+ "<input name='mail' size='21' style='width:255px; margin-left:30px;' type='email'><br><br>"
				+ "          <span>Indirizzo</span><span style='position:relative;left:410px;'>Civico</span><br>"
				+ "          <input size='40' style='width:445px' type='text'name='indirizzo'>"
				+ "<input name='civico' size='2' style='margin-left:30px;' type='text'><br><br>"
				+ "          <span>Citt&agrave;</span>" + "<span style='position:relative;left:178px;'>Prov.</span>"
				+ "<span style='position:relative;left:225px;'>CAP</span>"
				+ "<span style='position:relative;left:298px;'>Paese</span><br>"
				+ "          <input size='14' name='citta' type='text'>"
				+ "<input name='prov'style='width:50px; margin-left:30px;' size='1' type='text'>"
				+ "<input name='cap' style='margin-left:30px;' size='3' type='text'>"
				+ "<input name='paese' style='margin-left:30px;' size='9' type='text'>"
				+ "          </p> </fieldset> <fieldset id='metodo'>"

				+ "       <legend style='font-size: 20px;font-weight: bold;'>Metodo di pagamento</legend>"
				+ "        <p>  <label> <input type='radio' name='pag' value='contrassegno' id='pagamento_0' checked>"
				+ "              Contrassegno</label>  <br>  <label>"

				+ "              <input type='radio' name='pag' value='carta di credito' id='pagamento_1'>"
				+ "              Carta di Credito</label>  <br>  <label>"
				+ "              <input type='radio' name='pag' value='paypal' id='pagamento_2'>"
				+ "              PayPal</label>   <br> </p>  "
				+ "<a style='color:black;  text-decoration: none; ' href='index.jsp'>ritorna alla home</a>"
				+ "</fieldset>");

		output.println("<input style='display:none' type='text' name='larghezza' value='"
				+ request.getParameter("larghezza") + "'>"
				+ "<input style='display:none' type='text' name='altezza' value='" + request.getParameter("altezza")
				+ "'>" + "<input style='display:none' type='text' name='diametro' value='"
				+ request.getParameter("diametro") + "'>"
				+ "            <input type='submit' value='Prosegui' class='bottone' style='width:150px;'></form>"

				+ "    </div>"

				+ "</body></html>");

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
