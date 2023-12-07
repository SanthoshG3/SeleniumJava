package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Project extends PropertiesFile {
	
		static WebDriver driver;
		
		//setting up the driver
		public WebDriver setupDriver(String browser1)
		{
			String browser=browser1;
			driver=BrowserSetup.getWebDriver(browser);
			System.out.println(driver.getTitle()); //getting the page title
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return driver;
		}
		
		public void setElements()   //setting up the elements
		{
			
			//readProperties(); //calling the readProperties function
			
			//locating to the login/register button
			driver.findElement(By.xpath("//*[@id=\"navbar_0_6\"]/div[2]/ul/li[3]/a")).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			driver.findElement(By.id("email")).click();
			
			
			//sending the keys to email text filed
			driver.findElement(By.id("email")).sendKeys(prop.getProperty("email"));
			
			 driver.findElement(By.id("password")).click();
			 try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
			 
			 //sending the keys to password text field
			 driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
			 
			 //after entering keys to email and password fields click on login button
			 driver.findElement(By.xpath("//button[text()='Login']")).click();
			 try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 //getting the error message and storing in actuval error variable
		    String actual_error= driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible fade show']")).getText();
			 
		    System.out.println(actual_error); //printing error message on console
		    
			String excepted_error="Error: Email or password is incorrect!"; 
			
			if(actual_error.contains(excepted_error))//verifying the error message
			System.out.println("Test case passed");
			else {
		  System.out.println("Test case Failed");
			}
		}
		
		public void closeBrowser()
		{
			driver.quit();
		}
		
		public static void main(String args[])
		{
			readProperties();
		 Project min=new Project(); //creating the object for project class
		 min.setupDriver("chrome");
		 min.setElements();
		 min.closeBrowser(); //closing the driver
		 
		 min.setupDriver("firefox");
		 min.setElements();
		 min.closeBrowser(); //closing the driver
		}

	
}



	



