import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EndToEnd {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("https://spicejet.com");
		driver.manage().window().maximize();

		WebElement fromSelection = driver
				.findElement(By.xpath("//div[@data-testid='to-testID-origin'] //div[contains(@class, 'r-14lw9ot')]"));
		fromSelection.click();

		WebElement IXU = driver.findElement(By.xpath("//div[text()='IXU']"));
		IXU.click();

		WebElement GOI = driver.findElement(By.xpath("//div[contains(@class, 'r-b5h31w')] //div[text()='GOI']"));
		GOI.click();

		WebElement currentDate = driver.findElement(By.xpath(
				"//div[contains(@data-testid, 'January-2024')] //div[contains(@class, 'r-16dba41')][text()='15']"));
		currentDate.click();

		WebElement passengers = driver
				.findElement(By.xpath("//div[contains(@class, 'r-1phboty ')][@data-testid='home-page-travellers']"));
		passengers.click();

		WebElement addAdult = driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']"));

		for (int i = 0; i < 3; i++) {
			addAdult.click();
		}

		WebElement passengersDone = driver.findElement(By.xpath("//div[@data-testid='home-page-travellers-done-cta']"));
		passengersDone.click();
		Thread.sleep(3000);

		WebElement familyAndFriends = driver.findElement(By.xpath("//div[text()='Family & Friends']"));
		familyAndFriends.click();

		WebElement returnDate = driver.findElement(
				By.xpath("//div[contains(@class, 'r-5njf8e')][@data-testid='return-date-dropdown-label-test-id']"));

		if (returnDate.getAttribute("style").contains("background-color")) {
			System.out.println("The return date is disabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		WebElement searchFlightButton = driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']"));
		searchFlightButton.click();
		
		Thread.sleep(3000);
		
		driver.quit();

	}

}
