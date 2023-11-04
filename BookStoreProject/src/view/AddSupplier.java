package view;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import Controller.BookController;
import Controller.CategoryController;
import Controller.SupplierController;
import model.User;
import model.Category;
import model.CheckInput;

public class AddSupplier {
    User currentUser;
    int returnView=0;
    
	public AddSupplier(User currentUser) {
		this.currentUser = currentUser;
	}

	public void showView(Stage st) {
		
		Label name = new Label("Name");
		name.setFont(Font.font("Garamond", FontWeight.EXTRA_BOLD, 15));
	   	name.setStyle("-fx-text-fill: black;");
	   	
	   	Label email = new Label("E-mail");
	   	email.setFont(Font.font("Garamond", FontWeight.EXTRA_BOLD, 15));
	   	email.setStyle("-fx-text-fill: black;");
	   	
		Label phone = new Label("Mobile");
		phone.setFont(Font.font("Garamond", FontWeight.EXTRA_BOLD, 15));
	   	phone.setStyle("-fx-text-fill: black;");
		
		TextField nameField = new TextField();
		TextField emailField = new TextField();
		TextField phoneField = new TextField();
		
		Tooltip tp = new Tooltip("Phone MUST be in the format 069XXXXXXX");
		phoneField.setTooltip(tp);
		
				
		GridPane gp = new GridPane();
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(10,10,10,10));
		gp.addColumn(0,name, email, phone);
		gp.addColumn(1,nameField, emailField, phoneField);
		
		Button next = new Button("Next");
		next.setFont(Font.font("Garamond", FontWeight.BOLD, 15));
	   	next.setTextFill(Color.SALMON);
	   	
		Button back = new Button("Cancel");
		back.setFont(Font.font("Garamond", FontWeight.BOLD, 15));
	    back.setTextFill(Color.WHITE);
	   	back.setStyle("-fx-background-color: linear-gradient(#c50000 , #a60000)");
		
		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.setAlignment(Pos.BASELINE_CENTER);
		hb.getChildren().addAll(next,back);
		gp.add(hb, 1, 4);
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(10,10,10,10));
		gp.setAlignment(Pos.CENTER);

		VBox vb = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.setId("vbox");
		vb.getChildren().add(gp);
		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(100, 130, 100, 130));
		bp.setCenter(vb);
        Scene scene = new Scene(bp,500,580);
		st.setScene(scene);
		
		st.setTitle("Add Supplier");
	 	bp.setStyle("-fx-background-color: LAVANDERBLUSH " ) ;
		
		
		back.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(returnView==0) {
					(new ViewSuppliersM(currentUser)).showView(st);
				}else if(returnView==1) {
						(new ManagerView(currentUser)).showView(st);
				}
			}
				
		});
		
		next.setOnAction(new EventHandler<ActionEvent>() {
     
			@Override
			public void handle(ActionEvent event) {
				SupplierController rws = new SupplierController();
				boolean validname=false;
				boolean validemail=false;
				boolean validphone=false;
				
				if((nameField.getText()).isEmpty()) {
					nameField.setPromptText("Please enter a supplier");
					nameField.setStyle("-fx-prompt-text-fill: red");
				}else {
						if(rws.RegisterSupplier(nameField.getText().toString())) {
							nameField.clear();
							nameField.setPromptText("Username is used");
							nameField.setStyle("-fx-prompt-text-fill: red");
						}else {
							validname=true;
						}
				}
				
				if((emailField.getText()).isEmpty()) {
					emailField.setPromptText("Please enter E-mail");
					emailField.setStyle("-fx-prompt-text-fill: red");
				}else {
					if(!(new CheckInput().checkEmail(emailField.getText().toString()))){
						emailField.clear();
						emailField.setPromptText("Something went wrong");
						emailField.setStyle("-fx-prompt-text-fill: red");
					}else {
						validemail=true;
					}
				}
				if((phoneField.getText()).isEmpty()) {
					phoneField.setPromptText("Please enter mobile phone");
					phoneField.setStyle("-fx-prompt-text-fill: red");
				}else {
					if(new CheckInput().checkPhone(phoneField.getText().toString())) {
						validphone = true;
					}else {
						phoneField.clear();
						phoneField.setPromptText("Check the format!");
						phoneField.setStyle("-fx-prompt-text-fill: red");
					}
				}
				if(validname  && validemail && validphone) {
					(new AddBook(currentUser,nameField.getText(),emailField.getText(),phoneField.getText())).showView(st);
				}
			}
			
		});
		
	}

	public void showView(Stage st, int i) {
		returnView=1;
		showView(st);
	}

}