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
import databaseGomme.DettagliGomme;
import databaseGomme.Pneumatico;

/**
 * Servlet implementation class DettagliAcquisti questa classe non fa altro che
 * dare in dettaglio le informazioni sul pneumatico selezionato modifiche
 */
@WebServlet("/DettagliAcquistiS")
public class DettagliAcquistiS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DettagliAcquistiS() {
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
		try {
			/** uso la classe DataBase da me creata */

			AccessoDatabase dataBase = new AccessoDatabase("127.0.0.1", 3306, "root", "");

			/**
			 * uso i parametri e li salvo nelle sottostanti variabili (i dati
			 * provengono da RispostaIndex)
			 */
			String larghezza = request.getParameter("larghezza");
			String altezza = request.getParameter("altezza");
			String diametro = request.getParameter("diametro");
			String stagionalita = request.getParameter("stagionalita");
			String marcaProduttore = request.getParameter("marca");

			/** qui scrivo il codice html combinato */
			System.out.println("dettagli larg= " + larghezza + " alt= " + altezza + " diam= " + diametro + " stag= "
					+ stagionalita + " marca= " + marcaProduttore);
			output.println(" <!DOCTYPE HTML>" + "<html>" + "<head>"

					+ "    <title>BRIDGESTONE RAPID 82 - Dettagli Prodotto</title>"
					+ "    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>"
					+ "    <link rel='stylesheet' type='text/css' href='style.css'>"
					+ "    <link href='img/favicon.ico' rel='icon' type='image/x-icon' />"

					+ "</head><body>"

					+ "   <a style='cursor:pointer; position:absolute;top:-15px;right:10px;' onclick='window.close();'><h3>X</h3></a>"
					+ "   <h1 id='det_nome'>" + request.getParameter("nome") + "</h1>" + "   <div>"
					+ "       <figure><img src='gomma.png' style='width: 180px;position:relative;top:80px;'></figure>"
					+ "        <p style='font-size: 125%; line-height:30px;position:absolute;top:80px;left:250px;'>"
					+ "            Larghezza: " + "<br>" + "            Altezza: " + " <br>" + "            Diametro: "
					+ " <br>" + "            Stagionalit&agrave;: " + "<br>" + "            Marca Produttore:"
					+ "        </p>"
					+ "<p style='font-size: 150%;font-weight:bold; line-height:30px;position:absolute;top:75px;left:500px;'>"
					+ "<span id='larghezza'>" + request.getParameter("larghezza") + "</span> <br>"
					+ "<span id='altezza'>" + request.getParameter("altezza") + "</span> <br>" + "<span id='diametro'>"
					+ request.getParameter("diametro") + "</span> <br>" + "         <span id='stagionalita'>"
					+ request.getParameter("stagionalita") + "</span> <br>" + "         <span id='marcaproduttore'>"
					+ request.getParameter("marca") + "</span>" + "</p>" + "</div>"

					+ "</body>" + "</html>");
			dataBase.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
