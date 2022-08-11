package com.realestatecrm.loginPages;

import org.openqa.selenium.By;

import com.OrangeHRMTC.Baseclass;
import com.OrangeHRMTC.Util;

public class DealsModuleLoginPages extends Baseclass {
	
	public void addCompany()
	{
		Util.waitTobeClickable(By.id("dealsmenu"));
		  driver.findElement(By.id("dealsmenu")).click();
		  Util.waitTobeClickable(By.id("name"));
		  driver.findElement(By.id("name")).sendKeys("Test123");
		  driver.findElement(By.xpath("//div[@id=\"currencies-list\"]//following::input")).sendKeys("8045120");
		  driver.findElement(By.id("opportunity_validate")).click();
	}
	
	

}
