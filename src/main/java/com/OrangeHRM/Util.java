package com.OrangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class Util extends Baseclass {
public static void waitTobeClickable(By element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
public static void waitTobeVisible(By element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(element));
}
public static void fluentWait(final WebElement element)
{
	Wait<WebDriver> Fwait =new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
	.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
	Fwait.until(new Function<WebDriver,WebElement>(){
		public WebElement apply(WebDriver driver) {
		System.out.println("checking the element available");
		return element;
		}
		
	});
	}
 public static void selectFromDropdown(WebElement element,int index)
 {
	 Select select =new Select(element);
	 select.selectByIndex(index);
 }
 public static void validation(String Expectedresult,String ActualResult) throws Exception
 {
	 if (Expectedresult.equals(ActualResult))
	 {
		 System.out.println("Expected result:' "+Expectedresult+" 'matching to actual result:' "+ActualResult+" 'Test passed"); 
	 }
	 else
	 {
		throw new Exception("Expected result:' "+Expectedresult+" 'is not matching to actual result:' "+ActualResult+" 'Test passed"); 
	 }
 }
}
