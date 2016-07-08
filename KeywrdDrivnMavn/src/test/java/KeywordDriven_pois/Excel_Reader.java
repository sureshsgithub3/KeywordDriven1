package KeywordDriven_pois;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Excel_Reader {
	@Test
	public void Reader(){
		try {
			
		
			
			FileInputStream file= new FileInputStream("C:\\Users\\suresh\\Desktop\\Selenium data Files\\Excel files\\KywrdExcels\\TrelloLogin.xls");
			
			HSSFWorkbook workbook= new HSSFWorkbook(file);
			HSSFSheet testcases_sheet=workbook.getSheet("Testcases_sheet");
			HSSFSheet login_sheet=workbook.getSheet("Login_sheet");
			
			int testcase=testcases_sheet.getLastRowNum();
			System.out.println("total rows:"+testcase);
			
			int logincase=login_sheet.getLastRowNum();
			System.out.println("login sheet rows: "+logincase);
			
			Trelo_actions trello=new Trelo_actions();
			Method  trelloactions[]=trello.getClass().getMethods();
			//System.out.println("as "+trelloactions.length);
			
			
			
			for(int i=1;i<=testcase;i++)
			{
				String testcasename=testcases_sheet.getRow(i).getCell(0).getStringCellValue();
				String testcasemode=testcases_sheet.getRow(i).getCell(2).getStringCellValue();
				System.out.println(testcasename);
				System.out.println(testcasemode);
				
				if(testcasemode.equalsIgnoreCase("yes"))
				{
					for(int j=1;j<=logincase;j++)
					{
						String testcase_id=login_sheet.getRow(j).getCell(0).getStringCellValue();
						System.out.println(testcase_id);
						
						if(testcasename.equalsIgnoreCase(testcase_id))
						{
							
		
							// reading actions,objects and data from excel sheet in poi			
						//HSSFCell testaction=login_sheet.getRow(j).getCell(3);
					//	HSSFCell testfield=login_sheet.getRow(j).getCell(2);
						//HSSFCell testdata=login_sheet.getRow(j).getCell(4);
							
					//	toString();
					//	String testaction=String.valueOf(login_sheet.getRow(j).getCell(3));
					    String testfield=String.valueOf(login_sheet.getRow(j).getCell(2));
						String testdata=String.valueOf(login_sheet.getRow(j).getCell(4));
						String testaction1=String.valueOf(login_sheet.getRow(j).getCell(3));
							
							
							
							
					
					
					//	System.out.println(testaction1+","+testfield+","+testdata);
						
						for(int k=0;k<trelloactions.length;k++)
						{
							//System.out.println("size of array is :"+trelloactions.length);
							if(trelloactions[k].getName().equals(testaction1))
							{
								System.out.println(" methd name :"+trelloactions[k].getName());
								trelloactions[k].invoke(trello, testfield,testdata);
								
								
								
								break;
							}
							
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
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			
		
		}
       
		
	}

}
