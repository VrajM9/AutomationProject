package com.OrangeHRM;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Goibibo extends Baseclass {

	public static void main(String[] args) {
		launchBrowser("chrome");
		driver.get("https://www.goibibo.com/");
		WebElement forex=driver.findElement(By.xpath("//a[contains(@href, \"https://bookmyforex.com/\")]"));
		forex.click();
//		WebElement globalinr=driver.findElement(By.xpath("/html/body/section[2]/div/div[1]/div/div/ul/li[4]/a"));
//		globalinr.click();
		String forexParentadd=driver.getWindowHandle();
		Set <String>forexadd=driver.getWindowHandles();
		
	for(String forexadd1:forexadd)
	{
		System.out.println(forexadd1);
	}	
		
     System.out.println(driver.getTitle());       
	}

}

