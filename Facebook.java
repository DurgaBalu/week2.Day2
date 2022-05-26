package week2.Day2.Assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

//Week2 Day2 Assignment-1

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Drive and Browser Setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//launch URL
		driver.get("https://en-gb.facebook.com/");
		
		//Create an account
		driver.findElement(By.xpath("//div[@class='_6ltg']/a")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Durga");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Balu");
		
		//driver.findElement(By.xpath("//div[contains(text(),'Mobile number')]")).sendKeys("9150567890");
		driver.findElement(By.xpath("//div[@class='_5dbb']//input[@name='reg_email__']")).sendKeys("9150567890");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Magic@123");
		
		//Select Date of Birth from driver
		WebElement eleDropdownDay = driver.findElement(By.xpath("//select[@id='day']"));
		Select dropdownDay = new Select(eleDropdownDay);
		dropdownDay.selectByValue("19");
		
		WebElement eleDropdownMonth = driver.findElement(By.xpath("//select[@id='month']"));
		Select dropdownMonth = new Select(eleDropdownMonth);
		dropdownMonth.selectByVisibleText("Jun"); 
		
		WebElement eleDropdownYear = driver.findElement(By.xpath("//select[@id='year']"));
		Select dropdownYear = new Select(eleDropdownYear);
		dropdownYear.selectByValue("1996");
		
		driver.findElement(By.xpath("//span[@class='_5k_2 _5dba']/input[@value='1']")).click();
		driver.close();
		
	}

}
