package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {

	@Override
	public Comando costruisciComando(String istruzione) {

		Scanner scannerDiParole = new Scanner(istruzione);

		String nomeComando = null;
		String parametro = null;

		Comando comando;

		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();

		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();

		scannerDiParole.close();

		if (nomeComando == null)
			return new ComandoNonValido();

		String nomeClasse =
				"it.uniroma3.diadia.comandi.Comando"
				+ Character.toUpperCase(nomeComando.charAt(0))
				+ nomeComando.substring(1);

		try {

			comando = (Comando)
					Class.forName(nomeClasse)
					.getDeclaredConstructor()
					.newInstance();

		} catch (Exception e) {

			comando = new ComandoNonValido();
		}

		comando.setParametro(parametro);

		return comando;
	}
}