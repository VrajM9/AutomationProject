package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DeletEmpTC extends LoginTesting {
	public static void deletEmp()
	{
	WebElement checkbox=driver.findElement(By.id("ohrmList_chkSelectRecord_54"));
	checkbox.click();
	driver.findElement(By.id("btnDelete")).click();
	driver.findElement(By.id("dialogDeleteBtn")).click();
	if (driver.findElement(By.className("message success fadable")).isDisplayed())
	{
		String deletmsg=driver.findElement(By.className("message success fadable")).getText();
	
    if (deletmsg=="Successfully Deleted")
    {
    	System.out.println(deletmsg+" validation message is displayed");
    }
    
	}
	
	
	
	}

}
