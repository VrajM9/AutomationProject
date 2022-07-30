package com.realestatecrm.modules;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.OrangeHRM.Baseclass;
import com.OrangeHRM.Util;
import com.realestatecrm.loginPages.LoginPage;
public class CompanyModuleTC extends Baseclass {
 @BeforeClass
 @Parameters({"username","password","url","browser"})
 public void beforeclass(String username,String password,String url,String browser)
 {
	 LoginPage loginpage=new LoginPage();
	 launchBrowser(browser);
	 driver.manage().window().maximize();
	 driver.get(url);
	 loginpage.login(username,password);
 }
 @Test(priority=1,groups=("agilecrmTC"))
 public void addCompany() throws Exception
 {   Util.waitTobeClickable(By.id("companiesmenu"));
   	driver.findElement(By.id("companiesmenu")).click();
   	driver.findElement(By.xpath("//div[@id=\"view-list\"]/button[1]/i")).click();
    Util.waitTobeClickable(By.xpath("//input[@id=\"company_name\"]"));
   	driver.findElement(By.xpath("//input[@id=\"company_name\"]")).sendKeys("BajajFinsv");
   	driver.findElement(By.xpath("//input[@id=\"company_url\"]")).sendKeys("www.BajajFinsv.in");
   	driver.findElement(By.id("company_validate")).click();
   	Util.waitTobeVisible(By.id("company-name-text"));
	String companyname=driver.findElement(By.id("company-name-text")).getText();
	Util.validation("BajajFinsv", companyname);
 }	
 @Test(priority=2,dependsOnMethods="addCompany",groups=("agilecrmTC"))
 public void deletcompany()
 {    Util.waitTobeClickable(By.id("companiesmenu"));
	 driver.findElement(By.id("companiesmenu")).click();
	 Util.waitTobeClickable(By.xpath("//tbody[@id=\"companies-list-view-model-list\"]/descendant::i[1]"));
	 driver.findElement(By.xpath("//tbody[@id=\"companies-list-view-model-list\"]/descendant::i[1]")).click();
	 Util.waitTobeClickable(By.xpath("//button[text()=\"Delete\"]"));
	 driver.findElement(By.xpath("//button[text()=\"Delete\"]")).click();
	 Util.waitTobeClickable(By.id("success_callback"));
	 driver.findElement(By.id("success_callback")).click();
 }
}

