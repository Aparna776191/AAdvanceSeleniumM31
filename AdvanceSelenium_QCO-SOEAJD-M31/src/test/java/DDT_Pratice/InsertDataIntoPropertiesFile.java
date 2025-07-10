package DDT_Pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InsertDataIntoPropertiesFile {

	public static void main(String[] args) throws Throwable {
	
		//Inserting data into properties file
		Properties pro = new Properties();
		pro.setProperty("browser", "edge");
		pro.setProperty("url", "http://localhost:8888");
		pro.setProperty("username", "admin");
		pro.setProperty("password", "admin");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Shobha\\Downloads\\commondata.properties");
		pro.store(fos, "CommonData");
		System.out.println("Inserted the data");
//------------------------------------------------------------------------------------------------------------------------
   
		//fetching Data from Properties File
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\Downloads\\commondata.properties");
		
		//step2:- Create the object of Properties class and load all the Keys
	//	Properties pro = new Properties();
		pro.load(fis);
		
		//step3:-read the value using getProperty()
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");

		WebDriver driver;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	
	}

}
