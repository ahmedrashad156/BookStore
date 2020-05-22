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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddToCartController implements Initializable {
	private Book book;
	static boolean manager;
	
	@FXML
	ComboBox<Integer> combo = new ComboBox<Integer>();
	@FXML
	Label or;
	@FXML
	Button edit;
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
	public void add(ActionEvent event) throws IOException {
		int copies = combo.getValue();
		
		// add to cart
		
		Stage stage = (Stage) combo.getScene().getWindow();
	    stage.close();
	}
	
	@FXML
	public void editBook(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root;
		root = FXMLLoader.load(getClass().getResource("/application/EditBook.fxml"));
		Scene scene1 = new Scene(root,441, 425);
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene1);
		primaryStage.show();
		Stage stage = (Stage) combo.getScene().getWindow();
	    stage.close();
	}
	@FXML
	public void save(ActionEvent event) throws IOException {
		
		isbnField.setText(book.getIsbn());
		titleField.setText(book.getTitle());
		aothorField.setText(book.getAuthor());
		priceField.setText(book.getPrice());
		copiesField.setText(book.getCopies());
		publisherField.setText(book.getPublisher());
		categoryField.setText(book.getCategory());
		yearField.setText(book.getYear());
		//update book from fields
		
		Stage stage = (Stage) isbnField.getScene().getWindow();
	    stage.close();
	    
	    // refresh table view
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Integer> list = FXCollections.observableArrayList();
		book = Search.getBook();
		for(int i = 1; i <= Integer.parseInt(book.getCopies()); i++) {
			list.add(i);
		}
		combo.setItems(list);
		manager = ManagerHomePageController.getManager();
		if(manager) {
			or.setVisible(true);
			edit.setVisible(true);
		}
	}
}
