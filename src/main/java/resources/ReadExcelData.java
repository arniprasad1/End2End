package resources;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static String projectPath;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	public ReadExcelData(String exelPath, String sheetName)
	{	try
	{
		
		workbook = new XSSFWorkbook(exelPath);
		sheet = workbook.getSheet(sheetName);
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	}

	
	
	public static int getRowCount() {
		int rowCount = 0;
	try
	{
		
	rowCount = sheet.getPhysicalNumberOfRows();
	System.out.println("No of rows :" + rowCount);
	}
	catch (Exception e) 
	{	
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	
	return rowCount;
	
}
public static int getColCount() {
	int colCount = 0;
	try
	{
		
	colCount = sheet.getRow(0).getPhysicalNumberOfCells();
	System.out.println("No of Columns :" + colCount);
	}
	catch (Exception e) 
	{	
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	
	return colCount;
	
}
	public static String getCellDataString(int rowNum, int colNum) 
	{
		String cellData =null;
		try
		{
			
		cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		System.out.println("Cell Data is: " +cellData);
		}
		catch (Exception e) 
		{	
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return cellData;
	}	
	

	public static void getCellDataNumber(int rowNum, int colNum) 
	{
		try
		{
			
		double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		//System.out.println("Cell Data is: " +cellData);
		}
		catch (Exception e) 
		{	
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
