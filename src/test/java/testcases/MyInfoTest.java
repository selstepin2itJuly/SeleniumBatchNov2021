package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfoPage;
import testbase.TestBase;
import utilities.Utility;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class MyInfoTest {
	private WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;
	private MyInfoPage ip;

	@Test(priority=1, description="My info side menu items")
	public void myInfoSideNavItems005() {
		dp.clickOnDashboard();
		ip.clickOnMyInfo();
		List<String> actual = ip.getSideNavText();
		List<String> exp = new ArrayList<String>();
		exp.add("Personal Details");
		exp.add("Contact Details");
		exp.add("Emergency Contacts");
		exp.add("Dependents");
		exp.add("Immigration");
		exp.add("Job");
		exp.add("Salary");
		exp.add("Tax Exemptions");
		exp.add("Report-to");
		exp.add("Qualifications");
		exp.add("Memberships");
		Utility.attachScreenshotToReport();
		Reporter.log("Exp:"+exp);
		Reporter.log("Act:"+actual);
		assertEquals(exp, actual);
	}

	@Test(priority=2, description="My info side menu item count")
	public void myInfoSideNavItemsCount007() {
		Utility.attachScreenshotToReport();
		Reporter.log("Actual:"+ip.getSideNavCount());
		assertEquals(ip.getSideNavCount(), 11);
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		dr = TestBase.getInstance();
		lp = new LoginPage(dr);
		dp = new DashboardPage(dr);
		ip = new MyInfoPage(dr);
		lp.loginToApplication("Admin", "admin123");
		assertTrue(dp.isWelcomeDisplayed());
	}

	@AfterClass
	public void afterClass() {
		dr.quit();
	}

}
