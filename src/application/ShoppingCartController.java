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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ShoppingCartController implements Initializable{

	private int itemIndex = 0;
	private final ObservableList<CheckOutItem> data = FXCollections.observableArrayList();
	
	@FXML
	TableView<CheckOutItem> table = new TableView<CheckOutItem>();
	@FXML
	TableColumn<CheckOutItem, String> title = new TableColumn<CheckOutItem, String>("title");
	@FXML
	TableColumn<CheckOutItem, String> price = new TableColumn<CheckOutItem, String>("price");
	@FXML
	TableColumn<CheckOutItem, String> isbn = new TableColumn<CheckOutItem, String>("isbn");
	@FXML
	TableColumn<CheckOutItem, String> copies = new TableColumn<CheckOutItem, String>("copies");
	@FXML
	Button remove;
	@FXML
	TextField total = new TextField();
	@FXML
	Button checkout;
	
	@FXML
	public void removeItem(ActionEvent event) throws IOException {
		data.remove(itemIndex);
		
		 // remove from shopping cart then refresh scene
		
		System.out.println(data.size() + "  data");
		Stage stage = (Stage) remove.getScene().getWindow();
	    stage.close();
	    table.setItems(data);
		table.refresh();
	}
	
	@FXML
	public void checkOut(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root;
		root = FXMLLoader.load(getClass().getResource("/application/CreditCard.fxml"));
		Scene scene1 = new Scene(root,331, 327);
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage stage = (Stage) total.getScene().getWindow();
	    stage.close();
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		title.setCellValueFactory(new PropertyValueFactory<>("title"));
		price.setCellValueFactory(new PropertyValueFactory<>("price"));
		isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
		copies.setCellValueFactory(new PropertyValueFactory<>("copies"));
		
		// add everything in the cart to the table
		
		
		for(int i = 0; i < 3; i++) {
			CheckOutItem b = new CheckOutItem("title", "isbn", "copies", 12);
			data.add(b);
		}
		table.setItems(data);
		table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		        itemIndex = data.indexOf(table.getSelectionModel().getSelectedItem());
		        System.out.println(itemIndex);
		        
		     // use the index to remove from the cart
		        
		        Stage primaryStage = new Stage();
				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource("/application/RemoveItem.fxml"));
					Scene scene1 = new Scene(root,378, 303);
					scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene1);
					primaryStage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		        
		    }
		});
		int totalInt = 0;
		for(int i = 0; i < data.size(); i++) {
			totalInt += data.get(i).getPrice();
			System.out.println(data.get(i).getPrice());
		}
		total.setText(String.valueOf(totalInt));
	}

}
