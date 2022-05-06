package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	LinkedList<String> parola;
		
	public Parole() {
		//TODO
		parola= new LinkedList<String>();
	}
	
	public void addParola(String p) {
		//TODO
		parola.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parola);
		return parola;
	}
	
	public void reset() {
		// TODO
		parola.clear();
	}
	public void cancella(String selezionata) {
		parola.remove(selezionata);
	}

}
