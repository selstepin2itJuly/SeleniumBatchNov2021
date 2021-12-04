package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
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

public class DashboardTest {

	private WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;

	@Test(priority=1, description="Quick launch items", enabled=true)
	public void DashboardQuickLaunchItems004() {
		dp.clickOnDashboard();
		List<String> actual = dp.getQuickLinkItemText();
		List<String> exp = new ArrayList<String>();
		exp.add("Assign Leave");
		exp.add("Leave List");
		exp.add("Timesheets");
		exp.add("Apply Leave");
		exp.add("My Leave");
		exp.add("My Timesheet");
		Utility.attachScreenshotToReport();
		Reporter.log("Exp:"+exp);
		Reporter.log("Act:"+actual);
		assertEquals(exp, actual);
	}

	@Test(priority=-1, description="Quick Launch item count")
	public void DashboardQuickLaunchCount006() {
		Reporter.log("Output:"+dp.getQuickLinkCount());
		assertEquals(dp.getQuickLinkCount(), 6);
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		dr = TestBase.getInstance();
		lp = new LoginPage(dr);
		dp = new DashboardPage(dr);
		lp.loginToApplication("Admin", "admin123");
		assertTrue(dp.isWelcomeDisplayed());
	}

	@AfterClass
	public void afterClass() {
		dr.quit();
	}

}
