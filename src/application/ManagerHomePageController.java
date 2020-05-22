package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ManagerHomePageController {
	static boolean manager = false;
	
	public static boolean getManager() {
		return manager;
	}

	public static void setManager(boolean manager) {
		Search.manager = manager;
	}
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
	Button signout;
	
	@FXML
	public void personalInfo(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root;
		root = FXMLLoader.load(getClass().getResource("/application/PersonalInfo.fxml"));
		Scene scene1 = new Scene(root, 327, 394);
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene1);
		primaryStage.show();
		
		// get user info from db and put then in the text fields
		
	
	}
	@FXML
	public void savePersonalInfo(ActionEvent event) throws IOException {
		// update user db from text fields
		Stage stage = (Stage) username.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	public void searchForBooks(ActionEvent event) throws IOException {
		setManager(true);
		Stage primaryStage = new Stage();
		Parent root;
		root = FXMLLoader.load(getClass().getResource("/application/SearchForBooks.fxml"));
		Scene scene1 = new Scene(root,909, 888);
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
	@FXML
	public void shoppingCart(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root;
		root = FXMLLoader.load(getClass().getResource("/application/ShoppingCart.fxml"));
		Scene scene1 = new Scene(root,451, 437);
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
	@FXML
	public void logout(ActionEvent event) throws IOException {
		
		// delete all shopping cart
		
		manager = false;
		Stage primaryStage = new Stage();
		Parent root;
		root = FXMLLoader.load(getClass().getResource("/application/First.fxml"));
		Scene scene1 = new Scene(root, 396, 405);
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage stage = (Stage) signout.getScene().getWindow();
	    stage.close();
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
	
	@FXML
	TextField isbnField;
	@FXML
	TextField titleField;
	@FXML
	TextField aothorField;
	@FXML
	TextField priceField;
	@FXML
	TextField copiesField;
	@FXML
	TextField publisherField;
	@FXML
	TextField categoryField;
	@FXML
	TextField yearField;
	
	
	@FXML
	public void addBook(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root;
		root = FXMLLoader.load(getClass().getResource("/application/AddBook.fxml"));
		Scene scene1 = new Scene(root,441, 425);
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene1);
		primaryStage.show();
		
	}
	@FXML
	public void add(ActionEvent event) throws IOException {
		//get from textfields and insert
		Stage stage = (Stage) isbnField.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	TextField number;
	@FXML
	TextField quantity;
	@FXML
	public void placeOrder(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root;
		root = FXMLLoader.load(getClass().getResource("/application/PlaceOrder.fxml"));
		Scene scene1 = new Scene(root,331, 316);
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene1);
		primaryStage.show();
		
	}
	@FXML
	public void place(ActionEvent event) throws IOException {
		
		// insert into book orders
		Stage stage = (Stage) number.getScene().getWindow();
	    stage.close();
	}
	@FXML
	TextField num;
	@FXML
	public void confirmOrder(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root;
		root = FXMLLoader.load(getClass().getResource("/application/ConfirmOrder.fxml"));
		Scene scene1 = new Scene(root,327, 254);
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
	@FXML
	public void confirm(ActionEvent event) throws IOException {
		
		// confirm order 
		Stage stage = (Stage) num.getScene().getWindow();
	    stage.close();
	}
	@FXML
	TextField name;
	@FXML
	public void promoteUser(ActionEvent event) throws IOException {
		
		Stage primaryStage = new Stage();
		Parent root;
		root = FXMLLoader.load(getClass().getResource("/application/PromoteUser.fxml"));
		Scene scene1 = new Scene(root,285, 265);
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene1);
		primaryStage.show();
		
	}
	@FXML
	public void promote(ActionEvent event) throws IOException {
		
		// update user status to manager
		
		Stage stage = (Stage) name.getScene().getWindow();
	    stage.close();
	}
	@FXML
	public void viewReports(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root;
		root = FXMLLoader.load(getClass().getResource("/application/ViewReports.fxml"));
		Scene scene1 = new Scene(root,327, 254);
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
}
