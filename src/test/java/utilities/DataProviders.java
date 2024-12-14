package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		String file_path=".\\testData\\LoginDDTestData.xlsx";
		
		ExcelUtility xutil=new ExcelUtility(file_path);
		int rowCount = xutil.getRowCount("sheet1");
		int cellCount = xutil.getCellCount("sheet1", 1);
		
		String loginData[][]=new String [rowCount][cellCount];
		
		for(int r=1; r<=rowCount; r++) {
			
			for(int c=0; c<cellCount; c++) {
				loginData [r-1][c]=xutil.getCellData("sheet1", r, c);
			}
		}
		return loginData;
	}

}
