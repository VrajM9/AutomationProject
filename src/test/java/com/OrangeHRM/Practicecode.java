package com.OrangeHRM;
import org.openqa.selenium.By;
import com.OrangeHRMTC.Baseclass;
import com.OrangeHRMTC.Util;
import com.realestatecrm.loginPages.LoginPage;

public class Practicecode extends Baseclass{
	public static void main(String[] args)
	{ launchBrowser("chrome");
	driver.manage().window().maximize();
	driver.navigate().to("https://john6687.agilecrm.com");
	LoginPage loginpage=new LoginPage();
	loginpage.login("john123@yopmail.com", "john123");
		  Util.waitTobeClickable(By.id("dealsmenu"));
		  driver.findElement(By.id("dealsmenu")).click();
		  driver.navigate().refresh();
		  Util.waitTobeClickable(By.xpath("//div[@id=\"deals-action\"]/descendant::button"));
		  driver.findElement(By.xpath("//div[@id=\"deals-action\"]/descendant::button")).click();
     	  Util.waitTobeVisible(By.className(" required form-control"));
		  driver.findElement(By.className(" required form-control")).sendKeys("Test123");
		  driver.findElement(By.xpath("//div[@id=\"currencies-list\"]/following::input[1]")).sendKeys("8045120");
		  driver.findElement(By.id("opportunity_validate")).click();
		  driver.navigate().refresh(); 
		  String dealname=driver.findElement(By.xpath("//ul[@id=\"deals-by-paging-relax-model-list\"]/descendant::a[1]")).getText();
		  System.out.println(dealname);
	}
}
