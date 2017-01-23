package servletGestore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import databaseGomme.AccessoDatabase;
import databaseGomme.Pneumatico;

public class PneumaticoGestore {
	private int id;
	private String nome;
	private String larghezza;
	private String altezza;
	private String diametro;
	private String stagionalita;
	private String marca;
	private String descrizione;
	private double prezzo;
	private int quantita;
	private String foto;

	public PneumaticoGestore() {
		this.id = 0;
		this.nome = "";
		this.larghezza = "";
		this.altezza = "";
		this.diametro = "";
		this.stagionalita = "";
		this.marca = "";
		this.descrizione = "";
		this.prezzo = 0;
		this.quantita = 0;
		this.foto = "";
	}

	public PneumaticoGestore(int id, String nome, String larghezza, String altezza, String diametro,
			String stagionalita, String marca, String descrizione, double prezzo, int quantita, String foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.larghezza = larghezza;
		this.altezza = altezza;
		this.diametro = diametro;
		this.stagionalita = stagionalita;
		this.marca = marca;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.quantita = quantita;
		this.foto = foto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLarghezza() {
		return larghezza;
	}

	public void setLarghezza(String larghezza) {
		this.larghezza = larghezza;
	}

	public String getAltezza() {
		return altezza;
	}

	public void setAltezza(String altezza) {
		this.altezza = altezza;
	}

	public String getStagionalita() {
		return stagionalita;
	}

	public void setStagionalita(String stagionalita) {
		this.stagionalita = stagionalita;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getDiametro() {
		return diametro;
	}

	public void setDiametro(String diametro) {
		this.diametro = diametro;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public void inserisciPneumatico(AccessoDatabase dataBase, String nomeTabella) throws SQLException {

		String query = "insert into " + nomeTabella
				+ " (`id`, `nome`, `larghezza`, `altezza`, `diametro`, `stagionalita`, `marca`, `descrizione`, `prezzo`, `quantita`, `immagine`)  values ('"
				+ id + "','" + nome + "','" + larghezza + "','" + altezza + "','" + diametro + "','" + stagionalita
				+ "','" + marca + "','" + descrizione + "','" + prezzo + "','" + quantita + "','" + foto + "')";
		dataBase.effettuaUpdate(query);
	}

	public void ModificaPneumatico(AccessoDatabase dataBase, String nomeTabella) throws SQLException {
		// "update " + nomeTabella + " set `nome`='" + nome + "',`cognome`='" +
		// cognome + "' where id='"
		// + id + "'";

		String query = "update " + nomeTabella + " set `id`='" + id + "',`nome`='" + nome + "',`larghezza`='"
				+ larghezza + "'" + ",`altezza`='" + altezza + "',`diametro`='" + diametro + "',`stagionalita`='"
				+ stagionalita + "',`marca`='" + marca + "',`descrizione`='" + descrizione + "',`prezzo`='" + prezzo
				+ "',`quantita`='" + quantita + "',`immagine`='" + foto + "' where id='" + id + "'";
		dataBase.effettuaUpdate(query);
	}

	public void eliminaPneumatico(AccessoDatabase dataBase, String nomeTabella) throws SQLException {
		// "update " + nomeTabella + " set `nome`='" + nome + "',`cognome`='" +
		// cognome + "' where id='"
		// + id + "'";

		String query = "delete " + " from " + nomeTabella + " where id=" + "'" + id + "'";
		dataBase.effettuaUpdate(query);
	}

	// ____________________

	public static ArrayList<PneumaticoGestore> getPneumatico2(String larghezzaI, String altezzaI, String diametroI,
			String stagionalitaI, String marcaI, AccessoDatabase dataBase, String nomeTabella, String pagina)
			throws SQLException {

		String query = "select * " + " from " + nomeTabella + " where larghezza=" + "'" + larghezzaI + "'"
				+ "and altezza= '" + altezzaI + "' and diametro= '" + diametroI + "' and stagionalita='" + stagionalitaI
				+ "' and marca= '" + marcaI + "'";

		ArrayList<PneumaticoGestore> arrayListP = new ArrayList<>();

		try {

			ResultSet resultSet = dataBase.effetuaQuery(query);

			if (pagina.equalsIgnoreCase("tutto")) {
				while (resultSet.next()) {

					int id = resultSet.getInt("id");
					String nome = resultSet.getString("nome");
					String larghezza = resultSet.getString("larghezza");
					String altezza = resultSet.getString("altezza");
					String diametro = resultSet.getString("diametro");
					String stagionalita = resultSet.getString("stagionalita");
					String marca = resultSet.getString("marca");
					String descrizione = resultSet.getString("descrizione");
					Double prezzo = resultSet.getDouble("prezzo");
					int quantita = resultSet.getInt("quantita");

					PneumaticoGestore pneumaticoGestore = new PneumaticoGestore(id, nome, larghezza, altezza, diametro,
							stagionalita, marca, descrizione, prezzo, quantita, "");
					// emp.setNome(firstName);
					arrayListP.add(pneumaticoGestore);
				}

			}
			if (pagina.equalsIgnoreCase("index")) {

				while (resultSet.next()) {

					int id = resultSet.getInt("id");
					String nome = resultSet.getString("nome");
					String larghezza = resultSet.getString("larghezza");
					String altezza = resultSet.getString("altezza");
					String diametro = resultSet.getString("diametro");
					String stagionalita = resultSet.getString("stagionalita");
					String marca = resultSet.getString("marca");
					String descrizione = resultSet.getString("descrizione");
					Double prezzo = resultSet.getDouble("prezzo");
					int quantita = resultSet.getInt("quantita");

					PneumaticoGestore pneumatico1 = new PneumaticoGestore();
					pneumatico1.setId(id);
					// pneumatico1.setNome(nome);
					// pneumatico1.setAltezza(altezza);
					// pneumatico1.setLarghezza(larghezza);
					// pneumatico1.setDiametro(diametro);
					// pneumatico1.setPrezzo(prezzo);
					// pneumatico1.setQuantita();
					arrayListP.add(pneumatico1);
				}
			}
			if (pagina.equalsIgnoreCase("dettagliAcquisti")) {

				while (resultSet.next()) {

					int id = resultSet.getInt("id");
					String nome = resultSet.getString("nome");
					String larghezza = resultSet.getString("larghezza");
					String altezza = resultSet.getString("altezza");
					String diametro = resultSet.getString("diametro");
					String stagionalita = resultSet.getString("stagionalita");
					String marca = resultSet.getString("marca");
					String descrizione = resultSet.getString("descrizione");
					Double prezzo = resultSet.getDouble("prezzo");
					int quantita = resultSet.getInt("quantita");

					PneumaticoGestore pneumatico1 = new PneumaticoGestore();
					pneumatico1.setNome(nome);
					pneumatico1.setAltezza(altezza);
					pneumatico1.setLarghezza(larghezza);
					pneumatico1.setDiametro(diametro);
					pneumatico1.setStagionalita(stagionalita);
					pneumatico1.setMarca(marca);

					arrayListP.add(pneumatico1);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayListP;
	}

	public static ArrayList<PneumaticoGestore> queryDatabasePneumaticoTutto(AccessoDatabase dataBase,
			String nomeTabella) throws SQLException {

		String query = "select * " + " from " + nomeTabella;

		ArrayList<PneumaticoGestore> arrayListP = new ArrayList<>();

		try {

			ResultSet resultSet = dataBase.effetuaQuery(query);

			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String larghezza = resultSet.getString("larghezza");
				String altezza = resultSet.getString("altezza");
				String diametro = resultSet.getString("diametro");
				String stagionalita = resultSet.getString("stagionalita");
				String marca = resultSet.getString("marca");
				String descrizione = resultSet.getString("descrizione");
				Double prezzo = resultSet.getDouble("prezzo");
				int quantita = resultSet.getInt("quantita");
				String foto = resultSet.getString("immagine");

				PneumaticoGestore pneumaticoGestore = new PneumaticoGestore(id, nome, larghezza, altezza, diametro,
						stagionalita, marca, descrizione, prezzo, quantita, foto);

				arrayListP.add(pneumaticoGestore);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayListP;
	}

	// ___________
	public String toString() {

		String ind1 = foto;// "gomma.png";

		return " <form action='EliminaPneumaticoS' >" + "<input type='text' name='nome' value='" + nome
				+ "' style='display:none'>" + "<input type='text' name='larghezza'value='" + larghezza

				+ "' style='display:none'>" + "<input type='text' name='altezza'value='" + altezza

				+ "' style='display:none'>" + "<input type='text' name='diametro'value='" + diametro

				+ "' style='display:none'>" + "<input type='text' name='stagionalita'value='" + stagionalita

				+ "' style='display:none'>" + "<input type='text' name='marca'value='" + marca

				+ "' style='display:none'>" + "<input type='text' name='id'value='" + id + "' style='display:none'>"

				+ "<div class='item'><img class='itempic' src='" + ind1 + "'alt='bbbbbbbb'  height='90' />"
				+ "<span class='itemtitolo' " + " name='nome'>" + nome + "</span><br><span class='itemdescr'>"
				+ larghezza + " / " + altezza + " / " + diametro + "</span>" // +
				// stagionalita*/
				// +
				// ""
				// +
				// marca
				// +
				// "
				// "//
				// +
				// descrizione
				// + "<p class='prezzosing'> &euro; " + prezzo + " cad </p> " +
				// "<span style='color:#eae3e3'>" + quantita
				// + "</span>"
				+ "<span class='mod-eli' >"
				+ "<input  style='position:relative; top:21px;' type='submit' value='elimina'></span>" + "</form>"

				+ "<form action='ModificaPneumaticoS' >" + "<input type='text' name='nome' value='" + nome
				+ "' style='display:none'>" + "<input type='text' name='larghezza'value='" + larghezza
				+ "' style='display:none'>" + "<input type='text' name='altezza'value='" + altezza
				+ "' style='display:none'>" + "<input type='text' name='diametro'value='" + diametro
				+ "' style='display:none'>" + "<input type='text' name='stagionalita'value='" + stagionalita
				+ "' style='display:none'>" + "<input type='text' name='marca'value='" + marca
				+ "' style='display:none'>" + "<input type='number' name='prezzo'value='" + prezzo
				+ "' style='display:none'>" + "<input type='number' name='quantita'value='" + quantita
				+ "' style='display:none'>" + "<input type='text' name='id'value='" + id + "' style='display:none'>"

				+ "<span class='mod-eli'>  "
				+ "<input style='position:relative; top:1px;' type='submit' value='modifica'>" + "</span></form></div>";

	}
}
