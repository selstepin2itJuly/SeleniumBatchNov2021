package testcases;

import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.Utility;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	private WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;
	private ForgotPasswordPage fp;
  @Test(priority=2, description="Login Successful")
  public void loginSuccess001() {
	  lp.loginToApplication("Admin", "admin123");
	  boolean exp = dp.isWelcomeDisplayed();
	  Utility.attachScreenshotToReport();
	  Reporter.log("Output:"+exp);
	  assertTrue(exp);
  }
  
  @Test(priority=1, description="Wrong password for unsusccessful login")
  public void loginUnsuccess002() {
	  lp.loginToApplication("Admin", "admin1234");
	  boolean exp = lp.isErrorMsgDisplayed();
	  Utility.attachScreenshotToReport();
	  Reporter.log("Output:"+exp);
	  assertTrue(exp);
	  assertEquals(lp.getErrorText(),"Invalid Credentials");
  }
  
  @Test(priority=3, description="Forgot Password lin")
  public void ForgotPassword003() {
	  lp.clickOnForgotPassLink();
	  Utility.attachScreenshotToReport();
	  Reporter.log("Output:"+fp.isForgotPassowrdMessageDisplayed());
	  assertTrue(fp.isForgotPassowrdMessageDisplayed());
	  fp.clickOnCancel();
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  dr=TestBase.getInstance();
	  lp=new LoginPage(dr);
	  dp=new DashboardPage(dr);
	  fp= new ForgotPasswordPage(dr);
  }

  @AfterMethod
  public void afterMethod() {
	  dr.quit();
  }

}
