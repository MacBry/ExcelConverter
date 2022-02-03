package com.mac.bry.utillities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mac.bry.entities.Patient;

public class ExcelReader {

	private List<Patient> patientList = new ArrayList<Patient>();
	
	private ResultConverter resultConverter = new ResultConverter();

	private String sourceFilePath;
	

	private File sourceExcelFile;
	

	private FileInputStream fileInputStream;

	private Workbook workbook;

	private Sheet sheet;


	public ExcelReader(String filePath) throws IOException {
		super();
		this.sourceFilePath = filePath;
		this.sourceExcelFile = new File(this.sourceFilePath);
		this.fileInputStream = new FileInputStream(sourceExcelFile);
		//this.workbook = new HSSFWorkbook(fileInputStream);
		
		// creating patient from rows
		this.workbook = null;
		this.sheet = null;
		File file = new File(filePath);
		if (!file.exists()) {
		   if (file.toString().endsWith(".xlsx")) {
		      workbook = new XSSFWorkbook(fileInputStream);
		      this.sheet = workbook.getSheetAt(0);
		   } else {
		      workbook = new HSSFWorkbook(fileInputStream);
		      this.sheet = workbook.getSheetAt(0);
		   }
		} else {
		   workbook = WorkbookFactory.create(new FileInputStream(file));
		}

		int rows = sheet.getLastRowNum();


		for (int i = 2; i <= rows; i++) {
			Patient tempPatient = new Patient();
			tempPatient.setFirstName(sheet.getRow(i).getCell(4).getStringCellValue());
			tempPatient.setLastName(sheet.getRow(i).getCell(5).getStringCellValue());
			if(sheet.getRow(i).getCell(8) == null) {
				tempPatient.setPesel(" ");
			}else tempPatient.setPesel(sheet.getRow(i).getCell(8).getStringCellValue());
			tempPatient.setDonationDate(sheet.getRow(i).getCell(9).getStringCellValue());
			tempPatient.setResult(resultConverter.convertResult(sheet.getRow(i).getCell(11).getStringCellValue()));
			tempPatient.setResultDate(sheet.getRow(i).getCell(10).getStringCellValue());
			patientList.add(tempPatient);
			
		}

	}
	
	public List<Patient> getPatients () {
		return this.patientList;
	}

	
	public void printPatientList() {
		for (Patient patient : patientList) {
			System.out.println(patient.getFirstName() + " " + patient.getLastName() +" " +
		patient.getPesel() + " " + patient.getDonationDate() + " " + patient.getResultDate() + " "
		+ patient.getResultDate() + " " + patient.getResult());
		}

	}
	
	public List<Patient> getPatientList(){
		return this.patientList;
	}
}
