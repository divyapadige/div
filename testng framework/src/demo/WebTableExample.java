package demo;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTableExample {
	public WebDriver driver;

	@BeforeTest
	public void launchApp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.bseindia.com/markets/equity/EQReports/MarketWatch.aspx?expandable=2");
	}

	public boolean status = false;

	@Test
	public void webtableExp() {
		boolean flag = false;
		WebElement table = driver.findElement(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_grd1']"));
		ArrayList<WebElement> rows = new ArrayList<>(table.findElements(By.tagName("tr")));
		String[] pageLinks = rows.get(rows.size() - 1).getText().split(" ");
		System.out.println(pageLinks.length);
		for (int i = 1; i < pageLinks.length; i++) {
			table = driver.findElement(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_grd1']"));
			rows = new ArrayList<>(table.findElements(By.tagName("tr")));
			//rows loop
			for (int j = 0; j < rows.size(); j++) {
				// System.out.println(i+"row value is :"+rows.get(i).getText());
				if (rows.get(j).getText().contains("515055")) {
					// System.out.println(rows.get(i).getText());
					// rows.get(i).findElement(By.xpath("//td[2]/a")).click();
					ArrayList<WebElement> cells = new ArrayList<>(rows.get(j).findElements(By.tagName("td")));
					// System.out.printl(cells.get(1).getText());
					cells.get(1).findElement(By.tagName("a")).click();
					flag = true;
					break;//rows
				}
			}
			if(flag == true)
				break;//pages
			try {
				if (pageLinks[i].contains("...") && status == true) {
					table.findElement(By.xpath("(//a[contains(.,'...')])[2]")).click();
				} else {
					table.findElement(By.linkText(pageLinks[i])).click();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (pageLinks[i].contains("...")) {
				status = true;
				webtableExp();
			}
		}
		// for(WebElement i:rows){
		// System.out.println(i.getText());
		// }

		// for (int i = 0; i < rows.size(); i++) {
		// // System.out.println(i+"row value is :"+rows.get(i).getText());
		// if (rows.get(i).getText().contains("532648")) {
		// // System.out.println(rows.get(i).getText());
		// // rows.get(i).findElement(By.xpath("//td[2]/a")).click();
		// ArrayList<WebElement> cells = new
		// ArrayList<>(rows.get(i).findElements(By.tagName("td")));
		//// System.out.printl(cells.get(1).getText());
		// cells.get(1).findElement(By.tagName("a")).click();
		// break;
		// }
		// }

		// to print second column data
		// for (int i = 1; i < rows.size(); i++) {
		// ArrayList<WebElement> cells = new
		// ArrayList<>(rows.get(i).findElements(By.tagName("td")));
		// // System.out.println(cells.size());
		// if (rows.get(i).getText().contains("534076")) {
		// System.out.println("name is: "+cells.get(1).getText()+" no of trades
		// are: "+cells.get(cells.size()-1).getText());
		// break;
		// }
		// for (int i = 0; i < cells.size(); i++) {
		// System.out.println(cells.get(1).getText());
		// break;
		// }
		// }
	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
