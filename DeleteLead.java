package week2.Day2.Assignments;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//Week2 Day2 Assignment - 2.2
public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Drive and Browser Setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Login and Find Lead by using Phone Number
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("9150410987");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(3000);
		
		//Capture the First Lead ID
		String firstLeadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))
				.getText();
		System.out.println("First Lead Id is : " + firstLeadId);

		// Click on the First Lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();

		//Click on the Delete 
		driver.findElement(By.xpath("//div[@class='frameSectionExtra']/a[text()='Delete']")).click();

		//Click on Find Leads by Using Lead ID
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input[@name='id']")).sendKeys(firstLeadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Verification of Confirmation message
		String verification = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		System.out.println("Confirmation Message for Deletion : " + verification);

		driver.close();

	}

	private static Duration DurationofSeconds() {
		// TODO Auto-generated method stub
		return null;
	}

}
