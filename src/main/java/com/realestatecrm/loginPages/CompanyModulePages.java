package com.realestatecrm.loginPages;

import org.openqa.selenium.By;

import com.OrangeHRMTC.Baseclass;
import com.OrangeHRMTC.Util;

public class CompanyModulePages extends Baseclass {
	public void addCompany(String companyname, String companywebsite)
	 {  
	   	driver.findElement(By.id("companiesmenu")).click();
	   	driver.findElement(By.xpath("//div[@id=\"view-list\"]/button[1]/i")).click();
	    Util.waitTobeClickable(By.xpath("//input[@id=\"company_name\"]"));
	   	driver.findElement(By.xpath("//input[@id=\"company_name\"]")).sendKeys(companyname);
	   	driver.findElement(By.xpath("//input[@id=\"company_url\"]")).sendKeys(companywebsite);
	   	driver.findElement(By.id("company_validate")).click();
	 }
	public void editCompany(String phoneno) 
	 {
		 Util.waitTobeClickable(By.id("companiesmenu"));
		 driver.findElement(By.id("companiesmenu")).click();
		 driver.findElement(By.xpath("//tbody[@id=\"companies-list-view-model-list\"]/descendant::a[1]")).click();
		 Util.waitTobeClickable(By.xpath("//i[@class=\"material-icons edit\"]"));
		 driver.findElement(By.xpath("//i[@class=\"material-icons edit\"]")).click();
		 driver.findElement(By.id("phone")).sendKeys(phoneno);
		 driver.findElement(By.id("company-update")).click();
	 }
	public void deletCompany()
	 {   
		 driver.findElement(By.xpath("//i[contains(@class,\"material-icons more\")]")).click();
		 Util.waitTobeClickable(By.id("company-actions-delete"));
		 driver.findElement(By.id("company-actions-delete")).click();
		 driver.findElement(By.id("success_callback")).click();
	 }
}
