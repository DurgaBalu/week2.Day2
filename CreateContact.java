package week2.Day2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

//Week2 Day2 Assignment - 2.1
public class CreateContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Drive and Browser Setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Create Contact
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create')]")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Durga");
		driver.findElement(By.id("lastNameField")).sendKeys("Balu");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Durgab");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("BaluDSaras");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Computer Science");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Customer Request to create Contact");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("durga@gmail.com");

		WebElement eleDropdown = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));

		Select objDropdown = new Select(eleDropdown);

		objDropdown.selectByVisibleText("New York");

		driver.findElement(By.xpath("//input[@name='submitButton']")).click();

		// Edit Contact
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Customer Request - Cleared Description");
		driver.findElement(By.xpath("//input[@value='Update']")).click();

		// Title of the Page
		String titleOfthePage = driver.getTitle();
		System.out.println("Title of the Page : " + titleOfthePage);
		
		driver.close();

	}

}
