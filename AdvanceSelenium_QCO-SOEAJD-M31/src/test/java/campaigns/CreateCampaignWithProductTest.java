package campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Uitility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.CampLookUpImgPage;
import Pom_Repo.CreateCampaignPAge;
import Pom_Repo.CreateProductPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ProductLooUpImg;
import Pom_Repo.ValidationCampaignPage;
import Pom_Repo.WindowSwitchingPage;

public class CreateCampaignWithProductTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createCampaignWithProductTest() throws Throwable {

		WebDriver_Utility wlib = new WebDriver_Utility();
		
		HomePage home = new HomePage(driver);
		home.clickProductLink();

		ProductLooUpImg lookUp = new ProductLooUpImg(driver);
		lookUp.clickPrdLookUp();


		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
	
		Excel_Utility elib = new Excel_Utility();
		String prdName = elib.getExcelData("Product", 0, 0) + ranNum;
		System.out.println(prdName);

		
		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterPrdData(prdName);

		// ----------------------------------------------------------------------------------------------------------------

		home.clickCampaignsLink();

		CampLookUpImgPage img = new CampLookUpImgPage(driver);
		img.clickLookUpImg();

		String campName = elib.getExcelData("Campaigns", 0, 0) + ranNum;
		System.out.println(campName);

		CreateCampaignPAge campPage = new CreateCampaignPAge(driver);
		campPage.enterCampNAme(campName);

		WindowSwitchingPage winSwitch = new WindowSwitchingPage(driver);

		winSwitch.clickPrdLookUpImgInCamp();

		wlib.windowSwitching(driver, "Products&action");

		winSwitch.enterPrdDetails(prdName);

		// Dynamic xpath
		winSwitch.enterPrdNameInCamp(driver, prdName);

		wlib.windowSwitching(driver, "Campaigns&action");

		campPage.clickSaveButton();

		ValidationCampaignPage validate = new ValidationCampaignPage(driver);
		validate.validateCamp(driver, campName);
		validate.validateProduct(driver, prdName);

	}

}
