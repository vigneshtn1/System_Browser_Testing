package TestData;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Ecommerce_Flipkart_POM {

	@FindBy(xpath = "//span[@role='button']")
	public static WebElement AbortLogin;

	@FindBy(xpath = "//a[text()='Become a Seller']")
	public static WebElement SellerSection;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/div/form/div[1]/input")
	public static WebElement InvalidLogin;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div[2]/div/form/div[1]/span[3]")
	public static WebElement ErrorMessage;

}
