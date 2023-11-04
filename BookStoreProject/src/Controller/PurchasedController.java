package Controller;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Controller.LibrarianController;
import model.TheDate;
import model.PurchasedBook;
import model.SoldBooks;

public class PurchasedController {
    
	private static final String soldfile="sold.bin";
	private static final String purchasedfile = "purchase.bin";
	private File soldfilename;
	private File purchasefilename;
	ArrayList<SoldBooks> soldTable;
    ArrayList<PurchasedBook> purchasedTable;
	
    public PurchasedController() {
		soldTable=new ArrayList<>();
		purchasedTable=new ArrayList<>();
		soldfilename=new File(soldfile);
		purchasefilename= new File(purchasedfile);
		if(soldfilename.exists()) {
			readSoldBooks();
		} else {
			writeSoldBooks();
		}
		if(purchasefilename.exists()) {
			readPurchasedBooks();
		} else {
			writePurchasedBooks();
		}
	}
   
    public ArrayList<SoldBooks> getSoldTable() {
		return soldTable;
	}

	public ArrayList<PurchasedBook> getPurchasedTable() {
		return purchasedTable;
	}
	
	private void writeSoldBooks() {
		try {
			FileOutputStream fos=new FileOutputStream(soldfilename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(soldTable);
			oos.close();
			fos.close();
		} catch (Exception e) {
			System.err.println("Be careful!");
		}
	}
	
	private void readSoldBooks() {
		try {
			FileInputStream fis=new FileInputStream(soldfilename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			soldTable=(ArrayList<SoldBooks>)ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.err.println("Be Careful!");
		}
	}
	
	private void writePurchasedBooks() {
		try {
			FileOutputStream fos=new FileOutputStream(purchasefilename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(purchasedTable);
			oos.close();fos.close();
		} catch (Exception e) {
			System.err.println("Be careful!");
		} 
		}
	
	private void readPurchasedBooks() {
		try {
			FileInputStream fis=new FileInputStream(purchasefilename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			purchasedTable=(ArrayList<PurchasedBook>)ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.err.println("Be careful!");
		}
	}
	
	public void addBook(int position, String ISBN, int quantity) {	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		TheDate purchasedDate = new TheDate(sdf.format(new Date()));
		purchasedTable.add(new PurchasedBook(ISBN, quantity, purchasedDate));
		BookController pc = new BookController();
		pc.addQuantity(position,quantity);
		writePurchasedBooks();
	}

}
