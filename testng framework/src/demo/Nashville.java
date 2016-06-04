package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Nashville {
	@Test
	public void nashVille(){
		System.setProperty("webdriver.chrome.driver", "//Users//surya//Documents//Selenium/Selenium softwares//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://epermits.nashville.gov/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//do login
		driver.findElement(By.linkText("Apply for a Permit")).click();
		driver.findElement(By.id("inputEmail")).sendKeys("156569");
		driver.findElement(By.id("inputPassword")).sendKeys("156566");
		driver.findElement(By.xpath("//button[text()='Log in to ePermits']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'#/newPermit/terms')]/button")).click();
		driver.findElement(By.xpath("//button[text()='Okay']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'#/newPermit/noParent')]")).click();
		driver.findElement(By.xpath("//button[text()='Search']")).click();
	}

}
