package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Information {
	private File file;
	private List<User> users;

	public Information(String string) {
		file = new File(string);
		users = new ArrayList<User>();
	}

	public User getUser(String string) {
		return null;
	}

	public void load() throws FileNotFoundException {
		try {
		Scanner scanFile = new Scanner(file);
		
		while(scanFile.hasNextLine()) {
			User temp = new User(scanFile.next());
			temp.setChoice(scanFile.next());
			users.add(temp);
		}
		scanFile.close();
		} catch(FileNotFoundException e) {
			System.out.println(e);
		}
	}

	public boolean save() {
		return false;
	}

}
