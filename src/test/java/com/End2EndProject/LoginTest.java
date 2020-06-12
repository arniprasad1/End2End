package com.End2EndProject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.ReadExcelData;

public class LoginTest {
	
	public static void main(String[] args) {
		String exelPath = "E:\\SELENIUM\\End2EndProject\\exel\\UALData.xlsx";
		loginTest(exelPath, "E2E");
		
	}
	@DataProvider (name = "LoginTest1")
	public Object[][] getData()
	{
		String exelPath = "E:\\SELENIUM\\End2EndProject\\exel\\UALData.xlsx";
		Object data[][] = loginTest(exelPath, "E2E");
		return data;
		
	}
	
	@Test(dataProvider = "LoginTest1" )
	public void test1(String TestName, String username,String password)
	{
		System.out.println(TestName + " | " + username + " | "+ password);
	}
	
	public static Object[][] loginTest(String exelPath, String sheetName)
	{
		ReadExcelData exeldata = new ReadExcelData(exelPath, sheetName);
		int rowCount = exeldata.getRowCount();
		int colCount = exeldata.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i=1;i<rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				String cellData = exeldata.getCellDataString(i,j);
				//System.out.print(cellData+" | ");
				data[i-1][j] = cellData;
			}
			//System.out.println();
			
		}
		
		return data;
	}

}
