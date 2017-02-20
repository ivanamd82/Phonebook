package org.bild.ivana.BO;

import java.sql.SQLException;

import org.bild.ivana.DAO.UserDAO;
import org.bild.ivana.DTO.User;


public class UserBO implements IUserBO {
	
	UserDAO userDAO = null;
	User user = null;
	
	//login
	@Override
	public User getUserBO(String name, String password) throws SQLException {
		
		if (name == "" || password == "") {
			return null;
		}
		else {
			user = userDAO.getUser(name);
		
			if(user.getPassword() != password) {
				return null;
			}
			else {		
				return user;
			}
		}
	}
	//registracija
	@Override
	public boolean addUserBO(String name, String password) throws SQLException {
		
		if (name == "" || password == "") {
			return false;
		}
		else {
			user = userDAO.getUser(name);
			if (user != null) {
				return false;
			}
			else {
				this.user.setName(name);
				this.user.setPassword(password);
				return userDAO.addUser(user);
			}
		}		
	}
	//promjena lozinke
	@Override
	public boolean updateUserBO(User user, String password) throws SQLException {
		
		if (user == null) {
			return false;
		} else {
			if (password == "") {	
				return false;
			}
			else {
				user.setPassword(password);
				return userDAO.updateUser(user, password);
			}
		}
	}

}
