package com.realestatecrm.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.OrangeHRMTC.Baseclass;
import com.OrangeHRMTC.Util;
import com.realestatecrm.loginPages.ContactModulePages;

import junit.framework.Assert;

public class ContactsModuleTC extends Baseclass {
	@Test(priority=1,groups=("agilecrmTC"))
	public void contactModuleTC()
	{
	ContactModulePages contactmodulepages=new ContactModulePages();
	contactmodulepages.addContact("Narendra", "Modi", "9865781245");
       Util.waitTobeVisible(By.id("contact_name"));
       String contactname=driver.findElement(By.id("contact_name")).getText();
     Assert.assertEquals("Narendra Modi", contactname);
     contactmodulepages.editContact("9565565644");
       contactmodulepages.deletContact();
     driver.findElement(By.xpath("//tbody[@id=\\\"contacts-list-view-model-list\\\"]/descendant::i[1]")).click();
     driver.findElement(By.xpath("//button[text()=\"Delete\"]")).click();	
}
}