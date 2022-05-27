package week2.Day2.Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

//Week2 Day 2 Assignments - 4.2
public class LeafGround_LinkImages {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Drive and Browser Setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// *** Interact with Images ***
		System.out.println("*** Validation Images *** ");

		// 1. Click on Image to Go Home Page
		driver.get("http://leafground.com/pages/Image.html");
		driver.findElement(By.xpath("//label[contains(text(),'Click on this image')]/following-sibling::img")).click();
		System.out.println("Scenario 1 - The Title of Home Page by Clicking on Image : " + driver.getTitle());
		driver.navigate().back();

		// 2. Am I Broken Image
		String brokenImage = driver
				.findElement(By.xpath("//label[contains(text(),'Broken Image')]/following-sibling::img"))
				.getAttribute("naturalWidth");
		if (brokenImage.equals("0"))
			System.out.println("Scenario 2 - The Image is Broken and Invalid ");
		else
			System.out.println("Scenario 2 - The Image is Valid");

		// 3. Click me using Keyboard or Mouse
		WebElement clickMe = driver
				.findElement(By.xpath("//label[contains(text(),'Click me')]/following-sibling::img"));
		// clickMe.click();

		Actions builder = new Actions(driver);
		builder.click(clickMe).build().perform();

		System.out.println("Scenario 3 - The Image is clicked by using Mouse ");
		System.out.println(" Title of Current Page : " + driver.getTitle());

		// *** Launch URL for Hyperlink validation ***

		// 1. Go to Home Page
		System.out.println("****Validation of Hyperlinks****");
		driver.get("http://leafground.com/pages/Link.html");
		WebElement homePageToGo = driver.findElement(By.linkText("Go to Home Page"));
		homePageToGo.click();
		System.out.println("Scenario 1 - Navigated to Home Page and Title : " + driver.getTitle());
		driver.navigate().back();

		// 2.Go Without clicking Me
		String findLinktoGo = driver.findElement(By.linkText("Find where am supposed to go without clicking me?"))
				.getAttribute("href");

		System.out.println("Scenario 2 - Supposed to go without clicking me in this link : " + findLinktoGo);
		driver.get(findLinktoGo);

		System.out.println("Title of Current Page : " + driver.getTitle());
		driver.navigate().back();

		// 3. Verify AM I Broken
		driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).click();
		String titleOfCurrentPage = driver.getTitle();
		if (titleOfCurrentPage.contains("404 Not Found"))
			System.out.println("Scenario 3 - The given link : The link is Broken and Invalid");
		else
			System.out.println("The Link is Valid ");
		driver.navigate().back();

		// 4.Interact with Same link Name
		driver.findElement(By.xpath("//label[contains(text(),'(Interact with same link name)')]/preceding-sibling::a"))
				.click();
		System.out.println("Scenario 4 - Titel of the Current Page : " + driver.getTitle());
		driver.navigate().back();

		Thread.sleep(2000);

		// 5. Count of the Total link
		List<WebElement> countOfLink = driver.findElements(By.tagName("a"));
		System.out.println("Scenario 5 - The Total Links present in the Page is : " + countOfLink.size());

		// Close Browser
		driver.close();

	}

}
