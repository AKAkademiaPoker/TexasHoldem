package com.ak.texasholdem.tests;

import java.util.Scanner;

import com.ak.texasholdem.io.UserInputHandler;

public class UserInputHandlerTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UserInputHandler us = new UserInputHandler(scanner);

		int i = us.getIntAmongTwoNumbs(1, 5);
		System.out.println("ok " + i);
		// TODO Auto-generated method stub

		scanner.close();
	}

}
