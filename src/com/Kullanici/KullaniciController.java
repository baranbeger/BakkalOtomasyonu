package com.Kullanici;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.bilgilerveritabani.Kullanici;
import com.bilgilerveritabani.VeriTabaniIliskileri;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class KullaniciController implements Initializable {

    @FXML
    private TableView<Kullanici> tblvwkullanici;

    @FXML
    private TableColumn<Kullanici,Integer> tblvwkullanicino;

    @FXML
    private TableColumn<Kullanici,String> tblvwkullaniciisim;

    @FXML
    private TableColumn<Kullanici,String> tblvwkullanicisoyisim;

    @FXML
    private TableColumn<Kullanici,String> tblvwkullanicitakma;
    

    @FXML
    private TableColumn<Kullanici,String> tblvwkullanicisifre;
    ObservableList<Kullanici> liste=FXCollections.observableArrayList();
    
    @FXML
    void tiklayinca(MouseEvent event) {
    	VeriTabaniIliskileri obje=new VeriTabaniIliskileri();
		ResultSet rss;
    	
    	rss= obje.Listele("select * from kullanici");
    	try {
			while(rss.next()) {
				int id=rss.getInt("Kullaniciid");
				String ad=rss.getString("isim");
				String Soyisim=rss.getString("soyisim");
				String takma=rss.getString("kullaniciad");
				String sifre=rss.getString("sifre");
				Kullanici kk=new Kullanici(id,ad,Soyisim,takma,sifre);
				tblvwkullanici.getItems().add(kk);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		VeriTabaniIliskileri obje=new VeriTabaniIliskileri();
		ResultSet rss;
    	
    	rss= obje.Listele("select * from kullanici");
    	try {
			while(rss.next()) {
				int id=rss.getInt("Kullaniciid");
				String ad=rss.getString("isim");
				String Soyisim=rss.getString("soyisim");
				String takma=rss.getString("kullaniciad");
				String sifre=rss.getString("sifre");
				Kullanici kk=new Kullanici(id,ad,Soyisim,takma,sifre);
				tblvwkullanici.getItems().add(kk);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	
     	tblvwkullanicino.setCellValueFactory(new PropertyValueFactory<>("KullaniciNo"));
    	tblvwkullaniciisim.setCellValueFactory(new PropertyValueFactory<>("KullaniciIsim"));
    	tblvwkullanicisoyisim.setCellValueFactory(new PropertyValueFactory<>("KullaniciSoyisim"));
    	tblvwkullanicitakma.setCellValueFactory(new PropertyValueFactory<>("KullaniciAdi"));
    	tblvwkullanicisifre.setCellValueFactory(new PropertyValueFactory<>("KullaniciSifre"));
    	tblvwkullanici.setItems(liste);
		
		
	}

}
