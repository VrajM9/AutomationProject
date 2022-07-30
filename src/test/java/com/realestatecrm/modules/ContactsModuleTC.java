package com.realestatecrm.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.OrangeHRM.Baseclass;
import com.OrangeHRM.Util;

public class ContactsModuleTC extends Baseclass {
	@Test(priority=1,groups=("agilecrmTC"))
     public void addContact() throws Exception	
	{  Util.waitTobeClickable(By.id("contactsmenu"));
	   driver.findElement(By.id("contactsmenu")).click();
	   Util.waitTobeClickable(By.xpath("//div[@id=\"view-list\"]/descendant::i"));
       driver.findElement(By.xpath("//div[@id=\"view-list\"]/descendant::i")).click();
      WebElement lastname=driver.findElement(By.id("lname"));
      lastname.click();
      lastname.sendKeys("Modi");
      WebElement phoneno=driver.findElement(By.id("phone"));
      phoneno.click();
      phoneno.sendKeys("9898985656");
      WebElement firstname=driver.findElement(By.id("fname"));
      firstname.click();
      firstname.sendKeys("Narendra");
       driver.findElement(By.id("person_validate")).click();
       Util.waitTobeVisible(By.id("contact_name"));
       String conatctname=driver.findElement(By.id("contact_name")).getText();
       Util.validation("Narendra Modi", conatctname);
	}
	@Test(priority=2,dependsOnMethods="addContact",groups=("agilecrmTC"))
	public void deletContact()
	{
		   driver.findElement(By.xpath("//tbody[@id=\\\"contacts-list-view-model-list\\\"]/descendant::i[1]")).click();
		    driver.findElement(By.xpath("//button[text()=\"Delete\"]")).click();
	}
}
