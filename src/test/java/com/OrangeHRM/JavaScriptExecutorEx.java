package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorEx extends Baseclass {

	public static void main(String[] args) {
		Baseclass.launchBrowser("chrome");
		driver.navigate().to("https://realestateautomation.agilecrm.com/");
		driver.findElement(By.name("email")).sendKeys("automation@yopmail.com");
		driver.findElement(By.name("password")).sendKeys("Test1234");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement signinbtn=driver.findElement(By.xpath("//input[@value=\"Sign In\"]"));
		js.executeScript("arguments[0].click();",signinbtn);
		System.out.println(js.executeScript("return document.Domain"));
		System.out.println(js.executeScript("return document.URl"));
		Util.waitTobeVisible(By.xpath(("//*[@id=\"ui-id-1-1\"]/div[1]/h4/span")));
		js.executeScript("window.scrollBy(0,250);");
	}

}
 