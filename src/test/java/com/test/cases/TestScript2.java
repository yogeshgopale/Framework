package com.test.cases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.page.Clases.HomePage;
@Listeners(com.base.ListenerClass1.class)
public class TestScript2 extends BaseClass {
@Parameters({"user","pass"})
	@Test
	public void loginFun(String user ,String pass) throws InterruptedException {
		driver.get(URL);
		
		HomePage hp = new HomePage(driver);
	hp.entercredwithparameter(user, pass);
		hp.clicklgbtn();
		
		Thread.sleep(3000);
	}
	
	
	
}
