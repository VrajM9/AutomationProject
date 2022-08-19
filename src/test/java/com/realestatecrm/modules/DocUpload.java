package com.realestatecrm.modules;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.OrangeHRMTC.Baseclass;
import com.OrangeHRMTC.Util;
import com.realestatecrm.loginPages.LoginPage;

public class DocUpload extends Baseclass {

	@BeforeClass
	@Parameters({ "username", "password", "browser" })
	public void beforeClass(String username, String password, String browser) {
		launchBrowser(browser);
		driver.get("https://realestateautomation.agilecrm.com/");
		LoginPage loginPage = new LoginPage();
		loginPage.login(username, password);

	}

	@SuppressWarnings("deprecation")
	@Test
	public void uploadDoc() {
		driver.findElement(By.id("documentsmenu")).click();
		Util.waitTobeClickable(By.xpath("//*[text()=' Add Document']"));
		driver.findElement(By.xpath("//*[text()=' Add Document']")).click();
		Util.waitTobeClickable(By.id("docmsg"));
		driver.findElement(By.id("docmsg")).click();
		Util.waitTobeClickable(By.id("S3"));
		driver.findElement(By.id("S3")).click();
		try {
			Thread.sleep(10000);
			String filePath="C:\\Users\\parag\\Documents\\TestUploadFile.txt";
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\FileUploadScript.exe "+filePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
