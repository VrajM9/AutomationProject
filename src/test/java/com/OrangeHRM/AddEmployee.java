package com.OrangeHRM;

import org.openqa.selenium.By;

import com.OrangeHRMTC.Baseclass;

public class AddEmployee extends Baseclass {
	public static void addEmp(String firstName,String lastName )//,String id) 
	{
driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b")).click();
driver.findElement(By.id("btnAdd")).click();
driver.findElement(By.id("firstName")).sendKeys(firstName);
driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys(lastName);
//driver.findElement(By.id("employeeId")).clear();
//driver.findElement(By.id("employeeId")).sendKeys(id);
driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
if(driver.findElement(By.xpath("//*[@id=\"pdMainContainer\"]/div[1]/h1")).isDisplayed())
{
	System.out.println("Personal details page is displaying");
	driver.findElement(By.id("menu_pim_addEmployee")).click();
}
else if(driver.findElement(By.xpath("//div[@class=\"message warning fadable\"]")).isDisplayed())
{
	System.out.println("Warning message is displayed");
	driver.findElement(By.id("menu_pim_addEmployee")).click();
}
else
{
	System.out.println("test failed");
	driver.findElement(By.id("menu_pim_addEmployee")).click();
	
}

}
}
