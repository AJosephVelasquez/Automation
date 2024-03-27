import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement autoSuggestBox = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		autoSuggestBox.sendKeys("man");
		Thread.sleep(2000);
		
		String keyChord = Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.ENTER);
		
		autoSuggestBox.sendKeys(keyChord);
		
		System.out.println(autoSuggestBox.getAttribute("value"));
		
		
	}

}
