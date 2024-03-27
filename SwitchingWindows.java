import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingWindows {
	
	public static void main(String args[]) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		Set<String> windows = driver.getWindowHandles(); //[parentId, childId]
		Iterator<String> iterator = windows.iterator();
		String window1 = iterator.next();
		String window2 = iterator.next();
		driver.switchTo().window(window2);
		String red = driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
		String[] str= red.split("with");
		String[] str1 = str[0].split("at");
		String email = str1[1].trim();
		
		driver.switchTo().window(window1);
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys(email);
		
	}

}
