package Keyword_Driven_Pois;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;



public class Excel_Reader_Results {
	@Test
	public void Read_Excel(){
		try {
			FileInputStream file= new FileInputStream("C:\\Users\\suresh\\Desktop\\Selenium data Files\\Excel files\\KywrdExcels\\Key_Wrod_driven_Validate\\TrelloLogin.xls");
		
			HSSFWorkbook  Workbook=new HSSFWorkbook(file);
			HSSFSheet Testcasessheet=Workbook.getSheet("Testcases_sheet");
			HSSFSheet Loginsheet=Workbook.getSheet("Login_sheet");
			
			int testcaserows=Testcasessheet.getLastRowNum();
			int logincaserows=Loginsheet.getLastRowNum();
			
			Trello_Login_actions trello1=new Trello_Login_actions();
			Method  Trelloactions[]=trello1.getClass().getMethods();
			
			
			for(int i=1;i<=testcaserows;i++)
			{
				String testcasename=String.valueOf(Testcasessheet.getRow(i).getCell(0));
				String testmode=String.valueOf(Testcasessheet.getRow(i).getCell(2));
				
			    if(testmode.equalsIgnoreCase("yes"))
			    {
			    	for(int j=1;j<=logincaserows;j++)
			    	{
			    		String testcaseid=String.valueOf(Loginsheet.getRow(j).getCell(0));
			    		if(testcasename.equalsIgnoreCase(testcaseid))
			    		{
			    			String testaction=String.valueOf(Loginsheet.getRow(j).getCell(3));
			    			String testdata=String.valueOf(Loginsheet.getRow(j).getCell(4));
			    			String testobject=String.valueOf(Loginsheet.getRow(j).getCell(2));
			    			
			    			System.out.println(testaction+","+testdata+","+testobject);
			    			
			    			
			    			for(int k=0;k<Trelloactions.length;k++)
			    			{
			    				if(Trelloactions[k].getName().equalsIgnoreCase(testaction))
			    				{
			    					Trelloactions[k].invoke(trello1, testobject,testdata);
			    					
			    				//	if(Trelloactions[k].getName().contains("Validate")){
			    					
			    						System.out.println("Valid login");
			    						Cell cell=Loginsheet.getRow(j).createCell(5);
			    						cell.setCellType(Cell.CELL_TYPE_STRING);
			    						cell.setCellValue("success");
			    						FileOutputStream ofile=new FileOutputStream("C:\\Users\\suresh\\Desktop\\Selenium data Files\\Excel files\\KywrdExcels\\Key_Wrod_driven_Validate\\TrelloLogin.xls");
			    						Workbook.write(ofile);
			    						ofile.close();
			    						
			    						
			    					//}
			    					
			    					
			    					
			    					
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
