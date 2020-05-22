package application;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Search implements Initializable{
	private static Book book;
	static boolean manager;
	
	public static Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	@FXML
	ComboBox<String> attributes;
	@FXML
	TextField inputAttribute;
	@FXML
	TableView<Book> table = new TableView<Book>();
	@FXML
	TableColumn<Book, String> title = new TableColumn<Book, String>("title");
	@FXML
	TableColumn<Book, String> category = new TableColumn<Book, String>("category");
	@FXML
	TableColumn<Book, String> author = new TableColumn<Book, String>("author");
	@FXML
	TableColumn<Book, String> price = new TableColumn<Book, String>("price");
	@FXML
	TableColumn<Book, String> publisher = new TableColumn<Book, String>("publisher");
	@FXML
	TableColumn<Book, String> year = new TableColumn<Book, String>("year");
	@FXML
	TableColumn<Book, String> isbn = new TableColumn<Book, String>("isbn");
	@FXML
	TableColumn<Book, String> copies = new TableColumn<Book, String>("copies");
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@FXML
	public void searchForBooks(ActionEvent event) throws IOException {
		System.out.print("LLLLLLLLLLL");
		String SearchAttribute = attributes.getValue();
		String input = inputAttribute.getText();
	
		//search from db using the inputs
		
		//display output in list view
		
		final ObservableList<Book> data = FXCollections.observableArrayList();
		
		for(int i = 0; i < 3; i++) {
			Book b = new Book("11","Fady", "khaled", "NADA", "120", "1998", "NADA", "20");
			data.add(b);
		}
		table.setItems(data);
		table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		        int index = data.indexOf(table.getSelectionModel().getSelectedItem());
		        String id = (String) data.get(index).getIsbn();
		        System.out.println(index + "  " + id);
		        
		     // use the isbn to add the book to cart
		        
		        setBook(data.get(index));
		        Stage primaryStage = new Stage();
				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource("/application/AddToCart.fxml"));
					Scene scene1 = new Scene(root, 332,395);
					scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene1);
					primaryStage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		        
		    }
		});
     }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> list = FXCollections.observableArrayList();
		list.add("Title");
		list.add("Author");
		list.add("Category");
		list.add("Publication Year");
		list.add("Selling Price");
		list.add("Publisher");
		attributes.setItems(list);
		
		title.setCellValueFactory(new PropertyValueFactory<>("title"));
		author.setCellValueFactory(new PropertyValueFactory<>("author"));
		price.setCellValueFactory(new PropertyValueFactory<>("price"));
		publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
		category.setCellValueFactory(new PropertyValueFactory<>("category"));
		year.setCellValueFactory(new PropertyValueFactory<>("year"));
		isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
		copies.setCellValueFactory(new PropertyValueFactory<>("copies"));
		
		manager = ManagerHomePageController.getManager();
		
	}

}
