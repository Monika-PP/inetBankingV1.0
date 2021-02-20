package com.inetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.Loginpage;

public class TC_LoginTest_001 extends Baseclass{

	@Test
	public void loginTest() throws IOException
	{
		
		Logger.info("URL is open");
		Loginpage lp=new Loginpage(driver);
		lp.setUserName(username);
		Logger.info("Enter username");
		lp.setPassword(password);
		Logger.info("Enter password");
		lp.Clicksubmit();
		
		
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			Logger.info("Login test passed");
		}
		else
		{
			CaptureScreen(driver,"Login Test");
			Assert.assertTrue(false);
			Logger.info("Login test failed");
		}
	}
	
}
