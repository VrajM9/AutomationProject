package com.OrangeHRM.LoginPages;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.OrangeHRMTC.Baseclass;

public class EmpListPages extends Baseclass
{   By pimmodule=By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b");
    By emplisttab=By.id("menu_pim_viewEmployeeList");
		public Map<String,Object> addEmp(String firstName,String lastName,boolean ifuser,String username,String password) throws Exception
		{
		driver.findElement(pimmodule).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys(lastName);
		String empid=driver.findElement(By.id("employeeId")).getAttribute("value");
		Map<String,Object> empdetails=new HashMap<String,Object>();
		empdetails.put("firstname", firstName);
		empdetails.put("lastName", lastName);
		empdetails.put("empid", empid);
		if (ifuser)
		{
			driver.findElement(By.id("user_name")).sendKeys(username);
			driver.findElement(By.id("user_password")).sendKeys(password);
			driver.findElement(By.id("re_password")).sendKeys(password);
		}
		    driver.findElement(By.id("btnSave")).click();
		    return empdetails;
		}
		public void searchEmp(Map<String,Object> empdetails )
		{ Object firstname= empdetails.get("firstname");
		Object empid=empdetails.get("empid");
		String firstname1=(String)firstname;
		String empid1=(String)empid;
			driver.findElement(emplisttab).click();
			WebElement firstnametextfield=driver.findElement(By.id("empsearch_employee_name_empName"));
			firstnametextfield.click();
			firstnametextfield.clear();
			firstnametextfield.sendKeys(firstname1);
			driver.findElement(By.id("empsearch_id")).sendKeys(empid1);
			driver.findElement(By.id("searchBtn")).click();
		}
		public void editEmp()
		{
			driver.findElement(By.xpath("//div[@id=\"tableWrapper\"]/descendant::td[2]/a")).click();
			driver.findElement(By.id("btnSave")).click();
		}
		public void deletEmp()
		{
			driver.findElement(By.xpath("//div[@id=\"tableWrapper\"]/descendant::td[1]/input")).click();
			driver.findElement(By.id("btnDelet")).click();
			driver.findElement(By.id("btnDelet")).click();
		}
		}

