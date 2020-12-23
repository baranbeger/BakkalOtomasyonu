package com.kaydol;

import com.bilgilerveritabani.VeriTabaniIliskileri;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class KaydolController {

   

    @FXML
    private TextField txtisim;

    @FXML
    private TextField txtsoyisim;

    @FXML
    private TextField txtkullanici;

    @FXML
    private PasswordField txtsifre;

    @FXML
    private PasswordField txtsifreiki;
    VeriTabaniIliskileri obje=new VeriTabaniIliskileri();
    Alert mesaj=new Alert(AlertType.ERROR);

    @FXML
    void KaydetKontrol(ActionEvent event) {
    	String isim,soyisim,kullanici,sifre,sifre2;
    	
    	isim=txtisim.getText();
    	soyisim=txtsoyisim.getText();
    	kullanici=txtkullanici.getText();
    	sifre=txtsifre.getText();
    	sifre2=txtsifreiki.getText();
    	if(sifre.equals(sifre2)) {  
    	obje.Ekle("insert into kullanici(isim,soyisim,kullaniciad,sifre) values('"+isim+"','"+soyisim+"','"+kullanici+"','"+sifre+"');");

    	}
    	else {
    		mesaj.setTitle("Hata");
    		mesaj.setHeaderText("textboxlarý kontrol et");
    		mesaj.setContentText("sifre ve Kullanici adýný kontrol et");
    		mesaj.showAndWait();
    	}
    	final Node source=(Node) event.getSource();
        final Stage stage=(Stage) source.getScene().getWindow();
        stage.close();
    }

}