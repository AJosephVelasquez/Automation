import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		WebElement checkbox1 = driver.findElement(By.id("checkBoxOption1"));
		checkbox1.click();
		Thread.sleep(3000);
		
		Assert.assertTrue(checkbox1.isSelected());
		
		checkbox1.click();
		
		Assert.assertFalse(checkbox1.isSelected());
		
		//Count of how mny checkboxes in the page
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	}

}
