package selBasic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeLaunch {

	public static void main(String[] args) throws IOException, InterruptedException {

		// String UR =
		// "https://www.softwaretestingmaterial.com/software-testing-interview-questions-free-ebook";
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver");

		WebDriver driver = new FirefoxDriver();

		// ((JavascriptExecutor) driver).executeScript("alert('Test')");
		// driver.switchTo().alert().accept();

		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		//driver.manage().window().maximize();

		System.out.println("Successful");

		// File screenshot = ((TakesScreenshot)
		// driver).getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(screenshot, new
		// File(System.getProperty("User.dir") +
		// "SelexniumDemo/driver/screenshot1.jpg"));

		String ParentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath(".//*[@id='timingAlert']")).click();
		new WebDriverWait(driver,30).pollingEvery(2, TimeUnit.SECONDS).withTimeout(10, TimeUnit.SECONDS).until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		
		
		
		alert.accept();
		System.out.println("Accepted");
	}

}
