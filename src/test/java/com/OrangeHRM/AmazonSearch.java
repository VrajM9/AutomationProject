package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.OrangeHRMTC.Baseclass;
import com.OrangeHRMTC.Util;

public class AmazonSearch extends Baseclass {

	public static void main(String[] args) {
		launchBrowser("chrome");
		driver.get("https://www.amazon.in/");
		WebElement searchdropdown=driver.findElement(By.id("searchDropdownBox"));
		Select select=new Select(searchdropdown);
		select.selectByVisibleText("Appliances");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("washing machine");
		WebElement Searchbtn=driver.findElement(By.id("nav-search-submit-button"));
		Util.waitTobeClickable(By.id("nav-search-submit-button"));
		Searchbtn.click();
		for(int i=1;i<24;i++)
		{
			WebElement names=driver.findElement(By.xpath("//div[@id=\"search\"]//following::span[contains(@class,\"a-size-medium a-color-\")]["+i+"]"));
			WebElement price=driver.findElement(By.xpath("//div[@id=\"search\"]/descendant::span[@class=\"a-price-whole\"]["+i+"]"));
			System.out.println(names.getText()+"-:"+price.getText()+"/-");
		}	
 
}
} 
