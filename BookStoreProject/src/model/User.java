package model;

import java.io.Serializable;

public class User  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4930332055934462280L;
	private String firstName, lastName, password, phone, username, profession;
	private String salary;
	private String birthday;
	private static int nrOfUsers=0;
	private final int ID;
	public User(String firstName, String lastName, String username, String password, String phone, String profession, String salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.phone=phone;
		this.salary=salary;
		this.profession = profession;
	    this.ID = nrOfUsers++;
	    }
	public User(String firstName, String lastName, String username,String phone,String profession,String salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.phone=phone;
		this.profession=profession;
		this.salary=salary;
	    this.ID = nrOfUsers++;
	    }
	    
	    public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getProfession() {
			return profession;
		}

		public void setProfession(String profession) {
			this.profession = profession;
		}


		public String getSalary() {
			return salary;
		}

		public void setSalary(String salary) {
			this.salary = salary;
		}

		public String getBirthday() {
			return birthday;
		}

		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}

		public static int getNrOfUsers() {
			return nrOfUsers;
		}

		public static void setNrOfUsers(int nrOfUsers) {
			User.nrOfUsers = nrOfUsers;
		}

		public int getId() {
			return ID;
		}

		@Override
		public String toString() {
			return "User [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", phone=" + phone
					+ ", username=" + username + ", profession=" + profession + ", salary=" + salary + ", birthday="
					+ birthday + ", id=" + ID + "]";
		}

	


}
