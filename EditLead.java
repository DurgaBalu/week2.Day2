package week2.Day2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

//Week2 Day2 Assignment - 2.4
public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Drive and Browser Setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Login and Find Lead by using lead first name
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		Thread.sleep(3000);

		// Sendkey to find the lead and Click
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Durga");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();

		// Print the Current Company Name
		System.out.println(driver.getTitle());
		String companyname = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(companyname);

		// Click on Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();

		// Clear and Update Company Name
		WebElement eleCompanyName = driver.findElement(By.id("updateLeadForm_companyName"));
		eleCompanyName.clear();
		eleCompanyName.sendKeys("Fcebook");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		//Print Updated Company Name
		String eleUpdatedCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Updated Company Name : " + eleUpdatedCompanyName);
		
		//Confirmation Message
		if(companyname.equalsIgnoreCase(eleUpdatedCompanyName))
		{
		System.out.println("The Confirmation Message : The Company name is not Changed");
		}
		else
		System.out.println("The Confirmation Message : The Company name is Changed");
		
		driver.close();
	}

}
