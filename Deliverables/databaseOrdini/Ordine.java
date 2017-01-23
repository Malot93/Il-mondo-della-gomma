package databaseOrdini;

public class Ordine {
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

	public Ordine() {
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

	public Ordine(String nome, String cognome, String cF, String email, String indirizzo, String civico, String citta,
			String prov, String cap, String paese, String metodoPagamento, String intestatarioCarta, String numeroCarta,
			String dataScadenza, int quantita, double prezzo, String nomePneumatico) {
		
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

}
