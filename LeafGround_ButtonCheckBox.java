package week2.Day2.Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//Week2 Day2 Assignment - 4.1
public class LeafGround_ButtonCheckBox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Drive and Browser Setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// *** Radio Button Validation ***
		// 1. Are you enjoying the Classes
		System.out.println("****Validation of Radio Buttons****");
		driver.get("http://www.leafground.com/pages/radio.html");
		WebElement enjoyClasses = driver.findElement(By.xpath("//input[@id='yes']"));
		enjoyClasses.click();
		System.out.println("Scenario 1 - Are You Enjoying the Class : " + enjoyClasses.getAttribute("id"));

		// 2. Find default selected radio button
		WebElement findDefault = driver
				.findElement(By.xpath("//label[contains(text(),'Find default selected')]/following-sibling::input[2]"));
		boolean check = findDefault.isSelected();
		if (check == true)
			System.out.println("Scenario 2 - Default Selection is Available : " + check);
		else
			System.out.println("Scenario 2 - There is no Default selection available");

		// 3. Select Age Group if it not selected
		WebElement ageGroup = driver
				.findElement(By.xpath("//label[contains(text(),'Select your age group')]/following-sibling::input[2]"));
		System.out.println("Scenario 3 - Selected Age Group If it wasnt Selected : " + ageGroup.isSelected());

		// *** Launch URL for Check Box Validation ***
		// 1. Select Know Language
		System.out.println("****Validation of CheckBoxs****");
		driver.get("http://leafground.com/pages/checkbox.html");
		WebElement eleKnowLanguage = driver.findElement(
				By.xpath("//label[text()='Select the languages that you know?']/following-sibling::input"));
		eleKnowLanguage.click();

		boolean knowLanaguage = eleKnowLanguage.isSelected();
		System.out.println("Scenario 1 - Select the launguages that you know : Java - " + knowLanaguage);

		// 2. Confirm Selenium is checked
		boolean seleniumChecked = driver
				.findElement(By.xpath(
						"//label[text()='Confirm Selenium is checked']/following-sibling::input[@type='checkbox']"))
				.isSelected();
		if (seleniumChecked == true)
			System.out.println("Scenario 2 - Confirm Selenium is checked : " + seleniumChecked);

		// 3. DeSelect only Checked
		List<WebElement> eleTobeCheck = driver.findElements(
				By.xpath("//label[text()='DeSelect only checked']/following-sibling::input[@type='checkbox']"));
		int length = eleTobeCheck.size();

		for (int i = 0; i < length; i++) {
			boolean eleSelected = eleTobeCheck.get(i).isSelected();
			if (eleSelected == true) {
				eleTobeCheck.get(i).click();
				System.out.println("Scenario 3 - Deselected only selected and Show Result by indicating False: "
						+ eleTobeCheck.get(i).isSelected());
			}
		}

		// 4. Select all CheckBoxes
		List<WebElement> eleAllCheckbox = driver.findElements(
				By.xpath("//label[text()='Select all below checkboxes ']/following-sibling::input[@type='checkbox']"));
		int lengthofCheck = eleAllCheckbox.size();

		for (int i = 0; i < lengthofCheck; i++) {
			eleAllCheckbox.get(i).click();
		}
		System.out.println("Scenario 4 - All Below Checkboxes are selected");

		driver.close();
	}

}
