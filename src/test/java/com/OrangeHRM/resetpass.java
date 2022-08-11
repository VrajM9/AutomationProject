package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.OrangeHRMTC.Baseclass;

public class resetpass extends Baseclass {
	public static void rstpass(String Empname) throws Exception 
	{
		driver.findElement(By.id("securityAuthentication_userName")).sendKeys(Empname);
	    driver.findElement(By.id("btnSearchValues")).click();
	    WebElement SecurtAuth=driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[3]/div[1]"));
	    if (SecurtAuth.isDisplayed())
	    {
	    	System.out.println("security Authintication message should be displayed");
	    	
	    }
	    else
	    {
	    	throw new Exception("test fail");
	    }

	}
}
