package com.OrangeHRM.pmi;

import java.util.Map;

import org.testng.annotations.Test;

import com.OrangeHRM.Baseclass;
import com.OrangeHRM.EmpListPage;
import com.OrangeHRM.LoginPages.LoginPage;

public class NewTest extends Baseclass {
	EmpListPage emplistpage;
	LoginPage loginpage;
  @Test(priority=1)
  public void loginTestCase() {
	  launchBrowser("chrome");
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	 loginpage=new LoginPage();
	  loginpage.login("Admin", "admin123");  
//	  loginpage.logout();
  }
  @Test(priority=2,dependsOnMethods="loginTestCase")
  public void addEmployee() throws Exception
  {  loginTestCase();
	  emplistpage=new EmpListPage();
	  Map<String,Object> empdetails= emplistpage.addEmp("ajay","Devgan", false, null, null);
   emplistpage.searchEmp(empdetails);	  
  }
}
