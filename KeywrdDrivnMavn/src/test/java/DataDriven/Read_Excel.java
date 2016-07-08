package DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Read_Excel extends Mercury_tours {
	
	public Read_Excel(WebDriver driver)
	{
		
	}
	
	
	
	public void readexcelmethod()
	{
		File file=new File("");
		try {
			FileInputStream inputfile=new FileInputStream(file);
			HSSFWorkbook workbook=new HSSFWorkbook(inputfile);
			HSSFSheet loginsheet=workbook.getSheet("Logindata");
			int loginrows=loginsheet.getLastRowNum();
			
			
			for(int i=1;i<=loginrows;i++)
			{
				String res="invalid dara";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	

	public static void main(String[] args) 
	{
		

	}

}
