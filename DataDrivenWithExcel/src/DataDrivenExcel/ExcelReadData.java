package DataDrivenExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadData 
{
	public static void main(String args[]) throws Exception
	{
	File src = new File("E:\\Browser_drivers\\ExcelDemo.xlsx");
	
	//Read file from path
	FileInputStream fls = new FileInputStream(src);
	
	XSSFWorkbook wb = new XSSFWorkbook(fls);
	
	XSSFSheet sheet1 = wb.getSheetAt(0);
	
	int count = sheet1.getLastRowNum();
	
	System.out.println(count);
	
	for (int i = 0; i < count; i++) {
		
		String data0 = sheet1.getRow(i).getCell(0).getStringCellValue();
		
		System.out.println("Total Test Data From Excel :" +data0);
		
	}
	
	wb.close();
	}
}
