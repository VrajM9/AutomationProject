package com.realestatecrm.loginPages;

import org.openqa.selenium.By;

import com.OrangeHRM.Baseclass;
import com.OrangeHRM.Util;

public class LoginPage extends Baseclass {
	public void login(String username,String password)
	{
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("// input[@value=\"Sign In\"]")).submit();
	}
	public void logout()
	{
		 driver.findElement(By.xpath("//a[@class=\" clear\"]")).click();
		 Util.waitTobeClickable(By.xpath("//a[contains(@class,\"logout-in-modal\")]"));
		 driver.findElement(By.xpath("//a[contains(@class,\"logout-in-modal\")]")).click();
	}

}
