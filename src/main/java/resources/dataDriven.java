package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	
	
	//identify the testcases column by scanning the entire 1st row
	//once identified then scan entire test casecolumn to identify the purchase test case row
	//grab purchase test cases row = pull all the data in row
	@SuppressWarnings("deprecation")
	public ArrayList<String> getdata(String testcasename) throws IOException
	{
		//loading exelfile
	//System.out.println("Test1");
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("E:\\SELENIUM\\UALData.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			//System.out.println("Test2 = " + workbook.getSheetName(i));

			if(workbook.getSheetName(i).equalsIgnoreCase("E2E"))
			{
				
				//System.out.println("Test3 = " + workbook.getSheetName(i));
				XSSFSheet sheet = workbook.getSheetAt(i);
				//identify test cases column by scanning the 1st row
				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();
				Iterator<Cell> cel = firstrow.cellIterator();
				int k=0;
				int column =0;
				while(cel.hasNext())
				{	
					Cell value = cel.next();
					//System.out.println("Test4 = " + value.getStringCellValue());

			
					if(value.getStringCellValue().equalsIgnoreCase(testcasename))
					{
						column = k;
						
					}
					k++;
				}
				System.out.println("column = " + column);
				
				while(rows.hasNext())
				{
					Row r = rows.next();
					/*if (r == null ) {
						break;
					}*/
					//System.out.println("Test 5 " + r.getCell(column).getStringCellValue());

					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Login"))
					{
						//System.out.println("Test 6 " + r.getCell(column).getStringCellValue());

						Iterator<Cell> cv= r.cellIterator();
						while(cv.hasNext())
						{
							
							Cell c= cv.next();
							//System.out.println("Test 7 " + c.getCellType());

							if(c.getCellType()==CellType.STRING)
							{
								//System.out.println("Test 8 " + c.getStringCellValue());

								a.add(c.getStringCellValue());
							}
							else
							{
								NumberToTextConverter.toText(c.getNumericCellValue());
								
								
							}
						}
						
						
					}
					
					
				}
				
			}
			
		}return a;
		
		
		
	}
	public static void main(String[] args) throws IOException {

		

	}

}
