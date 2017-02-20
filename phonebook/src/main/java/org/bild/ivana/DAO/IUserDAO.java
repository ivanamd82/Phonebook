package org.bild.ivana.DAO;

import java.sql.SQLException;

import org.bild.ivana.DTO.User;



public interface IUserDAO {
	
	public User getUser(String name) throws SQLException; 
	
	public boolean addUser(User user) throws SQLException;
	
	public boolean updateUser(User user, String password) throws SQLException;	

}
