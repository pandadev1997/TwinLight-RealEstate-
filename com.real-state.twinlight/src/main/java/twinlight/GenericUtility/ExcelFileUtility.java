package twinlight.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelFileUtility {
	
	/**
	 * This method help us to fetch data from excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	public String fetch_data_from_excel(String sheet,int row,int cell) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		 Cell value = wb.getSheet(sheet).getRow(row).getCell(cell);
		 DataFormatter df=new DataFormatter();
		 String data = df.formatCellValue(value);
		wb.close();
		return data;
	}
	/**
	 * This method help us to store data into excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param value
	 * @throws Throwable
	 */
	public void store_data_into_excel(String sheet,int row,int cell,String value) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).createRow(row).createCell(cell).setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IpathConstant.excelfilepath);
		wb.write(fos);
		wb.close();
}
	/**
	 * This method help us to fetch data upto last row from excel sheet
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	public int getlastRowno(String sheetname) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		int Rowno = wb.getSheet(sheetname).getLastRowNum();
		return Rowno;
	}
	/**
	 * This method will help us to fetch multiple set of data from excel sheet
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readmultipleSetOfData(String sheetname) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastrow = sh.getLastRowNum()+1;
		short lastcell = sh.getRow(0).getLastCellNum();
		Object[][] p=new Object[lastrow][lastcell];
		DataFormatter df=new DataFormatter();
		for(int i=0;i<lastrow;i++) {
			for(int j=0;j<lastcell;j++) {
				p[i][j] = df.formatCellValue(sh.getRow(i).getCell(j));
			}
		}
		return p;
	}
}
