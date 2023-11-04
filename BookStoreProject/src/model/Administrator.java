package model;

public class Administrator extends User {
private String accessLevel;
	
	public Administrator(String firstName, String lastName, String username, String password ,
			String phone, String profession, String salary) {
		super(firstName, lastName, username, password ,phone , profession,salary);
	}

	public String getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	@Override
	public String toString() {
		return "Administrator [accessLevel=" + accessLevel + "]";
	}

}
