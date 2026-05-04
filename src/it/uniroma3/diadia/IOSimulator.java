package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO{
	private String[] input;     
	private int indiceInput;
	private List<String> output;
	
	public IOSimulator(String[] input) {
	    this.input = input;
	    this.indiceInput = 0;
	    this.output = new ArrayList<>();
	}
	@Override
	public String leggiRiga() {
	    if (indiceInput < input.length) {
	        return input[indiceInput++];
	    }
	    return null;
	}
	@Override
    public void mostraMessaggio(String msg) {
        output.add(msg);
    }
	public List<String> getOutput() {
        return output;
    }
}
