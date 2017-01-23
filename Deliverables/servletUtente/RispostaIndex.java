package servletUtente;

import java.awt.Window;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.sun.java.swing.plaf.windows.resources.windows;

import databaseGomme.AccessoDatabase;
import databaseGomme.DettagliGomme;
import databaseGomme.Pneumatico;

/**
 * Servlet implementation class RispostaIndex in questa classe si risponde
 * effettuando una ricerca in base ai dati inseriti dal' utente
 */
@WebServlet("/RispostaIndex")
public class RispostaIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RispostaIndex() {
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

		/**
		 * qui ho dichiarato delle variabili assegnandovi dei parametri presi da
		 * index.jsp
		 **/

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

			// faccio la query per farmi cacciare i risultati
			// Pneumatico.getPneumatico("", dataBase, "Pneumatico.pneumatici");

			/**
			 * in questa parte scrivo la pagina html combinata con la
			 * servletUtente che risponde a index.jsp e che la forza sia con te
			 */
			output.println("<!DOCTYPE html>" + "<html>" + "<head>"

					+ "<title>Il Mondo della Gomma - Risultati Ricerca</title>"
					+ "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'>" + "</script>"
					+ "<link rel='stylesheet' type='text/css' href='style.css'>"
					+ " <link href='favicon.ico' rel='icon' type='image/x-icon' />");

			output.println("</head> <body>" + "<div id='navbar'><h3> 089/1565482 </h3></div>" + "<div id='container'>"
					+ " <br><br><a style='color:black;  text-decoration: none; ' href='index.jsp'>ritorna alla home</a>"
					+ "<h2>Risultati Ricerca:</h2>" + DettagliGomme.getDettagliPneumatico(larghezza, altezza, diametro,
							stagionalita, marcaProduttore, dataBase, "Pneumatico.pneumatici", "").toString());

			output.println("</div>" + "</body> </html> ");

			// System.out.println(Pneumatico.getPneumatico2(larghezza, altezza,
			// diametro, stagionalita, marcaProduttore,
			// dataBase, "Pneumatico.pneumatici", "index").toString());
			System.out.println("larg= " + larghezza + " alt= " + altezza + " diam= " + diametro + " stag= "
					+ stagionalita + " marca= " + marcaProduttore);
			dataBase.close();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
