package model;

public class ProfitFromBooks implements Calculations{

	private String titleOfBook;
	private int quantity;
	private double price;
	
	public ProfitFromBooks(String titleOfBook, int quantity, double price) {
		super();
		this.titleOfBook = titleOfBook;
		this.quantity = quantity;
		this.price = price;
	}

	public String setTitleOfBook() {
		return titleOfBook;
	}

	public void setTitleOfBook(String name) {
		this.titleOfBook = name;
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

	@Override
	public String toString() {
		return "ProfitFromBooks [titleOfBook=" + titleOfBook + ", quantity=" + quantity + ", price=" + price + "]";
	}


	public double calculateTotalIncome(int quantity, double price) {
		double income = quantity*price;
		return income;
	}

	
	
	
	
}
