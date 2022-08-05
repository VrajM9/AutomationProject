package com.OrangeHRMTC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExelHandlingUtil {
	FileInputStream fis;
	Workbook wb;
	Sheet sheet;
	Row row;
	Cell cell;
	public String getFileExtention()
	{
		String filepath= "C:\\Users\\parag\\Desktop\\Virajm\\LoginTestData.xlsx";
		String extention=filepath.substring(filepath.indexOf("."));
		return extention;
	}
 public void getInstanceOfWorkbook(String filepath) throws FileNotFoundException
 {
	 fis=new FileInputStream(filepath);
	 String extention=getFileExtention();
	 try { 
		 if (extention.equals(".xlsx"))
	 {
		wb=new XSSFWorkbook(fis);
	 }
		 else
		 {
			 wb=new HSSFWorkbook(fis);
		 }
	 }
	 catch (Exception e) {
			e.printStackTrace();
		}
	 }
 public void getSheetInstance(String sheetname)
 {
	sheet=wb.getSheet(sheetname);
	if(Objects.isNull(sheet))
	{
		wb.createSheet("newSheet");
	}
 }
 public Object[][] getexceldata(String filepath,String sheetname) throws IOException
 {
	 getInstanceOfWorkbook(filepath);
	 getSheetInstance(sheetname);
	 int totalRows=sheet.getPhysicalNumberOfRows();
	 int totalColumn=sheet.getRow(0).getPhysicalNumberOfCells();
	 Object [][]data=new Object[totalRows][totalColumn];
	 for (int i=1;i<totalRows;i++)
	 {
		 row=sheet.getRow(i);	
		 for (int j=0;j<totalColumn;j++)
		 {
			 cell=row.getCell(j);
			 data[i][j]=getCellData();
		 }
		 }
	 wb.close();
	return data;
 }
    public Object getCellData() {
	switch(cell.getCellType())
	{
		case STRING:
			return cell.getStringCellValue();
		case _NONE:
			return null;	
		case NUMERIC:
			return cell.getNumericCellValue();
		case BLANK:
			return null;
		case FORMULA:
		    return cell.getCellFormula();
		case BOOLEAN:
		     return cell.getBooleanCellValue();
		case ERROR:
		     return cell.getErrorCellValue();
		default:
		     return null;		
	}
}
	public void setExcelData(String filepath,String sheetname,int rowindex,int cellindex, String value) throws IOException {
		getInstanceOfWorkbook(filepath);
		getSheetInstance(sheetname);
		 int totalRows=sheet.getPhysicalNumberOfRows();
		 if (totalRows== 0)
		 {
			 cell=sheet.createRow(rowindex).createCell(cellindex);
			 cell.setCellValue(value);
		 }
		 else 
		 {
			 cell=sheet.getRow(rowindex).getCell(cellindex);
			 cell.setCellValue(value);
		 }
		 FileOutputStream fos=new FileOutputStream(filepath);
		 wb.write(fos);
		 wb.close();
		 
		
	}
 }
