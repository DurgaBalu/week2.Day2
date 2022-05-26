package week2.Day2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//Week2 Day2 Assignment - 3
public class LoginAcmeSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Drive and Browser Setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Launch and Login into the application
		driver.get("https://acme-test.uipath.com/login");
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		// Print Title of the Page
		System.out.println("Title of the Page is : " + driver.getTitle());

		// Logout
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		
		//Close Browser
		driver.close();

	}

}
