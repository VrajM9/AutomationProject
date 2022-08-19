package com.OrangeHRM.pmi;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\parag\\Desktop\\Virajm\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/"); // get method will return current loaded page URL. implimentaion in Webdriver interface.
		
		//Selenium Waits
		
	 //1) implicit wait Syntax
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	    
	    
	    
	}    
	}