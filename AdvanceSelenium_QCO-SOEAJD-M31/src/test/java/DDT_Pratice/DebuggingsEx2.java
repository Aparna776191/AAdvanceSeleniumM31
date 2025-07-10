package DDT_Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import demo.Methods;
import net.bytebuddy.implementation.auxiliary.MethodCallProxy;

public class DebuggingsEx2 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.flipkart.com");
		
		Methods data = new Methods();
		data.maximizeWindow(driver);
		data.wait(driver);
		
		driver.findElement(By.name("q")).sendKeys("Puma");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}
