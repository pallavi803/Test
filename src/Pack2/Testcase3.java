package Pack2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase3 {
	@Test
	public void script()
	{
		System.setProperty("webdriver.gecko.driver","./Software/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.revfin.in/");
		driver.manage().window().maximize();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		driver.findElement(By.xpath("(//a[text()='Contact Us'])[1]")).click();
		WebElement Ele=driver.findElement(By.xpath("//p[text()='Get in touch with us if you have any queries']"));
		Point Loc = Ele.getLocation();
		int x=Loc.getX();
		int y=Loc.getY();
		System.out.println(x);
		System.out.println(y);
		jse.executeScript("window.scrollBy(146,4500)");
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Revfin");
		driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys("7856425621");
		driver.findElement(By.xpath("//input[@placeholder='Email ID']")).sendKeys(" ");
		driver.findElement(By.xpath("//textarea[@placeholder='Your Message']")).sendKeys(" ");
		driver.findElement(By.xpath("//button[@type='submit' and @class='btn submitbutton mb-2']")).click();
		WebElement success_msg = driver.findElement(By.xpath("//div[@class='successfullymessage ']"));
		Assert.assertEquals(true, success_msg.isDisplayed());
		System.out.println("submittion done ");
		
		driver.quit();
	}

}
