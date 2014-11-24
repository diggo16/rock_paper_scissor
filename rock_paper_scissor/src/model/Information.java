package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Information {
	private File file;
	private List<User> users;

	/*
	 * constructor that creates a file and an empty list
	 */
	public Information(String string) {
		file = new File(string);
		users = new ArrayList<User>();
	}
	/*
	 * get a user from the list users
	 */
	public User getUser(String string) {
		Iterator<User> iter = users.iterator();
		while(iter.hasNext()) {
			User user = iter.next();
			if(user.name.equals(string)) {
				return user;
			}
		}
		return null;
	}
	/*
	 * load the users from a text document
	 */
	public void load() throws FileNotFoundException {
		try {
		Scanner scanFile = new Scanner(file);
		
		while(scanFile.hasNext()) {
			User temp = new User(scanFile.next());
			temp.setChoice(scanFile.next());
			users.add(temp);
		}
		scanFile.close();
		} catch(FileNotFoundException e) {
			System.out.println(e);
		}
	}
	/*
	 * save the users on a text document
	 */
	public boolean save(List<User> list) {
		users = list;
		try {
			PrintWriter pw = new PrintWriter(file);
			Iterator<User> iter = users.iterator();
			while(iter.hasNext()) {
				User user = iter.next();
				pw.println(user.name+" "+user.choice);
			}
			pw.close();
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("Error: File is not initialized!");
		}
		return false;
	}

}
