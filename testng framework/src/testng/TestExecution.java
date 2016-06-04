package testng;

import org.testng.Reporter;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(testng.TListener.class)

public class TestExecution extends Repository {
	
	

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
//		//Reporter.log("branch clicked succesfully", true);
		clickNewBranchButton();
//		//Reporter.log("new branch button clicked succesfully", true);
//		fillBranchDetails();
//		//Reporter.log("branch details filled succesfully", true);
		bsubmit();
//		//Reporter.log("branch submit clicked succesfully", true);
		driver.switchTo().alert().accept();
	}

	@Test(priority = 7, groups={"branches"})
	public void verifyBranchSearch() throws InterruptedException  {
		clickBranchesButton();
//		//Reporter.log("branches clikced successfully", true);
		branchDetailsSearch();
//		//Reporter.log("branches serach details filled successfully", true);
		clickBranchSearch();
		Thread.sleep(5000);
//		//Reporter.log("search button clikced successfully", true);
	}

	@Test(priority =6, dependsOnMethods={"verifyBranchSearch","verifyBranchCreation"})
	public void verifyBranchSearchClear() {
		branchDetailsClear();
		//Reporter.log("breach serach cleared", true);
	}

	@Test(priority =5, groups={"role","creation"})
	public void verifyRoleCreation() {
		// launch();
		// login();
		clickRolesButton();
		//Reporter.log("roles clicked succesfully", true);
		newroles_button();
		//Reporter.log("new role clicked succesfully", true);
		newRoleCreation_page();
		//Reporter.log("role details filled succesfully", true);
		submitbutton();
		//Reporter.log("role submit clicked succesfully", true);
		driver.switchTo().alert().accept();
	}

	@Test(priority =4, groups={"employee","creation"})
	public void verifyEmployeeCreation() {
		// launch();
		// login();
		clickEmployeeButton();
		//Reporter.log("employee clicked succesfully", true);
		newemployee_button();
		//Reporter.log("new employee clicked succesfully", true);
		newEmployeeCreation_page();
		//Reporter.log("employee details filled succesfully", true);
		submit_button();
		//Reporter.log("employee submit clicked succesfully", true);
		driver.switchTo().alert().accept();
	}

	@Test(priority = 2, groups={"branches"})
	public void verifyBracnhCreationReset() {
		clickBranchesButton();
		//Reporter.log("branch clicked succesfully", true);
		clickNewBranchButton();
		//Reporter.log("new branch button clicked succesfully", true);
//		fillBranchDetails();
		//Reporter.log("branch details filled succesfully", true);
		bReset();
		//Reporter.log("teset button clicked succesfully", true);
	}
	
	@Test(priority = 3, groups={"branches"})
	public void verifyBracnhCreationCancel() {
		clickBranchesButton();
		//Reporter.log("branch clicked succesfully", true);
		clickNewBranchButton();
		//Reporter.log("new branch button clicked succesfully", true);
//		fillBranchDetails();
		//Reporter.log("branch details filled succesfully", true);
		bcancel();
		//Reporter.log("cancel button clicked succesfully", true);
	}

	@AfterClass(groups={"branches", "employee","role"})
	public void verifyLogout() {
		// launch();
		// login();
		clickLogoutButton();
	}
}
