import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String window1 = iterator.next();
		String window2 = iterator.next();
		driver.switchTo().window(window2);
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		driver.switchTo().window(window1);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
	}

}
