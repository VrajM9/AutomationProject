  package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.OrangeHRMTC.Baseclass;

public class SearchEmployee extends Baseclass{
	public static void srchEmp(String Empname,String id)
	{
	WebElement searchfld=driver.findElement(By.id("empsearch_employee_name_empName"));
	searchfld.clear();
	searchfld.sendKeys(Empname);
	WebElement searchfld1=driver.findElement(By.id("empsearch_id"));
	searchfld1.clear();
	searchfld1.sendKeys(id);
	
	driver.findElement(By.id("searchBtn")).click();
//	Util.waitTobeClickable(By.id("")););
//	if()
//	{
//		
//	}
//	else
//	{
//		
//	}	
	}
}
