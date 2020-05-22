package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController {
	@FXML
	TextField username;
	@FXML
	TextField email;
	@FXML
	TextField firstname;
	@FXML
	TextField lastname;
	@FXML
	TextField addressname;
	@FXML
	TextField phone;
	@FXML
	PasswordField password;
	@FXML
	Label error;
	
	@FXML
	public void signUp(ActionEvent event) throws IOException {
		// add to the database
		// if kolo tamam {
		 	Stage primaryStage = new Stage();
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/application/CustomerHomePage.fxml"));
			Scene scene1 = new Scene(root,397 , 451);
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene1);
			Stage stage = (Stage) username.getScene().getWindow();
	    	stage.close();
			primaryStage.show();
		// else { 
			//error.setVisible(true);
	}
	
}
