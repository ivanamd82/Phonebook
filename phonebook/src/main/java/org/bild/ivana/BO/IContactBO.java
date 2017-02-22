package org.bild.ivana.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import org.bild.ivana.DTO.Contact;



public interface IContactBO {
	
	public ArrayList<Contact> getContactsBO(String userName) throws SQLException;
	
	public Contact getContactBO(int contactID) throws SQLException;
	
	public boolean addContactBO(String name, String number, String userName) throws SQLException;
	
	public boolean updateContactBO(String name, String password, int contactID) throws SQLException;
	
	public boolean deleteContactBO(int contactID) throws SQLException;
	
}
