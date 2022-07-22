package com.OrangeHRM;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.OrangeHRM.LoginPages.LoginPage;

public class OrangeHrmAutomationTC extends Baseclass {

	public static void main(String[] args) throws Exception {
		launchBrowser("chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		LoginPage loginpage=new LoginPage();
		loginpage.login("Admin", "admin123");
		EmpListPage emplistpage=new EmpListPage();
Map<String,Object> employeedetails=emplistpage.addEmp("Donald", "Trump", false, null, null);
Object firstname= employeedetails.get("firstname");
Object lastname= employeedetails.get("lastname");
Object empid=employeedetails.get("empid");
String lastname1=(String)lastname;
String firstname1=(String)firstname;
String empid1=(String)empid;
emplistpage.searchEmp(firstname1, empid1);
String addedempid=driver.findElement(By.xpath("//div[@id=\"tableWrapper\"]/descendant::td[2]/a")).getText();
String addedfirstname=driver.findElement(By.xpath("//div[@id=\"tableWrapper\"]/descendant::td[3]/a")).getText();
Util.validation(empid1, addedempid);
Util.validation(firstname1, addedfirstname);
emplistpage.editEmp();
WebElement MartialStatus=driver.findElement(By.id("personal_cmbMarital"));
Util.selectFromDropdown(MartialStatus, 1);
String selectedvalue=driver.findElement(By.xpath("/select[@id=\"personal_cmbMaritial\"]/option[2]")).getAttribute("selected");
Util.validation("selected", selectedvalue);
emplistpage.deletEmp();
if(driver.findElement(By.className("message success fadable")).isDisplayed())
{
	String deletmsg=driver.findElement(By.className("message success fadable")).getText();
	if(deletmsg=="Successfully Deleted")
	{
		System.out.println(deletmsg+"validation nessage is displayed");
	}
	else
	{
		throw new Exception("validation message is not matching"+deletmsg);
	}
}

	}

}
