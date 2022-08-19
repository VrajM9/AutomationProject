package com.OrangeHRMTC;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

  public  static WebDriver driver;
  public static ExtentTest Logger;
  public String executionReports;
  public String methodName;
    public static void launchBrowser(String browser)
    {
    	switch(browser)
    	{
    		case "chrome": 
    			WebDriverManager.chromedriver().setup();
    		driver=new ChromeDriver();	
    	}
    }
public void takeScreenShot(String dstFilePath)
{
	try {TakesScreenshot screenShot=(TakesScreenshot)driver;
	File srcFile=screenShot.getScreenshotAs(OutputType.FILE);
	File dstFile=new File(dstFilePath);
	
		FileUtils.copyFile(srcFile, dstFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
}
