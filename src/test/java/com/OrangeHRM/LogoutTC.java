package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;

import com.OrangeHRMTC.Util;

public class LogoutTC extends LoginTesting{

public static void Logout()
{
	driver.findElement(By.id("welcome")).click();
	Util.waitTobeClickable(By.linkText("Logout"));
	driver.findElement(By.linkText("Logout")).click();
	if(driver.findElement(By.id("txtUsername")).isDisplayed())
	{
		System.out.println("user get successfully logout");
	}
	else
	{
		throw new ElementNotVisibleException ("test failed");
	}
}

}
