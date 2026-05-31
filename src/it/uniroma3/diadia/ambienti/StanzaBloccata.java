package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private Direzione direzioneBloccata;
	private String attrezzoSblocco;

	public StanzaBloccata(String nome, Direzione dir, String attrezzo) {
		super(nome);
		this.direzioneBloccata = dir;
		this.attrezzoSblocco = attrezzo;
	}

	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {

		if (this.direzioneBloccata == direzione &&
			!super.hasAttrezzo(this.attrezzoSblocco)) {
			return this;
		}

		return super.getStanzaAdiacente(direzione);
	}

	@Override
	public String getDescrizione() {
		return super.getDescrizione()
				+ "\nDirezione bloccata: "
				+ this.direzioneBloccata;
	}
}