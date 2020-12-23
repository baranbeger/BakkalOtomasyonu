package com.Ozellikler;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.bilgilerveritabani.Gecmis;
import com.bilgilerveritabani.VeriTabaniIliskileri;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OzelliklerController implements Initializable{

    @FXML
    private TableView<Gecmis> tblvwgecmis;

    @FXML
    private TableColumn<Gecmis, Integer> tblvwgecmisno;

    @FXML
    private TableColumn<Gecmis,String> tblvwgecmisisim;

    @FXML
    private TableColumn<Gecmis, Integer> tblvwgecmisfiyat;

    @FXML
    private TableColumn<Gecmis, Integer> tblvwgecmiskategori;

    @FXML
    private TableColumn<Gecmis, Date> tblvwgecmistarih;
    ObservableList<Gecmis> liste=FXCollections.observableArrayList();
    VeriTabaniIliskileri obje=new VeriTabaniIliskileri();
    Alert mesaj=new Alert(AlertType.INFORMATION);

    @FXML
    void encokkategori(ActionEvent event) {
    	try {
    		Stage stage=new Stage();
			AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("kategorisayi.fxml"));
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }


    @FXML
    void encokurunKontrol(ActionEvent event) {
    	//en çok satýlan ürün
 	

    }

    @FXML
    void gecmislisKontrol(ActionEvent event) {
    	tblvwgecmis.getItems().clear();
    	ResultSet rss;
    	
    	rss= obje.Listele("select * from gecmis");
    	try {
			while(rss.next()) {
				int id=rss.getInt("Islemid");
				String ad=rss.getString("isim");
				int fiyat=rss.getInt("fiyat");
				String kategori=rss.getString("kategori");
				String tarih=rss.getString("tarih");
				Gecmis kkk=new Gecmis(id,ad,fiyat,kategori,tarih);
				tblvwgecmis.getItems().add(kkk);
				System.out.println(id+"-"+ad+"- "+fiyat+"-"+kategori);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void kullaniciKontrol(ActionEvent event) {
    	try {
    		Stage stage=new Stage();
			AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("/com/Kullanici/Kullanici.fxml"));
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void satisKontrol(ActionEvent event) {
    	//toplam satýþ
    	int sum=0;
    	
    	ResultSet rss=obje.Listele("select sum(fiyat) from gecmis");
    	try {
			while(rss.next()) {
				int c=rss.getInt(1);
				sum+=c;
				
				
			}
			
			mesaj.setHeaderText("satýlan urunlerin satýþ toplamý");
			mesaj.setContentText("Toplam:"+sum+" TL");
			mesaj.show();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	

    }

    @FXML
    void truncateKontrol(ActionEvent event) {
    	
    	
    	obje.Editle("TRUNCATE TABLE gecmis;");
    	
    	gecmislisKontrol(event);

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		tblvwgecmisno.setCellValueFactory(new PropertyValueFactory<>("IslemNo"));
		tblvwgecmisisim.setCellValueFactory(new PropertyValueFactory<>("UrunIsim"));
		tblvwgecmisfiyat.setCellValueFactory(new PropertyValueFactory<>("UrunFiyat"));
		tblvwgecmiskategori.setCellValueFactory(new PropertyValueFactory<>("UrunKategori"));
		tblvwgecmistarih.setCellValueFactory(new PropertyValueFactory<>("Uruntarih"));
		tblvwgecmis.setItems(liste);
		
	}

}