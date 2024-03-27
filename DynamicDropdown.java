import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("http://spicejet.com"); // URL in the browser
		driver.manage().window().maximize();

//  //a[@value='MAA']  - Xpath for chennai

//  //a[@value='BLR']

		driver.findElement(By.xpath("(//input[@class='css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu'])[1]")).click();

		driver.findElement(By.xpath("//div[text()='BLR']")).click();

		Thread.sleep(2000);

//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-b5h31w r-95jzfe'] //div[text()='MAA']")).click();

	}

}