package org.bild.ivana.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import org.bild.ivana.DTO.Contact;



public interface IContactBO {
	
	public ArrayList<Contact> getContacts(String userName) throws SQLException;
	
	public Contact getContact(int contactID) throws SQLException;
	
	public boolean addContact(String name, String number, String userName) throws SQLException;
	
	public boolean updateContact(String name, String password, int contactID) throws SQLException;
	
	public boolean deleteContact(int contactID) throws SQLException;
	
	public boolean printContact(Contact contact) throws SQLException;

}
