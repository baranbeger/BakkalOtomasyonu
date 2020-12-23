package com.Guncelle;

import com.ana.*;
import com.bilgilerveritabani.VeriTabaniIliskileri;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GuncelleKontroller {
	VeriTabaniIliskileri ilisliGuncelle=new VeriTabaniIliskileri();

    @FXML
    private TextField txtno;

    @FXML
    private TextField txtmarka;

    @FXML
    private TextField txtisim;

    @FXML
    private TextField txtfiyat;

    @FXML
    private TextField txtkategori;
   

    @FXML
    void getirKontrol(ActionEvent event) {
    	 String numara,isimler,markalar,fiyatlar,kategoriler;
    	numara=Integer.toString(AnaSayfaController.no);
    	txtno.setText(numara);
    	fiyatlar=Integer.toString(AnaSayfaController.price);
    	txtfiyat.setText(fiyatlar);
    	isimler=AnaSayfaController.name;
    	txtisim.setText(isimler);
    	markalar=AnaSayfaController.mark;
    	txtmarka.setText(markalar);
    	kategoriler=AnaSayfaController.category;
    	txtkategori.setText(kategoriler);

    }
    

    @FXML
    void kaydetKontrol(ActionEvent event) {
    	 String numara,isimler,markalar,fiyatlar,kategoriler;
    	numara=txtno.getText();
    	isimler=txtisim.getText();
    	markalar=txtmarka.getText();
    	fiyatlar=txtfiyat.getText();
    	kategoriler=txtkategori.getText();
    	 
    	ilisliGuncelle.Editle("update urunler set Urunisim='"+isimler+"', marka='"+markalar+"', fiyat="+fiyatlar+", kategori='"+kategoriler+"' where Urunid='"+numara+"';");
    	
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
