import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();

		WebElement name = driver.findElement(By.xpath("//div[@class='form-group'] //input[@name='name']"));
		name.sendKeys("Alain");

		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("pogiko19@gmail.com");

		WebElement password = driver.findElement(By.id("exampleInputPassword1"));
		password.sendKeys("pogikotalaga");

		WebElement iceCreamCheckbox = driver.findElement(By.id("exampleCheck1"));
		iceCreamCheckbox.click();

		Select dropdown = new Select(driver.findElement(By.id("exampleFormControlSelect1")));

		dropdown.selectByVisibleText("Female");

		WebElement radio = driver.findElement(By.id("inlineRadio1"));
		radio.click();

		WebElement birthday = driver.findElement(By.name("bday"));
		birthday.sendKeys("04191999");

		WebElement submit = driver.findElement(By.cssSelector("input[type='submit']"));
		submit.click();

		String successMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]")).getText();
		System.out.println(successMessage);
	}

}
