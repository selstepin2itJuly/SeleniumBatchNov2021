package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utility;

public class DashboardPage {

private WebDriver dr;
	
	public DashboardPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(id="welcome")
	private WebElement welcome;
	
	@FindBy(id="menu_dashboard_index")
	private WebElement dashboard;
	
	@FindBy(className="quickLinkText")
	private List<WebElement> quickLink;
	
	public boolean isWelcomeDisplayed()
	{
		boolean b=false;
		Utility.waitForElementToVisible(welcome);
		try {
			b=welcome.isDisplayed();
		}
		catch(Exception e)
		{}
		
		return b;
	}
	
	public void clickOnDashboard()
	{
		dashboard.click();
	}
	
	public int getQuickLinkCount()
	{
		return quickLink.size();
	}
	
	public List<String> getQuickLinkItemText()
	{
		List<String> temp = new ArrayList<String>();
		for(WebElement e: quickLink)
		{
			temp.add(e.getText().trim());
		}
		
		return temp;
	}
	
}
