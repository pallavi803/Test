package Pack2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 {
	@Test
	public void script() 
	  
	{
		System.setProperty("webdriver.gecko.driver","./Software/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.revfin.in/");
		driver.manage().window().maximize();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		WebElement Ele=driver.findElement(By.xpath("//p[text()='Get in touch with us if you have any queries']"));
		Point Loc = Ele.getLocation();
		int x=Loc.getX();
		int y=Loc.getY();
		System.out.println(x);
		System.out.println(y);
		jse.executeScript("window.scrollBy(146,4500)");		
		String Contact = Ele.getText();
		Assert.assertEquals(Contact,"Get in touch with us if you have any queries");
		
		System.out.println("TC Pass");
		
		WebElement Name = driver.findElement(By.xpath("//input[@name='name']"));
		Assert.assertEquals(true, Name.isDisplayed());
		Name.sendKeys("Revfin");
		WebElement Mobile = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
		Assert.assertEquals(true, Mobile.isDisplayed());
		Mobile.sendKeys("7586425641");
		WebElement Mail = driver.findElement(By.xpath("//input[@placeholder='Email ID']"));
		Assert.assertEquals(true, Mail.isDisplayed());
		Mail.sendKeys("revfin123@gmail.com");
		WebElement message = driver.findElement(By.xpath("//textarea[@placeholder='Your Message']"));
		Assert.assertEquals(true, message.isDisplayed());
		message.sendKeys("HI");
		WebElement button = driver.findElement(By.xpath("//button[text()='Submit']"));
		Assert.assertEquals(true, button.isEnabled());
		button.click();
		driver.quit();
	}

}
