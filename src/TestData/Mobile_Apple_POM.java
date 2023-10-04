package TestData;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Mobile_Apple_POM {
	
	@FindBy(xpath = "//li[@class='globalnav-submenu-trigger-item']//a[@href='/iphone/']")
	public static WebElement iphoneSection;
	
	@FindBy(xpath = "//ul[@class='chapternav-items']/child::li")
	public static WebElement iPhones;
	
	@FindBy(xpath = "//ul[@class='chapternav-items']/child::li[1]")
	public static WebElement latestiPhone;
	
	@FindBy(xpath = "//p[@class='welcome__lockup-primary-copy has-dynamic-content show']/child::span[1]")
	public static WebElement latestiPhonePrice;

}
