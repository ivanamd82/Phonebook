package org.bild.ivana.BO;

import java.sql.SQLException;

import org.bild.ivana.DAO.UserDAO;
import org.bild.ivana.DTO.User;


public class UserBO implements IUserBO {
	
	UserDAO userDAO = new UserDAO();
	User user = null;
	
	//login
	@Override
	public User getUserBO(String name, String password) throws SQLException {
		
		if (name == "" || password == "") {
			return null;
		}
		else {
			user = userDAO.getUser(name);
		
			if(!user.getPassword().equals(password)) {
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
			User user = userDAO.getUser(name);
			if (user != null) {
				return false;
			}
			else {
				return userDAO.addUser(name, password);
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
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
