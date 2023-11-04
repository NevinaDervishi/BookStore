package Controller;


	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.util.ArrayList;

	import model.Category;

	public class CategoryController {
		private ArrayList<Category> categories;
		private static final String file="category.bin";
		private File filename;
		
		public CategoryController() {
			categories=new ArrayList<>();
			filename=new File(file);
			if(filename.exists()) {
				readCategory();
			} else {
				writeCategory();
			}
		}

		private void writeCategory() {
			try {
				FileOutputStream fos=new FileOutputStream(filename);
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				oos.writeObject(categories);
				oos.close();fos.close();
			} catch (FileNotFoundException e) {
				System.err.println("File cannot be written!!!");
			} catch (IOException e) {
				System.err.println("Problem with writing object");
			}
		}
		
		private void readCategory() {
			try {
				FileInputStream fis=new FileInputStream(filename);
				ObjectInputStream ois=new ObjectInputStream(fis);
				categories=(ArrayList<Category>)ois.readObject();
				ois.close();
				fis.close();
			} catch (Exception e) {
				System.err.println("Be careful!");
			}
		}

		public ArrayList<Category> getCategories() {
			return categories;
		}
	    
		public void addCategory(Category c) {
			categories.add(c);
			writeCategory();
		}
		
		
	}


