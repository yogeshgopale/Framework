package com.base;

import java.time.Duration;

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
	
	public WebDriver driver;
	
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
}
