package com.OrangeHRM.pmi;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.OrangeHRM.LoginPages.LoginPage;
import com.OrangeHRMTC.Baseclass;
import com.OrangeHRMTC.ExelHandlingUtil;
public class GetDataEX extends Baseclass {
	
	   LoginPage loginpage;
	@BeforeClass
	public void beforeclass()
	{ 
		loginpage=new LoginPage();
		launchBrowser("chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		loginpage.login("Admin", "admin123");
		
	}
  @Test
  public Object[][] getDataFromOrangeHrm() throws IOException
  {  
     driver.findElement(By.id("menu_pim_viewPimModule")).click();
     List<WebElement> Rows= driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
     List<WebElement> columns= driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr[1]/td"));
     int TotalRows=Rows.size();
     int TotalColumn=columns.size();
    Object[][] data=new Object[TotalRows][TotalColumn];
    for(int i=1;i<TotalRows;i++)
    {
    	for (int j=1;j<TotalColumn;j++)
    	{
    		String values=driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
    		data[i][j]=values;
    	}
    }
   return data;
     	 }
  @Test
  public void Test() throws IOException
  
  {  ExelHandlingUtil excelhandlingutil=new ExelHandlingUtil();
	  String filepath="C:\\Users\\parag\\Desktop\\Virajm\\OrangeHRMTest1.xlsx";
	  Object[][] data=getDataFromOrangeHrm();
	  int rowSize=data[0].length;
	  int columnSize=data[1].length;
	  
	  for(int i=1;i<rowSize;i++)
	  {
		  for (int j=1;j<columnSize;j++)
		  {
             excelhandlingutil.setExcelData(filepath, "Sheet1", i, j, data[i][j]);
		  }
	  }
  }
  
}
  
  
  