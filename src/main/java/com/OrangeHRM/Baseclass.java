package com.OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

  public  static WebDriver driver;
    public static void launchBrowser(String browser)
    {
    	switch(browser)
    	{
    		case "chrome": 
    			WebDriverManager.chromedriver().setup();
    		driver=new ChromeDriver();	
    	}
    }
}
