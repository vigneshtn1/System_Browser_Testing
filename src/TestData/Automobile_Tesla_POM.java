package TestData;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Automobile_Tesla_POM {
	
	@FindBy(id="dx-nav-item--vehicles")
	public static WebElement VehicleSection;
	
	@FindBy(xpath = "//a[@href='/models']")
	public static WebElement ModelS;
	
	@FindBy(xpath = "//a[@href='/model3']")
	public static WebElement Model3;
	
	@FindBy(xpath = "//a[@href='/modelx']")
	public static WebElement Modelx;
	
	@FindBy(xpath = "//a[@href='/modely']")
	public static WebElement Modely;
	
	@FindBy(xpath = "//div[@id='block-tesla-frontend-content']//h1")
	public static WebElement VehicleName;
	
	@FindBy(xpath = "//div[@id='block-tesla-frontend-content']//strong")
	public static WebElement VehiclePrice;
	
	@FindBy(xpath = "//*[@id=\"tds-site-header\"]/h1/a[1]")
	public static WebElement ReturnHome;

}
