import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaStreamSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//th[@role='columnheader'] //span[@class='sort-icon sort-descending']")).click();
		
		List<WebElement> elementList = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));
		
		List<String> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());
		
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(sortedList.equals(originalList));
		
		
		List<String> price;
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Pineapple")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));
			if(price.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		} while(price.size() < 1);

	}

	private static String getPriceVeggie(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
