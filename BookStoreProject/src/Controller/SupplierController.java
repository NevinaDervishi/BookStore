package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Supplier;


public class SupplierController {
	private static final String file = "supplier.bin";
	private File filename;
	private ArrayList<Supplier> suppliers;
	
	public SupplierController() {
		suppliers=new ArrayList<>();
		filename=new File(file);
		if(filename.exists()) {
			readSuppliers();
		} else {
			writeSuppliers();
		}
	}

	private void writeSuppliers() {
		try {
			FileOutputStream fos=new FileOutputStream(filename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(suppliers);
			oos.close();fos.close();
		} catch (Exception e) {
			System.err.println("Be Careful");
		}
	}
	
	private void readSuppliers() {
		try {
			FileInputStream fis=new FileInputStream(filename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			suppliers=(ArrayList<Supplier>)ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.err.println("File not found!!!");
		}
	}
	
	public ArrayList<Supplier> getSuppliers() {
		return suppliers;
	}


	public void addSupplier(Supplier supplier) {
		suppliers.add(supplier);
		writeSuppliers();
	}

	
	public boolean RegisterSupplier(String s) { 
		for(Supplier s1: suppliers) {
			if(s1.getnameOfSupplier().equals(s))
				return true;
		}
		return false;
	}
	
	public int getPosition(Supplier supplier) {
		
		for(int i=0; i<suppliers.size(); i++)
		{
			if(suppliers.get(i).getnameOfSupplier().equals(supplier.getnameOfSupplier()))
				return i;
		}	
		return -1;
	}	
	
	public void deleteSupplier(int position) {
		suppliers.remove(position); 
		writeSuppliers();
	
	}
}