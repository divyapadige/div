package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClassTwo{
	@BeforeTest
	public void testm(){
		WebDriver driver = new FirefoxDriver();
		System.out.println("before test method from classtwo");
	}
	
	@Test(priority=0)
	public void methodThree(){
		System.out.println(Thread.currentThread().getId());
		System.out.println("mehtod Three form  class two");
	}
	
	@Test(priority=1)
	public void methodFour(){
		System.out.println(Thread.currentThread().getId());
		System.out.println("mehtod Four form class two");
	}
}
