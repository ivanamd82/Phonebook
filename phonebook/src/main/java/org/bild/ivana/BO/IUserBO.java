package org.bild.ivana.BO;

import java.sql.SQLException;

import org.bild.ivana.DTO.User;



public interface IUserBO {
	
	public User getUserBO(String name, String password) throws SQLException;

	public boolean addUserBO(String name, String password) throws SQLException;

	public boolean updateUserBO(User user, String password) throws SQLException;

}
