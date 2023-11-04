package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;

public class LibrarianView {
	 User currentUser;

	public LibrarianView(User currentUser) {
		this.currentUser = currentUser;
	}

	public Scene showView(Stage primaryStage) {
		Button rb1=new Button("Create Bill");
	    rb1.setFont(Font.font("Garamond", FontWeight.SEMI_BOLD, 20));
		rb1.setTextFill(Color.WHITE);
		rb1.setStyle("-fx-background-color: BLACK");
		
		Button rb2=new Button("Log Out");
		rb2.setFont(Font.font("Garamond", FontWeight.SEMI_BOLD, 20));
		rb2.setTextFill(Color.WHITE);
		rb2.setStyle("-fx-background-color: BLACK");
		
		Button rb3=new Button("Help");
		rb3.setFont(Font.font("Garamond", FontWeight.SEMI_BOLD, 20));
		rb3.setTextFill(Color.WHITE);
		rb3.setStyle("-fx-background-color: BLACK");
		
		
		
		rb1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				AddBillView abv = new AddBillView(currentUser);
				Scene sc1 = abv.showView(primaryStage);
				primaryStage.setScene(sc1);
				
			}
			
		});
		rb2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(new LoginView().showView(primaryStage));
				
			}
			
		});
		rb3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Alert al= new Alert(AlertType.INFORMATION, "If you have any problem , you may reach us at : 069-859-6475 ");
				al.show() ;
			}
			
		});
		
		
		HBox hb1=new HBox();
		hb1.getChildren().addAll(rb1,rb3);
		hb1.setSpacing(30);
		hb1.setAlignment(Pos.CENTER);
		HBox hb2=new HBox();
		hb2.setPadding(new Insets(5, 5, 5, 5));
	//	hb2.setMargin(b2, new Insets(0, 10, 0, 10));
		hb2.getChildren().add(rb2);
		hb2.setAlignment(Pos.CENTER);
		
		VBox vb=new VBox();
		Text t2 = new Text();
		t2.setX(10.0f);
		t2.setY(140.0f);
		t2.setCache(true);
		t2.setText("Welcome to librarian Page!");
		t2.setFill(Color.BLACK);
		t2.setFont(Font.font("Garamond", FontWeight.BOLD, 40));
		vb.getChildren().addAll(t2,hb1,hb2);
		vb.setSpacing(45);
		vb.setAlignment(Pos.CENTER);
		StackPane sp=new StackPane();
		sp.getChildren().addAll(vb);
		
			
		Scene sc=new Scene(sp,700,500);
		sp.setBackground(new Background( new BackgroundImage(
                new Image("file:///C:/Users/SATURN-V/Desktop/0.png"),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
        )));
		primaryStage.setScene(sc);
		primaryStage.setTitle("Librarian of BookStore");
		primaryStage.setResizable(false);
		primaryStage.show();
		
		return sc;
		
	}

}
