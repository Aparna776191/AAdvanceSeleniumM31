package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Uitility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.CreateProductPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.OrganizationCreatePage;
import Pom_Repo.OrganizationLookUpImg;
import Pom_Repo.ProductLooUpImg;
import Pom_Repo.ProductValidationPage;
import Pom_Repo.ValidateOrgPage;

public class CreateOrganizationTest extends BaseClass {

	@Test(groups = {"smokeTest","regressionTest"})
	public void createOrganizationTest() throws Throwable {

		// Login to vtiger application
		// ->click on organizations link
		// ->click on create organization lookup image
		// ->Enter organisation name,phone number and email
		// ->click on save Btn
		// ->verify whether the organization is created in Organization Information page
		// and
		// Logout from the application.

		

		HomePage home = new HomePage(driver);
		home.clickOrgLink();

		OrganizationLookUpImg lookUp = new OrganizationLookUpImg(driver);
		lookUp.clickPrdLookUp();

		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();

		Excel_Utility elib = new Excel_Utility();
		String OrgName = elib.getExcelData("Organization", 0, 0) + ranNum;
		String PhnNum = elib.getExcelDataUsingFormatter("Organization", 1, 0);
		String mailId = elib.getExcelDataUsingFormatter("Organization", 2, 0);

		OrganizationCreatePage orgPage = new OrganizationCreatePage(driver);
		orgPage.enterOrgnaizationData(OrgName, PhnNum, mailId);

		ValidateOrgPage validate = new ValidateOrgPage(driver);
		validate.validateOrg(driver, OrgName);

	}
	//----------------------------------------------------------------------------------------------------


}
