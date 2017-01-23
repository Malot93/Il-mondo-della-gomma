package databaseOrdini;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import databaseGomme.AccessoDatabase;
import databaseGomme.Pneumatico;

/** questa classe istanzia gli attributi dell' ordine */

public class DettagliOrdine {
	private String nome;
	private String cognome;
	private String cF;
	private String email;
	private String indirizzo;
	private String civico;
	private String citta;
	private String prov;
	private String cap;
	private String paese;
	private String metodoPagamento;
	private String intestatarioCarta;
	private String numeroCarta;
	private String dataScadenza;
	private int quantita;
	private double prezzo;
	private String nomePneumatico;

	public DettagliOrdine() {

		this.nome = "";
		this.cognome = "";
		this.cF = "";
		this.email = "";
		this.indirizzo = "";
		this.civico = "";
		this.citta = "";
		this.prov = "";
		this.cap = "";
		this.paese = "";
		this.metodoPagamento = "";
		this.intestatarioCarta = "";
		this.numeroCarta = "";
		this.dataScadenza = "";
		this.quantita = 0;
		this.prezzo = 0;
		this.nomePneumatico = "";
	}

	public DettagliOrdine(String nome, String cognome, String cF, String email, String indirizzo, String civico,
			String citta, String prov, String cap, String paese, String metodoPagamento, String intestatarioCarta,
			String numeroCarta, String dataScadenza, int quantita, double prezzo, String nomePneumatico) {

		this.nome = nome;
		this.cognome = cognome;
		this.cF = cF;
		this.email = email;
		this.indirizzo = indirizzo;
		this.civico = civico;
		this.citta = citta;
		this.prov = prov;
		this.cap = cap;
		this.paese = paese;
		this.metodoPagamento = metodoPagamento;
		this.intestatarioCarta = intestatarioCarta;
		this.numeroCarta = numeroCarta;
		this.dataScadenza = dataScadenza;
		this.quantita = quantita;
		this.prezzo = prezzo;
		this.nomePneumatico = nomePneumatico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getcF() {
		return cF;
	}

	public void setcF(String cF) {
		this.cF = cF;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProv() {
		return prov;
	}

	public void setProv(String prov) {
		this.prov = prov;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getPaese() {
		return paese;
	}

	public void setPaese(String paese) {
		this.paese = paese;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public String getIntestatarioCarta() {
		return intestatarioCarta;
	}

	public void setIntestatarioCarta(String intestatarioCarta) {
		this.intestatarioCarta = intestatarioCarta;
	}

	public String getNumeroCarta() {
		return numeroCarta;
	}

	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

	public String getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getNomePneumatico() {
		return nomePneumatico;
	}

	public void setNomePneumatico(String nomePneumatico) {
		this.nomePneumatico = nomePneumatico;
	}

	public void inserisciOrdine(AccessoDatabase dataBase, String nomeTabella) throws SQLException {

		String query = "insert into " + nomeTabella
				+ "(`nome`, `cognome`, `CF`, `email`, `indirizzo`, `civico`, `citta`, `provincia`,"
				+ "`cap`, `paese`, `metodoPagameento`, `intestatarioCarta`, `numeroCarta`, `dataScadenza`,"
				+ " `quantita`, `prezzo`, `nomePneumatico`)" + " values (  '" + nome + "','" + cognome + "','" + cF
				+ "','" + email + "','" + indirizzo + "','" + civico + "','" + citta + "','" + prov + "','" + cap
				+ "','" + paese + "','" + metodoPagamento + "','" + intestatarioCarta + "','" + numeroCarta + "','"
				+ dataScadenza + "','" + quantita + "','" + prezzo + "','" + nomePneumatico + "')";
		dataBase.effettuaUpdate(query);
	}

	// public void ModificaOrdine(AccessoDatabase base, String nomeTabella)
	// throws SQLException {
	// String query = "update " + nomeTabella + " set `id`='" + " set `nome`='"
	// + nome + "',`larghezza`='" + larghezza
	// + " set `altezza`='" + altezza + " set `stagionalita`='" + stagionalita +
	// " set `marca`='" + marca
	// + " set `descizione`='" + descrizione + " set `prezzo`='" + prezzo + "
	// set `quantita`='" + quantita
	// + "' where id='" + id + "'";
	// base.effettuaUpdate(query);
	// }

	public static Pneumatico getOrdine(String larghezzaI, String altezzaI, String diametroI, String stagionalitaI,
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

	public void eliminaOrdine(AccessoDatabase dataBase, String nomeTabella) throws SQLException {

		String query = "delete " + " from " + nomeTabella + " where CF=" + "'" + cF + "'";
		dataBase.effettuaUpdate(query);
	}

	// ____________________

	public static ArrayList<DettagliOrdine> getDettagliOrdini(AccessoDatabase dataBase, String nomeTabella,
			String pagina) throws SQLException {

		String query = "select * " + " from " + nomeTabella;

		ArrayList<DettagliOrdine> arrayListO = new ArrayList<>();

		try {

			ResultSet resultSet = dataBase.effetuaQuery(query);

			if (pagina.equalsIgnoreCase("tutto")) {

				while (resultSet.next()) {

					String nome = resultSet.getString("nome");
					String cognome = resultSet.getString("cognome");
					String cf = resultSet.getString("CF");
					String email = resultSet.getString("email");
					String indirizzo = resultSet.getString("indirizzo");
					String civico = resultSet.getString("civico");
					String citta = resultSet.getString("citta");
					String provincia = resultSet.getString("provincia");
					String cap = resultSet.getString("cap");
					String paese = resultSet.getString("paese");
					String metodoPagamento = resultSet.getString("metodoPagameento");
					String intestatarioCarta = resultSet.getString("intestatarioCarta");
					String numeroCarta = resultSet.getString("numeroCarta");
					String dataScadenza = resultSet.getString("dataScadenza");
					int quantita = resultSet.getInt("quantita");
					double prezzo = resultSet.getDouble("prezzo");
					String nomePneumatico = resultSet.getString("nomePneumatico");

					DettagliOrdine ordine = new DettagliOrdine();
					ordine.setNome(nome);
					ordine.setCognome(cognome);
					ordine.setcF(cf);
					ordine.setEmail(email);
					ordine.setIndirizzo(indirizzo);
					ordine.setCivico(civico);
					ordine.setCitta(citta);
					ordine.setProv(provincia);
					ordine.setCap(cap);
					ordine.setPaese(paese);
					ordine.setMetodoPagamento(metodoPagamento);
					ordine.setIntestatarioCarta(intestatarioCarta);
					ordine.setNumeroCarta(numeroCarta);
					ordine.setDataScadenza(dataScadenza);
					ordine.setQuantita(quantita);
					ordine.setPrezzo(prezzo);
					ordine.setNomePneumatico(nomePneumatico);
					arrayListO.add(ordine);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayListO;
	}

	@Override
	public String toString() {

		return "<div class='item'><form action='DettaglioOrdineS'><span class'ordernome'> " + nome + " " + cognome
				+ " </span><br>" + "<input type='text' name='cf' value='" + cF + "' style='display:none'>"
				+ "<input type='text' name='nome' value='" + nome + "' style='display:none'>"
				+ "<input type='text' name='cognome' value='" + cognome + "' style='display:none'>"
				+ "<input type='text' name='email' value='" + email + "' style='display:none'>"
				+ "<input type='text' name='indirizzo' value='" + indirizzo + "' style='display:none'>"
				+ "<input type='text' name='civico' value='" + civico + "' style='display:none'>"

				+ "<input type='text' name='citta' value='" + citta + "' style='display:none'>"
				+ "<input type='text' name='provincia' value='" + prov + "' style='display:none'>"
				+ "<input type='text' name='cap' value='" + cap + "' style='display:none'>"
				+ "<input type='text' name='paese' value='" + paese + "' style='display:none'>"
				+ "<input type='text' name='metodoPagamento' value='" + metodoPagamento + "' style='display:none'>"
				+ "<input type='text' name='intestatarioCarta' value='" + intestatarioCarta + "' style='display:none'>"
				+ "<input type='text' name='numeroCarta' value='" + numeroCarta + "' style='display:none'>"
				+ "<input type='text' name='dataScadenza' value='" + dataScadenza + "' style='display:none'>"
				+ "<input type='text' name='quantita' value='" + quantita + "' style='display:none'>"
				+ "<input type='text' name='prezzo' value='" + prezzo + "' style='display:none'>"
				+ "<input type='text' name='nomePneumatico' value='" + nomePneumatico + "' style='display:none'>"

				+ "    <span class='orderarticolo'> " + nomePneumatico + " x<span class='num'>" + quantita
				+ " </span></span><br>" + "    <span class='orderid'>ID ordine: <span class='id'><b>" + cF
				+ "</b></span></span><br>" + "    <span class='orderdett'>" + "" + "" + "" + ""
				+ "<input type='submit' value='dettaglio ordine'></span></form>" + "</div>";
		// + "DettagliOrdine [nome=" + nome + ", cognome=" + cognome + ", cF=" +
		// cF + ", email=" + email
		// + ", indirizzo=" + indirizzo + ", civico=" + civico + ", citta=" +
		// citta + ", prov=" + prov + ", cap="
		// + cap + ", paese=" + paese + ", metodoPagamento=" + metodoPagamento +
		// ", intestatarioCarta="
		// + intestatarioCarta + ", numeroCarta=" + numeroCarta + ",
		// dataScadenza=" + dataScadenza + ", quantita="
		// + quantita + ", prezzo=" + prezzo + ", nomePneumatico=" +
		// nomePneumatico + "]";
	}

}
