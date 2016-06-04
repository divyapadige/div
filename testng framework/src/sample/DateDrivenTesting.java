package sample;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testng.Repository;

public class DateDrivenTesting extends Repository{

	
	@BeforeTest(groups={"branches", "employee", "role","creation"})
	public void verifyLaunch() {
		launch();
	}  
	@BeforeClass(groups={"branches","employee","role","creation"})
	public void verifyLogin() {
		login();
	}

	@Test(priority = 0,groups={"branches","creation"},timeOut=10000, description="branch creation method which has to be executed within 10 seconds")
	public void verifyBranchCreation() {
		// launch();
		// login();
		
		clickBranchesButton();
		Excel.setExcel("inputdata.xls", 0);
		Excel.setOutputExcel("inputdata.xls", "output.xls", "Sheet1");
		int rc = Excel.getColumnCount();
		for(int i=1; i<rc;i++){
			clickNewBranchButton();
			fillBranchDetails(Excel.readData(i, 0),Excel.readData(i, 1),Excel.readData(i, 2),Excel.readData(i, 3),Excel.readData(i, 4),Excel.readData(i, 5));
			bsubmit();
			String result = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			Excel.writedata(result, i, 6);
		}
		Excel.saveWorkbook();
		
	}
}
