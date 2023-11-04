package view;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Book;
import Controller.BookController;
import Controller.PurchasedController;
import model.User;

public class QuantityM {
	User currentUser;
	BookController pc = new BookController();;
    Book currentBook;
    
    ObservableList<Book> book = FXCollections.observableArrayList(pc.getBooks());
    
	public QuantityM(User currentUser) {
		this.currentUser = currentUser;
	}
	
	public Scene showView(Stage st) {
		
		BorderPane mainPane = new BorderPane();
		mainPane.setOpaqueInsets(new Insets(10,10,10,10));
		
		TextField bc = new TextField();
		bc.setPromptText("ISBN");
	
		TextField qt = new TextField();
		qt.setPromptText("Quantity");
		
		TableView table = new TableView();
		
		TableColumn ISBN=new TableColumn("ISBN");
		ISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
		ISBN.setMinWidth(150);
		
		TableColumn name = new TableColumn("Book");
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		name.setMinWidth(150);
		
		TableColumn category=new TableColumn("Category");
	    category.setCellValueFactory(new PropertyValueFactory<>("category"));
	    category.setMinWidth(150);
		
		TableColumn supplier=new TableColumn("Supplier");
		supplier.setCellValueFactory(new PropertyValueFactory<>("supplier"));
		supplier.setMinWidth(150);
		
		TableColumn stock = new TableColumn("Stock");
		stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
		
		table.setItems(book);
		table.getColumns().addAll(ISBN,name,category,supplier,stock);
		stock.setMinWidth(150);
		

	    table.setRowFactory(tv -> {
            TableRow<Book> currRow = new TableRow<>();
            currRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (! currRow.isEmpty()) ) {
                    currentBook = currRow.getItem();
                    bc.setText(currentBook.getISBN());
                }
            });
            return currRow;
        });

	    
		HBox hb1 = new HBox();	
		hb1.setSpacing(10);
		hb1.setPadding(new Insets(20,20,20,20));
		hb1.setAlignment(Pos.CENTER);
		
		Button add = new Button("Add");
		add.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		add.setTextFill(Color.WHITE);
	    add.setStyle("-fx-background-color: LAVANDER");
	    
       
	    add.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				boolean isValidISBN = false;

			
				if(bc.getText().isEmpty()) {
					new Alert(AlertType.WARNING,"Please select a book from table!",ButtonType.OK).show();
				}else {
					isValidISBN=true;
				}
				boolean isValidquantity=false;
				try {
					
					if(Integer.parseInt(qt.getText()) <=0){
						qt.clear();
						qt.setPromptText("Enter a valid quantity");
				        qt.setStyle("-fx-prompt-text-fill: red");
					}else {
					    isValidquantity=true;
					}
				}catch(NumberFormatException e){
					qt.clear();
					qt.setPromptText("Enter a valid quantity");
			        qt.setStyle("-fx-prompt-text-fill: red");
				}
				
				if(isValidISBN && isValidquantity) {
					
					int pos=pc.getPosition(currentBook);
					PurchasedController rwsp = new PurchasedController();
					rwsp.addBook(pos,bc.getText(), Integer.parseInt(qt.getText()));
					(new QuantityM(currentUser)).showView(st);
				}
				
			}
		});
	    
		Button back = new Button("Back");
		back.setFont(Font.font("Arial", FontWeight.BOLD, 15));
	    back.setTextFill(Color.WHITE);
	    back.setStyle("-fx-background-color: linear-gradient(#ff6666 , #ff9999)");
		
	    back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				(new ManagerView(currentUser)).showView(st);
				
			}
		});
	    
		hb1.getChildren().addAll(bc,qt,add,back);
		
		VBox vb1 = new VBox();
		vb1.setAlignment(Pos.CENTER);
		vb1.setPadding(new Insets(10, 10, 10, 30));
		vb1.getChildren().addAll(table);
		
		mainPane.setTop(hb1);
	    mainPane.setCenter(vb1);
	    mainPane.setStyle("-fx-background-color: #FFCCCC");
	    Scene sc = new Scene(mainPane,790,500);
	    st.setScene(sc);
	    st.setTitle("Quantity");
	    st.setResizable(false);
	    st.setMaxWidth(900);
	    st.setMaxHeight(600);
	    sc.getStylesheets().add("/CSS/style.css");
		return sc;
}
}
