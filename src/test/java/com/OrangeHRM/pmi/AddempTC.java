package com.OrangeHRM.pmi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.OrangeHRM.Baseclass;
import com.OrangeHRM.LoginPages.LoginPage;

public class AddempTC extends Baseclass {
    String empid;
	@BeforeClass(groups=("OrnagehrmTC"))
	@Parameters({"username","password","browser","url"})
	public void beforeclass(String username,String password,String browser,String url)
	{
		  launchBrowser(browser);
		  driver.get(url);
		  LoginPage loginpage=new LoginPage();
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
    driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
    if (ifuser)
    {
    	driver.findElement(By.id("user_name")).sendKeys("Barak123");
    	driver.findElement(By.id("user_password")).sendKeys("barak123");
    	driver.findElement(By.id("re_password")).sendKeys("barak123");
    }
        driver.findElement(By.id("btnSave")).click();
    
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
    	driver.findElement(By.xpath("//div[@id=\"tableWrapper\"]/descendant::td[2]/a")).click();
    	driver.findElement(By.id("btnSave")).click();
    }
    @Test(priority=4,dependsOnMethods="editEmp",groups="OrnagehrmTC")
    public void deleteEmp()
    {
    	driver.findElement(By.xpath("//div[@id=\"tableWrapper\"]/descendant::td[1]/input")).click();
    	driver.findElement(By.id("btnDelet")).click();
    	driver.findElement(By.id("btnDelet")).click();
    }
}
