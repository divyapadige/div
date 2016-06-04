package sample;

import org.testng.annotations.Test;
import testng.Repository;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class DataProviderExample extends Repository {

	// @Test(pirodataProvider = "datatwo")
	// public void f(Integer n, String s, String a,Integer n1, String s1, String
	// a1,String z ) {
	// System.out.println(n + " " + s + " " + a );
	// }
	@BeforeTest(groups={"branches", "employee", "role","creation"})
	public void verifyLaunch() {
		launch();
	}  
	@BeforeClass(groups={"branches","employee","role","creation"})
	public void verifyLogin() {
		login();
	}
	@Test(dataProvider = "branchCreationData")
	public void verifyBranchCreation(String bname, String add1, String zcode, String country, String s, String c) {
		clickBranchesButton();
		clickNewBranchButton();
		fillBranchDetails(bname, add1, zcode, country,s,c);
		bsubmit();
		String result = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
	}

	@DataProvider(name = "dataone")
	public Object[][] branchedata() {
		return new Object[][] { new Object[] { 1, "arnitha", "sr nagar", "521001" },
				new Object[] { 2, "divya", "sr nagar", "53114" }, new Object[] { 1, "himaja", "sr nagar", "521001" },
				new Object[] { 1, "ammu", "sr nagar", "521001" }, new Object[] { 1, "venkat", "sr nagar", "521001" } };
	}

	@DataProvider(name = "datatwo")
	public Object[][] roledata() {
		return new Object[][] { new Object[] { 1, "arnitha", "sr nagar" }, new Object[] { 2, "divya", "sr nagar" },
				new Object[] { 1, "himaja", "sr nagar" } };
	}

	@DataProvider(name = "branchCreationData")
	public Object[][] bcdata() {
		// Object[][] input = getExcelData("inputdata.xls", "Sheet1");
		// return input;
		return getExcelData("inputdata.xls", "Sheet1");
	}

	
	@DataProvider(name="roleCreationData")
	public Object[][] rcdata(){
		return getExcelData("rolecreation.xls", "Sheet1");
	}
	public String[][] getExcelData(String filename, String sheetname) {
		String[][] data = null;
		Excel.setExcel(filename, sheetname);
		int rc = Excel.getRowCount();
		int cc = Excel.getColumnCount();
		data = new String[rc - 1][cc];
		for (int r = 1; r < rc; r++) {
			for (int c = 0; c < cc; c++) {
				data[r - 1][c] = Excel.readData(r, c);
			}
		}
		return data;
	}
}
