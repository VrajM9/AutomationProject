package com.OrangeHRM;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmpListPage extends Baseclass {
public Map<String,Object> addEmp(String firstName,String lastName,boolean ifuser,String username,String password) throws Exception
{
driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b")).click();
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
public void searchEmp(String firstname,String empid)
{
	driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
	WebElement firstnametextfield=driver.findElement(By.id("empsearch_employee_name_empName"));
	firstnametextfield.click();
	firstnametextfield.clear();
	firstnametextfield.sendKeys(firstname);
	driver.findElement(By.id("empsearch_id")).sendKeys(empid);
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
