package org.bild.ivana.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import org.bild.ivana.DAO.ContactDAO;
import org.bild.ivana.DTO.Contact;

public class ContactBO implements IContactBO {
	
	ContactDAO contactDAO = new ContactDAO();
	Contact contact = null;
	ArrayList<Contact> contacts = new ArrayList<>();

	@Override
	public ArrayList<Contact> getContactsBO(String userName) throws SQLException {
		
		if (userName == "") {
			return null;
		}
		else {
			contacts = contactDAO.getContacts(userName);
			return contacts;
		}
	}

	@Override
	public Contact getContactBO(int contactID) throws SQLException {
		if (contactID == 0) {
			return null;
		}
		else {
			contact = contactDAO.getContact(contactID);
			return contact;
		}
	}

	@Override
	public boolean addContactBO(String name, String phone, String userName) throws SQLException {
		
		if (userName == "") {
			return false;
		}
		else {
			if (name == "" || phone == "") {
				return false;
			}
			else {
				return contactDAO.addContact(name, phone, userName);
			}
		}
		
	}

	@Override
	public boolean updateContactBO(String name, String phone, int contactID) throws SQLException {
		
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
	public boolean deleteContactBO(int contactID) throws SQLException {
		
		if (contactID == 0) {
			return false;
		}
		else {
			return contactDAO.deleteContact(contactID);
		}
	}

	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}

}
