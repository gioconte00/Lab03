package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	private String word;
	private boolean corretto;
	
	public RichWord(String word, boolean corretto) {
		
		this.word = word;
		this.corretto = corretto;
	}

	public String getWord() {
		return word;
	}

	public boolean isCorretto() {
		return corretto;
	}
	
	
	
	

}
