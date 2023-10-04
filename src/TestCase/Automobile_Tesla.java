package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestData.Automobile_Tesla_POM;

public class Automobile_Tesla {

	WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void LaunchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tesla.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

// Tesla Model S Details
	@Test(priority = 0)
	public void ModelS() {
		
		System.out.println("Testing Pathform Tesla");

		PageFactory.initElements(driver, Automobile_Tesla_POM.class);

		Automobile_Tesla_POM.VehicleSection.click();
		Automobile_Tesla_POM.ModelS.click();

		String vehicle_name = Automobile_Tesla_POM.VehicleName.getText();
		System.out.println("\n" + "Tesla Car Model Name: " + vehicle_name);

		String vehicle_price = Automobile_Tesla_POM.VehiclePrice.getText();
		System.out.println("Price Stating " + vehicle_price);

	}

// Tesla Model 3 Details
	@Test(priority = 1)
	public void Model3() {

		PageFactory.initElements(driver, Automobile_Tesla_POM.class);

		Automobile_Tesla_POM.ReturnHome.click();

		Automobile_Tesla_POM.VehicleSection.click();
		Automobile_Tesla_POM.Model3.click();

		String vehicle_name = Automobile_Tesla_POM.VehicleName.getText();
		System.out.println("\n" + "Tesla Car Model Name: " + vehicle_name);

		String vehicle_price = Automobile_Tesla_POM.VehiclePrice.getText();
		System.out.println("Price Stating " + vehicle_price);

	}

// Tesla Model X Details
	@Test(priority = 2)
	public void ModelX() {

		PageFactory.initElements(driver, Automobile_Tesla_POM.class);

		Automobile_Tesla_POM.ReturnHome.click();

		Automobile_Tesla_POM.VehicleSection.click();
		Automobile_Tesla_POM.Modelx.click();

		String vehicle_name = Automobile_Tesla_POM.VehicleName.getText();
		System.out.println("\n" + "Tesla Car Model Name: " + vehicle_name);

		String vehicle_price = Automobile_Tesla_POM.VehiclePrice.getText();
		System.out.println("Price Stating " + vehicle_price);

	}

// Tesla Model X Details
	@Test(priority = 2)
	public void ModelY() {

		PageFactory.initElements(driver, Automobile_Tesla_POM.class);

		Automobile_Tesla_POM.ReturnHome.click();

		Automobile_Tesla_POM.VehicleSection.click();
		Automobile_Tesla_POM.Modely.click();
		
		String vehicle_name = Automobile_Tesla_POM.VehicleName.getAttribute("innerHTML");
		System.out.println("\n" + "Tesla Car Model Name: " + vehicle_name);

		String vehicle_price = Automobile_Tesla_POM.VehiclePrice.getText();
		System.out.println("Price Stating " + vehicle_price+"\n" );
 
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
