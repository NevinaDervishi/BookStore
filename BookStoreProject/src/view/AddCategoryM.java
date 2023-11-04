package view;
import Controller.CategoryController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Category;
import model.User;


public class AddCategoryM {
User currentUser;
	
	public AddCategoryM(User currentUser) {
		this.currentUser = currentUser;
	}
	
	
   public Scene showView(Stage St) {
	   
	   GridPane gp = new GridPane();
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setAlignment(Pos.CENTER);
	
		Label category = new Label("New Category");
		category.setFont(Font.font("Garamond", FontWeight.EXTRA_BOLD, 15));
	   	category.setStyle("-fx-text-fill: black;");
		TextField CategoryField = new TextField();
		gp.addRow(0, category , CategoryField);
		
		
		Button add = new Button("Add");
		add.setFont(Font.font("Garamond", FontWeight.BOLD, 15));
	   	add.setTextFill(Color.LIGHTCORAL);
	  
	   	add.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(CategoryField.getText().toString().matches("[A-Z][a-z]*\\s?[a-z]*")) {
					CategoryController cc = new CategoryController();
				    cc.addCategory(new Category(CategoryField.getText()));
				   CategoryField.clear();
				    new Alert(AlertType.CONFIRMATION,"The New Category has been added to your store!").show();
				}else {
					CategoryField.clear();
					CategoryField.setStyle("-fx-prompt-text-fill: red");
				}
			}
		});
	   	
		Button cancel = new Button("Cancel");
		cancel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
	    cancel.setTextFill(Color.WHITE);
	   	cancel.setStyle("-fx-background-color: linear-gradient(#fbd6ec,#f79fa9)");
	   	
	   	cancel.setOnAction(e -> {
			(new ManagerView(currentUser)).showView(St);
		});
	   	
		HBox hb = new HBox();
		hb.setSpacing(12);
		hb.getChildren().addAll(add,cancel);
		gp.add(hb, 1, 1);
     
	
		Scene scene = new Scene(gp,450,300);
		St.setScene(scene);
		St.setResizable(false);
		gp.setStyle("-fx-background-image: LavanderBlush") ;
		
		St.setTitle("Add New Category");
		St.show();
		
		
		return scene;}

}
