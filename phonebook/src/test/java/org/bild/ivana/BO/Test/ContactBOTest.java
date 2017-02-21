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
	

	@Before
	public void setUp() {		
		contactBO = new ContactBO();
		mockContactDAO = Mockito.mock(ContactDAO.class);
		contactBO.setContactDAO(mockContactDAO);
		userName = "user";
	}
	
	@Test
	public void getContactsBOShouldReturnNullWhenUserNameIsEmpty() throws SQLException {
		
		ArrayList<Contact> result = contactBO.getContactsBO(userName);
		
		assertNull(result);		
	}
	
	@Test
	public void getContactsBOShouldReturnListNotNullWhenUserNameIsEmpty() throws SQLException {
		
		
	}
	

}
