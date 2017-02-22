package org.bild.ivana.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import org.bild.ivana.DTO.Contact;



public interface IContactDAO {
	
	public ArrayList<Contact> getContacts(String userName) throws SQLException;
	
	public Contact getContact(int contactID) throws SQLException;
	
	public boolean addContact(String name, String phone, String userName) throws SQLException;
	
	public boolean updateContact(String name, String password, int contactID) throws SQLException;
	
	public boolean deleteContact(int contactID) throws SQLException;
	
}
