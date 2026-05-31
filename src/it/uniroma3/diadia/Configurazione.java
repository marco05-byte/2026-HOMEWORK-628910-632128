package it.uniroma3.diadia;

import java.io.InputStream;
import java.util.Properties;

public class Configurazione {

	private static Properties properties = new Properties();

	static {
		
		try (InputStream input =
				Configurazione.class.getClassLoader()
				.getResourceAsStream("diadia.properties")) {

			properties.load(input);

		} catch (Exception e) {
			throw new RuntimeException("Errore caricamento properties", e);
		}
	}

	public static int getCFUIniziali() {
		return Integer.parseInt(properties.getProperty("cfu_iniziali"));
	}

	public static int getPesoMassimoBorsa() {
		return Integer.parseInt(properties.getProperty("peso_massimo_borsa"));
	}
	
}