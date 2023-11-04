package model;

import java.io.Serializable;

public class PurchasedBook implements Serializable{
	private String ISBN; 
    private int quantity;
    private TheDate boughtDate;
    private TheDate expiryDate;
	public PurchasedBook(String ISBN, int quantity, TheDate boughtDate) {
		super();
		this.ISBN = ISBN;
		this.quantity = quantity;
		this.boughtDate = boughtDate;
		
	}

	public String getISBN() {
		return ISBN;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public TheDate getBoughtDate() {
		return boughtDate;
	}
	public TheDate getExpiryDate() {
		return expiryDate;
	}	
	@Override
	public String toString() {
		return "PurchasedBook [ISBN=" + ISBN + ", quantity=" + quantity 
				+ ", purchasedDate=" + boughtDate + ", expiryDate=" + expiryDate + "]";
	}
    
}
