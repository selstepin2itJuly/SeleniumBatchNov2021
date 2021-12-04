package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Reporter;
import org.testng.Reporter;

import testbase.TestBase;

public class Utility extends TestBase{

	
	public static void scrollToElement(WebElement e)
	{
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(false);", e);
		je.executeScript("window.scrollBy(0,300)", "");
	}

	public static void ClickOnElementJS(WebElement e)
	{
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", e);
	}
	
	//Explicite Wait time
	
	public static void waitForElementToClickable(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver, Integer.parseInt(explicitTime));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void waitForElementToVisible(WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver, Integer.parseInt(explicitTime));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void waitForElementPolling(WebElement ele)
	{
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.withTimeout(Integer.parseInt(explicitTime), TimeUnit.SECONDS)
		.pollingEvery(5, TimeUnit.SECONDS)
		.ignoring(NoSuchElementException.class);
	}
	
	public static void captureScreen() throws IOException
	{
		TakesScreenshot sc=(TakesScreenshot) driver;
		File file = sc.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(getDate()+"_image.jpg")); //jpg and png
	}
	
	public static String getDate()
	{
		Date dt = new Date();
		//System.out.println(dt);
		SimpleDateFormat sdf = new SimpleDateFormat("Y_MMM_d_h_m_s_S_a_z");
		String date = sdf.format(dt);
		System.out.println(date);
		return date;
	}
	
	public static void attachScreenshotToReport()
	{
		TakesScreenshot c=(TakesScreenshot) driver;
		String file = c.getScreenshotAs(OutputType.BASE64);
		String st= "<img src=\"data:image/png;base64, " + file + "\" height=\"600\" width=\"800\" />";
		Reporter.log(st);
	}
}
