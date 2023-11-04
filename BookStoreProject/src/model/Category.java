package model;

import java.io.Serializable;

public class Category implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2564026012494993767L;
	String category;

	public Category(String category) {
		super();
		this.category = category;
		
	}

	@Override
	public String toString() {
		return category;
	}
}