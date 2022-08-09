 package com.realestatecrm.loginPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.OrangeHRMTC.Baseclass;
import com.OrangeHRMTC.Util;

public class ContactModulePages extends Baseclass{
	public By contactMenu=By.id("contactsmenu");
	public By addContactButton=By.xpath("//div[@id=\"view-list\"]/descendant::i");
	public By firstNameTextField=By.id("fname");
	public By emailTextfield=By.id("email");
	public By phoneNoTextField=By.id("phone");
	public By saveButton=By.id("person_validate");
	public By yesButton=By.linkText("Yes");
	
	public void addContact(String firstname,String email,String phoneno)
	{     
	   Util.waitTobeClickable(contactMenu);
	   driver.findElement(contactMenu).click();
	   Util.waitTobeClickable(addContactButton);
	   driver.findElement(addContactButton).click();
	   Util.waitTobeClickable(firstNameTextField);
	   driver.findElement(firstNameTextField).sendKeys(firstname);
	   driver.findElement(emailTextfield).sendKeys(email);
	   driver.findElement(phoneNoTextField).sendKeys(phoneno);
	   driver.findElement(saveButton).click();
	   driver.navigate().refresh();
	}
	public void editContact(String phoneno)
	{   Util.waitTobeClickable(contactMenu);
    driver.findElement(contactMenu).click();
	Util.waitTobeVisible(By.xpath("//tbody[@id=\"contacts-list-view-model-list\"]/descendant::i[2]"));
	driver.findElement(By.xpath("//tbody[@id=\"contacts-list-view-model-list\"]/descendant::i[2]")).click();
	Util.waitTobeVisible(By.xpath("//*[@id=\"contacts-list-view-model-list\"]/descendant::a[6]"));
	driver.findElement(By.xpath("//*[@id=\"contacts-list-view-model-list\"]/descendant::a[6]")).click();
	WebElement phoneno1=driver.findElement(phoneNoTextField);
	phoneno1.click();
	phoneno1.sendKeys(phoneno);
	driver.findElement(By.id("update"));
	}
	public void deletContact()
	{
		Util.waitTobeClickable(contactMenu);
		driver.findElement(contactMenu).click();
		Util.waitTobeVisible(By.xpath("//tbody[@id=\"contacts-list-view-model-list\"]/descendant::i[2]"));
		driver.findElement(By.xpath("//tbody[@id=\"contacts-list-view-model-list\"]/descendant::i[2]")).click();
		Util.waitTobeVisible(By.xpath("//*[@id=\"contacts-list-view-model-list\"]/descendant::a[7]"));
		driver.findElement(By.xpath("//*[@id=\"contacts-list-view-model-list\"]/descendant::a[7]")).click();
	    Util.waitTobeVisible(yesButton);
		driver.findElement(yesButton).click();
	}

}
