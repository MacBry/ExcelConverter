package com.mac.bry;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mac.bry.utillities.ExcelPathFinder;
import com.mac.bry.utillities.ExcelReader;
import com.mac.bry.utillities.ExcelWriter;

@SpringBootApplication
public class ExcelConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelConverterApplication.class, args);
		
		ExcelReader excelReader;
		ExcelWriter excelWriter;
		ExcelPathFinder excelPathFinder = new ExcelPathFinder();
		
		
		
		
		try {
			excelReader = new ExcelReader(excelPathFinder.getSourceFileName());
			excelReader.printPatientList();
			excelWriter = new ExcelWriter(excelPathFinder.getResultTemplateFileName(), excelPathFinder.getFinalResultName(),excelReader.getPatientList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
