package view;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Book;
import Controller.BookController;
import model.User;

public class viewStockM {
	User currentUser;

	public viewStockM(User currentUser) {
		super();
		this.currentUser = currentUser;
	}

	public Scene showView(Stage st) {
		BorderPane mainPane = new BorderPane();
		mainPane.setPadding(new Insets(40, 100 , 40, 100));
		
		BookController bc=new BookController();
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        
        BarChart<String,Number> chart =  new BarChart<String,Number>(xAxis,yAxis);
        chart.setTitle("Low Stock Books");     
        chart.setLegendVisible(false);
        chart.setStyle("-fx-background-color: LAVENDER");
 
        XYChart.Series y = new XYChart.Series();
       
        
        for(Book pro: bc.getBooks()) {
        	if(pro.getStock()<=5) {
        	y.getData().add(new XYChart.Data(pro.getTitleOfBook(),pro.getStock()));
        	}
        }
  
  
        HBox hb= new HBox();
        hb.setAlignment(Pos.BOTTOM_CENTER);
        Button back= new Button("Back");
        back.setFont(Font.font("Garamond", FontWeight.BOLD, 15));
	    back.setTextFill(Color.WHITE);
	    back.setStyle("-fx-background-color: linear-gradient(#FFE5CC , #FF9999)");
        hb.getChildren().add(back);
        hb.setMargin(back, new Insets(10,10,10,10));
        
        back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				    (new ManagerView(currentUser)).showView(st);		
			}
        	
        });  
        
        
        mainPane.setCenter(chart);
        mainPane.setBottom(hb);
        mainPane.setStyle("-fx-background-color: LAVENDERBLUSH");
        Scene sc  = new Scene(mainPane,500,400);
        chart.getData().addAll(y);
        st.setScene(sc);
        st.setTitle("Low Stocks");
        st.show();
		return sc;
		
	}

}
