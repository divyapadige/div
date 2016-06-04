package demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Baseclass {
	@BeforeTest
	public void testMethod(){
		System.out.println("before test method from base class");
	}
	
	@AfterTest
	public void testMethod1(){
		System.out.println("After test method from base class");
	}
	
	@BeforeClass
	public void classmethod(){
		System.out.println("Before class method from base class");
	}
	
	@AfterClass
	public void classmethod1(){
		System.out.println("after class method from base class");
	}
	
	@Test(priority=0)
	public void methodOne(){
		System.out.println("mehtod one form base class");
	}
	
	@Test(priority=1)
	public void methodTwo(){
		System.out.println("mehtod two form base class");
	}
	
	@Test(priority=2)
	public void methodfive(){
		System.out.println("mehtod five form base class");
	}
	
	@Test(priority = 3)
	public void methodSix(){
		System.out.println("mehtod six form base class");
	}
	
	@Test(priority =4)
	public void methodSeven(){
		System.out.println("mehtod seven form base class");
	}

}
