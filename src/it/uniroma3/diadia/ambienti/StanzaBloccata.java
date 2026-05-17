package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private String direzioneBloccata;
	private String attrezzoSblocco;
	public StanzaBloccata(String nome, String dir, String attrezzo) {
		super(nome);
		this.direzioneBloccata=dir;
		this.attrezzoSblocco = attrezzo;
	}
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(this.direzioneBloccata.equals(direzione) && 
				!super.hasAttrezzo(this.attrezzoSblocco)) {
			return this;
		}
		else {
			return super.getStanzaAdiacente(direzione);
		}
			
	}
	@Override
	public String getDescrizione() {
		return super.getDescrizione()+"\nDirezione bloccata: "+this.direzioneBloccata;
	}
}
