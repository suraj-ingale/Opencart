package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	

	public  FileInputStream fi;
	public  FileOutputStream fo;
	public  XSSFWorkbook workbook;
	public  XSSFSheet sheet;
	public  XSSFRow row;
	public  XSSFCell cell;
	public  CellStyle style;
	public String file_path;
	
	public ExcelUtility(String file_path) {
		this.file_path=file_path;
	}

	public int getRowCount(String sheet_name) throws IOException {

		fi = new FileInputStream(file_path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheet_name);
		int rowCount = sheet.getLastRowNum();
		
		workbook.close();
		fi.close();

		return rowCount;

	}
	
	public int getCellCount(String sheet_name, int row_num) throws IOException {
		
		fi=new FileInputStream(file_path );
		workbook=new XSSFWorkbook(fi);
		workbook.getSheet(sheet_name);
		row=sheet.getRow(row_num);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fi.close();
		
		return cellCount;
		
	}
	
	public String getCellData(String sheet_name, int row_num, int cell_num) throws IOException {
		
		fi=new FileInputStream(file_path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheet_name);
		row=sheet.getRow(row_num);
		cell=row.getCell(cell_num);
		
		String cellData;
		try {
			
		//	cellData=cell.toString();
			DataFormatter formatter=new DataFormatter();
			cellData=formatter.formatCellValue(cell);
			
		}catch(Exception e) {
			cellData="";
		}
		
		workbook.close();
		fi.close();
		
		return cellData;
		
	}
	
	public void setCellData( String sheet_name, int row_num, int cell_num, String data) throws IOException {
		
		fi=new FileInputStream(file_path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheet_name);
		row=sheet.getRow(row_num);
		cell=row.createCell(cell_num);
		cell.setCellValue(data);
		fo=new FileOutputStream(file_path);
		workbook.write(fo);
		
		workbook.close();
		fo.close();
		fi.close();
	}
	
	public void fillGreenColor( String sheet_name, int row_num, int cell_num) throws IOException {
		
		fi=new FileInputStream(file_path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheet_name);
		row=sheet.getRow(row_num);
		cell=row.getCell(cell_num);
		
		style=workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo=new FileOutputStream(file_path);
		workbook.write(fo);
		workbook.close();
		fo.close();
		fi.close();
		
	}
	
	public void fillRedColor(String sheet_name, int row_num, int cell_num) throws IOException {
		
		fi=new FileInputStream(file_path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheet_name);
		row=sheet.getRow(row_num);
		cell=row.getCell(cell_num);
		
		style=workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo=new FileOutputStream(file_path);
		workbook.write(fo);
		workbook.close();
		fo.close();
		fi.close();
		
	}

}
