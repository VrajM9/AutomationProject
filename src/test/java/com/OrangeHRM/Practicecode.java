package com.OrangeHRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.OrangeHRMTC.Baseclass;
import com.OrangeHRMTC.Util;
import com.realestatecrm.loginPages.LoginPage;

public class Practicecode extends Baseclass{
	public static void main(String[] args)
	{ launchBrowser("chrome");
	driver.manage().window().maximize();
	driver.navigate().to("https://john6687.agilecrm.com");
	LoginPage loginpage=new LoginPage();
	loginpage.login("john123@yopmail.com", "john123");
	 Util.waitTobeClickable(By.id("contactsmenu"));
	    driver.findElement(By.id("contactsmenu")).click();
		Util.waitTobeVisible(By.xpath("//tbody[@id=\"contacts-list-view-model-list\"]/descendant::i[2]"));
		driver.findElement(By.xpath("//tbody[@id=\"contacts-list-view-model-list\"]/descendant::i[2]")).click();
		Util.waitTobeVisible(By.xpath("//*[@id=\"contacts-list-view-model-list\"]/descendant::a[6]"));
		driver.findElement(By.xpath("//*[@id=\"contacts-list-view-model-list\"]/descendant::a[6]")).click();
		WebElement phoneno=driver.findElement(By.id("phone"));
		phoneno.click();
		phoneno.sendKeys("95658956");
		driver.findElement(By.id("update"));
	}
}
