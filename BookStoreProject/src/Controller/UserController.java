package Controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.scene.control.TableView;
import model.Librarian;
import model.Manager;
import model.User;

public class UserController {
	private ArrayList<User> users;
	private File file;
	public UserController(){
		users= new ArrayList<>();
		file= new File("users.bin");
		if(file.exists()){
			readUsers();
		}
		else {
			writeUsers();
		}
	}
	private void readUsers() {
		try{
			FileInputStream fis= new FileInputStream(file);
			ObjectInputStream ois= new ObjectInputStream(fis);
			users=(ArrayList<User>)ois.readObject();
			fis.close();
			ois.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	private void writeUsers(){
		try{
			FileOutputStream fos= new FileOutputStream(file);
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			oos.writeObject(users);
			oos.close();
			fos.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void addUser(User u){
		this.users.add(u);
		writeUsers();
	}
	public void delete(User u) {
		this.users.remove(positionOfUser(u));
		writeUsers();
	}
	public boolean signUpUser(String firstName, String lastName, String username, String phone,String profession,String salary){
		
			User u = new User(firstName, lastName, username, phone,profession,salary);
			this.addUser(u);
			writeUsers();
			return true;
	}
	/*public boolean signUp(String firstName, String lastName, String username,
			String phone, String profession, String salary){
	
			User u = new User(firstName, lastName, username, phone,profession ,salary);
			this.addUser(u);
			writeUsers();
			return true;
	
	}*/
	public User login(String username, String password){
		System.out.println("Users:"+ this.users);
		for(User user: users){
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}
	
	public ArrayList<User> getUsers(){
		return this.users;
	}
	
	public void editUser(User updatedUser, int index){
		this.users.set(index, updatedUser);
		writeUsers();
	}
	
	public int positionOfUser(User currentUser) {
		for(int i=0 ; i<this.users.size(); i++) {
			if(currentUser.getUsername().equals(this.users.get(i).getUsername())){
				return i;
			}
		}
		return -1;
	}

}
