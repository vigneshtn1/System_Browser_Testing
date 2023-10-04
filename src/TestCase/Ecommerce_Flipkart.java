package TestCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestData.Ecommerce_Flipkart_POM;

public class Ecommerce_Flipkart {

	WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void LaunchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

// Negative Test Case
	@Test(priority = 0)
	public void InvalidFlipkartLogin() {
		
		System.out.println("Testing Pathform Flipkart"+"\n");

		PageFactory.initElements(driver, Ecommerce_Flipkart_POM.class);

		Ecommerce_Flipkart_POM.InvalidLogin.sendKeys("1234567890" + Keys.ENTER);
		if (Ecommerce_Flipkart_POM.ErrorMessage.isDisplayed()) {
			System.out.println("If the user enters invalid number/email it displays that "
					+ Ecommerce_Flipkart_POM.ErrorMessage.getText() + "\n");
		}

	}

	@Test(priority = 1)
	public void FlipkartSellerInfo() {
		PageFactory.initElements(driver, Ecommerce_Flipkart_POM.class);
		try {
			Ecommerce_Flipkart_POM.AbortLogin.click();
		} catch (Exception e) {
			System.out.println("Login Alert Not Displayed");
		}

		Ecommerce_Flipkart_POM.SellerSection.click();

		System.out.println("Seller Benefits:" + "\n");
		List<WebElement> Benefits = driver
				.findElements(By.xpath("//ul[@class='styles__KpiList-o5uywd-3 CmNXr']/child::li/child::div"));
		for (WebElement webElement : Benefits) {
			String SellerBenefits = webElement.getText();
			System.out.println(SellerBenefits);
		}

		System.out.println("\n" + "Popular categories to sell across India:" + "\n");
		List<WebElement> Popular = driver
				.findElements(By.xpath("//div[@class='styles__ListItems-a5s7uc-18 kaLJIs']/child::a"));
		for (WebElement webElement : Popular) {
			String PopularProducts = webElement.getText();
			System.out.println(PopularProducts);
		}
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
