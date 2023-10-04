package TestCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Basics {

	WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void LaunchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// Locate and click the button
	@Test(priority = 0)
	public void LocateAndClick() {
		
		System.out.println("Basic Concepts of Selenium"+"\n");

		driver.get("https://www.amazon.com/");
		try {
			driver.findElement(By.xpath("//div[@data-cel-widget='search_result_2']//a")).isDisplayed();
		} catch (Exception e) {
			driver.get("https://www.amazon.com/");
		}
		try {
			// Locate the button
			WebElement getposition = driver
					.findElement(By.xpath("/html/body/div/div[1]/div[3]/div/div/form/div[2]/div/span/span/button"));
			Point xypoint = getposition.getLocation();
			int xvalue = xypoint.getX();
			int yvalue = xypoint.getY();
			System.out.println("X value is " + xvalue + " Y value is " + yvalue);
			// Color of the button
			String color = getposition.getCssValue("background-color");
			System.out.println("Button color is: " + color);
			// Click the button
			getposition.click();
			driver.quit();
		} catch (Exception e) {
			WebElement signin = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
			signin.click();
			// Locate the button
			WebElement getposition1 = driver.findElement(By.id("continue"));
			Point xypoint1 = getposition1.getLocation();
			int xvalue1 = xypoint1.getX();
			int yvalue1 = xypoint1.getY();
			System.out.println("X value is " + xvalue1 + " Y value is " + yvalue1);
			// Color of the button
			String color1 = getposition1.getCssValue("background-color");
			System.out.println("Button color is: " + color1);
			// Click the button
			getposition1.click();
		}

	}

	// Select dropdown
	@Test(priority = 1)
	public void DropDown() {

		driver.get("https://www.leafground.com/select.xhtml");
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"j_idt87\"]/div/div[1]/div[1]/div/div/select"));
		Select select = new Select(dropdown);
		List<WebElement> optionlist = select.getOptions();
		int size = optionlist.size();
		System.out.println("\n" + "Number of elements in the dropdown is: " + size);
		select.selectByIndex(1);

	}

	// Alert Handle
	@Test(priority = 2)
	public void AlertHandle() {

		driver.get("https://www.leafground.com/alert.xhtml");
		// ConfirmAlert
		WebElement alertbox = driver.findElement(By.id("j_idt88:j_idt93"));
		alertbox.click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		// PromptAlert
		WebElement alertbox1 = driver.findElement(By.id("j_idt88:j_idt104"));
		alertbox1.click();
		Alert alert1 = driver.switchTo().alert();
		alert1.sendKeys("Vignesh");
		alert1.accept();

	}

	// RadioButton
	@Test(priority = 3)
	public void RadioButton() {

		driver.get("https://www.leafground.com/radio.xhtml");
		WebElement radiobutton = driver.findElement(By.xpath("//*[@id=\"j_idt87:city2\"]/div/div[1]/div"));
		radiobutton.click();

	}

	// Checkbox Operation
	@Test(priority = 4)
	public void checkbox() {

		driver.get("https://www.leafground.com/checkbox.xhtml");
		WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt91\"]/div[2]"));
		checkbox.click();
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"j_idt87:basic\"]/tbody/tr/td[3]/div/div[2]"));
		checkbox1.click();
		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"j_idt87:basic\"]/tbody/tr/td[2]/div/div[2]"));
		checkbox2.click();
		WebElement checkbox3 = driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt100\"]/div[2]"));
		checkbox3.click();

	}

	// Handle Frames
	@Test(priority = 5)
	public void HandleFrames() {

		driver.get("https://www.leafground.com/frame.xhtml");
		driver.switchTo().frame(0);
		WebElement click10 = driver.findElement(By.id("Click"));
		click10.click();
		String text01 = driver.findElement(By.id("Click")).getText();
		System.out.println("\n" + "Text inside the frame is " + "'" + text01 + "'");
		// Nested Frames
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("frame2");
		WebElement click11 = driver.findElement(By.id("Click"));
		click11.click();
		String text11 = driver.findElement(By.id("Click")).getText();
		System.out.println("Text inside the Nested frame is " + "'" + text11 + "'");
		driver.switchTo().defaultContent();
		// Number of Frames
		List<WebElement> totalframe = driver.findElements(By.tagName("iframe"));
		int count01 = totalframe.size();
		System.out.println("Total frame in the webpage is " + count01);

	}

	// Drag Drop
	@Test(priority = 6)
	public void DragDrop() {

		driver.get("https://www.leafground.com/drag.xhtml");
		WebElement from = driver.findElement(By.id("form:drag"));
		WebElement to = driver.findElement(By.id("form:drop"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(from, to).build().perform();

		WebElement from1 = driver.findElement(By.id("form:conpnl"));
		WebElement to1 = driver.findElement(By.id("form:restrictPanel"));
		Point location = to1.getLocation();
		System.out.println("\n" + "Location of the point is " + location);
		// Question: How to find(x&y) axis of a random point in the webpage.
		actions.dragAndDropBy(from1, 85, 162).build().perform();

	}

	// HyperLink
	@Test(priority = 7)
	public void HyperLink() {

		driver.navigate().to("https://www.leafground.com/link.xhtml");
		// Click the link
		WebElement dash_link = driver.findElement(By.linkText("Go to Dashboard"));
		dash_link.click();

		driver.navigate().back();
		// Find the link without clicking
		WebElement find_link = driver.findElement(By.partialLinkText("Find the URL"));
		String link_f = find_link.getAttribute("href");
		System.out.println("\n" + link_f);
		// Find broken link
		WebElement broken_link = driver.findElement(By.linkText("Broken?"));
		broken_link.click();
		String title1 = driver.getTitle();
		if (title1.contains("404")) {
			System.out.println("Link is broken");
		}
		driver.navigate().back();
		// Total link in the web page
		List<WebElement> total_link1 = driver.findElements(By.tagName("a"));
		int linkcount1 = total_link1.size();
		System.out.println("Total hyperlinks in the webpage is " + linkcount1 + "\n");

	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
