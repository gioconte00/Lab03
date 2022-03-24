package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dictionary {
	
	private Set<String> dizionarioItaliano;
	private Set<String> dizionarioInglese;
	
	
	public Dictionary() {
		
		 dizionarioItaliano = new HashSet<String>();
		 dizionarioInglese = new HashSet<String>();
	}



	public void loadDictionary(String language)  {

	try {
		if(language.equals("English")) {
		
		FileReader fr = new FileReader("src\\main\\resources\\English.txt");
		BufferedReader br = new BufferedReader(fr);
		String word;
		while ((word = br.readLine()) != null) {
			dizionarioInglese.add(word);
		}
		br.close();
		
		}
		if(language.equals("Italian")) {
			
		FileReader fr = new FileReader("src\\main\\resources\\Italian.txt");
		BufferedReader br = new BufferedReader(fr);
		String word;
		while ((word = br.readLine()) != null) {
			dizionarioItaliano.add(word);
		}
		br.close();
		}
		
		 } catch (IOException e){
		System.out.println("Errore nella lettura del file");
		 }
		}
	
	public List<RichWord> spellCheckText(List<String> inputTextList) {
		
		List<RichWord> paroleSbagliate = new ArrayList<RichWord>();
		List<RichWord> paroleTesto= new ArrayList<RichWord>();
		RichWord r;
		
		if(!dizionarioItaliano.isEmpty()) {
			for(String s:inputTextList) {
				if(dizionarioItaliano.contains(s))
					r = new RichWord(s, true);
				else {
					r = new RichWord(s, false);
					paroleSbagliate.add(r);
			}
				paroleTesto.add(r);
			}
		}
			
			if(!dizionarioInglese.isEmpty()) {
				for(String s:inputTextList) {
					if(dizionarioInglese.contains(s))
						r = new RichWord(s, true);
					else {
						r = new RichWord(s, false);
						paroleSbagliate.add(r);
				}
					paroleTesto.add(r);
				}
				
			}
			
		return paroleSbagliate;
	}

	public int numErrori(List<String> inputTextList) {
		return spellCheckText(inputTextList).size();
	}
}
