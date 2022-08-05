package com.realestatecrm.loginPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.OrangeHRMTC.Baseclass;
import com.OrangeHRMTC.Util;

public class CompanyModulePages extends Baseclass {
	By companyMenu=By.id("companiesmenu");
	By addCompanyButton=By.xpath("//div[@id=\"view-list\"]/button[1]/i");
	By companyNameTextField=By.xpath("//input[@id=\"company_name\"]");
	By companyUrlTextField=By.xpath("//input[@id=\"company_url\"]");
	By savebutton=By.id("company_validate");
	By kebabMenu=By.xpath("//tbody[@id=\"companies-list-view-model-list\"]/descendant::a[1]");
	By editButton=By.xpath("//i[@class=\"material-icons edit\"]");
	By phonenoTextField=By.id("phone");
	By updateButton=By.id("company-update");
	By KebabMenuInCompanyPage=By.xpath("//i[contains(@class,\"material-icons more\")]");
	By DeleteButton=By.id("company-actions-delete");
	By YesButton=By.id("success_callback");
	
	public void addCompany(String companyname, String companywebsite)
	 {  
	   	driver.findElement(companyMenu).click();
	   	driver.findElement(addCompanyButton).click();
	    Util.waitTobeClickable(By.xpath("//input[@id=\"company_name\"]"));
	   	driver.findElement(companyNameTextField).sendKeys(companyname);
	   	driver.findElement(companyUrlTextField).sendKeys(companywebsite);
	   	driver.findElement(savebutton).click();
	 }
	public void editCompany(String type ,String value, int index) 
	 {
		 Util.waitTobeClickable(companyMenu);
		 driver.findElement(companyMenu).click();
		 driver.findElement(kebabMenu).click();
		 Util.waitTobeClickable(editButton);
		 driver.findElement(editButton).click();
		switch(type)
		{
		case "phone":
		 driver.findElement(phonenoTextField).sendKeys(value);
		 break;
		case "email":
		driver.findElement(By.id("type")).sendKeys(value);
	   	 break;
		case "Dropdown":
			WebElement countryDropDown=driver.findElement(By.id("country"));
			Select select=new Select(countryDropDown);
			select.selectByIndex(index);	
	 }
		 driver.findElement(updateButton).click();
	 }
	public void deletCompany()
	 {   driver.findElement(companyMenu);
		 driver.findElement(KebabMenuInCompanyPage).click();
		 Util.waitTobeClickable(DeleteButton);
		 driver.findElement(DeleteButton).click();
		 driver.findElement(YesButton).click();
	 }
}
