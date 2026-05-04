package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	private String attrezzoSpeciale;
	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.attrezzoSpeciale = nomeAttrezzo;
	}
	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(this.attrezzoSpeciale)) {
			return super.toString();
		}
		else {
			return "qui c'è un buio pesto";
		}
	}
}
