package selenium;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile 
     {
	//creating properties object
	static Properties prop=new Properties();
	public static void readProperties() 
	{
	
	try {
		//creating a input file object
	  InputStream readFile=new  FileInputStream("C:\\Eclipse\\Project\\MySeleniumProject2\\src\\selenium\\config.properties");
		prop.load(readFile);
	   }
	catch(Exception e) //handling the exception
	{
		e.printStackTrace();
	}
 }
	
  }


