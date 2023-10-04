package TestCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestData.Mobile_Apple_POM;

public class Mobile_Apple {

	WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void LaunchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.apple.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void iPhones() throws InterruptedException {
		
		System.out.println("\n"+"Testing Pathform Apple"+"\n");

		PageFactory.initElements(driver, Mobile_Apple_POM.class);

		Mobile_Apple_POM.iphoneSection.click();

		System.out.println("iPhones available to purchase:");

		Thread.sleep(2000);
		List<WebElement> iphones = driver.findElements(By.xpath("//ul[@class='chapternav-items']/child::li"));
		for (WebElement webElement : iphones) {
			String Total_iphones = webElement.getText();
			if (Total_iphones.startsWith("iPhone")) {
				System.out.println(Total_iphones.replace("New", ""));
			}

		}

		String latestiphone = Mobile_Apple_POM.iPhones.getText();
		System.out.println("\n" + "Latest iPhone is: " + latestiphone.replace("New", ""));

		Mobile_Apple_POM.latestiPhone.click();

		Thread.sleep(2000);
		String latestiphoneprice = Mobile_Apple_POM.latestiPhonePrice.getText();
		System.out.println("Latest " + latestiphone.replace("New", "") + " price starting " + latestiphoneprice + "\n");

	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
