package TestData;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Ecommerce_Amazon_POM {
	
	@FindBy(id="twotabsearchtextbox")
	public static WebElement SearchProduct;
	
	@FindBy(xpath = "//div[@data-cel-widget='search_result_1']//a")
	public static WebElement FirstProduct;
	
	@FindBy(xpath = "//div[@data-cel-widget='search_result_2']//a")
	public static WebElement SecondProduct;
	
	@FindBy(id="productTitle")
	public static WebElement ProductTitle;
	
	@FindBy(id="price_inside_buybox")
	public static WebElement ProductPrice;
	
	@FindBy(id="acrPopover")
	public static WebElement CustomerRating;
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	public static WebElement Signin;
	
	@FindBy(id="ap_email")
	public static WebElement invalidmailid;
	
	@FindBy(id="ap_password")
	public static WebElement invalidpassword;
	
	@FindBy(id="auth-error-message-box")
	public static WebElement Errormessage;
	
}
