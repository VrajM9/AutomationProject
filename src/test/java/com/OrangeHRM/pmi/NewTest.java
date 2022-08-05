package com.OrangeHRM.pmi;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.OrangeHRM.LoginPages.LoginPage;
import com.OrangeHRMTC.Baseclass;
import com.OrangeHRMTC.ExelHandlingUtil;
public class NewTest extends Baseclass {
	ExelHandlingUtil excelhandlingutil;
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
  public void OrangeHrm() throws IOException
  { 
      String filepath="C:\\Users\\parag\\Desktop\\Virajm\\OrangeHRMTest.xlsx";
	 driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b")).click();
	 driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
	 for (int i=8;i<=115;i++)
	 {  List<WebElement> alldeatils=driver.findElements(By.xpath("[//table[@id=\"resultTable\"]/descendant::a]["+i+"]"));
	 
	 }
	 }
  
  
  
  }
  