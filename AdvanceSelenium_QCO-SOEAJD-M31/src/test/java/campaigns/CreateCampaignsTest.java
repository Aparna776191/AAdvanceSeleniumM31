package campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Uitility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.CampLookUpImgPage;
import Pom_Repo.ContactLookUpImgPage;
import Pom_Repo.CreateCampaignPAge;
import Pom_Repo.CreateContactPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ValidateContactPage;
import Pom_Repo.ValidationCampaignPage;

//@Listeners(Generic_Utilities.ListenerImp.class)
@Listeners(Generic_Utilities.ExtentReportImp.class)
public class CreateCampaignsTest extends BaseClass {
	//@Test(retryAnalyzer =Generic_Utilities.RetryAnalyserImp.class )
	@Test
	public void createCampaignsTest() throws Throwable {

		// Login to vtiger application->mouseOverOn more Link->click on campaigns->
		// click on create campaign lookup image->Enter campaignName->
		// click on save Btn->verify whether the campaign is created in campaign
		// Information page
		// and Logout from the application.

		HomePage home = new HomePage(driver);
		home.clickCampaignsLink();

		CampLookUpImgPage campLookUp = new CampLookUpImgPage(driver);
		campLookUp.clickLookUpImg();

		Excel_Utility elib = new Excel_Utility();
		String campName = elib.getExcelData("Campaigns", 0, 0);

		CreateCampaignPAge campPage = new CreateCampaignPAge(driver);
		campPage.enterCampNAme(campName);
		campPage.clickSaveButton();

//		Assert.fail();
		
		ValidationCampaignPage validate = new ValidationCampaignPage(driver);
		validate.validateCamp(driver, campName);

	}
	
//-----------------------------------------------------------------------------------------------------------------------------------
	
}
