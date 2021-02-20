package com.inetBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.Utilities.XLUtils;
import com.inetBanking.pageObjects.Loginpage;

public class TC_LoginDDT_002 extends Baseclass{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		Loginpage lp=new Loginpage(driver);
		lp.setUserName(user);
		Logger.info("Username provided");
		lp.setPassword(pwd);
		Logger.info("Password Provided");
		lp.Clicksubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Logger.warn("Login Failed");
			
		}
		else 
		{
			Assert.assertTrue(true);
			Logger.info("Login Passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
	}
	
	@DataProvider(name="LoginData")
	String [][]getdata() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "sheet1");
		int colcount=XLUtils.getCellCount(path, "sheet1",1);
		
		String logindata[][]=new String [rownum][colcount];
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
				
			}
		}
	return logindata;
	
	}
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
			
		}
	catch(NoAlertPresentException e)
		{
		return false;
		
		}
	}
	
}
