package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.LoginView;
public class HomeView {
	public Scene showView(Stage primaryStage)
	{
		
		
		GridPane pane = new GridPane();
		Button bt1 = new Button ("Login");
		Font font1 = Font.font("Garamond",FontWeight.BOLD,20);
		bt1.setFont(font1);
		bt1.setTextFill(Color.BLACK);
		bt1.setStyle("-fx-background-color:linear-gradient(#E6E6FA) ");
		
		Button bt2 = new Button("Exit");
		Font font2 = Font.font("Garamond",FontWeight.BOLD,20);
		bt2.setFont(font2);
		bt2.setTextFill(Color.BLACK);
		bt2.setStyle("-fx-background-color:linear-gradient(#E6E6FA) ");
		
		pane.add(bt1,0,3);
		pane.add(bt2,2 ,2 );
		HBox h= new HBox();
		h.setPadding(new Insets(5, 5, 5, 5));
		h.setSpacing(10);
		h.getChildren().addAll(bt1,bt2);
		pane.add(h, 2,4);

		
		Text tx1 = new Text();
		tx1.setText("BookStore");
		tx1.setFont(Font.font("Garamond ",FontWeight.SEMI_BOLD,FontPosture.ITALIC, 50));
		pane.setHgap(6);
		pane.setVgap(6);
		pane.setPadding(new Insets(50,50,50,50));
		pane.setAlignment(Pos.BOTTOM_LEFT);
		pane.add(tx1, 2, 0);
		
		
		pane.setStyle("-fx-background-image: url('file:///C:/Users/SATURN-V/Desktop/IMG_8728.JPG');"+ "-fx-background-position: center center; " +
		           "-fx-background-repeat: stretch;" +
		           "-fx-background-size: 700 500");
		
		Scene sc=new Scene(pane,700,500);
		
		primaryStage.setScene(sc);
		primaryStage.setTitle("BookStore");
		primaryStage.setResizable(false);
		
		primaryStage.show();
		
		LoginView login= new LoginView();
		bt1.setOnAction(e->{
			
				primaryStage.setScene(login.showView(primaryStage));
			
			
		
		});
			bt2.setOnAction(e->
			{
				System.exit(0);
			});
		
		
		return sc ;
	}

}
