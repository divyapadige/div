package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SampleClassTwo {
	public WebDriver driver;
	@Test(priority=0, invocationCount=3, threadPoolSize=3)
	public void methodThree() throws InterruptedException{
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		Thread.sleep(5000);
		System.out.println(Thread.currentThread().getId());
		
	}
	
}
