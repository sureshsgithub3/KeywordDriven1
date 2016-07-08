package KeywordDriven_pois;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.CellEditor;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

public class Excel_Reader1 {
	
	
	
@Test
	public void ReadKeywords(){
	
	try {
		FileInputStream file=new FileInputStream("C:\\Users\\suresh\\Desktop\\Selenium data Files\\Excel files\\KywrdExcels\\TrelloLogin.xls");
		HSSFWorkbook workbook=new HSSFWorkbook(file);
		HSSFSheet Testcasesheet=workbook.getSheet("Testcases_sheet");
		HSSFSheet Logincasesheet=workbook.getSheet("Login_sheet");
		
		int testcasesheetrows=Testcasesheet.getLastRowNum();
		int logincasesheetrows=Logincasesheet.getLastRowNum();
		
		System.out.println(testcasesheetrows);
		System.out.println(logincasesheetrows);
		
		
		for(int i=1;i<=testcasesheetrows;i++)
		{
			String Testcasemode=Testcasesheet.getRow(i).getCell(2).getStringCellValue();
			String Testcasename=Testcasesheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(Testcasemode+","+Testcasename);
			
			if(Testcasemode.equalsIgnoreCase("Yes"))
			{
				for(int j=1;j<=logincasesheetrows;j++)
				{
				Row row=Logincasesheet.getRow(j);
				  for(int k=0;k<row.getLastCellNum();k++)
				  {
					//System.out.println("no of cell in rows"+k);  
					  if(row.getCell(k)!=null)
					  {
						  HSSFCell testaction=Logincasesheet.getRow(j).getCell(3);
							HSSFCell testfield=Logincasesheet.getRow(j).getCell(2);
							HSSFCell testdata=Logincasesheet.getRow(j).getCell(4);
							
							System.out.println(testaction+","+testfield+","+testdata);
						
						 
						  
					  }
				  }
				}
			}
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
