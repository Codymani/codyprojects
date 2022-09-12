package org.today;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class FlipkartNextPage extends flipkartPage {
	
	@Test
	private void flipPage() throws InterruptedException, IOException {
		
		flipkartLogin();
		
		List<String>newProduct=new ArrayList<>();
		List<String>newPrice=new ArrayList<>();
		for (int i=0;i<3;i++) {
			List<String> productName = productName();
			List<String> productPrice = productPrice();
			newProduct.addAll(productName);
			newPrice.addAll(productPrice);
			
		}
		System.out.println(newProduct);
		System.out.println(newPrice);
		
//	Excel Creation and import
		  Workbook wb=new XSSFWorkbook();
		  FileOutputStream excelCreation=new FileOutputStream("D:\\eclipse-workspace\\TestNGMaster\\src\\test\\resources\\Flipkart.xlsx");
		  Sheet Sheet = wb.createSheet();
		  Row createRow = Sheet.createRow(0);
		  createRow.createCell(0).setCellValue("Product Names");
		  createRow.createCell(1).setCellValue("Product price");
		  
		  for(int i=0;i<newProduct.size();i++) {
			  Row createRow2 = Sheet.createRow(i+1); 
			  createRow2.createCell(0).setCellValue(newProduct.get(i));
			  createRow2.createCell(1).setCellValue(newPrice.get(i));
		  }
		  wb.write(excelCreation);
	
	    
		
		
		

	}
	
}

