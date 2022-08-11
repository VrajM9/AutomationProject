package com.OrangeHRM;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.OrangeHRM.LoginPages.EmpListPages;
import com.OrangeHRM.LoginPages.LoginPage;
import com.OrangeHRMTC.Baseclass;
import com.OrangeHRMTC.Util;

public class OrangeHrmAutomationTC extends Baseclass {

	public static void main(String[] args) throws Exception {
		launchBrowser("chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		LoginPage loginpage=new LoginPage();
		loginpage.login("Admin", "admin123");
		EmpListPages emplistpages=new EmpListPages();
Map<String,Object> employeedetails=emplistpages.addEmp("Donald", "Trump", false, null, null);
Set employee=employeedetails.entrySet();
Iterator i=employee.iterator();
while(i.hasNext())
{
	String empname=(String)i.next();
	Util.validation(empname, "Donald");
}
emplistpages.searchEmp(employeedetails);
String addedempid=driver.findElement(By.xpath("//div[@id=\"tableWrapper\"]/descendant::td[2]/a")).getText();
String addedfirstname=driver.findElement(By.xpath("//div[@id=\"tableWrapper\"]/descendant::td[3]/a")).getText();
//Util.validation(empid1, addedempid);
//Util.validation(firstname1, addedfirstname);
emplistpages.editEmp();
WebElement MartialStatus=driver.findElement(By.id("personal_cmbMarital"));
Util.selectFromDropdown(MartialStatus, 1);
String selectedvalue=driver.findElement(By.xpath("/select[@id=\"personal_cmbMaritial\"]/option[2]")).getAttribute("selected");
Util.validation("selected", selectedvalue);
emplistpages.deletEmp();
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
