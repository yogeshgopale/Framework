package com.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.utility.PropertiesRead;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	PropertiesRead prop = new PropertiesRead();
	
	String Browserval = prop.browser();
	
	public static WebDriver driver;
	
protected	String URL = prop.URL();
	
	@BeforeTest
	public void Browsersetup() {
	
		if(Browserval.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		
		}else if(Browserval.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		
		}else if(Browserval.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			System.out.println("Browser value is wrong");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@AfterTest
	public void tearup() {
		driver.close();
	}
	
	public void captureScreenShot(WebDriver driver, String testName) throws IOException {
		// step1: convert webDriver object to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot) driver);

		// step2: call getScreenshotAs method to create image file
		
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());

		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir") + "//screenshots//" + testName + timestamp +".png");

		// step3: copy image file to destination
		FileUtils.copyFile(src, dest);
	}
	
}
