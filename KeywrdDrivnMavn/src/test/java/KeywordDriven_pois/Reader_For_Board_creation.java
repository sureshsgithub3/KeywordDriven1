package KeywordDriven_pois;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

public class Reader_For_Board_creation {
	
	@Test
	public void Trello_board_Reader()
	{
		try {
			FileInputStream file=new FileInputStream("TrelloLogin.xls");
			HSSFWorkbook workbook=new HSSFWorkbook(file);
			HSSFSheet TestCases=workbook.getSheet("Testcases_sheet");
			HSSFSheet Loginsheet=workbook.getSheet("Login_sheet");
			HSSFSheet Boardsheet=workbook.getSheet("Trello_Board");
			
			int Testcasesrows=TestCases.getLastRowNum();
			System.out.println(Testcasesrows);
			
			int Loginsheetrows=Loginsheet.getLastRowNum();
			System.out.println(Loginsheetrows);
			int Boardsheetrows=Boardsheet.getLastRowNum();
			System.out.println(Boardsheetrows);
			
			for(int i=1;i<=Testcasesrows;i++)
			{
				String testcasename=String.valueOf(TestCases.getRow(i).getCell(0));
				String testcasemode=String.valueOf(TestCases.getRow(i).getCell(2));
				if(testcasemode.equalsIgnoreCase("Yes"))
				{
					System.out.println(testcasename);
				
				for(int j=1;j<=Loginsheetrows;j++)
				{
					String testcaseid=String.valueOf(Loginsheet.getRow(j).getCell(0));
					if(testcasename.equalsIgnoreCase(testcaseid))
					{
						System.out.println("---------------");
						System.out.println(testcaseid);
					}
				}
				for(int k=1;k<=Boardsheetrows;k++)
				{
					String testcaseid1=String.valueOf(Boardsheet.getRow(k).getCell(0));
					if(testcaseid1.equalsIgnoreCase(testcasename))
					{
						System.out.println("-----------");
						System.out.println(testcaseid1);
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
