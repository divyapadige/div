package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import demo.UCDriver;

public class Repository {

	protected WebDriver d;
	public EventFiringWebDriver driver;


	// application launch
	public void launch() {
		d = new FirefoxDriver();
		driver = new EventFiringWebDriver(d);
		EventListener el = new EventListener();
		driver.register(el);
		
		driver.get("http://srssprojects.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	// login method
	public void login() {
		driver.findElement(Locators.username).sendKeys(TestData.username);
		driver.findElement(Locators.password).sendKeys(TestData.password);
		driver.findElement(Locators.loginButton).click();
	}

	public void clickLogout() {
		driver.findElement(Locators.logoutButton).click();
	}

	// Admin home page related
	// click on branches button
	public void clickBranchesButton() {
		driver.findElement(Locators.branchesButton).click();
	}

	public void clickNewBranchButton() {
		driver.findElement(Locators.newBranchButton).click();
	}

	public void fillBranchDetails(String bname, String add1, String zcode, String country, String state, String city) {
		driver.findElement(Locators.BC_TB_BranchName).sendKeys(bname);
		driver.findElement(Locators.BC_TB_Address1).sendKeys(add1);
//		driver.findElement(Locators.BC_TB_Address2).sendKeys();
//		driver.findElement(Locators.BC_TB_Address3).sendKeys();
//		driver.findElement(Locators.BC_TB_Area).sendKeys();
		driver.findElement(Locators.BC_TB_ZipCode).sendKeys(zcode);
		new Select(driver.findElement(Locators.BC_LB_Country)).selectByVisibleText(country);
		new Select(driver.findElement(Locators.BC_LB_State)).selectByVisibleText(state);
		new Select(driver.findElement(Locators.BC_LB_City)).selectByVisibleText(city);
	}

	public void bsubmit() {

		driver.findElement(Locators.BC_Button_Submit).click();
	}

	public void bReset() {

		driver.findElement(Locators.BC_Button_Reset).click();
	}

	public void bcancel() {

		driver.findElement(Locators.BC_Button_Cancel).click();
	}

	public void editbranch() {

		driver.findElement(Locators.BranchName_update).sendKeys(TestData.BranchName_update);

		driver.findElement(Locators.Address1_update).sendKeys(TestData.Address1_update);

		driver.findElement(Locators.Address2_update).sendKeys(TestData.Address2_update);

		driver.findElement(Locators.Address3_update).sendKeys(TestData.Address3_update);
		driver.findElement(Locators.Area_update).sendKeys(TestData.Area_update);

		driver.findElement(Locators.ZipCode_update).sendKeys(TestData.ZipCode_update);

		driver.findElement(Locators.Country_update).sendKeys(TestData.Country_update);
		driver.findElement(Locators.State_update).sendKeys(TestData.State_update);
		driver.findElement(Locators.City_update).sendKeys(TestData.City_update);

	}

	// fill user search
	public void usersearch() {
		driver.findElement(Locators.userSelectBranch).sendKeys(TestData.userSelectBranch);
		driver.findElement(Locators.userSelectRole).sendKeys(TestData.userSelectRole);
	}

	// usersearch button
	public void usersearchbutton() {
		driver.findElement(Locators.userSearchbutton).click();
	}

	// user search clear
	public void usersearchclear() {
		driver.findElement(Locators.userSearchClear).click();
	}

	// click on roles button
	public void clickRolesButton() {
		driver.findElement(Locators.rolesButton).click();
	}

	// click on employee button
	public void clickEmployeeButton() {
		driver.findElement(Locators.employeeButton).click();
	}

	// click home button
	public void clickHomeButton() {
		driver.findElement(Locators.homeButton).click();
	}

	// click logout button
	public void clickLogoutButton() {
		driver.findElement(Locators.logoutButton).click();
	}

	// for NewEmployee_Button
	public void newemployee_button() {
		driver.findElement(Locators.New_Employee).click();
	}

	// for newRole Button
	public void newroles_button() {
		driver.findElement(Locators.New_Role).click();
	}

	// for newroleCreation page
	public void newRoleCreation_page() {
		driver.findElement(Locators.RoleName).sendKeys(TestData.Rolename);
		driver.findElement(Locators.RoleDesc).sendKeys(TestData.RoleDesc);
		driver.findElement(Locators.RoleType).sendKeys(TestData.RoleType);
	}

	// for newEmployeeCreation page
	public void newEmployeeCreation_page() {
		driver.findElement(Locators.Employername).sendKeys(TestData.Employername);
		driver.findElement(Locators.LoginPassword).sendKeys(TestData.LoginPassword);
		// driver.findElement(Locators.Role).sendKeys(Testdata.Role);
		Select s = new Select(driver.findElement(Locators.Role));
		s.selectByVisibleText(TestData.Role);

		Select s1 = new Select(driver.findElement(Locators.Branch));
		s1.selectByVisibleText("hyderabad");

	}

	// for Submit_Button
	public void submit_button() {
		driver.findElement(Locators.Submit_Button).click();
	}

	public void submitbutton() {
		driver.findElement(Locators.SubmitButton).click();
	}

	// for Reset_Button
	public void reset_button() {
		driver.findElement(Locators.ResetButton).click();
	}

	// for Cancel_Button
	public void cancel_button() {
		driver.findElement(Locators.CancelButton).click();
	}

	public void roleupdate() {
		driver.findElement(Locators.rolename_update).sendKeys(TestData.rolename_update);
		driver.findElement(Locators.Roledec_update).sendKeys(TestData.Roledec_update);
		driver.findElement(Locators.roletype_update).sendKeys(TestData.roletype_update);

	}

	public void roleupdatebutton() {
		driver.findElement(Locators.roleupdatebutton).click();
	}

	public void rolecancelbutton() {
		driver.findElement(Locators.rolecancelbutton_update).click();
	}

	public void employeesimage() {

		driver.findElement(Locators.employeeButton).click();
	}

	public void newemployee() {
		driver.findElement(Locators.Employername).sendKeys(TestData.employername);
		driver.findElement(Locators.LoginPassword).sendKeys(TestData.loginpassword);
		driver.findElement(Locators.Role).sendKeys(TestData.rolefield);
		driver.findElement(Locators.Branch).sendKeys(TestData.branchfield);

	}

	public void empsubmit() {
		driver.findElement(Locators.Submit_Button).click();
	}

	public void empreset() {
		driver.findElement(Locators.ResetButton).click();
	}

	public void empcancel() {
		driver.findElement(Locators.CancelButton).click();
	}

	public void editemployee() {
		driver.findElement(Locators.Employername_update).sendKeys(TestData.employername_update);
		driver.findElement(Locators.loginpassword_update).sendKeys(TestData.loginpassword_update);
		driver.findElement(Locators.Rolefield_update).sendKeys(TestData.branchfield_update);
		driver.findElement(Locators.Branchfield_update).sendKeys(TestData.branchfield_update);

	}

	public void empupdate() {
		driver.findElement(Locators.empUpdatebutton).click();
	}

	public void empucancel() {
		driver.findElement(Locators.empcancelbutton_update).click();
	}

	// for Employee updation
	public void employeeUpdation() {
		driver.findElement(Locators.Banker_id).sendKeys(TestData.Banker_id);
		driver.findElement(Locators.Employer_Name).sendKeys(TestData.Employer_Name);
		driver.findElement(Locators.Login_Password).sendKeys(TestData.Login_Password);
		Select s = new Select(driver.findElement(Locators.EmployeeUpdation_Role));
		s.selectByVisibleText(TestData.EmployeeUpdation_Role);

		Select s1 = new Select(driver.findElement(Locators.EmployeeUpdation_Branch));
		s1.selectByVisibleText(TestData.EmployeeUpdation_Branch);

	}

	// for Cancel_Button
	public void update_button() {
		driver.findElement(Locators.Update_Button).click();
	}

	// for employee updation cancel button
	public void Updatecancel_Button() {
		driver.findElement(Locators.Updatecancel_Button).click();
	}

	// Repository
	public void branchDetailsSearch() {
		new Select(driver.findElement(Locators.BD_LB_Country)).selectByVisibleText(TestData.BD_Country);
		new Select(driver.findElement(Locators.BD_LB_State)).selectByVisibleText(TestData.BD_State);
		new Select(driver.findElement(Locators.BD_LB_City)).selectByVisibleText(TestData.BD_City);
	}
	
	public void clickBranchSearch(){
		driver.findElement(Locators.BD_TB_Search).click();
	}

	public void branchDetailsClear() {
		driver.findElement(Locators.BD_TB_Clear).click();
	}

}
