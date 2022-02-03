package com.mac.bry.utillities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mac.bry.entities.Patient;


public class ExcelWriter {



	private FileInputStream fileInputStream;
	
	private FileOutputStream fileOutputStream;

	private Workbook workbook;

	private DeliveryDateCreator deliveryDateCreator = new DeliveryDateCreator();

	public ExcelWriter(String templateFilePath,String resultFilePath, List<Patient> patientsList) throws IOException {
		super();
		
		this.fileInputStream = new FileInputStream(new File(templateFilePath));
		
		this.workbook = WorkbookFactory.create(fileInputStream);
		
		Sheet sheet = workbook.getSheetAt(0);
		
		
		int rowCount = 0;
        
        for (Patient patient: patientsList) {
            Row row = sheet.createRow(++rowCount);
           
            
            
            Cell cell = ((Row) row).createCell(0);
            cell.setCellValue(patient.getPesel() + patient.getDonationDate());
            
            cell = row.createCell(2);
            cell.setCellValue(patient.getPesel());
            
            cell = row.createCell(6);
            cell.setCellValue(patient.getFirstName());
            
            cell = row.createCell(7);
            cell.setCellValue(patient.getLastName());
            
            cell = row.createCell(8);
            cell.setCellValue("COVID19");
            
            cell = row.createCell(11);
            cell.setCellValue(patient.getDonationDate());
            
            cell = row.createCell(12);
            cell.setCellValue(deliveryDateCreator.createDeliverDate(patient.getDonationDate()));
            
            cell = row.createCell(13);
            cell.setCellValue(patient.getResultDate());
            
            cell = row.createCell(14);
            cell.setCellValue(patient.getResult());
                 
        }
        
        fileInputStream.close();
        
        this.fileOutputStream = new FileOutputStream(new File(resultFilePath));

        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
        
	}

}
