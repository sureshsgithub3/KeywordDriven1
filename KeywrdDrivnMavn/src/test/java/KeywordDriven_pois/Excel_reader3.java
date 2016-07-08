package KeywordDriven_pois;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

public class Excel_reader3 {
	
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
						HSSFCell  testaction=login_sheet.getRow(j).getCell(3);
						HSSFCell testfield=login_sheet.getRow(j).getCell(2);
						HSSFCell testdata=login_sheet.getRow(j).getCell(4);
						
						System.out.println(testaction+","+testfield+","+testdata);
						
						for(int k=0;k<trelloactions.length;k++)
						{
							if(trelloactions[k].getName().equals(testaction))
							{
								//trelloactions[k].invoke(trello, testfield,testdata);
								if (trelloactions[k].getName().contains("validate"))
								{
									trelloactions[k].invoke(trello, testfield,testdata);
									
									
								}
								else
								{
									trelloactions[k].invoke(trello, testfield,testdata);
								}
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
