package com.Ozellikler;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.bilgilerveritabani.Markalar;
import com.bilgilerveritabani.VeriTabaniIliskileri;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class kategorisayiController implements Initializable {
	VeriTabaniIliskileri obje=new VeriTabaniIliskileri();

    @FXML
    private TableView<Markalar> tblvwkat;

    @FXML
    private TableColumn<Markalar, String> tblvwkategoriler;

    @FXML
    private TableColumn<Markalar, Integer> tblvwkategorilersayi;
    
    ObservableList<Markalar> liste=FXCollections.observableArrayList();
    @FXML
    void tiklayinca(MouseEvent event) {
     	ResultSet rss;
    	
    	
    	try {
    		rss= obje.Listele("select kategori,count(isim) as 'Sayisi' from gecmis group by kategori;");
			while(rss.next()) {
				
				String ad=rss.getString("kategori");
				int marka=rss.getInt("Sayisi");
					Markalar kkkkkk=new Markalar(ad,marka);
					tblvwkat.getItems().add(kkkkkk);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
ResultSet rss;
    	
    	
    	try {
    		rss= obje.Listele("select kategori,count(isim) as 'Sayisi' from gecmis group by kategori;");
			while(rss.next()) {
				
				String ad=rss.getString("kategori");
				int marka=rss.getInt("Sayisi");
					Markalar kkkkkk=new Markalar(ad,marka);
					tblvwkat.getItems().add(kkkkkk);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		    	tblvwkategoriler.setCellValueFactory(new PropertyValueFactory<>("markalar"));
		    	tblvwkategorilersayi.setCellValueFactory(new PropertyValueFactory<>("MarkaSayilari"));
		    	tblvwkat.setItems(liste);
		    	
		
	}
	

}
