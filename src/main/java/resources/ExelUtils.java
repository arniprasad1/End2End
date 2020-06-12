package resources;

public class ExelUtils {
	
	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		ReadExcelData red = new ReadExcelData(projectPath+"\\exel\\UALData.xlsx", "E2E");
		red.getRowCount();
		red.getColCount();
		red.getCellDataString(0, 0);
		//red.getCellDataNumber(1,0);
		
		
	}

}
