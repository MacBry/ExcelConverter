package com.mac.bry.entities;

public class Patient {

	private String firstName;
	private String lastName;
	private String pesel;
	private String donationDate;
	private String resultDate;
	private String result;
	
	public Patient(String firstName, String lastName, String pesel, String donationDate, String resultDate,
			String result) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
		this.donationDate = donationDate;
		this.resultDate = resultDate;
		this.result = result;
	}

	public Patient() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pESEL) {
		pesel = pESEL;
	}

	public String getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(String donationDate) {
		this.donationDate = donationDate;
	}

	public String getResultDate() {
		return resultDate;
	}

	public void setResultDate(String resultDate) {
		this.resultDate = resultDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
	
}
