package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utility;

public class MyInfoPage {

	private WebDriver dr;
	
	public MyInfoPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(id="menu_pim_viewMyDetails")
	private WebElement myInfoTab; 
	
	@FindBy(css="ul[id='sidenav']>li>a")
	private List<WebElement> sideNav;
	
	public void clickOnMyInfo()
	{
		myInfoTab.click();
	}
	
	public List<String> getSideNavText()
	{
		Utility.waitForElementToClickable(myInfoTab);
		List<String> temp = new ArrayList<String>();
		for(WebElement e: sideNav)
		{
			temp.add(e.getText().trim());
		}
		
		return temp;
	}
	
	public int getSideNavCount()
	{
		return sideNav.size();
	}
	
}
