package view;
import java.util.ArrayList;

import Controller.UserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;
public class AllEmployeeView {
private User currentUser;
	
	public AllEmployeeView(User u){
		this.currentUser= u;
	}
	
	
	public Scene showView(Stage stage){
		VBox root= new VBox();
		UserController uc= new UserController();
		ObservableList<User> users=FXCollections.observableArrayList(uc.getUsers());
		
		TableView<User> table = new TableView();
		table.setItems(users);
		table.setEditable(true);
		
		TableColumn firstNameColumn = new TableColumn("First Name");
		firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<User , String>("firstName"));
		firstNameColumn.setOnEditCommit(new EventHandler<CellEditEvent<User , String>>(){

			@Override
			public void handle(CellEditEvent<User, String> t) {
				// TODO Auto-generated method stub
				
				User modifiedUser= (User)t.getTableView().getItems().get(t.getTablePosition().getRow());
				int pos=uc.positionOfUser(modifiedUser);
				modifiedUser.setFirstName(t.getNewValue());
				uc.editUser(modifiedUser, pos);
			}
			
		});
	

		TableColumn lastNameColumn = new TableColumn("Last Name");
		lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<User , String>("lastName"));
		lastNameColumn.setOnEditCommit(new EventHandler<CellEditEvent<User , String>>(){

			@Override
			public void handle(CellEditEvent<User, String> t) {
				// TODO Auto-generated method stub
				
				User modifiedUser= (User)t.getTableView().getItems().get(t.getTablePosition().getRow());
				int pos=uc.positionOfUser(modifiedUser);
				modifiedUser.setLastName(t.getNewValue());
				uc.editUser(modifiedUser, pos);
			}
			
		});
		

		TableColumn usernameColumn = new TableColumn("Username");
		usernameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		usernameColumn.setCellValueFactory(new PropertyValueFactory<User , String>("username"));
		usernameColumn.setOnEditCommit(new EventHandler<CellEditEvent<User , String>>(){

			@Override
			public void handle(CellEditEvent<User, String> t) {
				
				
				User modifiedUser= (User)t.getTableView().getItems().get(t.getTablePosition().getRow());
				int pos=uc.positionOfUser(modifiedUser);
				modifiedUser.setUsername(t.getNewValue());
				uc.editUser(modifiedUser, pos);
			}
			
		});
		
		

		TableColumn phoneColumn = new TableColumn("Phone");
		phoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		phoneColumn.setCellValueFactory(new PropertyValueFactory<User , String>("phone"));
		phoneColumn.setOnEditCommit(new EventHandler<CellEditEvent<User , String>>(){

			@Override
			public void handle(CellEditEvent<User, String> t) {
				// TODO Auto-generated method stub
				
				User modifiedUser= (User)t.getTableView().getItems().get(t.getTablePosition().getRow());
				int pos=uc.positionOfUser(modifiedUser);
				
				
				modifiedUser.setPhone(t.getNewValue());
				uc.editUser(modifiedUser, pos);
			}
			
		});
		
		TableColumn salaryColumn = new TableColumn("Salary");
		salaryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		salaryColumn.setCellValueFactory(new PropertyValueFactory<User , String>("salary"));
		salaryColumn.setOnEditCommit(new EventHandler<CellEditEvent<User , String>>(){

			@Override
			public void handle(CellEditEvent<User, String> t) {
				
				User modifiedUser= (User)t.getTableView().getItems().get(t.getTablePosition().getRow());
				int pos=uc.positionOfUser(modifiedUser);
				//String newFirstName=(String) t.getNewValue();
				
				modifiedUser.setSalary(t.getNewValue());
				uc.editUser(modifiedUser, pos);
			}
			
		});
		
		
		TableColumn professionColumn = new TableColumn("Profession");
		professionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		professionColumn.setCellValueFactory(new PropertyValueFactory<User , String>("profession"));
		table.getColumns().addAll(firstNameColumn,lastNameColumn, usernameColumn, phoneColumn,salaryColumn,professionColumn);
		
		Text err  = new Text("Please select an employee!");
		err.setVisible(false);
		Button add = new Button("Add");
		 add.setFont(Font.font("Garamond", FontWeight.BOLD, 15));
		 add.setTextFill(Color.WHITE);
	     add.setStyle("-fx-background-color: linear-gradient(#ff6666 , #ff9999)");
		Button delete = new Button("Delete");
		 delete.setFont(Font.font("Garamond", FontWeight.BOLD, 15));
	     delete.setTextFill(Color.WHITE);
	     delete.setStyle("-fx-background-color: linear-gradient(#c50000 , #a60000)");
		Button back = new Button("Back");
		 back.setFont(Font.font("Garamond", FontWeight.BOLD, 15));
	     back.setTextFill(Color.WHITE);
	     back.setStyle("-fx-background-color: linear-gradient(#99003d , #cc0052)");
		HBox hb = new HBox();
		hb.getChildren().addAll(add,delete,back,err);
		hb.setPadding(new Insets(10,10,10,10));
		hb.setSpacing(10);
		

		add.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				RegisterEmployerView sv = new RegisterEmployerView(currentUser);
				Scene sc = sv.showView(stage);
				stage.setScene(sc);
				
			}
			
		});
		
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				(new AdministratorView(currentUser)).showView(stage);
				
			}
			
		});
		
		delete.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(table.getSelectionModel().getSelectedItems().isEmpty()) {
					err.setVisible(true);
				}else {
					uc.delete(table.getSelectionModel().getSelectedItem());
					table.getItems().clear();
					table.getItems().addAll(FXCollections.observableArrayList(uc.getUsers()));
					System.out.println(users.size());
				}
				
			}
			
		});
		
		root.getChildren().addAll(table, hb);
		root.setStyle("-fx-background-color: #FFCCCC");
		Scene scene= new Scene(root, 450, 450);
		stage.setTitle("Employee List");
		scene.getStylesheets().add("/CSS/style.css");
		return scene;
	}
}
