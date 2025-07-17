package Contact;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Uitility;
import Generic_Utilities.WebDriver_Utility;
import Pom_Repo.ContactLookUpImgPage;
import Pom_Repo.CreateContactPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ValidateContactPage;

//@Listeners(Generic_Utilities.ListenerImp.class)
public class CreateContactTest extends BaseClass {

	// im pulling---->pull1
	
	@Test(groups = "regressionTest")
	public void CreateContactTest() throws Throwable {

		HomePage home = new HomePage(driver);
		home.clickContactLink();

		ContactLookUpImgPage lookUp = new ContactLookUpImgPage(driver);
		lookUp.clickLookUp();

		Excel_Utility elib = new Excel_Utility();
		String firstName = elib.getExcelData("Contact", 0, 0);
		System.out.println(firstName);

		CreateContactPage contactPage = new CreateContactPage(driver);
		contactPage.selectDropDown(driver);

//		Assert.fail("---------failing------");
		String lastName = elib.getExcelData("Contact", 0, 1);
		System.out.println(lastName);

		contactPage.enterPrdData(firstName, lastName);

		ValidateContactPage validate = new ValidateContactPage(driver);
		validate.validateContactFirstNAme(driver, firstName);
		validate.validateContactlastNAme(driver, lastName);

	}

}
