package org.bild.ivana.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import org.bild.ivana.DAO.ContactDAO;
import org.bild.ivana.DTO.Contact;



public class ContactBO implements IContactBO {
	
	ContactDAO contactDAO = null;
	Contact contact = null;
	ArrayList<Contact> contacts= null;

	@Override
	public ArrayList<Contact> getContacts(String userName) throws SQLException {
		if (userName == " ") {
			return null;
		}
		else {
			contacts = contactDAO.getContacts(userName);
			return contacts;
		}
	}

	@Override
	public Contact getContact(int contactID) throws SQLException {
		if (contactID == 0) {
			return null;
		}
		else {
			contact = contactDAO.getContact(contactID);
			return contact;
		}
	}

	@Override
	public boolean addContact(String name, String phone, String userName) throws SQLException {
		
		if (userName == null) {
			return false;
		}
		else {
			if (name == null || phone == null) {
				return false;
			}
			else {
				this.contact.setName(name);
				this.contact.setPhone(phone);
				this.contact.setUserName(userName);
				return contactDAO.addContact(contact);
			}
		}
		
	}

	@Override
	public boolean updateContact(String name, String phone, int contactID) throws SQLException {
		if (contactID == 0) {
			return false;
		}
		else {
			if (name == "" || phone == "") {
				return false;
			}		
			else {
				return contactDAO.updateContact(name, phone, contactID);
			}
		}
	}

	@Override
	public boolean deleteContact(int contactID) throws SQLException {
		
		if (contactID == 0) {
			return false;
		}
		else {
			return contactDAO.deleteContact(contactID);
		}
	}

	@Override
	public boolean printContact(Contact contact) throws SQLException {
		
		return false;
	}

}
