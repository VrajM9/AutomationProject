package com.realestatecrm.modules;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.OrangeHRMTC.Baseclass;
import com.OrangeHRMTC.Util;
import com.realestatecrm.loginPages.ContactModulePages;
import com.realestatecrm.loginPages.LoginPage;
import junit.framework.Assert;
public class ContactsModuleTC extends Baseclass {
	ContactModulePages contactmodulepages;
	@BeforeClass(groups = ("agilecrmTC"))
	@Parameters({ "username", "password", "url", "browser" })
	public void beforeclass(String username, String password, String url, String browser) {
		LoginPage loginpage = new LoginPage();
		launchBrowser(browser);
		driver.manage().window().maximize();
		driver.get(url);
		loginpage.login(username, password);
	}
	@Test(priority=1, groups=("agilecrmTC"))
	public void addContactValidDetails() {
		// Add Contact with valid details
		contactmodulepages=new ContactModulePages();
		contactmodulepages.addContact("Narendra", "Narendra@gmail.com", "9865781245");
		Util.waitTobeVisible(By.id("contact_name"));
		String contactname = driver.findElement(By.id("contact_name")).getText();
		Assert.assertEquals("Narendra Modi", contactname);
	}	
	@Test(priority=2, groups=("agilecrmTC"))
    public void addContactWithExitingDetails(){
		// Add contact with already existing details
		contactmodulepages.addContact("Narendra", "Narendra@gmail.com", "9865781245");
	    WebElement validationMessage = driver.findElement(By.xpath("//div[@class=\"alert alert-danger\"]"));
        if (validationMessage.isDisplayed()) {
        String message = validationMessage.getText();
		Assert.assertEquals("Sorry, duplicate contact found with the same email address.", message,"Validation message is not displayed");
			}
    }
	@Test(priority=3,groups=("agilecrmTC"))	
	public void addContactWithNullDetails()
	{	 //Add contact with null inputs
		contactmodulepages.addContact("", "", "");
		WebElement mandotoryMessage = driver.findElement(By.xpath("//input[@id=\"fname\"]/following-sibling::span"));
		if (mandotoryMessage.isDisplayed()) {
			String message1 = mandotoryMessage.getText();
			Assert.assertEquals("This field is required.", message1,"Mandotory field Validation message is not displayed");
	}
}
     @Test(priority = 4, groups = ("agilecrmTC"))
	public void editContactTc() {
		new ContactModulePages();
		// update phone no to contact
		contactmodulepages.editContact("8989895645");
		WebElement phoneno = driver.findElement(By.xpath("//a[@class=\"contact-make-call info-text\"]"));
		if (phoneno.isDisplayed()) {
			String contactphone = phoneno.getText();
			Assert.assertEquals("8989895645", contactphone, "Contact not added");
		}	}
     @Test(priority=5,groups=("agilecrmTC"))
     public void deleteContact() {// delete contact from contact list
     contactmodulepages.deletContact();
     driver.findElement(By.id("trashmenu")).click();
     List<WebElement>contactnames=driver.findElements(By.xpath("//a[contains(@class,\"text-cap custom\")]"));
     for(WebElement contacts:contactnames)
     {
    	 String deletedConatactNames=contacts.getText();
    	 if(deletedConatactNames.equals("Narendra"))
    	 {
    		 break;
    	 }
     }
        }
     
   }
   