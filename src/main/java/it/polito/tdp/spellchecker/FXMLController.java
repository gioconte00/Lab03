package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {

	private Dictionary model;
	Long start, end;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> cmbLingua;

    @FXML
    private Label txtNumErrori;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private TextArea txtTesto;

    @FXML
    private Label txtTime;

    @FXML
    void handleCheck(ActionEvent event) {
    	
    	start = System.nanoTime();
    	
    	txtRisultato.clear();
    	model = new Dictionary();
    	this.model.loadDictionary(cmbLingua.getValue());
    	String testo = txtTesto.getText();
    	String t = testo.toLowerCase().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    	
    	String parola[] = t.split(" ");
    	List<String> parole = new ArrayList<String>();
    	
    	for(String s:parola)
    		parole.add(s);
    	
    	for(RichWord r: this.model.spellCheckText(parole))
    		txtRisultato.appendText(r.getWord()+" ");
    	
    	txtNumErrori.setText("The text contains "+model.numErrori(parole)+" errors.");
    	//System.out.print("The text contains "+model.numErrori(parole)+" errors.");
    	
    	end = System.nanoTime();
    	txtTime.setText("Tempo impiegato: "+(end-start)+" ns");
    	
 
    }

    @FXML
    void handleClear(ActionEvent event) {
    	
    	txtRisultato.clear();
    	txtTesto.clear();
    	
    	

    }

    @FXML
    void initialize() {
        assert cmbLingua != null : "fx:id=\"cmbLingua\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNumErrori != null : "fx:id=\"txtNumErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";

        cmbLingua.getItems().clear();
        cmbLingua.getItems().add("English");
        cmbLingua.getItems().add("Italian");
       
        
    }

    public void setModel(Dictionary model) {
    	this.model=model;
    }
}



