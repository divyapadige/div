package demo;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;

public class InterviewClass {

	public WebDriver driver;
	public Workbook book;
	public Sheet sh;

	public int appearCount(String searchText, String searchContent) {
		int count = 0;
		String sc[] = searchContent.split(" ");
		for (int i = 0; i < sc.length; i++) {
			if (searchText.matches(sc[i])) {
				count++;
			}
		}
		return count;
	}

	public String[][] getExceContents(String filename, String sheetname) {
		String exceldata[][] = null;
		try {
			File f = new File("path of the file" + filename);
			book = Workbook.getWorkbook(f);
			sh = book.getSheet(sheetname);
			int rc = sh.getRows();
			int cc = sh.getColumns();
			exceldata = new String[rc - 1][cc];
			for (int i = 1; i < rc; i++) {
				for (int j = 0; j < cc; j++) {
					exceldata[i - 1][j] = sh.getCell(j, i).getContents();
				}
			}
			return exceldata;
		} catch (Exception e) {
			return null;
		}
	}

	@DataProvider(name = "data")
	public Object[][] excelData() {
		return getExceContents("input.xls", "Sheet1");
	}
	// String alertText = "The input 'Hello' appears 1 time(s) in the search
	// content";

	@BeforeTest
	@Parameters({ "br" })
	public void launch(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "path of the driver");
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}else{
			driver = new HtmlUnitDriver();
		}
		driver.get("http://www.abc.com/findtext.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void close() {
		driver.close();
	}

	// //first question
	// @Test
	// public void validation() {
	// String searchTerm = "Hello";
	// String searchContent = "Hello world";
	// driver.findElement(By.id("seaterm")).sendKeys(searchTerm);
	// driver.findElement(By.id("seaterm")).sendKeys(searchContent);
	// driver.findElement(By.id("findBut")).click();
	// String alertText = driver.switchTo().alert().getText();
	// driver.switchTo().alert().accept();
	//
	// int c = appearCount(searchTerm, searchContent);
	// String at[] = alertText.split(" ");
	//
	// if(c == Integer.parseInt(at[4])){
	// System.out.println("Stirngterm appered in String content "+c+" times,
	// alert text showing count as "+at[4]+" content matched");
	// }else{
	// System.out.println("Stirngterm appered in String content "+c+" times,
	// alert text showing count as "+at[4]+" content not matched");
	// }
	// //
	// }

	// second question
	@Test(dataProvider = "data")
	public void secondQuestion(String searchTerm, String searchContent) {
		driver.findElement(By.id("seaterm")).sendKeys(searchTerm);
		driver.findElement(By.id("seaterm")).sendKeys(searchContent);
		driver.findElement(By.id("findBtn")).click();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();

		int c = appearCount(searchTerm, searchContent);
		String at[] = alertText.split(" ");

		if (c == Integer.parseInt(at[4])) {
			Reporter.log("Stirngterm appered in String content " + c + " times, alert text showing count as " + at[4]
					+ " content matched");
		} else {
			Reporter.log("Stirngterm appered in String content " + c + " times, alert text showing count as " + at[4]
					+ " content not matched");
		}
	}

	

}
