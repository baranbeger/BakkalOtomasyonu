package com.ana;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.bilgilerveritabani.Urunler;
import com.bilgilerveritabani.VeriTabaniIliskileri;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnaSayfaController implements Initializable {
	public static String name,mark,category;
	public static int no,price;
	
	
    @FXML
    private TextField araid;

    @FXML
    private TableView<Urunler> tblvw;

    @FXML
    private TableColumn<Urunler, Integer> tblvwNo;

    @FXML
    private TableColumn<Urunler, String> tblvwisim;

    @FXML
    private TableColumn<Urunler, String> tblvwmarka;

    @FXML
    private TableColumn<Urunler, Integer> tblvwfiyat;

    @FXML
    private TableColumn<Urunler, String> tblvwkategori;
    
    ObservableList<Urunler> liste=FXCollections.observableArrayList();
    VeriTabaniIliskileri obje=new VeriTabaniIliskileri();
    
    @FXML
    void araText(KeyEvent event) {
      	tblvw.getItems().clear();
    	String nn=araid.getText();
    	
    	ResultSet rss;
    	rss=obje.Listele("select *from urunler where Urunisim like '"+nn+"%';");
    	try {
    		while(rss.next()) {
				int id=rss.getInt("Urunid");
				String ad=rss.getString("Urunisim");
				String marka=rss.getString("marka");
				int fiyat=rss.getInt("fiyat");
				String kategori=rss.getString("kategori");
				Urunler kk=new Urunler(id,ad,marka,fiyat,kategori);
				tblvw.getItems().add(kk);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    
     

    @FXML
    void araKontrol(ActionEvent event) {
    	tblvw.getItems().clear();
    	String nn=araid.getText();
    	
    	ResultSet rss;
    	rss=obje.Listele("select *from urunler where Urunisim like '"+nn+"%';");
    	try {
    		while(rss.next()) {
				int id=rss.getInt("Urunid");
				String ad=rss.getString("Urunisim");
				String marka=rss.getString("marka");
				int fiyat=rss.getInt("fiyat");
				String kategori=rss.getString("kategori");
				Urunler kk=new Urunler(id,ad,marka,fiyat,kategori);
				tblvw.getItems().add(kk);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void ekleKontrol(ActionEvent event) {
    	try {
    		Stage stage=new Stage();
			AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("/com/Ekle/Ekle.fxml"));
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void guncelleKontrol(ActionEvent event) {
    	try {
    		Stage stage=new Stage();
			AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("/com/Guncelle/Guncelle.fxml"));
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void listeleKontrol(ActionEvent event) {
    	tblvw.getItems().clear();
    	ResultSet rss;
    	
    	rss= obje.Listele("select * from urunler");
    	try {
			while(rss.next()) {
				int id=rss.getInt("Urunid");
				String ad=rss.getString("Urunisim");
				String marka=rss.getString("marka");
				int fiyat=rss.getInt("fiyat");
				String kategori=rss.getString("kategori");
				Urunler kk=new Urunler(id,ad,marka,fiyat,kategori);
				tblvw.getItems().add(kk);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	

    }

    @FXML
    void ozellilkerKontrol(ActionEvent event) {
    	try {
    		Stage stage=new Stage();
			AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("/com/Ozellikler/Ozellikler.fxml"));
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void silKontrol(ActionEvent event) {
    	
    	obje.sil("delete from urunler where Urunid='"+no+"';");
    	listeleKontrol(event);

    }
    @FXML
    void secKontrol(MouseEvent event) {
    	Urunler kk=tblvw.getSelectionModel().getSelectedItem();
    	no=kk.getUrunNo();
    	price=kk.getUrunFiyat();
    	name=kk.getUrunIsim();
    	category=kk.getUrunKategori();
    	mark=kk.getUrunMarka();
    	
    	

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		tblvwNo.setCellValueFactory(new PropertyValueFactory<>("UrunNo"));
		tblvwisim.setCellValueFactory(new PropertyValueFactory<>("UrunIsim"));
		tblvwmarka.setCellValueFactory(new PropertyValueFactory<>("UrunMarka"));
		tblvwfiyat.setCellValueFactory(new PropertyValueFactory<>("UrunFiyat"));
		tblvwkategori.setCellValueFactory(new PropertyValueFactory<>("UrunKategori"));
		tblvw.setItems(liste);
		
	}

}