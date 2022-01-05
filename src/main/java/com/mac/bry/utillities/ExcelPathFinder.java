package com.mac.bry.utillities;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ExcelPathFinder {
	Properties properties = PropReader.properties();
	
	final String sourceGeneralDir = properties.getProperty("Source-General-Dir");
	final String resultTemplateDir = properties.getProperty("Result-Template-Dir");
	final String fianlResultDir = properties.getProperty("Final-Result-Dir");
	
	public String getSourceFileName() {
		
		List<String> resultsList = new ArrayList<String>();
		File[] files = new File(sourceGeneralDir).listFiles();
		System.out.println(sourceGeneralDir);
		for (File file : files) {
			if (file.isFile()) {
				
				resultsList.add(file.getName());
			}
		}
		return sourceGeneralDir +"\\" + resultsList.get(0);
	}
	
	public String getResultTemplateFileName() {
		String result = resultTemplateDir + "\\resultTemplate.xlsx";
		return result;
	}
	
	public String getFinalResultName() {
		DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
		String dateTimeAfterFormat = LocalDateTime.now().format(formatter);
		String result = fianlResultDir + "\\RESULT" + dateTimeAfterFormat + ".xlsx";
		System.out.println(result);
		return result;
	}
}
