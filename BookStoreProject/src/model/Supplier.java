package model;

import java.io.Serializable;

public class Supplier implements Serializable {
	
	private String nameOfSupplier;
    private String emailOfSupplier;
    private String phoneOfSupplier;
    
    public Supplier(String nameOfSupplier, String emailOfSupplier, String phoneOfSupplier) {
		super();
		this.nameOfSupplier = nameOfSupplier;
		this.emailOfSupplier = emailOfSupplier;
		this.phoneOfSupplier = phoneOfSupplier;
	}

	public String getnameOfSupplier() {
		return nameOfSupplier;
	}


	public String getEmail() {
		return emailOfSupplier;
	}

	public void setEmail(String emailOfSupplier) {
		this.emailOfSupplier = emailOfSupplier;
	}

	public String getPhone() {
		return phoneOfSupplier;
	}

	public void setPhone(String phoneOfSupplier) {
		this.phoneOfSupplier = phoneOfSupplier;
	}
     

}
