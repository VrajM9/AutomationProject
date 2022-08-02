package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.OrangeHRMTC.Baseclass;

public class ActionsEx extends Baseclass{

	public static void main(String[] args) {
		Baseclass.launchBrowser("chrome");
		driver.get("https://realestateautomation.agilecrm.com/");
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("automation@yopmail.com");
		WebElement username=driver.findElement(By.xpath("//input[@name=\"password\"]"));
//		username.click();
		username.sendKeys("Test1234");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).submit();
		Actions act=new Actions(driver);
		WebElement deals=driver.findElement(By.id("dealsmenu"));
		act.click(deals).build().perform();
		WebElement AutoTest=driver.findElement(By.id("5003049292070912"));
		WebElement prospects=driver.findElement(By.id("deals-by-paging-relax-model-list"));
		act.dragAndDrop(AutoTest, prospects).build().perform();
		
		

	}

}

