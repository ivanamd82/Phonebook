package org.bild.ivana;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.bild.ivana.DTO.User;
import org.bild.ivana.view.UserInteraction;

public class App {
	
	static Scanner input = new Scanner(System.in);

	static UserInteraction userI = new UserInteraction();

	
    public static void main( String[] args ) throws SQLException {
 
    	while(true) {
    		printMainMenu(userI);
   		}     
    }
    
    public static void printMainMenu(UserInteraction userI) throws SQLException {
    	
    	User user = null;
    	
    	System.out.println("Izaberite opciju: \n");
		System.out.println("1. Log \n"
				+ "2. Registracija\n"
				+ "3. Izlaz\n");
		
		try {		
			int izbor = input.nextInt();	
			
			switch(izbor) {	
			case 1: {
				input.nextLine();
				user = userI.loginMainMenu();
				if(user != null) {
					while(true) {
						printUserMenu(user);
					}
				}
				break;		
			}
			case 2: {	
				input.nextLine(	);
				userI.registracijaMainMenu();
				break;				
			}
			case 3: {		
				System.out.println("Pa-pa");				
				System.exit(0);	
			}
			default: throw new InputMismatchException("Pogresan unos.");
			}															
		} catch (InputMismatchException ex) {		
			System.out.println("Pogresan unos. Pokusajte ponovo: ");			
			input.nextLine();	
		}			
    }
    
    public static void printUserMenu(User user) throws SQLException {
    	
    	System.out.println("\nIzaberite opciju: \n");
		System.out.println("1. Ispis svih kontakata\n"
				+ "2. Dodaj novi kontakt\n"
				+ "3. Uredjivanje kontakata\n"
				+ "4. Izmjena korisnicke sifre\n"
				+ "5. Izlaz\n");	
		try {
			int izbor = input.nextInt();
			
			switch (izbor) {
			case 1: {
				userI.printAllContacts(user);
				break;
			}
			case 2: {
				userI.addContact(user);
				break;
			}
			case 3: {
				userI.modifyContact(user);
				break;
			}
			case 4: {
				userI.changeInfoUser(user);
				break;
			}
			case 5: {
				System.out.println("Pa-pa");				
				System.exit(0);	
			}
			default: throw new InputMismatchException("Pogresan unos.");
			}															
		} catch (InputMismatchException ex) {		
			System.out.println("Pogresan unos. Pokusajte ponovo: ");			
			input.nextLine();	
		}			
    }
}
