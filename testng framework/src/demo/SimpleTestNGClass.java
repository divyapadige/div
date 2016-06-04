package demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.testng.TestNG;
import org.testng.xml.Parameters;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;

public class SimpleTestNGClass {

	public static void simpleTestNGTest() {
		//represents suites tag in testng.xml
		ArrayList<XmlSuite> suites = new ArrayList<>();
		
		
		//represents classes tag
		List<XmlClass> hclasses = new ArrayList<>();
		List<XmlClass> aclasses = new ArrayList<>();
//		List<XmlPackage> pckgs = new ArrayList<>();
		
		//create a suite and set the name of the suite
		XmlSuite hsuite = new XmlSuite();
		hsuite.setName("himaja suite");
		
		//parallel mode for tests
		hsuite.setParallel(ParallelMode.TESTS);
		hsuite.setThreadCount(2);
		
		//parallel mode for class
		hsuite.setParallel(ParallelMode.CLASSES);
		
		//parallel mode for methods
		hsuite.setParallel(ParallelMode.METHODS);
		
		//parameters tag suite level and test level
		Map<String, String> suiteParameters= new HashMap<>();
		Map<String, String> htestParameters = new HashMap<>();
		Map<String, String> atestParameters = new HashMap<>();
		suiteParameters.put("url", "http://srssprojects.in");
		suiteParameters.put("uname", "Admin");
		suiteParameters.put("pwd", "Admin");
		hsuite.setParameters(suiteParameters);
		
		//represents test tag
		XmlTest htest = new XmlTest(hsuite);
		htest.setName("himaja test");
		
		//test level parameter
		htestParameters.put("browser", "firefox");
		htest.setParameters(htestParameters);
		
		//represent test tag and name the test
		XmlTest atest = new XmlTest(hsuite);
		atest.setName("arnitha test");
		
		//test level parameter
		atestParameters.put("browser", "chrome");
		atest.setParameters(atestParameters);
		
		//class tag represents different classes
		XmlClass cl = new XmlClass("testng.TestExecution");
		XmlClass cl1 = new XmlClass("demo.Baseclass");
		XmlClass c12 = new XmlClass("demo.Baseclass");
		
		//including methods in execution
		List<XmlInclude> includeMethods = new ArrayList<XmlInclude>();
		XmlInclude include = new XmlInclude("methodone");
		includeMethods.add(include);
		cl.setIncludedMethods(includeMethods);
		
		
		//add individual class to classes tag
		aclasses.add(c12);
		hclasses.add(cl);
		hclasses.add(cl1);
		
		//add classes tag to individual test tag
		htest.setXmlClasses(hclasses);
		atest.setXmlClasses(aclasses);
		
		//add suite tag to suites 
		suites.add(hsuite);
		
		//create an object of TestNG class
		TestNG tg = new TestNG();
		tg.setXmlSuites(suites);
		tg.run();
	}

	public static void main(String[] args) {
		simpleTestNGTest();
	}

}
