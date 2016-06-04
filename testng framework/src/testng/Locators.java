package testng;

import org.openqa.selenium.By;

public class Locators {

	// login form elements
	public static By username = By.id("txtuId");
	public static By password = By.id("txtPword");
	public static By loginButton = By.id("login");

	// branches button
	public static By branchesButton = By.xpath("//img[@src='images/Branches_but.jpg']");
	public static By rolesButton = By.xpath("//img[@src='images/Roles_but.jpg']");
	public static By employeeButton = By.xpath("//img[@src='images/emp_btn.jpg']");
	public static By usersButton = By.xpath("//img[@src='images/Users_but.jpg']");
	public static By homeButton = By.xpath("//img[@src='images/admin_but_01.jpg']");
	public static By logoutButton = By.xpath("//img[@src='images/admin_but_03.jpg']");

	public static By newBranchButton = By.id("BtnNewBR");
	// branch creation
	// locators for Branch Creation
	public static By BC_TB_BranchName = By.xpath("//input[@id='txtbName']");
	public static By BC_TB_Address1 = By.xpath("//input[@id='txtAdd1']");
	public static By BC_TB_Address2 = By.xpath("//input[@id='Txtadd2']");
	public static By BC_TB_Address3 = By.xpath("//input[@id='txtadd3']");
	public static By BC_TB_Area = By.xpath("//input[@id='txtArea']");
	public static By BC_TB_ZipCode = By.xpath("//input[@id='txtZip']");
	public static By BC_LB_Country = By.xpath("//select[@id='lst_counrtyU']");
	public static By BC_LB_State = By.xpath("//select[@id='lst_stateI']");
	public static By BC_LB_City = By.xpath("//select[@id='lst_cityI']");
	public static By BC_Button_Submit = By.xpath("//input[@id='btn_insert']");
	public static By BC_Button_Reset = By.xpath("//input[@id='Btn_Reset']");
	public static By BC_Button_Cancel = By.xpath("//input[@id='Btn_cancel']");

	// branch updation
	public static By BranchName_update = By.xpath("//input[@id='txtbName']");
	public static By Address1_update = By.xpath("//input[@id='txtAdd1']");
	public static By Address2_update = By.xpath("//input[@id='Txtadd2']");
	public static By Address3_update = By.xpath("//input[@id='txtadd3']");
	public static By Area_update = By.xpath("//input[@id='txtArea']");
	public static By ZipCode_update = By.xpath("//input[@id='txtZip']");
	public static By Country_update = By.xpath("//select[@id='lst_counrtyU']");
	public static By State_update = By.xpath("//select[@id='lst_stateI']");
	public static By City_update = By.xpath("//select[@id='lst_cityI']");
	public static By bupdate_Button = By.xpath("//input[@id='btnupdate']");
	public static By bCancel_Button = By.xpath("//input[@id='Btncancel']");

	// Elements in Employee Page
	public static By New_Employee = By.xpath("//input[@type='image']");
	public static By New_Role = By.xpath("//input[@id='btnRoles']");

	// user search
	// user searchfields
	public static By userSelectBranch = By.xpath("//select[@id='lst_branchS']");
	public static By userSelectRole = By.xpath("//select[@id='lst_rolesS']");
	public static By userSearchbutton = By.xpath("//input[@id='btn_search']");
	public static By userSearchClear = By.xpath("//input[@id='btn_clear']");

	// Elements in New Employee Page
	public static By Employername = By.name("txtUname");
	public static By LoginPassword = By.name("txtLpwd");
	public static By Role = By.name("lst_Roles");
	public static By Branch = By.name("lst_Branch");
	public static By Submit_Button = By.name("BtnSubmit");
	public static By ResetButton = By.name("//*[@id='Btn_Reset']");
	public static By CancelButton = By.name("//*[@id='Btn_cancel']");

	// Elements in Role page

	public static By RoleName = By.name("txtRname");
	public static By RoleDesc = By.name("txtRDesc");
	public static By RoleType = By.name("lstRtypeN");
	public static By SubmitButton = By.xpath("//*[@id='btninsert']");

	// role update page
	public static By rolename_update = By.xpath("//input[@id='txtrNameU']");
	public static By Roledec_update = By.xpath("//input[contains(@id,'txtrdescU')]");
	public static By roletype_update = By.xpath("//select[contains(@id,'lstRtype')]");
	public static By roleupdatebutton = By.xpath("//input[@id='btnupdate']");
	public static By rolecancelbutton_update = By.xpath("//input[@id='Btncancel']");

	// employee updation page
	public static By Employername_update = By.xpath("//input[@id='txtUname']");
	public static By loginpassword_update = By.xpath("//input[@id='txtLpwd']");
	public static By Rolefield_update = By.xpath("//select[@id='lst_Roles']");
	public static By Branchfield_update = By.xpath("//select[@id='lst_Branch']");
	public static By empUpdatebutton = By.xpath("//input[@id='btnreset']");
	public static By empcancelbutton_update = By.xpath("//input[@id='btnCancel']");

	// Elements in Employee Updation P429age
	public static By Banker_id = By.xpath("//span[@id='lbBidU']");
	public static By Employer_Name = By.name("txtBnameU");
	public static By Login_Password = By.name("txtPwdU");
	public static By EmployeeUpdation_Role = By.name("lstrolesU");
	public static By EmployeeUpdation_Branch = By.name("lstBidU");
	public static By Update_Button = By.xpath("//*[@id='BtnUpdate']");
	public static By Updatecancel_Button = By.xpath("//*[@id='btncancelU']");

	// locators for Branch details Page
	public static By BD_LB_Country = By.xpath("//select[@id='lst_countryS']");
	public static By BD_LB_State = By.xpath("//select[@id='lst_stateS']");
	public static By BD_LB_City = By.xpath("//select[@id='lst_cityS']");
	public static By BD_TB_Search = By.xpath("//input[@id='btn_search']");
	public static By BD_TB_Clear = By.xpath("//input[@id='btn_clsearch']");

}
