package model;

import java.io.Serializable;

public class Book implements Serializable{
	private String ISBN;
	private String titleOfBook;
	private String category;
	private String supplier;

	private int stock;	
	
	public Book(String barcode, String titleOfBook,  int stock) {
		this.stock = stock;
		this.ISBN = barcode;
		this.titleOfBook = titleOfBook;
	}

	public Book(String ISBN, String titleOfBook, String category, String supplier) {
		stock=0;
		this.ISBN = ISBN;
		this.titleOfBook = titleOfBook;
		this.category = category;
		this.supplier = supplier;
		
	}


	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	public String getISBN() {
		return ISBN;
	}
	
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public String getTitleOfBook() {
		return titleOfBook;
	}
	public void  setTitleOfBookame(String titleOfBook) {
		this.titleOfBook = titleOfBook;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", titleOfBook=" + titleOfBook + ", category=" + category + ", supplier=" + supplier
				+ ", stock=" + stock + "]";
	}





}
