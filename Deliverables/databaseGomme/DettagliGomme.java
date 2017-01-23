package databaseGomme;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DettagliGomme {
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

	public DettagliGomme() {
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

	public DettagliGomme(int id, String nome, String larghezza, String altezza, String diametro, String stagionalita,
			String marca, String descrizione, double prezzo, int quantita, String foto) {

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
				+ " (`id`, `nome`, `larghezza`, `altezza`, `stagionalita`, `marca`, `descrizione`, `prezzo`,`quantita`, `foto`)  values ('"
				+ id + "','" + nome + "','" + larghezza + "','" + altezza + "','" + stagionalita + "','" + marca + "','"
				+ descrizione + "','" + prezzo + "','" + quantita + "','" + foto + "')";
		dataBase.effettuaUpdate(query);
	}

	public void ModificaPneumatico(AccessoDatabase base, String nomeTabella) throws SQLException {
		String query = "update " + nomeTabella + " set `id`='" + " set `nome`='" + nome + "',`larghezza`='" + larghezza
				+ " set `altezza`='" + altezza + " set `stagionalita`='" + stagionalita + " set `marca`='" + marca
				+ " set `descizione`='" + descrizione + " set `prezzo`='" + prezzo + " set `quantita`='" + quantita
				+ "' where id='" + id + "'";
		base.effettuaUpdate(query);
	}

	public static Pneumatico getPneumatico(String larghezzaI, String altezzaI, String diametroI, String stagionalitaI,
			String marcaI, AccessoDatabase dataBase, String nomeTabella) throws SQLException {

		String query = "select * " + " from " + nomeTabella + " where larghezza=" + "'" + larghezzaI + "'";

		ResultSet resultSet = dataBase.effetuaQuery(query);

		if (resultSet.first()) {

			return new Pneumatico(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("larghezza"),
					resultSet.getString("altezza"), resultSet.getString("diametro"),
					resultSet.getString("stagionalita"), resultSet.getString("marca"),
					resultSet.getString("descrizione"), resultSet.getDouble("prezzo"), resultSet.getInt("quantita"));

		} else {
			return null;
		}
	}

	// ____________________

	public static ArrayList<DettagliGomme> getDettagliPneumatico(String larghezzaI, String altezzaI, String diametroI,
			String stagionalitaI, String marcaI, AccessoDatabase dataBase, String nomeTabella, String pagina)
			throws SQLException {

		String query = "select * " + " from " + nomeTabella + " where larghezza=" + "'" + larghezzaI + "'"
				+ "and altezza= '" + altezzaI + "' and diametro= '" + diametroI + "' and stagionalita='" + stagionalitaI
				+ "' and marca= '" + marcaI + "'";

		ArrayList<DettagliGomme> arrayListP = new ArrayList<>();

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

				DettagliGomme pneumatico = new DettagliGomme(id, nome, larghezza, altezza, diametro, stagionalita,
						marca, descrizione, prezzo, quantita, foto);
				
				arrayListP.add(pneumatico);
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

					DettagliGomme pneumatico1 = new DettagliGomme();
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

	public String toString() {
		String ind1 = foto;

		return " <form action='DettagliAcquistiS' target='_blank'>" + "<input type='text' name='nome' value='" + nome
				+ "' style='display:none'>" + "<input type='text' name='larghezza'value='" + larghezza
				+ "' style='display:none'>" + "<input type='text' name='altezza'value='" + altezza
				+ "' style='display:none'>" + "<input type='text' name='diametro'value='" + diametro
				+ "' style='display:none'>" + "<input type='text' name='stagionalita'value='" + stagionalita
				+ "' style='display:none'>" + "<input type='text' name='marca'value='" + marca
				+ "' style='display:none'>"

				+ "<div class='risultato'><img src='" + ind1 + "'alt='bbbbbbbb'  height='180' width='188'/>"
				+ "<br><br> " + "<h2 class='nomepneumatico' " + " name='nome'>" + nome
				+ "</h2><h2 class='specifichetec'>" + larghezza + " / "

				+ altezza + " / " + diametro + "</h2> " // + stagionalita*/ + ""
														// + marca + " "// +
														// descrizione
				+ "<p class='prezzosing'> &euro; " + prezzo + " cad </p> " + "<span style='color:#eae3e3'>" + quantita
				+ "</span>" + " <input type='submit' value='visualizza' class='bottone' style='right:140px;' "
				+ "></form>"

				+ "<form action='CompraS'>" + "<input type='text' name='nome' value='" + nome
				+ "' style='display:none'>" + "<input type='text' name='larghezza'value='" + larghezza
				+ "' style='display:none'>" + "<input type='text' name='altezza'value='" + altezza
				+ "' style='display:none'>" + "<input type='text' name='diametro'value='" + diametro
				+ "' style='display:none'>" + "<input type='text' name='stagionalita'value='" + stagionalita
				+ "' style='display:none'>" + "<input type='text' name='marca'value='" + marca
				+ "' style='display:none'>" + "<input type='number' name='prezzo'value='" + prezzo
				+ "' style='display:none'>"

				+ "  <input type='submit' value='acquista' class='bottone'></div></form>";

	}

	// ___________

}
