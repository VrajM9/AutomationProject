package com.OrangeHRM.pmi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.OrangeHRM.LoginPages.LoginPage;
import com.OrangeHRMTC.Baseclass;
import com.OrangeHRMTC.Util;

public class AddempTC extends Baseclass {
    String empid;
    LoginPage loginpage;
	@BeforeClass(groups=("OrnagehrmTC"))
	@Parameters({"username","password","browser","url"})
	public void beforeclass(String username,String password,String browser,String url)
	{
		  launchBrowser(browser);
		  driver.get(url);
		   new LoginPage();
		  loginpage.login(username, password); 
	}
    @Test(priority=1,groups="OrnagehrmTC")
    @Parameters("ifuser")
    public void addEmp(boolean ifuser)
    {
    driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b")).click();
    driver.findElement(By.id("btnAdd")).click();
    driver.findElement(By.id("firstName")).sendKeys("Barak");
    driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Obama");
    empid=driver.findElement(By.id("employeeId")).getAttribute("value"); 
    if (ifuser)
    {
    	driver.findElement(By.id("user_name")).sendKeys("Barak123");
    	driver.findElement(By.id("user_password")).sendKeys("barak123");
    	driver.findElement(By.id("re_password")).sendKeys("barak123");
    }
    
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
    
    }
    @Test(priority=2,dependsOnMethods="addEmp",groups="OrnagehrmTC")
    public void searchEmp()
    {
    	driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
    	WebElement firstnametextfield=driver.findElement(By.id("empsearch_employee_name_empName"));
    	firstnametextfield.click();
    	firstnametextfield.clear();
    	firstnametextfield.sendKeys("Barak123");
    	driver.findElement(By.id("empsearch_id")).sendKeys(empid);
    	driver.findElement(By.id("searchBtn")).click();	
    }
    @Test(priority=3,dependsOnMethods="searchEmp",groups="OrnagehrmTC")
    public void editEmp()
    {
    	driver.findElement(By.linkText("Admin")).click();
    	driver.findElement(By.id("btnSave")).click();
    	WebElement gender=driver.findElement(By.id("personal_cmbMarital"));
    	Util.selectFromDropdown(gender, 1);
    	driver.findElement(By.id("btnSave")).click();
    	if(driver.findElement(By.xpath("//div[@id=\"pdMainContainer\"]/descendant::div[3]")).isDisplayed())
    	{String validtaionmsg=driver.findElement(By.xpath("//div[@id=\"pdMainContainer\"]/descendant::div[3]")).getText();
    		System.out.println(validtaionmsg);
    	}
    }
    @Test(priority=4,dependsOnMethods="editEmp",groups="OrnagehrmTC")
    public void deleteEmp()
    {   driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
    	driver.findElement(By.xpath("//div[@id=\"tableWrapper\"]/descendant::td[1]/input")).click();
    	driver.findElement(By.id("btnDelet")).click();
    	driver.findElement(By.id("dialogDeleteBtn")).click();
    }
    @AfterClass
    public void afterClass()
    {
    	new LoginPage();
    	loginpage.logout();
    	driver.quit();
    }
}

