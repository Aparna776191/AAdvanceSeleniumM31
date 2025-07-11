package product;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Uitility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.CreateProductPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ProductLooUpImg;
import Pom_Repo.ProductValidationPage;

public class CreateProductTest extends BaseClass {

	//im eng1------>Hi
	@Test
	public  void createProductTest() throws Throwable {

//Login to vtiger application->click on product link->click on create product lookup image->
//Enter product name->click on save Btn->verify whether the product is created in product Information page 
//and Logout from the application.	

		
        HomePage home = new HomePage(driver);
		home.clickProductLink();

		// >click on create product lookup image
        ProductLooUpImg lookUp = new ProductLooUpImg(driver);
		lookUp.clickPrdLookUp();

		Excel_Utility elib = new Excel_Utility();
		String prdName = elib.getExcelData("Product", 0, 0);
        CreateProductPage prdpage = new CreateProductPage(driver);
		prdpage.enterPrdData(prdName);

//		Assert.fail();
		Thread.sleep(2000);
		// >verify whether the product is created in product Information page
        ProductValidationPage validate = new ProductValidationPage(driver);
		validate.prdValidate(driver, prdName);

	}
	
	@Test
	public void m2()
	{
		System.out.println("Hello");
	}

}
