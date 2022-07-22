package com.OrangeHRM.LoginPages;

import org.openqa.selenium.By;

import com.OrangeHRM.Baseclass;
import com.OrangeHRM.Util;

public class LoginPage extends Baseclass {
public void login(String username,String password)
{
	driver.findElement(By.id("txtUsername")).sendKeys(username);
	driver.findElement(By.id("txtPassword")).sendKeys(password);
	driver.findElement(By.id("btnLogin")).click();
	}
public void logout()
{
	driver.findElement(By.id("welcome")).click();
	Util.waitTobeClickable(By.linkText("Logout"));
	driver.findElement(By.linkText("Logout")).click();
}
}
