package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridDemo {

	public WebDriver driver;
	public DesiredCapabilities caps;

	// public String nodeURL = "http://192.168.0.15:5555/wd/hub";
	@BeforeTest
	@Parameters({ "nodeURL", "brower" })
	public void gridExample(String nodeURL, String b) throws MalformedURLException {

		if (b.equalsIgnoreCase("firefox")) {
			caps = new DesiredCapabilities();
			caps = DesiredCapabilities.firefox();
//			caps.setBrowserName("firefox");
//			caps.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(nodeURL), caps);
		} else if (b.equalsIgnoreCase("chrome")) {
			/*
			 * to launch chorme with node use the following command 
			 * java -jar  selenium standalone server.jar -Dwebdriver.chrome.driver=
			 * "path of the chrome driver" -role node -hub
			 * http://192.168.0.11/grid/register -browser
			 * "browserName=chrome, maxInstance=2"
			 */
			caps = new DesiredCapabilities();
			caps = DesiredCapabilities.chrome();
//			caps.setBrowserName("chrome");
//			caps.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL(nodeURL), caps);
		}else if(b.equalsIgnoreCase("ie")){
			caps = new DesiredCapabilities();
			caps = DesiredCapabilities.internetExplorer();
			driver = new RemoteWebDriver(new URL(nodeURL),caps);
		}

	
		System.out.println("driver object created succesfully");
		driver.get("http://www.srssprojects.in");
		System.out.println("navigated to " + driver.getTitle());
		driver.manage().window().maximize();
		System.out.println("browser maximized");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// driver.close();
	}

	@Test(priority = 0)
	public void test1() {
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();
	}

	@Test(priority = 1)
	public void test2() {
		driver.findElement(By.xpath("//img[@src='images/Branches_but.jpg']")).click();
	}

	@Test(priority = 2)
	public void test3() {
		driver.findElement(By.xpath("//img[@src='images/Roles_but.jpg']")).click();
	}

	@Test(priority = 3)
	public void test4() {
		driver.findElement(By.xpath("//img[@src='images/Users_but.jpg']")).click();
	}

	@Test(priority = 4)
	public void test5() {
		driver.findElement(By.xpath("//img[@src='images/emp_btn.jpg']")).click();
	}

	@Test(priority = 5)
	public void test6() {
		driver.findElement(By.xpath("//img[@src='images/admin_but_03.jpg']")).click();
	}

}
