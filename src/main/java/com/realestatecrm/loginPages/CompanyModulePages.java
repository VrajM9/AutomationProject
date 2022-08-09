package com.realestatecrm.loginPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.OrangeHRMTC.Baseclass;
import com.OrangeHRMTC.Util;

public class CompanyModulePages extends Baseclass {
	public By companyMenu=By.id("companiesmenu");
	public By addCompanyButton=By.xpath("//div[@id=\"view-list\"]/button[1]/i");
	public By companyNameTextField=By.xpath("//input[@id=\"company_name\"]");
	public By companyUrlTextField=By.xpath("//input[@id=\"company_url\"]");
	public By savebutton=By.id("company_validate");
	public By kebabMenu=By.xpath("//tbody[@id=\"companies-list-view-model-list\"]/descendant::a[1]");
	public By editButton=By.xpath("//i[@class=\"material-icons edit\"]");
	public By phonenoTextField=By.id("phone");
	public By updateButton=By.id("company-update");
	public By KebabMenuInCompanyPage=By.xpath("//i[contains(@class,\"material-icons more\")]");
	public By DeleteButton=By.id("company-actions-delete");
	public By YesButton=By.id("success_callback");
	
	public void addCompany(String companyname, String companywebsite)
	 {  
	   	driver.findElement(companyMenu).click();
	   	driver.findElement(addCompanyButton).click();
	    Util.waitTobeClickable(companyNameTextField);
	   	driver.findElement(companyNameTextField).sendKeys(companyname);
	   	driver.findElement(companyUrlTextField).sendKeys(companywebsite);
	   	driver.findElement(savebutton).click();
	 }
	public void editCompany(String type ,String value, int index) 
	 {
		 Util.waitTobeClickable(companyMenu);
		 driver.findElement(companyMenu).click();
		 driver.findElement(kebabMenu).click();
		 Util.click(editButton);
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
		Util.click(KebabMenuInCompanyPage);
		 driver.findElement(DeleteButton).click();
		 driver.findElement(YesButton).click();
	 }
}
