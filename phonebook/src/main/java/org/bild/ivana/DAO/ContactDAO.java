package org.bild.ivana.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.bild.ivana.DTO.Contact;



public class ContactDAO implements IContactDAO {
	
	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public ArrayList<Contact> getContacts(String userName) throws SQLException {
		
		ArrayList<Contact> contacts = new ArrayList<>();
		String query = "SELECT * from imenik.contact WHERE contact.userName = ?";
		ResultSet rs = null;
		
		try (PreparedStatement ps = connection.prepareStatement(query)){
			
			ps.setString(1, userName);
			rs = ps.executeQuery(query);
			
			while(rs.next()) {
				contacts.add(new Contact(rs.getInt("contactID"),rs.getString("name"),rs.getString("phone"),rs.getString("userName")));
			}
			rs.close();
		} 
		return contacts;
	}
	
	public Contact getContact(int contactID) throws SQLException {
		
		Contact contact = null;
		
		String query = "SELECT * FROM imenik.contact WHERE imenik.contactID = ?";
		
		ResultSet rs = null;
		
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, contactID);
						
			rs = ps.executeQuery(query);
			
			if(rs.next()) {
				contact = new Contact(rs.getInt("contactID"),rs.getString("name"),rs.getString("phone"),rs.getString("userName"));
			}
			rs.close();
		}
		return contact;
	}

	@Override
	public boolean addContact(String name, String phone, String userName) throws SQLException {
		
		String query = "INSERT INTO imenik.contact (name,phone,userName) VALUES (?, ?, ?)";
		
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, userName);
			
			ps.executeUpdate();
//			System.out.println("Kontakt dodat.");
			
			return true;
		}
	}

	@Override
	public boolean updateContact(String name, String phone, int contactID) throws SQLException {
		
		String query = "UPDATE imenik.contact SET name = ?, phone = ? WHERE conctactID = ?";
		
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setInt(3, contactID);
			
			ps.executeUpdate();
//			System.out.println("Kontakt izmijenjen.");
			
			return true;
		}
	}

	@Override
	public boolean deleteContact(int contactID) throws SQLException {
		
		String query = "DELETE * FROM imenik.contact WHERE contactID = ?";
		
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, contactID);
			ps.executeUpdate();
			
//			System.out.println("Kontakt izbrisan");
			
			return true;
		}
	}

	@Override
	public boolean printContact(Contact contact) throws SQLException {
		
		return true;
	}
	

}
