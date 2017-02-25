package org.bild.ivana.BO.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.bild.ivana.BO.UserBO;
import org.bild.ivana.DAO.UserDAO;
import org.bild.ivana.DTO.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;



public class UserBOTest {	
	UserBO userBO;
	UserDAO mockUserDAO;
	User empty;
	User valid;
	
	@Before
	public void setUp(){
		userBO = new UserBO();
		mockUserDAO = Mockito.mock(UserDAO.class);
		userBO.setUserDAO(mockUserDAO);
		empty = new User("","");
		valid = new User("name","password");
	}
	
	@Test
	public void getUserBOShouldReturnNullWhenNameIsEmpty() throws SQLException {
		
		User result = userBO.getUserBO(empty.getName(),empty.getPassword());
		
		assertNull(result);		
	}
	
	@Test
	public void getUserBOShouldReturnNullWhenPasswordIsEmpty() throws SQLException {
		
		User result = userBO.getUserBO(empty.getName(), empty.getPassword());
		
		assertNull(result);
	}
	
	@Test
	public void getUserBOShouldReturnNullWhenPasswordNotMatch() throws SQLException {
		
		Mockito.when(mockUserDAO.getUser(valid.getName())).thenReturn(valid);
		
		User result = userBO.getUserBO(valid.getName(), "sifra");
		
		assertNull(result);
		
		Mockito.verify(mockUserDAO).getUser(valid.getName());
	}
	
	@Test
	public void getUserBOShouldReturnNotNullWhenPasswordMatch() throws SQLException {
		
		Mockito.when(mockUserDAO.getUser(valid.getName())).thenReturn(valid);
		
		User result = userBO.getUserBO(valid.getName(),valid.getPassword());
		
		assertNotNull(result);
		
		Mockito.verify(mockUserDAO).getUser(valid.getName());
	}
	
	@Test
	public void addUserBOShouldReturnFalseWhenNameIsEmpty() throws SQLException {
		
		boolean result = userBO.addUserBO(empty.getName(), empty.getPassword());
		
		assertFalse(result);
	}
	
	@Test
	public void addUserBOShouldReturnFalseWhenPasswordIsEmpty() throws SQLException {
		
		boolean result = userBO.addUserBO(empty.getName(), empty.getPassword());
		
		assertFalse(result);
	}
	
	@Test
	public void addUserBOShouldReturnFalseWhenUserIsNotNull() throws SQLException {
		
		Mockito.when(mockUserDAO.getUser(valid.getName())).thenReturn(valid);
		
		boolean result = userBO.addUserBO(valid.getName(), valid.getPassword());
		
		assertFalse(result);
		
		Mockito.verify(mockUserDAO).getUser(valid.getName());
	}
	
	@Test
	public void addUserBOShouldReturnTrueWhenDAOaddMethodIsCalled() throws SQLException {
		
		Mockito.when(mockUserDAO.addUser(valid.getName(), valid.getPassword())).thenReturn(true);
		
		boolean result = userBO.addUserBO(valid.getName(), valid.getPassword());
		
		assertTrue(result);
		
		Mockito.verify(mockUserDAO).addUser(valid.getName(), valid.getPassword());
	}
	
	@Test
	public void updateUserBOShouldReturnFalseWhenUserIsNull() throws SQLException {
		
		boolean result = userBO.updateUserBO(null,valid.getPassword());
		
		assertFalse(result);
	}
	
	@Test
	public void updateUserBOShouldReturnNullWhenPasswordIsEmpty() throws SQLException {
		
		boolean result = userBO.updateUserBO(valid,empty.getPassword());
		
		assertFalse(result);
	}
	
	@Test
	public void updateUserBOShouldReturnTrueWhenDAOupdateMetodIsCalled() throws SQLException {
		Mockito.when(mockUserDAO.updateUser(valid, valid.getPassword())).thenReturn(true);
		
		boolean result = userBO.updateUserBO(valid, valid.getPassword());
		
		assertTrue(result);
		
		Mockito.verify(mockUserDAO).updateUser(valid, valid.getPassword());
	}
	
}
