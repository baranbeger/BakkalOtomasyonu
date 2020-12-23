package application; 
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bilgilerveritabani.VeriTabaniIliskileri;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class IlkSayfaController {
	VeriTabaniIliskileri obje=new VeriTabaniIliskileri();
	Alert mesaj=new Alert(AlertType.ERROR);

    @FXML
    private TextField txtad;

    @FXML
    private TextField textsifre;

    @FXML
    void girisKontrol(ActionEvent event) {
    	String TakmaAd,Sifre;
    	TakmaAd=txtad.getText();
    	Sifre=textsifre.getText();
    	
    	          
    	
    	try {
    		ResultSet rss;
    		rss=obje.Listele("select count(Kullaniciid) as 'giris' from kullanici where kullaniciad='"+TakmaAd+"' and sifre='"+Sifre+"';");
			while(rss.next()) {
				if(rss.getInt("giris")==1) {
					try {
		    		Stage stage=new Stage();
					AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("/com/ana/AnaSayfa.fxml"));
					stage.setScene(new Scene(root));
					stage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				}
				else {
					mesaj.setTitle("Hata Mesaji");
					mesaj.setHeaderText("Hatali giris");
					mesaj.setContentText("lütfen doðru  gir");
					mesaj.show();
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	

    }

    @FXML
    void kaydolKontrol(ActionEvent event) {
    	try {
    		Stage stage=new Stage();
			AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("/com/kaydol/Kaydol.fxml"));
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    }
    

    @FXML
    void unuttumKontrol(MouseEvent event) {
    	Alert mesaj=new Alert(AlertType.WARNING);
    	mesaj.setTitle("Bilgi");
		mesaj.setHeaderText("Bu bilgi Mesajýdýr");
		mesaj.setContentText("unutmasaydýn");
		mesaj.show();

    }

}