package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {


private WebDriver dr;
	
	public ForgotPasswordPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//*[text()='Forgot Your Password?']")
	private WebElement forgotText;
	
	@FindBy(id="btnSearchValues")
	private WebElement cancelButton;
	
	public boolean isForgotPassowrdMessageDisplayed()
	{
		boolean b=false;
		try {
			b=forgotText.isDisplayed();
		}catch(Exception e)
		{}
		
		return b;
	}
	
	public void clickOnCancel()
	{
		cancelButton.click();
	}
}
