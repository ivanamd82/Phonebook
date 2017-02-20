package org.bild.ivana.DTO;

public class Contact {
	
	private int contactID;
	private String name;
	private String phone;
	private String userName;
	
	public Contact(int contactID, String name, String phone, String userName){
		this.contactID = contactID;
		this.name = name;
		this.phone = phone;
		this.userName = userName;		
	}

	public int getContactID() {
		return contactID;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
