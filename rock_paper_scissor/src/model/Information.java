package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Information {
	private File file;
	private User user;
	/*
	 * constructor that creates a file and an empty list
	 */
	public Information(String string) {
		file = new File(string);
		user = new User("user");
	}
	/*
	 * get a user
	 */
	public User getUser() {
		return user;
	}
	public void addUser(User newUser) {
		user = newUser;
	}
	/*
	 * load the users from a text document
	 */
	public void load() throws FileNotFoundException {
		try {
		Scanner scanFile = new Scanner(file);
		
		while(scanFile.hasNext()) {
			User temp = new User(scanFile.next());
			int wins = scanFile.nextInt();
			for(int i = 0; i < wins; i++) {
				temp.gameResult("won");
			}
			int losses = scanFile.nextInt();
			for(int i = 0; i < losses; i++) {
				temp.gameResult("lost");
			}
		
			user = temp;
		}
		scanFile.close();
		} catch(FileNotFoundException e) {
			System.out.println(e);
		}
	}
	/*
	 * save user on the text file
	 */
	public boolean save(User user) {
		try {
			PrintWriter pw = new PrintWriter(file);
			Statistics stats = user.getStatistics();
			pw.println(user.name+" "+stats.getWins()+" "+stats.getLosses());
			pw.close();
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("Error: File is not initialized!");
		}
		return false;
	}

}
