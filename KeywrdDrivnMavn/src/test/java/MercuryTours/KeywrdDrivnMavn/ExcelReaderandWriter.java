package MercuryTours.KeywrdDrivnMavn;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReaderandWriter {
	
	//Creating function resturns List of 2d string 
	
	public List<List<String>>  ReadFile(String Filename){
		
		//Creating 2d List 
		List<List<String>> table=new ArrayList<List<String>>();
		
		
		try {
			
			FileInputStream file= new FileInputStream(new File(Filename));
			HSSFWorkbook workbook= new HSSFWorkbook(file);
			HSSFSheet sheet=workbook.getSheetAt(0);
			
			
			//Iterator to iterate thrgh sheet 
			
			Iterator<Row> rowiterator=sheet.iterator();
			
			while(rowiterator.hasNext()){
				
				List<String> rowdata= new ArrayList<String>();
				Row row=rowiterator.next();
				Iterator<Cell>celliterator=row.cellIterator();
				
				while(celliterator.hasNext()){
					
					Cell cell=celliterator.next();
					
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:
						 rowdata.add(String.valueOf(cell.getBooleanCellValue()));
						 break;
						 
						 
					case Cell.CELL_TYPE_NUMERIC:
						rowdata.add(String.valueOf(cell.getNumericCellValue()));
						break;
					case Cell.CELL_TYPE_STRING:
						rowdata.add(String.valueOf(cell.getStringCellValue()));
						break;
						
					case Cell.CELL_TYPE_BLANK:
						break;
						
					}
					
				}
				table.add(rowdata);
			}
			System.out.println(table);
			
			
				
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return table;
		
	}

}
