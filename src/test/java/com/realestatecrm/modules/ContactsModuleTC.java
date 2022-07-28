package com.realestatecrm.modules;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.OrangeHRM.Baseclass;
import com.OrangeHRM.Util;

public class ContactsModuleTC extends Baseclass {
	@Test(priority=1)
     public void addContact() throws Exception	
	{  Util.waitTobeClickable(By.id("contactsmenu"));
	   driver.findElement(By.id("contactsmenu")).click();
	   Util.waitTobeClickable(By.xpath("//div[@id=\"view-list\"]/descendant::i"));
       driver.findElement(By.xpath("//div[@id=\"view-list\"]/descendant::i")).click();
       Util.waitTobeClickable(By.id("fname"));
       driver.findElement(By.id("fname")).sendKeys("Narendra");
       driver.findElement(By.id("lname")).sendKeys("Modi");
       driver.findElement(By.id("phone")).sendKeys("9898985656");
       driver.findElement(By.id("person_validate")).click();
       Util.waitTobeVisible(By.id("contact_name"));
       String conatctname=driver.findElement(By.id("contact_name")).getText();
       Util.validation("Narendra Modi", conatctname);
	}
	@Test(priority=2,dependsOnMethods="addContact")
	public void deletContact()
	{
		   driver.findElement(By.xpath("//tbody[@id=\\\"contacts-list-view-model-list\\\"]/descendant::i[1]")).click();
		    driver.findElement(By.xpath("//button[text()=\"Delete\"]")).click();
	}

}
