package com.test.cases;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.page.Clases.HomePage;

public class TestScript1 extends BaseClass{

	@Test
	public void loginFun() throws InterruptedException {
		driver.get(URL);
		
		HomePage hp = new HomePage(driver);
		hp.entercred();
		hp.clicklgbtn();
		
		Thread.sleep(3000);
	}
	
	
}
