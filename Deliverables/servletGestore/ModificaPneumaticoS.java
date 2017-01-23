package servletGestore;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModificaPneumaticoS in questa classe si modifica
 * il pneumatico presente ne database Pneumatico
 */
@WebServlet("/ModificaPneumaticoS")
public class ModificaPneumaticoS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificaPneumaticoS() {
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

		output.println("<!DOCTYPE HTML> <html> <head>"

				+ " <title>Modifica prodotto - BRIDGESTONE RAPID 82</title>"
				+ " <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>"
				+ " <link rel='stylesheet' type='text/css' href='style.css'>"
				+ " <link href='favicon.ico' rel='icon' type='image/x-icon' />" + " <style>" + "     body {"
				+ "         padding: 30px; font-size: 20px; }" + "     span {    font-weight: bold; }"
				+ "     input {      font-size: 20px; }" + " </style> </head> <body> <div>"
				+ "     <form action='PneumaticoModificatoConSuccessoS' >" + "     <span>Foto Prodotto</span><br>"
				+ "     <input name='foto' type='file' accept='image/*'>"
				+ "     <span style='margin-left:85px;'>Quantit&agrave;: </span>"
				+ "<input name='quantita' style= 'width:35px;' type='number' size='5' value='"
				+ Integer.parseInt(request.getParameter("quantita")) + "'><br><br>"
				+ "     <span>Nome Prodotto</span><span style='position:relative;left:158px;'>"
				+ "Marca Produttore</span><br>" + "     <input name='nome' size='25' type='text' value='"
				+ request.getParameter("nome") + "'>"
				+ "<input name='marca' style='margin-left:30px;' size='25' type='text' " + "value='"
				+ request.getParameter("marca") + "'><br><br>" + "     <span>Larghezza</span>"
				+ "<span style='position:relative;left:33px;'>Altezza</span>"
				+ "<span style='position:relative;left:98px;'>Diametro</span>"
				+ "<span style='position:relative;left:135px;'>Stagionalit&agrave;</span><br>"
				+ "     <input name='larghezza' size='7' type='text'" + "value='" + request.getParameter("larghezza")
				+ "'>" + "<input name='altezza' style='margin-left:30px;' size='7' type='text'" + "value='"
				+ request.getParameter("altezza") + "'>"
				+ "<input name='diametro' style='margin-left:30px;' size='7' type='text'" + "value='"
				+ request.getParameter("diametro") + "'>"
				+ "<input name='stagionalita' style='margin-left:25px;' size='14' type='text'" + "value='"
				+ request.getParameter("stagionalita") + "'>" + "<br><br>");

		output.println(" <b>Id:</b> <input name='id' style='margin-left:25px;' size='14' type='text'" + "value='"
				+ request.getParameter("id") + "'>"

				+ " <b>Prezzo:</b> <input name='prezzo' style='margin-left:25px;' size='14' type='text'" + "value='"
				+ request.getParameter("prezzo") + "'>"
				+ "     <input type='submit' value='Salva Modifiche' class='bottone'>" + "     </form>"
				+ " </div> </body> </html>");

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
