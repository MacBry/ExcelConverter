package com.mac.bry.utillities;

public class ResultConverter {
	
	public String  convertResult(String eskulapResult) {
		if(eskulapResult.equals("NIE WYKRYTO RNA SARS-CoV-2")) {
			return "negatywny";
		}
		else if(eskulapResult.equals("WYKRYTO RNA SARS-CoV-2")) {
			return"pozytywny";
		}
		else return "nierozstrzygajacy";
	}

}
