package com.realestatecrm.loginPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.OrangeHRMTC.Baseclass;
import com.OrangeHRMTC.Util;

public class ContactModulePages extends Baseclass{
	public void addContact(String firstname,String lastname,String phoneno)
	{     
		Util.waitTobeClickable(By.id("contactsmenu"));
		driver.findElement(By.id("contactsmenu")).click();
	   Util.waitTobeClickable(By.xpath("//div[@id=\"view-list\"]/descendant::i"));
	   driver.findElement(By.xpath("//div[@id=\"view-list\"]/descendant::i")).click();
	   Util.waitTobeClickable(By.id("fname"));
	   driver.findElement(By.id("fname")).sendKeys(firstname);
	   driver.findElement(By.id("lname")).sendKeys(lastname);
	   driver.findElement(By.id("phone")).sendKeys(phoneno);
	   driver.findElement(By.id("person_validate")).click();
	   driver.navigate().refresh();
	}
	public void editContact(String phoneno)
	{   Util.waitTobeClickable(By.id("contactsmenu"));
    driver.findElement(By.id("contactsmenu")).click();
	Util.waitTobeVisible(By.xpath("//tbody[@id=\"contacts-list-view-model-list\"]/descendant::i[2]"));
	driver.findElement(By.xpath("//tbody[@id=\"contacts-list-view-model-list\"]/descendant::i[2]")).click();
	Util.waitTobeVisible(By.xpath("//*[@id=\"contacts-list-view-model-list\"]/descendant::a[6]"));
	driver.findElement(By.xpath("//*[@id=\"contacts-list-view-model-list\"]/descendant::a[6]")).click();
	WebElement phoneno1=driver.findElement(By.id("phone"));
	phoneno1.click();
	phoneno1.sendKeys(phoneno);
	driver.findElement(By.id("update"));
	}
	public void deletContact()
	{
		Util.waitTobeClickable(By.id("contactsmenu"));
		driver.findElement(By.id("contactsmenu")).click();
		Util.waitTobeVisible(By.xpath("//tbody[@id=\"contacts-list-view-model-list\"]/descendant::i[2]"));
		driver.findElement(By.xpath("//tbody[@id=\"contacts-list-view-model-list\"]/descendant::i[2]")).click();
		Util.waitTobeVisible(By.xpath("//*[@id=\"contacts-list-view-model-list\"]/descendant::a[7]"));
		driver.findElement(By.xpath("//*[@id=\"contacts-list-view-model-list\"]/descendant::a[7]")).click();
	    Util.waitTobeVisible(By.linkText("Yes"));
		driver.findElement(By.linkText("Yes")).click();
	}

}
