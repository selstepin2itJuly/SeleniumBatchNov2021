package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

private WebDriver dr;
	
	public LoginPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(id="txtUsername")
	private WebElement username;
	
	@FindBy(name="txtPassword")
	private WebElement password;
	
	@FindBy(className="button")
	private WebElement login;
	
	@FindBy(linkText="Forgot your password?")
	private WebElement forgotLink;
	
	@FindBy(id="spanMessage")
	private WebElement errorMsg;
	
	public void loginToApplication(String user, String pass) 
	{
		username.clear();
		username.sendKeys(user);
		password.clear();
		password.sendKeys(pass);
		login.click();
	}
	
	public void clickOnForgotPassLink()
	{
		forgotLink.click();
	}
	
	public boolean isErrorMsgDisplayed()
	{
		boolean b=false;
		try {
			b=errorMsg.isDisplayed();
		}catch(Exception e)
		{
			
		}
		return b;
	}
	
	public String getErrorText()
	{
		return errorMsg.getText().trim();
	}
}
