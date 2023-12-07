package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSetup extends PropertiesFile {
	private static WebDriver driver;
	public static  WebDriver getWebDriver(String browser1){
		
		/*readProperties();
		String browser;
		
		System.out.println("Enter the Browser Name[chrome/firefox] :");
		Scanner sc = new Scanner(System.in);  // creating object for Scanner
        browser=sc.nextLine();
        //System.out.println(prop.getProperty("browser"));
         * 
         */
		String browser= browser1;
		if(browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Eclipse/chromedriver.exe");
			
			 driver = new ChromeDriver(); //creating a  chrome driver object
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 driver.navigate().to(prop.getProperty("url")); //reading the url from properties file
			 
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);//waiting for the browser to load
			 driver.manage().window().maximize(); //maximizing the browser window
			
		}//getting chrome browser
		
		else if(browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "../MySeleniumProject2/driverselenium/geckodriver.exe");
			
			driver = new FirefoxDriver(); //creating  a firefox driver object
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.navigate().to(prop.getProperty("url")); //reading the url from properties file
			
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);//waiting for the browser to load
			driver.manage().window().maximize(); //maximizing the browser window
		}//getting firefox browser
		
		else {
			System.err.println("browser : "+ prop.getProperty("browser") +" is invalid ");
		}// for invalid browser
		
		return driver;
	}

	}
	
