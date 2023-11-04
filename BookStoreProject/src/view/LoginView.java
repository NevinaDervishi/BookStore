package view;

import model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class LoginView {
	User currentUser;
	public Scene showView(Stage primaryStage) {
		GridPane pane = new GridPane();
		pane.setHgap(6);
		pane.setVgap(6);
		pane.setPadding(new Insets(50,50,50,50));
		pane.setAlignment(Pos.CENTER_LEFT);
		
		Label l1 = new Label("   LOGIN");
		l1.setFont(Font.font("Imprint MT Shadow", FontWeight.BOLD, FontPosture.ITALIC, 35));
		l1.setStyle("-fx-text-fill: white;");
		pane.add(l1, 2, 0);
		
		Label l2 = new Label("Don't have an account? Sign up here");
		l2.setFont(Font.font("Imprint MT Shadow", FontPosture.ITALIC, 17));
		l2.setStyle("-fx-text-fill: white;");
		pane.add(l2, 2, 7);
	
		Button signUp = new Button( "Sign Up");
		signUp.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		signUp.setTextFill(Color.SALMON);
		pane.add(signUp,2,9);
		
	
		Label  username= new Label("Username");
		TextField userField = new TextField();
		username.setFont(Font.font("Garamond",FontWeight.BOLD,16));
		username.setStyle("-fx-text-fill:white");
		userField.setPromptText("Enter username");
		pane.add(username, 1, 2);
		pane.add(userField, 2,2 );
		
		
		Label  password= new Label("Password");
		PasswordField passField = new PasswordField();
		password.setFont(Font.font("Garamond", FontWeight.BOLD, 16));
		password.setStyle("-fx-text-fill: white;");
		passField.setPromptText("Enter Password");
		pane.add(password, 1, 3);
		pane.add(passField, 2, 3);
		
		Button login= new Button("Log in");
		login.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		login.setTextFill(Color.SALMON);
		
		
		Button cancel= new Button("Cancel");
		cancel.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		cancel.setTextFill(Color.SALMON);
	

		pane.setStyle("-fx-background-image: url('file:///C:/Users/SATURN-V/Desktop/7535068F-88A9-445F-AA6C-40954B29B4AB.PNG');"+ "-fx-background-position: center center; " +
		           "-fx-background-repeat: stretch;" +
		           "-fx-background-size: 700 500");
		
		HBox h= new HBox();
		h.setPadding(new Insets(5, 5, 5, 5));
		h.setSpacing(10);
		h.getChildren().addAll(login,cancel);
		pane.add(h, 2, 4);
		
		Text err = new Text("Something is wrong!!!!");
		err.setFont(Font.font("Garamond", FontWeight.NORMAL, 15));
		err.setStyle("-fx-background-color:#F01414");
		err.setFill(Color.RED);
		err.setVisible(false);
		
		pane.add(err, 2, 3);
	
		
		signUp.setOnAction(e->{
			RegisterView rv = new RegisterView(currentUser);
			Scene scene2 = rv.showView(primaryStage);
			primaryStage.setScene(scene2);
	
		});
		
		
		

		cancel.setOnAction(new EventHandler<ActionEvent>()  {
			public void handle (ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		login.setOnAction(e->{
			if(userField.getText().equals("librarian") && passField.getText().equals("librarian"))
			{
				
			    LibrarianView LibrarianView = new LibrarianView(currentUser);
				Scene scene1 = LibrarianView.showView(primaryStage);
				primaryStage.setScene(scene1);
					
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("Successfully logged in as a librarian!");
				alert.showAndWait();
			   
			}
			else if(userField.getText().equals("manager") && passField.getText().equals("manager"))
			{
				
				
				ManagerView mv = new ManagerView(currentUser);
				Scene sc = mv.showView(primaryStage);
				primaryStage.setScene(sc);
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("Successfully logged in as a manager!");
				alert.showAndWait();
			}
			else if(userField.getText().equals("admin") && passField.getText().equals("admin"))
			{
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setContentText("Successfully logged in as a administrator!");
				alert.show();
				AdministratorView av = new AdministratorView(currentUser);
				Scene sc = av.showView(primaryStage);
			}
			
			else {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setTitle("Error");
				errorAlert.setContentText("Please, enter the correct credencials!");
	            errorAlert.show();
			}
			
		});
		pane.setStyle("-fx-background-image: url('file:///C:/Users/SATURN-V/Desktop/7535068F-88A9-445F-AA6C-40954B29B4AB.PNG');"+ "-fx-background-position: center center; " +
		           "-fx-background-repeat: stretch;" +
		           "-fx-background-size: 700 500");
		Scene sc= new Scene(pane, 700, 500);
		primaryStage.setTitle("Log in");
		primaryStage.setResizable(false);
		primaryStage.show();
		

		sc.setOnKeyPressed(new EventHandler<KeyEvent>() {


			@Override
			public void handle(KeyEvent event) {
			    if(userField.getText().equals("librarian") && userField.getText().equals("Librarian"))
				{
					
				    LibrarianView cashierview = new LibrarianView(currentUser);
					Scene scene1 = cashierview.showView(primaryStage);
					primaryStage.setScene(scene1);
						
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setContentText("Successfully logged in as a librarian!");
					alert.showAndWait();
				   
				}
				else if(userField.getText().equals("manager") && passField.getText().equals("librarian"))
				{
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setContentText("Successfully logged in as a manager!");
					alert.show();
					
					ManagerView mv = new ManagerView(currentUser);
					Scene sc = mv.showView(primaryStage);
				}
				else if(userField.getText().equals("admin") && passField.getText().equals("admin"))
				{
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setContentText("Successfully logged in as a administrator!");
					alert.show();
					AdministratorView av = new AdministratorView(currentUser);
					Scene sc = av.showView(primaryStage);
				}
				
				else {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setTitle("Error");
					errorAlert.setContentText("Please, enter the correct credencials!");
		            errorAlert.show();
				}
				
			}
			
		});
		return sc;
	}

}
