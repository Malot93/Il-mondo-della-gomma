package servletUtente;

import java.io.IOException;
import java.io.PrintWriter;
//Questa classe non è stata usata non è stata  usata!!!!!!
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class RicercaEffettuataConSuccessoS
 */
@WebServlet("/RicercaEffettuataConSuccessoS")
public class RicercaEffettuataConSuccessoS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RicercaEffettuataConSuccessoS() {
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

		String larghezza = request.getParameter("larghezza");
		String altezza = request.getParameter("altezza");
		String diametro = request.getParameter("diametro");
		String stagionalita = request.getParameter("stagionalita");
		String marcaProduttore = request.getParameter("marca");
		/**
		 * effettuo dei controlli per garantire che i parametri inseriti dal'
		 * utente siano corretti
		 */
		if (larghezza.equalsIgnoreCase("0")) {
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showMessageDialog(null, "errore non hai inserito la larghezza del pneumatico");

		}

		if (altezza.equalsIgnoreCase("0")) {
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showMessageDialog(null, "errore non hai inserito l' altezza del pneumatico");
		}

		if (diametro.equalsIgnoreCase("0")) {
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showMessageDialog(null, "errore non hai inserito il diametro del pneumatico");
		}

		if (stagionalita.equalsIgnoreCase("0")) {
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showMessageDialog(null, "errore non hai inserito la stagionalità del pneumatico");
		}

		if (marcaProduttore.equalsIgnoreCase("0")) {
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showMessageDialog(null, "errore non hai inserito la marca del pneumatico");
		}

		if (altezza.equalsIgnoreCase("0") || larghezza.equalsIgnoreCase("0")) {
			response.sendRedirect("index.jsp");
		}
		output.println("<!DOCTYPE HTML>" + "<html>" + "<head>"

				+ " <title>Il Mondo della Gomma - Successo</title>"
				+ "  <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>"
				+ "  <link rel='stylesheet' type='text/css' href='style.css'>"
				+ " <link href='img/favicon.ico' rel='icon' type='image/x-icon' />"
				// + "<meta http-equiv='refresh' content='3;URL=RispostaIndex'>"
				// + "</head>"

				+ "<body>"

				+ "<div id='navbar'></div>" + "<div id='centrale'>"
				+ "   <h2 align='center' style='position:relative;top:-40px;'>" + " Riepilogo ricerca........</h2>"

				+ "<form action='RispostaIndex'>" + "<input class='ricerca' type='text' name='larghezza' value='"
				+ larghezza + "' readonly>" + "<input type='text' name='altezza' value='" + altezza + "' readonly>"
				+ "<input type='text' name='diametro' value='" + diametro + "' readonly>"
				+ "<input type='text' name='stagionalita' value='" + stagionalita + "' readonly>"
				+ "<input type='text' name='marca' value='" + marcaProduttore + "' readonly><br><br>"
				+ "<input class='bottone' type='submit' value='conferma la ricerca'>"
				+ "<a style='color:black; text-decoration:none; ' href='index.jsp'>Torna alla home</a>" + "  </div>");

		output.println("</body>" + "</html>");

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
