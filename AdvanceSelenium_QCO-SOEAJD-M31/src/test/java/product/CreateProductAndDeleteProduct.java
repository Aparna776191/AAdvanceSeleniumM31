package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Uitility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.CreateProductPage;
import Pom_Repo.DeleteProductPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ProductLooUpImg;

public class CreateProductAndDeleteProduct {

	public static void main(String[] args) throws Throwable {

		File_Uitility flib = new File_Uitility();
		String BROWSER = flib.getKeyAndValue("browser");
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
		WebDriver driver;

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}

		driver.get(URL);
        LoginPage login = new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);

		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitElementsToLoad(driver);

		// >click on product link
        HomePage home = new HomePage(driver);
		home.clickProductLink();

		// >click on create product lookup image
        ProductLooUpImg lookUp = new ProductLooUpImg(driver);
		lookUp.clickPrdLookUp();

		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();

		Excel_Utility elib = new Excel_Utility();
		String prdName = elib.getExcelData("Product", 0, 0) + ranNum;

		CreateProductPage Prdpage = new CreateProductPage(driver);
		Prdpage.enterPrdData(prdName);

		Thread.sleep(1000);

		home.clickProductLink();

		DeleteProductPage deletePrd = new DeleteProductPage(driver);
		deletePrd.selectPrdCheckBox(driver, prdName);

		deletePrd.clickDeleteButton();

		wlib.alertHandle(driver);

		deletePrd.validatePrdDeleted(driver, prdName);

	//	home.logoutApp();

	}

}
