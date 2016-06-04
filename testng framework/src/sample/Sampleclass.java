package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sampleclass {
	public WebDriver driver;

//	@Parameters({ "fb" })
	@Test(priority = 1)
	public void testone() {
//		if (fb.equals("firefox")) {
		System.out.println(Thread.currentThread().getId());
			driver = new FirefoxDriver();
//		}
	}

//	@Parameters({ "cb" })
	@Test(priority = 2)
	public void testtwo() {
//		if (cb.equals("chrome")) {
		System.out.println(Thread.currentThread().getId());
			System.setProperty("webdriver.chrome.driver",
					"//Users//surya//Documents//Selenium//Selenium softwares//chromedriver");
			driver = new ChromeDriver();
//		}
	}
	
//	@Parameters({"br","url"})
//	@BeforeTest
//	public void launch(String b, String url) throws InterruptedException{
//		if(b.equals("firefox")){
//			driver = new FirefoxDriver();
//		}else if(b.equals("chrome")){
//			System.setProperty("webdriver.chrome.driver",
//					"//Users//surya//Documents//Selenium//Selenium softwares//chromedriver");
//			driver = new ChromeDriver();
//		}
//		driver.get(url);
//		Thread.sleep(5000);
//		driver.close();
//	}
	

	
}
