package com.ak.texasholdem.io;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInputHandler {

	private Scanner scanner = new Scanner(System.in);

	public UserInputHandler(Scanner scanner) {
		this.scanner = scanner;
	}

	/**
	 * 
	 * @param lower inclusive
	 * @param upper inclusive
	 * @return
	 */
	public int getIntAmongTwoNumbs(int lower, int upper) {
		int number = -1;
		while (true) {
			System.out.println(">");
			String input = scanner.nextLine().trim();
			String regex = "^[0-9]+$";
			if (Pattern.matches(regex, input)) {
				number = Integer.parseInt(input);
				if (number >= lower && number <= upper) {
					return number;
				}
			}
		}
	}
	
	
}
