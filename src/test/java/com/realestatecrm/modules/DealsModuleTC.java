package com.realestatecrm.modules;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.OrangeHRMTC.Baseclass;
import com.OrangeHRMTC.Util;
import com.realestatecrm.loginPages.DealsModuleLoginPages;
import com.realestatecrm.loginPages.LoginPage;

public class DealsModuleTC extends Baseclass {
	DealsModuleLoginPages dealsmodule;
  @Test(priority=1,groups=("agilecrmTC"))
  public void addDeals() throws Exception {
	  dealsmodule.addCompany();
	  driver.navigate().refresh(); 
	  String dealname=driver.findElement(By.xpath("//ul[@id=\"deals-by-paging-relax-model-list\"]/descendant::a[1]")).getText();
	  Util.validation("Test123", dealname);
  }
  @Test(priority=2,dependsOnMethods="addDeals",groups=("agilecrmTC"))
  public void deletDeal() {
//   WebElement deal=driver.findElement(By.xpath("//div[@id=\"New-list-container\"]/descendant::div[2]"));
//	  Actions action=new Actions(driver);
//	  action.dragAndDrop(deal, null);
  }
  @AfterClass()
  public void afterclass()
  {
  	  LoginPage loginpage=new LoginPage();
       loginpage.logout();
         driver.quit();
  }
}
