package view;

import Controller.LibrarianController;
import Controller.ManagerController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.User;

public class ManagerView {

User currentUser;
	
	public ManagerView(User currentUser) {
		this.currentUser = currentUser;
	}

	public Scene showView(Stage primaryStage) {
		BorderPane Pane = new BorderPane();
		
		
		Pane.setStyle("-fx-background-color: THISTLE");
		Rectangle r= new Rectangle();
		
		r.setX(50);
		r.setY(50);
		r.setWidth(330);
		r.setHeight(380);
		r.setFill(Color.LAVENDER);
		r.setStroke(Color.BLACK);
	
		
		GridPane gp= new GridPane();
		gp.setVgap(10);
		gp.setHgap(10);
		gp.setAlignment(Pos.CENTER);
		

		Label l1= new Label("    BOOKS");
		l1.setFont(Font.font("Garamond", FontWeight.BOLD, FontPosture.ITALIC, 25));
		l1.setTextFill(Color.BLACK);
		gp.add(l1, 1, 1);
		

		Button ViewSupplier= new Button("   View Supplier");
		ViewSupplier.setAlignment(Pos.CENTER);
		ViewSupplier.setFont(Font.font("Garamond", FontWeight.BOLD, 15));
		ViewSupplier.setTextFill(Color.BLACK);
		
		ViewSupplier.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				(new ViewSuppliersM(currentUser)).showView(primaryStage);
			}
		});
		
		Button AddSupplier= new Button("   Add Supplier ");
		AddSupplier.setAlignment(Pos.CENTER);
		AddSupplier.setFont(Font.font("Garamond", FontWeight.BOLD, 15));
		AddSupplier.setTextFill(Color.BLACK);
		AddSupplier.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				(new AddSupplier(currentUser)).showView(primaryStage,1);
			}
		});
		
		Button Stock= new Button("          Stock      ");
		Stock.setAlignment(Pos.CENTER);
		Stock.setFont(Font.font("Garamond", FontWeight.BOLD, 15));
		Stock.setTextFill(Color.BLACK);
		
		Stock.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			(new viewStockM(currentUser)).showView(primaryStage);
				
			}
		});
		
	
		Button Category= new Button("     Category     ");
		Category.setAlignment(Pos.CENTER);
		Category.setFont(Font.font("Garamond", FontWeight.BOLD, 15));
		Category.setTextFill(Color.BLACK);
		
		Category.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				(new AddCategoryM(currentUser)).showView(primaryStage);
				
			}

		});

		Button Quantity= new Button("      Quantity     ");
		Quantity.setAlignment(Pos.CENTER);
		Quantity.setFont(Font.font("Garamond", FontWeight.BOLD, 15));
		Quantity.setTextFill(Color.BLACK);
		Quantity.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				(new QuantityM(currentUser)).showView(primaryStage);
				
			}
		});
		
		Button ShowPerformance= new Button("Show Performance");
		ShowPerformance.setAlignment(Pos.CENTER);
		ShowPerformance.setFont(Font.font("Garamond", FontWeight.BOLD, 15));
		ShowPerformance.setTextFill(Color.BLACK);
		ShowPerformance.setOnAction(e->{
			ManagerController mc = new ManagerController();
			String result = mc.checkLibrarianPerformance(new LibrarianController());
			System.out.println(result);
			if(result=="OK") {
				Alert okAlert = new Alert(AlertType.INFORMATION);
				okAlert.setHeaderText("Good performance");
				okAlert.setContentText("The performace of the librarian is satisfying. He has ordered more than 5 bills today."+System.lineSeparator() +"You can always check his bills in the bills folder inside the project folder.");
				okAlert.show();
			}
			else if(result=="FAIL") {
				Alert warningAlert = new Alert(AlertType.WARNING);
				warningAlert.setHeaderText("Bad performance");
				warningAlert.setContentText("The performace of the librarian is not satisfying. He has ordered less than 5 bills today."+System.lineSeparator()	+ " You can always check his bills in the bills folder inside the project folder.");
				warningAlert.show();
			}
		});

		HBox h= new HBox();
		
		Button logout= new Button("Log Out");
		logout.setFont(Font.font("Garamond", FontWeight.BOLD, 20));
		logout.setTextFill(Color.SALMON);
		Button cancel= new Button("Cancel");
		cancel.setFont(Font.font("Garamond", FontWeight.BOLD, 20));
		cancel.setTextFill(Color.SALMON);
		
		h.getChildren().addAll(logout,cancel);
		h.setAlignment(Pos.BOTTOM_CENTER);
		h.setPadding(new Insets(20,20,20,20));
		h.setMargin(logout, new Insets(0,20,0,0));
	
		gp.addColumn(1, ViewSupplier,AddSupplier,Stock,Category,Quantity,ShowPerformance);
		Pane.setBottom(h);
		

        logout.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(new LoginView().showView(primaryStage));
				
			}
       
        });
        
        cancel.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
				
			}
        	
        });
	
		
		StackPane sp = new StackPane();
		sp.getChildren().addAll(r , gp);
		Pane.setCenter(sp);
		
		Scene scene = new Scene(Pane,800,539);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Manager of BookStore");
		return scene;
		
	
		
		
		
		
	}

}
