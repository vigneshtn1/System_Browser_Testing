package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestData.Ecommerce_Amazon_POM;

public class Ecommerce_Amazon {

	WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void LaunchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

// Negative Test Case
	@Test(priority = 0)
	public void InvalidAmazonLogin() {

		System.out.println("\n" + "Testing Pathform Amazon" + "\n");

		PageFactory.initElements(driver, Ecommerce_Amazon_POM.class);

		try {
			Ecommerce_Amazon_POM.SearchProduct.isDisplayed();
		} catch (Exception e) {
			driver.get("https://www.amazon.com/");
		}

		try {
			Ecommerce_Amazon_POM.Signin.click();
			Ecommerce_Amazon_POM.invalidmailid.sendKeys("abcd@gmail.com" + Keys.ENTER);
			Ecommerce_Amazon_POM.invalidpassword.sendKeys("1234567" + Keys.ENTER);
			String error = Ecommerce_Amazon_POM.Errormessage.getText();
			System.out.println("If the user enters invalid email/password it displays that " + "\n" + error);
		} catch (Exception e) {
			System.out.println("Captcha Authencation is popped up so skipping this negative case");
		}

	}

// Search Apple Laptop
	@Test(priority = 1)
	public void AppleLaptop() {

		driver.get("https://www.amazon.com/");

		PageFactory.initElements(driver, Ecommerce_Amazon_POM.class);

		Ecommerce_Amazon_POM.SearchProduct.sendKeys("Apple Laptop" + Keys.ENTER);

		try {
			Ecommerce_Amazon_POM.FirstProduct.click();
		} catch (Exception e) {
			Ecommerce_Amazon_POM.SecondProduct.click();
		}

		String ProductTitle = Ecommerce_Amazon_POM.ProductTitle.getText();
		System.out.println("\n" + ProductTitle);

		try {
			String ProductPrice = Ecommerce_Amazon_POM.ProductPrice.getText();
			System.out.println("Price of Laptop is " + ProductPrice);
		} catch (Exception e) {
			System.out.println("Temporarily out of stock");
		}

		String ProductRating = Ecommerce_Amazon_POM.CustomerRating.getText();
		System.out.println("Customer Rating is " + ProductRating + " out of 5");

	}

// Search Apple Laptop
	@Test(priority = 2)
	public void LenovoLaptop() {

		PageFactory.initElements(driver, Ecommerce_Amazon_POM.class);

		Ecommerce_Amazon_POM.SearchProduct.clear();

		Ecommerce_Amazon_POM.SearchProduct.sendKeys("Lenovo Laptop" + Keys.ENTER);

		try {
			Ecommerce_Amazon_POM.FirstProduct.click();
		} catch (Exception e) {
			Ecommerce_Amazon_POM.SecondProduct.click();
		}

		String ProductTitle = Ecommerce_Amazon_POM.ProductTitle.getText();
		System.out.println("\n" + ProductTitle);

		try {
			String ProductPrice = Ecommerce_Amazon_POM.ProductPrice.getText();
			System.out.println("Price of Laptop is " + ProductPrice);
		} catch (Exception e) {
			System.out.println("Temporarily out of stock");
		}

		String ProductRating = Ecommerce_Amazon_POM.CustomerRating.getText();
		System.out.println("Customer Rating is " + ProductRating + " out of 5");

	}

// Search Hp Laptop
	@Test(priority = 3)
	public void HpLaptop() {

		PageFactory.initElements(driver, Ecommerce_Amazon_POM.class);

		Ecommerce_Amazon_POM.SearchProduct.clear();

		Ecommerce_Amazon_POM.SearchProduct.sendKeys("Hp Laptop" + Keys.ENTER);

		try {
			Ecommerce_Amazon_POM.FirstProduct.click();
		} catch (Exception e) {
			Ecommerce_Amazon_POM.SecondProduct.click();
		}

		String ProductTitle = Ecommerce_Amazon_POM.ProductTitle.getText();
		System.out.println("\n" + ProductTitle);

		try {
			String ProductPrice = Ecommerce_Amazon_POM.ProductPrice.getText();
			System.out.println("Price of Laptop is " + ProductPrice);
		} catch (Exception e) {
			System.out.println("Temporarily out of stock");
		}

		String ProductRating = Ecommerce_Amazon_POM.CustomerRating.getText();
		System.out.println("Customer Rating is " + ProductRating + " out of 5");

	}

// Search Dell Laptop
	@Test(priority = 4)
	public void DellLaptop() {

		PageFactory.initElements(driver, Ecommerce_Amazon_POM.class);

		Ecommerce_Amazon_POM.SearchProduct.clear();

		Ecommerce_Amazon_POM.SearchProduct.sendKeys("Dell Laptop" + Keys.ENTER);

		try {
			Ecommerce_Amazon_POM.FirstProduct.click();
		} catch (Exception e) {
			Ecommerce_Amazon_POM.SecondProduct.click();
		}

		String ProductTitle = Ecommerce_Amazon_POM.ProductTitle.getText();
		System.out.println("\n" + ProductTitle);

		try {
			String ProductPrice = Ecommerce_Amazon_POM.ProductPrice.getText();
			System.out.println("Price of Laptop is " + ProductPrice);
		} catch (Exception e) {
			System.out.println("Temporarily out of stock");
		}

		String ProductRating = Ecommerce_Amazon_POM.CustomerRating.getText();
		System.out.println("Customer Rating is " + ProductRating + " out of 5" + "\n");

	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
