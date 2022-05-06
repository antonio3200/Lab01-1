/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.parole;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.parole.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Parole model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancella"
    private Button btnCancella; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doCancella(ActionEvent event) {
          String parola=txtResult.getSelectedText();
          if(parola.length()==0) {
        	  txtResult.setText("SELEZIONA UNA PAROLA");
          }
          model.cancella(parola);
          txtResult.clear();
          String result="";
          for(String s: model.getElenco())
          	result+=s+"\n";
          txtResult.appendText(result);
          
    }

    @FXML
    void doInsert(ActionEvent event) {
    	txtResult.clear();
        String parola= txtParola.getText();
        if(parola.length()==0) {
        	txtResult.setText("ATTENZIONE:SCRIVI PAROLA");
        	}
        else {
        model.addParola(parola);
        String result="";
        for(String s: model.getElenco())
        	result+=s+"\n";
        txtResult.appendText(result);
        txtParola.clear();
        }
    }   

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	model.reset();
    	txtParola.clear();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        model= new Parole();
    }
}
