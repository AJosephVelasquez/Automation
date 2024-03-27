import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		int numberOfCheckboxes = driver.findElements(By.xpath("//div[@id='checkbox-example'] //input")).size();
		
		Random random = new Random();
		
		int randomCheckboxNumber = random.nextInt(numberOfCheckboxes) + 1;
		
		WebElement selectedCheckbox = driver.findElement(By.id("checkBoxOption" + randomCheckboxNumber));
		selectedCheckbox.click();
		
		WebElement parentLabel = selectedCheckbox.findElement(By.xpath("parent::label"));
		
		String label = parentLabel.getText();
		
		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByVisibleText(label);
		
		driver.findElement(By.id("name")).sendKeys(label);
		Thread.sleep(3000);
		
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(3000);
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String[] str = alertMessage.split(",");
		String[] str1 = str[0].split(" ");
		String capturedLabel = str1[1].trim();
		
		Assert.assertEquals(capturedLabel, label, "Wrong label captured in Alert");
	}

}
