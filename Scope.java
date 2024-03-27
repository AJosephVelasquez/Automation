import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scope {

	public static void main(String args[]) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		Actions action = new Actions(driver);

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		System.out.println(driver.findElements(By.tagName("a")).size());

		System.out.println(driver.findElements(By.xpath("//div[@id='gf-BIG'] //a")).size());

		List<WebElement> discountCouponLinks = driver
				.findElements(By.xpath("//a[contains(text(), 'Discount Coupons')]/../../.. //a"));

		System.out.println(discountCouponLinks.size());

		for (int i = 1; i < discountCouponLinks.size(); i++) {
			action.moveToElement(discountCouponLinks.get(i)).keyDown(Keys.CONTROL).click().build().perform();
		}
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		
		while(iterator.hasNext()) {
			driver.switchTo().window(iterator.next());
			System.out.println(driver.getTitle());
		}
	}

}
