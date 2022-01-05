package com.mac.bry.utillities;

import java.util.Scanner;


public class DataReader {

	private Scanner scanner;

	public DataReader() {
		super();
		this.scanner = new Scanner(System.in);
	}


	public void closeScanner() {
		this.scanner.close();
	}
	

	
	public String readAcceptanceDate() {
		System.out.println("Wpisz date przyjecia materialu (RRRR-MM-DD GG:MM): ");
		String tempDate = scanner.nextLine();
		return tempDate;
	}
}
