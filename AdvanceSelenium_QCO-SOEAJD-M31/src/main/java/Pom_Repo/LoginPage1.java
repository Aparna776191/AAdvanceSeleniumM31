package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage1 {

	private WebDriver driver;
	// Locators
	private By userTextField = By.name("user_name");
	private By passWordTextField = By.name("user_password");
	private By loginButton = By.id("submitButton");

//constructor
	public LoginPage1(WebDriver driver) {
		this.driver = driver;
	}

//methods to interact with webelements
	public void enterUserName(String username) {
		WebElement userInput = driver.findElement(userTextField);
		userInput.sendKeys(username);
	}

	public void enterPassWord(String password) {
		WebElement passWordInput = driver.findElement(passWordTextField);
		passWordInput.sendKeys(password);
	}

	public void clickloginButton() {
		WebElement loginButton1 = driver.findElement(loginButton);
		loginButton1.click();
	}
	
	public void loginToApp(String name,String password)
	{
		enterUserName(name);
		enterPassWord(password);
		clickloginButton();
	}

}
