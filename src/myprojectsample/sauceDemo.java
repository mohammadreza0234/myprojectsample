package myprojectsample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class sauceDemo {

	public static String url = "https://www.saucedemo.com";

	public static String username = "standard_user";

	public static String password = "secret_sauce";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(url);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		WebElement user = driver.findElement(By.id("user-name"));
		user.sendKeys(username);

		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys(password);

		WebElement loginBtn = driver.findElement(By.id("login-button"));
		loginBtn.click();

		Thread.sleep(1000);

		Select sel = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));

		sel.selectByValue("hilo");

		Thread.sleep(1000);

		driver.findElement(By.linkText("Sauce Labs Onesie")).click();

		WebElement addToCart = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']"));
		addToCart.click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

		String actual = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		String expected = "Sauce Labs Onesie";

		if (expected.equalsIgnoreCase(actual)) {

			System.out.println("item is on the card");
		} else {
			System.out.println("item is not on the card!");
		}

		WebElement checkOut = driver.findElement(By.id("checkout"));
		checkOut.click();
		Thread.sleep(1000);

		WebElement firstName = driver.findElement(By.id("first-name"));
		firstName.sendKeys("Enver");
		Thread.sleep(1000);

		WebElement lastName = driver.findElement(By.id("last-name"));
		lastName.sendKeys("Baumeister");
		Thread.sleep(1000);

		WebElement postalCode = driver.findElement(By.xpath("//input[@id='postal-code']"));
		postalCode.sendKeys("2179");
		Thread.sleep(1000);

		WebElement con = driver.findElement(By.name("continue"));
		con.click();

		WebElement finish = driver.findElement(By.id("finish"));
		finish.click();
		Thread.sleep(1000);

		String expectedText = "Checkout: Complete!";
		String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();

		if (actualText.equalsIgnoreCase(expectedText)) {

			System.out.println(actualText + " is verified!");

		} else {
			System.out.println(actualText + " is not verified!");
		}

		Thread.sleep(2000);

		driver.quit();

	}

}
