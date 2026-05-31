package it.uniroma3.diadia.comandi;

import java.util.HashSet;
import java.util.Set;

import it.uniroma3.diadia.IO;

public abstract class AbstractComando implements Comando {

	private String parametro;
	protected IO io;

	private static Set<String> comandiDisponibili = new HashSet<>();


	protected void registraComando(String nome) {
		comandiDisponibili.add(nome);
	}

	public static Set<String> getComandiDisponibili() {
		return comandiDisponibili;
	}

	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	@Override
	public String getParametro() {
		return this.parametro;
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}
}
