package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignInController implements Initializable{
	@FXML
	TextField username;
	@FXML
	PasswordField password;
	@FXML
	ComboBox<String> userType;
	
	@FXML
	public void signIn(ActionEvent event) throws IOException {
		//check username and password
		/*if(true && userType.getValue() == "Manager") {*/
			Stage primaryStage = new Stage();
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/application/ManagerHomePage.fxml"));
			Scene scene1 = new Scene(root, 354, 516);
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene1);
			Stage stage = (Stage) username.getScene().getWindow();
		    stage.close();
			primaryStage.show();
		/*}*/
			
		/*if(true && userType.getValue() == "Customer") {
			Stage primaryStage = new Stage();
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/application/CustomerHomePage.fxml"));
			Scene scene1 = new Scene(root,397 , 451);
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene1);
			Stage stage = (Stage) username.getScene().getWindow();
		    stage.close();
			primaryStage.show();
		/*}*/
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> list = FXCollections.observableArrayList();
		list.add("Manager");
		list.add("Customer");
		userType.setItems(list);
	}
	
}
