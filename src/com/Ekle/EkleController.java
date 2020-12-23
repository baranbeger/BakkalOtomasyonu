package com.Ekle;

import com.bilgilerveritabani.VeriTabaniIliskileri;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EkleController {

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtisim;

    @FXML
    private TextField txtfiyat;

    @FXML
    private TextField txtmarka;

    @FXML
    private TextField txtkategori;
    VeriTabaniIliskileri obje=new VeriTabaniIliskileri();

    @FXML
    void kaydetKontrol(ActionEvent event) {
    	String no,isim,fiyat,marka,kategori;
    	no=txtid.getText();
    	isim=txtisim.getText();
    	fiyat=txtfiyat.getText();
    	marka=txtmarka.getText();
    	kategori=txtkategori.getText();
    	
    	obje.Ekle("insert into urunler(Urunid,Urunisim,marka,fiyat,kategori) values("+no+",'"+isim+"','"+marka+"',"+fiyat+",'"+kategori+"')");
    	
    	final Node source=(Node) event.getSource();
        final Stage stage=(Stage) source.getScene().getWindow();
        stage.close();
    	
    }
    

    @FXML
    void vazgecKontrol(ActionEvent event) {
    	final Node source=(Node) event.getSource();
        final Stage stage=(Stage) source.getScene().getWindow();
        stage.close();

    }

}