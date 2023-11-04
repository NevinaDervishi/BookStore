package Controller;

import java.io.*;
import java.util.ArrayList;


import model.Book;


public class BookController {
	
	private ArrayList<Book> books;
	private static final String file="product.bin";
	private File filename;
	
	public BookController() {
		books=new ArrayList<>();
		filename=new File(file);
		if(filename.exists()) {
			readBooks();
		} else {
			writeBooks();
		}
	}
	
	public ArrayList<Book> getBooks() {
		return books;
	}

	public void addBooks(Book product) {
		books.add(product);
		writeBooks();
	}
	
	private void writeBooks() {
		try {
			FileOutputStream fos=new FileOutputStream(filename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(books);
			oos.close();fos.close();
		} catch (Exception e) {
			System.err.println("Be Careful!");
		}
	}
	
	private void readBooks() {
		try {
			FileInputStream fis=new FileInputStream(filename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			books=((ArrayList<Book>)ois.readObject());
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.err.println("Be Careful!");
		} 
	}
	
	public boolean useISBN(String ISBN) {
		for(Book  b: books) {
			if((b.getISBN()).equals(ISBN)) {
				return true;
			}
		}			
		return false;
	}
	

	public int getPosition(Book book) {
		
		for(int i=0; i<books.size(); i++)	{
			if(books.get(i).getISBN()==book.getISBN())
				return i;	}	
		return -1;
	}
	
	
	
	public void deleteBook(Book book) {
	   books.remove(book);
		writeBooks();
	}
	
	
	
	
	public void addQuantity(int pos, int quantity) {
	books.get(pos).setStock(books.get(pos).getStock()+quantity);
		writeBooks();
	}


}





