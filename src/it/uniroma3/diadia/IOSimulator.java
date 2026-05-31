package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IOSimulator implements IO {

	private Queue<String> input;
	private List<String> output;

	public IOSimulator(List<String> input) {

		this.input = new LinkedList<>(input);
		this.output = new ArrayList<>();
	}

	@Override
	public String leggiRiga() {

		if (this.input.isEmpty())
			return null;

		return this.input.poll();
	}

	@Override
	public void mostraMessaggio(String msg) {

		this.output.add(msg);
	}

	public List<String> getOutput() {

		return this.output;
	}
}