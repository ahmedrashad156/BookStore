package application;

import java.io.IOException;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreditCardController {
	@FXML
	Button checkout;
	@FXML
	TextField number;
	@FXML
	TextField date;
	@FXML
	Label error;
	
	@FXML
	public void checkOut(ActionEvent event) throws IOException {
		/*if(/*valid card) { 
			
			//remove all elements from cart
			//sell books from db
			
			Stage stage = (Stage) checkout.getScene().getWindow();
		    stage.close();
		    
		    //refresh cart
		/*}
		else {
			error.setVisible(true);
		}*/
	}
}
