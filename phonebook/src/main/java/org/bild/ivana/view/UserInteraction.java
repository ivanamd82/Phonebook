package org.bild.ivana.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.bild.ivana.BO.ContactBO;
import org.bild.ivana.BO.UserBO;
import org.bild.ivana.DTO.Contact;
import org.bild.ivana.DTO.User;

public class UserInteraction {
	
	static Scanner input = new Scanner(System.in);
	
	User user;
	UserBO userBO = new UserBO();
	ContactBO contactBO = new ContactBO();
	ArrayList<Contact> contacts = null;
	Contact contact = null;
	
	
	public  User userInfoInput() {
			
		System.out.println("Unesite korisnicko ime: ");
		String userName = input.next();
		System.out.print("Unesite sifru: ");
		String userPassword = input.next();
		
		User user = new User(userName, userPassword);
		
		return user;
	}
	
	public String newPassword() {
		
		String newPassword;
		
		System.out.print("Unesite novu sifru: ");
		newPassword = input.next();
		
		return newPassword;
	}
		
	public User loginMainMenu() throws SQLException {
		
		User user = userInfoInput();
		
		try {			
			user = userBO.getUserBO(user.getName(),user.getPassword());
			if(user == null) {
				System.out.println("Pogresno korisnicko ime ili sifra!");
				return null;
			}
			else {
				System.out.println("Uspjesno ste ulogovali.");
				contacts = loadContacts(user);
				return user;
			}
		} catch (NullPointerException e) {
			System.out.println("baza prazna");
			return null;
		}
	}
	
	public void registracijaMainMenu() throws SQLException {
		
		User user = userInfoInput();
		
		if (userBO.addUserBO(user.getName(),user.getPassword())) {
			System.out.println("Uspjesno ste se registrovali.");
		}
		else {
			System.out.println("Pogresno korisnicko ime/ime je vec zauzeto");
		}				
	}

	public ArrayList<Contact> loadContacts(User user) throws SQLException {
		
		try {
			ArrayList<Contact>contacts = contactBO.getContactsBO(user.getName());
			return contacts;
		} catch (NullPointerException e) {
			System.out.println("Nema kontakata u imeniku\n");
			return null;
		}
	}

	public void printAllContacts(User user) throws SQLException {
		
		if(contacts.isEmpty()) {
			System.out.println("Nema kontakata u imeniku");
		}
		else {
			for (Contact contact: contacts) {
				System.out.println(contact);
			}	
		}
	}

	public void addContact(User user) throws SQLException {
		
		System.out.println("Unesite ime: ");
		String name = input.next();
		
		System.out.println("Unesite broj telefona: ");
		String number = input.next();

		if(contactBO.addContactBO(name, number, user.getName())) {
			System.out.println("Kontakt uspjesno dodan.");
			contacts = loadContacts(user);
		}
		else {
			System.out.println("Greska, molim vas pokusajte ponovo.");
		}
	}

	public void modifyContact(User user) {
		
		if(contacts.isEmpty()) {
			System.out.println("Nema kontakata u imeniku");
		}
		
		System.out.println("Unesite ime: ");
		String name = input.next();
		
		for(Contact contact: contacts) {
			if(contact.getName().equals(name)) {
				System.out.println(contact);
			}
		}
		System.out.println("under construction...");
		
	}
	
	public void deleteContact() {
		
	}
	
	public void updateContact() {
		
	}

	public void changeInfoUser(User user) throws SQLException {
		
		String newPassword = newPassword();
		
		if (userBO.updateUserBO(user, newPassword)) {
			System.out.println("Sifra uspijesno izmjenjena");			
		}
		else {
			System.out.println("Greska, molim vas pokusajte ponovo.");
		}		
	}
	
}
