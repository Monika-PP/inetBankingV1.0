package com.inetBanking.TestCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.Loginpage;

public class TC_AddCustomerTest_003 extends Baseclass{

	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		Loginpage lp=new Loginpage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.Clicksubmit();
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		Logger.info("Providing Customer Details");
		addcust.CustName("Monika");///html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input
		addcust.CustGender("female");
		addcust.custdob("08", "25", "1987");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
        addcust.custcity("Mumbai");
        addcust.custstate("Maharashtra");
        addcust.custpinno("567597");
        addcust.custtelephoneno("8987876569");
        String email=randomestring()+"@gmail.com";
        addcust.custemailid(email);
        
        addcust.custpassword("abcdef");
        addcust.custsubmit();
        Thread.sleep(3000);
        
        boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
        
        if(res==true)
        {
        	Assert.assertTrue(true);
        }
        
        else
        {
        	CaptureScreen(driver, "addnewcustomer");
        	Assert.assertTrue(false);
        }
	}


public String randomestring()
{
	String generatedstring=RandomStringUtils.randomAlphabetic(8);
	return (generatedstring);
	
}

public static String rondomeNum()
{
	String generateString2=RandomStringUtils.randomNumeric(4);
	return (generateString2);
	
}

}
