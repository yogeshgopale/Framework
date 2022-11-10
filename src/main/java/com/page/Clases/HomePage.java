package com.page.Clases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.PropertiesRead;

public class HomePage {

	PropertiesRead read = new PropertiesRead();
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	private WebElement loginbtn;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void entercred() {
		username.sendKeys(read.username());
		password.sendKeys(read.password());
	}
	
	public void clicklgbtn () {
		loginbtn.click();
	}
}
