package model;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SoldBooks  implements Serializable{
	private String titleOfBook;
	private String ISBN;
    private int quantity;
    private double price;
    private TheDate Date;
    
    public SoldBooks(String ISBN,String titleOfBook, int quantity, double price) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		TheDate Date = new TheDate(sdf.format(new Date()));
		this.ISBN = ISBN;
		this.titleOfBook=titleOfBook;
		this.quantity = quantity;
		this.price = price;
		this.Date = Date;
	}
    public String getTitleOfBook() {
		return titleOfBook;
	}



	public void setName(String titleOfBook) {
		this.titleOfBook = titleOfBook;
	}



	public String getISBN() {
		return ISBN;
	}



	public void setBarcode(String ISBN) {
		this.ISBN = ISBN;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public TheDate getDate() {
		return Date;
	}



	public void setDate(TheDate date) {
		Date = date;
	}



	@Override
	public String toString() {
		return "SoldBooks [ISBN=" + ISBN + ", titleOfBook=" + titleOfBook + ", quantity=" + quantity + ", sellprice="
				+ price + ", sellDate=" + Date + "]";
	}

	
	

}
