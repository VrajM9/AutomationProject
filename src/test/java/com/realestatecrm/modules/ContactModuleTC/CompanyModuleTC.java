package com.realestatecrm.modules.ContactModuleTC;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.OrangeHRMTC.Baseclass;
import com.OrangeHRMTC.Util;
import com.realestatecrm.loginPages.CompanyModulePages;
import com.realestatecrm.loginPages.LoginPage;
public class CompanyModuleTC extends Baseclass {
	 CompanyModulePages companymodulepages;
 @BeforeClass(groups=("agilecrmTC"))
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
public void companyModuleTc1()
{    
	 companymodulepages=new CompanyModulePages();
	 //Add Company with valid details
	 companymodulepages.addCompany("BajajFinsv", "www.bajajfinsv.in");
	 Util.waitTobeVisible(By.xpath("//div[@id=\"company-Input\"]/descendant::div"));
	 String companyname=driver.findElement(By.xpath("//div[@id=\"company-Input\"]/descendant::div")).getText();
	 Assert.assertEquals("BajajFinsv", companyname,"Comapany not added");	
}
@Test(priority=2,groups=("agilecrmTC"))
public void companyModuleTc2()
{   //Add Company with SameExting details
	companymodulepages.addCompany("BajajFinsv", "www.bajajfinsv.in");
	String validationMsg=driver.findElement(By.xpath("//div[@class=\"alert alert-danger\"]")).getText();
	Assert.assertEquals(validationMsg, "Company name already exists.");	
}
@Test(priority=3,groups=("agilecrmTC"))
public void companyModuleTc3() {
	//Add Company With Null details
	companymodulepages.addCompany("","");
	String mandatoryMsg=driver.findElement(By.xpath("//input[@id='company_name']/following-sibling::span")).getText();
	Assert.assertEquals(mandatoryMsg, "This field is required.");	
}
@Test(priority=4,groups=("agilecrmTC"))
public void editCompany1()
// Update phone no to the company
{  companymodulepages.editCompany("phone","9899984555", 0);
   String phoneNo=driver.findElement(By.xpath("//div[@class='contact-make-call-div']/a")).getText();
   Assert.assertEquals(phoneNo, "9899984555");	
}
@Test(priority=5,groups=("agilecrmTC"))
public void editCompany2()
{
	companymodulepages.editCompany("Dropdown","", 2);
	String CountryName=driver.findElement(By.xpath("//div[@class='info-text c-p']")).getText();
	Assert.assertEquals(CountryName, "Algeria");
}
@Test(priority=6,groups=("agilecrmTC"))
public void deleteCompany()
{
	companymodulepages.deletCompany();
	driver.findElement(By.id("trashmenu")).click();
	driver.findElement(By.xpath("//li[@class='companies-trash-tab']/a")).click();
	List<WebElement> deletedCompanyNames=driver.findElements(By.xpath("//a[@class='text-cap cursor-default']"));
	for(WebElement Allcompanies:deletedCompanyNames)
	{
		String companies=Allcompanies.getText();
		if (companies.equals("OlaCabs"))
		{
			break;
		}
	}
}
}	 
	 
	 
	 
	 
	 
//	 // update company details
//     companymodulepages.editCompany("9898985565");    
//	 String phoneno=driver.findElement(By.xpath("//div[@id=\"-container\"]/descendant::a[1]")).getAttribute("phone");
//	 Assert.assertEquals("9865986512", phoneno,"phoneno updated");
//	 //detete company
//	 companymodulepages.deletCompany();
