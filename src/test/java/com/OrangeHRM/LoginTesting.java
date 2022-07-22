  package com.OrangeHRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTesting extends Baseclass {

	public static void login(String username, String password) throws Exception
     {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		WebElement validationMsg=driver.findElement(By.id("spanMessage"));
		
		if (validationMsg.isDisplayed())
		{ String invalidmsg=driver.findElement(By.id("spanMessage\"")).getText();
		switch(invalidmsg)
		{	case "Invalid credentials" :
			System.out.println(invalidmsg+"invalid credentials validation message should be displayed");	
			driver.navigate().refresh();
			break;
		case "Password cannot be empty" :
			System.out.println(invalidmsg+"invalid credentials validation message should be displayed");
			driver.navigate().refresh();
			break;
		case "Username cannot be empty" :
			System.out.println(invalidmsg+"invalid credentials validation message should be displayed");	
			driver.navigate().refresh();
			break;
			default :
				throw new Exception("test case is fail");
		}
		}
		else
		{
			System.out.println("test failed");
		}
	
     }
	public static void main(String[] args)throws Exception
      {// set the chrome driver
	   launchBrowser("chrome");
		driver.get("https://opensource-demo.orangehrmlive.com/");
    // valid username and invalid password
	login("Akash", "Abc1234");
	// invalid username and valid password
    login("ABC","admin123");
    // invalid credentials
    login("Akash","akash234");
    // null inputs in the username and password text field.
    login("","");
    // null inputs in username and valid password
    login("","akash234");
    // valid username and null password
    login("Admin","");
    // Verifying the forgot password link
    driver.findElement(By.xpath("//a[text()=\"Forgot your password?\"]")).click();
    // verifying by Employee name 
   resetpass. rstpass("Donald");
    // verifying by null inputs
   resetpass. rstpass("");
    driver.navigate().back();
    driver.navigate().back();
    driver.navigate().back();
    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
   	driver.findElement(By.id("txtPassword")).sendKeys("admin123");
   	driver.findElement(By.id("btnLogin")).click();
  	WebElement DashBoard=driver.findElement(By.id("menu_dashboard_index"));
   	if (DashBoard.isDisplayed())
   	{
   		System.out.println("Successfully login");	
   	}
   	else
   	{
   	     System.out.println("unsuccesfull login");
   	}
	driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b")).click();
	// Employee search with valid employee name and valid id
	SearchEmployee.srchEmp("Mahi", "007");
	// Employee search with null inputs
	SearchEmployee.srchEmp("","");
	// Add Employee with employee details
	AddEmployee.addEmp("MahendraSingh","Dhoni");
	// Add employee with same details of already present employee
	AddEmployee.addEmp("viraj","Mandavkar");	
	//Add employee with null inputs
	AddEmployee.addEmp("","");
	// Delet Emp 
	DeletEmpTC.deletEmp();
	// logout 
	LogoutTC.Logout();
	driver.close();
	driver.quit();
	}
   
}

