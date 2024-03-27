import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,600)");
		
		System.out.println(driver.findElements(By.xpath("//table[@id='product' and @name='courses'] //tr")).size());
		System.out.println(driver.findElements(By.xpath("//table[@id='product' and @name='courses'] //th")).size());
		
		WebElement thirdRow = driver.findElement(By.xpath("//table[@id='product' and @name='courses'] //tr[3]"));
		
		List<WebElement> thirdRowData = thirdRow.findElements(By.tagName("td"));
		int count = thirdRowData.size();
		
		for(int i = 0; i < count; i++) {
			System.out.println(thirdRowData.get(i).getText());
		}
	}

}
