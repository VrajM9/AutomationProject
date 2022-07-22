package com.OrangeHRM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassEx extends Baseclass {

	public static void main(String[] args) throws AWTException {
	Baseclass.launchBrowser("chrome");
	driver.navigate().to("https://www.amazon.in/");
	String parentadd=driver .getWindowHandle();
	Actions act= new Actions(driver);
	WebElement bestseller=driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/descendant::a[1]"));
	act.contextClick(bestseller).build().perform();
	Robot robot=new Robot();
	robot.keyPress(KeyEvent.VK_PAGE_DOWN);
    //robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	robot.keyPress(KeyEvent.VK_ENTER);
	//robot.keyRelease(KeyEvent.VK_ENTER);
	Set<String>windowadd=driver.getWindowHandles();
	for(String adress:windowadd)
	{
		if (!adress.equals(parentadd))
		{
			driver.switchTo().window(adress);
			System.out.println(driver.getTitle());
			driver.close();
			driver.switchTo().window(parentadd);
			System.out.println(driver.getTitle());
		}
	}}
	

	

}

