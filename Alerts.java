import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {

		String text = "Alain";

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("name")).sendKeys(text);

		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		
		Thread.sleep(3000);

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("name")).sendKeys(text);

		driver.findElement(By.id("confirmbtn")).click();
		
		Thread.sleep(3000);

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().dismiss();

	}

}
