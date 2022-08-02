package com.realestatecrm.modules;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.OrangeHRMTC.Baseclass;
import com.OrangeHRMTC.Util;
import com.realestatecrm.loginPages.CompanyModulePages;
import com.realestatecrm.loginPages.LoginPage;
public class CompanyModuleTC extends Baseclass {
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
public void companyModuleTc()
{    
	 CompanyModulePages companymodulepages=new CompanyModulePages();
	 //Add Company with valid details
	 companymodulepages.addCompany("BajajFinsv", "www.bajajfinsv.in");
	 Util.waitTobeVisible(By.xpath("//div[@id=\"company-Input\"]/descendant::div"));
	 String companyname=driver.findElement(By.xpath("//div[@id=\"company-Input\"]/descendant::div")).getText();
	 Assert.assertEquals("BajajFinsv", companyname,"Comapany not added");	
	 // update company details
     companymodulepages.editCompany("9898985565");    
	 String phoneno=driver.findElement(By.xpath("//div[@id=\"-container\"]/descendant::a[1]")).getAttribute("phone");
	 Assert.assertEquals("9865986512", phoneno,"phoneno updated");
	 //detete company
	 companymodulepages.deletCompany();
   }
}
