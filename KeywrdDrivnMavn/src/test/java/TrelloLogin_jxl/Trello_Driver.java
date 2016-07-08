package TrelloLogin_jxl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Trello_Driver {
	
	
	@Test
	public void Logintest(){
		
		//Read Excel file
		
				File file= new File("TrelloLogin.xls");
				
				try {
					Workbook workbook= Workbook.getWorkbook(file);
					
					Sheet testcases=workbook.getSheet("Test_cases");
					//reading no of rows of Test_cases sheet in excel file
					int testcases_rows=testcases.getRows();
					
					Sheet login=workbook.getSheet("Trello_login");
					//reading no of rows of Trello_login sheet in excel file
					int login_rows=login.getRows();
					
					System.out.println("cases"+ testcases_rows);
					System.out.println("login "+ login_rows);
					
					Trello_Login trellosignin=new Trello_Login();
					
					Method trelloactions[]=trellosignin.getClass().getMethods();
					
					
					for(int i=1;i<testcases_rows;i++)
					{
						String testcasemode=testcases.getCell(2,i).getContents();
						String testcasename=testcases.getCell(0, i).getContents();
						
						
						if(testcasemode.equalsIgnoreCase("yes"))
						{
							for(int j=1;j<login_rows;j++)
							{
								String testcase_id=login.getCell(0,j).getContents();
								
								if(testcasename.equalsIgnoreCase(testcase_id))
								{
									String testaction=login.getCell(3, j).getContents();
									String field=login.getCell(2,j).getContents();
									String testdata=login.getCell(4, j).getContents();
									
									System.out.println(testaction+","+field+","+testdata);
									
									for(int k=0;k<trelloactions.length;k++)
									{
										if(trelloactions[k].getName().equals(testaction))
										{
											trelloactions[k].invoke(trellosignin, field,testdata);
											break;
										}
									}
								}
							}
							
						}
					}
					
				} catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
	}

}
