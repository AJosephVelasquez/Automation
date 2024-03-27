import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://www.path2usa.com/travel-companions");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");

		Thread.sleep(5000);
		driver.findElement(By.id("form-field-travel_comp_date")).click();

		do {
			System.out
					.println("Current month: " + driver.findElement(By.xpath("//span[@class='cur-month']")).getText());
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//span[@class='flatpickr-next-month'] //*[local-name()='svg']")))
					.click();
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month'] //*[local-name()='svg']")).click();
		} while (!driver.findElement(By.xpath("//span[@class='cur-month']")).getText().contains("August"));

		List<WebElement> dates = driver.findElements(By.xpath("//span[contains(@class, 'flatpickr-day')]"));
		int count = dates.size();

		for (int i = 0; i < count; i++) {
			String text = dates.get(i).getText();
			if (text.equalsIgnoreCase("23")) {
				dates.get(i).click();
				break;
			}
		}
	}
}