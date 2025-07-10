package TestNG_Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utility;

public class DataProviderEx3 {

	
	@Test(dataProvider = "readContactData")
	public void createContact(String FirstNAme,String LastNAme) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Contact...\"]")).click();
		driver.findElement(By.name("firstname")).sendKeys(FirstNAme);
		driver.findElement(By.name("lastname")).sendKeys(LastNAme);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
	
	@DataProvider
	public Object[][] readContactData() throws Throwable
	{
		
	Excel_Utility elib = new Excel_Utility();
		
	Object[][] data = elib.readDataUsingDAtaProvider("DataProvider");
	return data;	
		
		
		
	}
}
