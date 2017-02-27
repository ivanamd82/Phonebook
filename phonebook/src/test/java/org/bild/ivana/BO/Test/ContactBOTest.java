package org.bild.ivana.BO.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

import org.bild.ivana.BO.ContactBO;
import org.bild.ivana.DAO.ContactDAO;
import org.bild.ivana.DTO.Contact;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ContactBOTest {
	
	ContactBO contactBO;
	ContactDAO mockContactDAO;
	String userName;
	String emptyName;
	Contact contact;
	int zero;
	

	@Before
	public void setUp() {		
		contactBO = new ContactBO();
		mockContactDAO = Mockito.mock(ContactDAO.class);
		contactBO.setContactDAO(mockContactDAO);
		
		zero = 0;
		emptyName = "";
		contact = new Contact(1,"ime","broj",userName);
	}
	
	@Test
	public void getContactsBOShouldReturnNullWhenUserNameIsEmpty() throws SQLException {
		
		ArrayList<Contact> result = contactBO.getContactsBO(emptyName);
		
		assertNull(result);
	}
	
	@Test
	public void getContactsBOShouldReturnListWhenContactGetContactsIsCalled() throws SQLException {
		
		ArrayList<Contact> list = new ArrayList<>();
		list.add(contact);
		
		Mockito.when(mockContactDAO.getContacts(userName)).thenReturn(list);
		ArrayList<Contact> result = contactBO.getContactsBO(userName);
		assertSame(list.get(0),result.get(0));
		
		Mockito.verify(mockContactDAO).getContacts(userName);
	}
	
	@Test
	public void getContactBOShouldReturnNullWhenIDIsZero() throws SQLException {
		
		Contact result = contactBO.getContactBO(zero);
		
		assertNull(result);		
	}
	
	@Test
	public void getContactBOShouldReturnNotNullWhenContactGetMetodIsCalled() throws SQLException {
		
		Mockito.when(mockContactDAO.getContact(contact.getContactID())).thenReturn(contact);
		
		Contact result = contactBO.getContactBO(contact.getContactID());
		
		assertSame(contact, result);
		
		Mockito.verify(mockContactDAO).getContact(contact.getContactID());
	}
	
	@Test
	public void addContactBOShouldReturnFalseWhenUserNameIsEmpty() throws SQLException {
		
		boolean result = contactBO.addContactBO(contact.getName(),contact.getPhone(),emptyName);
		
		assertFalse(result);			
	}
	
	@Test
	public void addContactBOShouldReturnFalseWhenContactNameIsEmpty() throws SQLException {
		
		boolean result = contactBO.addContactBO(emptyName,contact.getPhone(),contact.getUserName());
		
		assertFalse(result);			
	}
	
	@Test
	public void addContactBOShouldReturnFalseWhenContactNumberIsEmpty() throws SQLException {
		
		boolean result = contactBO.addContactBO(contact.getName(),emptyName,contact.getUserName());
		
		assertFalse(result);			
	}
	
	@Test
	public void addContactBOShouldReturnTrueWhenContactAddMetodIsCalled() throws SQLException {
		
		Mockito.when(mockContactDAO.addContact(contact.getName(),contact.getPhone(),contact.getUserName())).thenReturn(true);
		
		boolean result = contactBO.addContactBO(contact.getName(),contact.getPhone(),contact.getUserName());
		
		assertTrue(result);
		
		Mockito.verify(mockContactDAO).addContact(contact.getName(),contact.getPhone(),contact.getUserName());
	}
	
	@Test
	public void updateContactBOShouldReturnFalseWhenIDIsZero() throws SQLException {
		
		boolean result = contactBO.updateContactBO(contact.getName(),contact.getPhone(),zero);
		
		assertFalse(result);		
	}
	
	@Test
	public void updateContactBOShouldReturnFalseWhenContactNameIsEmpty() throws SQLException {
		
		boolean result = contactBO.updateContactBO(emptyName,contact.getPhone(),contact.getContactID());
		
		assertFalse(result);			
	}
	
	@Test
	public void updateContactBOShouldReturnFalseWhenContactNumberIsEmpty() throws SQLException {
		
		boolean result = contactBO.updateContactBO(contact.getName(),emptyName,contact.getContactID());
		
		assertFalse(result);			
	}
	
	@Test
	public void updateContactBOShouldReturnTrueWhenContactUpdateMetodIsCalled() throws SQLException {
		
		Mockito.when(mockContactDAO.updateContact(contact.getName(),contact.getPhone(), contact.getContactID())).thenReturn(true);
		
		boolean result = contactBO.updateContactBO(contact.getName(),contact.getPhone(),contact.getContactID());
		
		assertTrue(result);
		
		Mockito.verify(mockContactDAO).updateContact(contact.getName(),contact.getPhone(),contact.getContactID());
	}
	
	@Test
	public void deleteContactBOShouldReturnFalseWhenIDIsZero() throws SQLException {
		
		boolean result = contactBO.deleteContactBO(zero);
		
		assertFalse(result);		
	}
	
	@Test
	public void deleteContactBOShouldReturnTrueWhenContactDeleteMetodIsCalled() throws SQLException {
		
		Mockito.when(mockContactDAO.deleteContact(contact.getContactID())).thenReturn(true);
		
		boolean result = contactBO.deleteContactBO(contact.getContactID());
		
		assertTrue(result);
		
		Mockito.verify(mockContactDAO).deleteContact(contact.getContactID());
	}	

}
