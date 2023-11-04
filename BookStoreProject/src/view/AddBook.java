package view;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Book;
import Controller.CategoryController;

import java.util.ArrayList;

import Controller.BookController;
import Controller.SupplierController;
import model.Supplier;
import model.User;



public class AddBook {
	 User currentUser;
	    int view=0;
	    String supplierName;
	    String phone;
	    String email;
	   	  
	    
	    public AddBook(User currentUser, String supplierName, String email, String phone) {
	    	
			super();
			this.currentUser = currentUser;
			this.supplierName = supplierName;
			this.email = email;
			this.phone = phone;
			view=1;
	    }
	    
		public AddBook(User currentUser, String supplierName) { 
			this.currentUser = currentUser;
			this.supplierName=supplierName;
		}
		
		

			public Scene showView(Stage st) {	
			GridPane gp = new GridPane();
			gp.setHgap(10);
			gp.setVgap(10);
			gp.setPadding(new Insets(10,0,10,0));
			gp.setAlignment(Pos.CENTER_LEFT);
			
			Text text = new Text("Books");
			text.setFont(Font.font("Garamond", FontWeight.EXTRA_BOLD, 25));
		   	text.setStyle("-fx-text-fill: black;");
			
			Label supplier = new Label("Supplier");
			supplier.setFont(Font.font("Garamond", FontWeight.EXTRA_BOLD, 15));
		   	supplier.setStyle("-fx-text-fill: black;");
		   	
		   	
			
			TextField supField = new TextField(supplierName);
			supField.setDisable(true);
			
			Label ISBN = new Label("ISBN");
			ISBN.setFont(Font.font("Garamond", FontWeight.EXTRA_BOLD, 15));
		   	ISBN.setStyle("-fx-text-fill: black;");
			TextField ISBNField = new TextField();
			ISBNField.setTooltip(new Tooltip("ISBN should be of the format ABXX"));
			
			Label name = new Label("Name");
			name.setFont(Font.font("Garamond", FontWeight.EXTRA_BOLD, 15));
		   	name.setStyle("-fx-text-fill: black;");
			TextField nameField = new TextField();
			
			Label category = new Label("Category");	
			category.setFont(Font.font("Garamond", FontWeight.EXTRA_BOLD, 15));
		   	category.setStyle("-fx-text-fill: black;");
			CategoryController cc = new CategoryController();
			ChoiceBox categoryField = new ChoiceBox(FXCollections.observableArrayList(cc.getCategories()));
			categoryField.getSelectionModel().select(0);
						
			gp.addColumn(0, supplier, ISBN, name, category);
			gp.addColumn(1,supField, ISBNField, nameField, categoryField);
			
	        Button create = new Button("Create");
	        create.setFont(Font.font("Garamond", FontWeight.BOLD, 15));
	      	create.setTextFill(Color.LIGHTCORAL);
	      	
	      	create.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					BookController bc = new BookController();
					SupplierController sc = new SupplierController();
						try {
						
						boolean isValidname=false;
						if(nameField.getText().isEmpty()){
							nameField.clear();
							nameField.setPromptText("Please enter the name");
							nameField.setStyle("-fx-prompt-text-fill: red");
						}else {
								isValidname=true;
						}
						
						
						boolean isValidBarcode=false;
						if((ISBNField.getText()).isEmpty()) {
							ISBNField.setPromptText("Please enter the ISBN");
							ISBNField.setStyle("-fx-prompt-text-fill: red");
						}else {
							if(ISBNField.getText().toString().matches("AB[0-9]")) {
								if(bc.useISBN(ISBNField.getText().toString())) {
									ISBNField.clear();
									ISBNField.setPromptText("This ISBN is already used");
									ISBNField.setStyle("-fx-prompt-text-fill: red");
								}else {
									isValidBarcode=true;
								}
							}else {
								ISBNField.clear();
								ISBNField.setPromptText("Check the format");
								ISBNField.setStyle("-fx-prompt-text-fill: red");
							}
						}
						
						
						if(isValidBarcode  && isValidname) {
							String ct = categoryField.getSelectionModel().getSelectedItem().toString();
							bc.addBooks(new Book(ISBNField.getText(), nameField.getText(),ct, supplierName));
							if(view==1) {
								sc.addSupplier(new Supplier(supplierName, email, phone));
							}
							(new ViewSuppliersM(currentUser)).showView(st);
						}
						}catch(Exception e) {
						}
					}
				});
	      	
	        Button back = new Button("Cancel");
	        back.setFont(Font.font("Arial", FontWeight.BOLD, 15));
	        back.setTextFill(Color.WHITE);
	      	back.setStyle("-fx-background-color: linear-gradient(#fbd6ec,#f79fa9)");
	        back.setOnAction(new EventHandler<ActionEvent>() {
				
	   			@Override
	   			public void handle(ActionEvent arg0) {
	   				(new ViewSuppliersM(currentUser)).showView(st);	
	   			}
	   		});
	        
	        
	        HBox h = new HBox();
			h.setSpacing(10);
	        h.getChildren().addAll(create,back);
	        
	        gp.add(h, 1, 6);
	        VBox vb= new VBox();
	        
	        vb.setSpacing(10);
	        vb.getChildren().addAll(text,gp);
	        vb.setAlignment(Pos.CENTER);
			BorderPane root = new BorderPane();
			root.setPadding(new Insets(100, 100, 100, 100));
			root.setCenter(vb);
			st.setTitle("Add Book");
	        Scene scene = new Scene(root,500,400);
			st.setScene(scene);
			root.setStyle("-fx-background-color: LAVANDERBLUSH") ;
			
			return scene;
	        
			}


}
