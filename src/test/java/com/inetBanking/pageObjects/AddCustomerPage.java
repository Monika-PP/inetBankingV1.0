package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	/*@FindBy(how=How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement inkAddNewCustomer;*/
	
	@FindBy(how=How.LINK_TEXT, using="New Customer")
	@CacheLookup
	WebElement inkAddNewCustomer;
	
	
	
	@FindBy(how=How.CSS, using="body > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td:nth-child(2) > input[type=text]")
	@CacheLookup
	WebElement txtcustomername;
	
	@FindBy(how=How.NAME, using="rad1")
	@CacheLookup
	WebElement rdgender;
	
	@FindBy(how=How.ID_OR_NAME, using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how=How.NAME, using="addr")
	@CacheLookup
	WebElement txtaddress;
	
	
	@FindBy(how=How.NAME, using="city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(how=How.NAME, using="state")
	@CacheLookup
	WebElement txtstate;
	
	
	@FindBy(how=How.NAME, using="pinno")
	@CacheLookup
	WebElement txtpinno;
	
	
	@FindBy(how=How.NAME, using="telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy(how=How.NAME, using="emailid")
	@CacheLookup
	WebElement txtmailid;
	
	
	@FindBy(how=How.NAME, using="password")
	@CacheLookup
	WebElement txtpassword;
	
	
	@FindBy(how=How.NAME, using="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	
	
	public void clickAddNewCustomer()
	{
		inkAddNewCustomer.click();
		
	/*ldriver.switchTo().alert().accept();
	@FindBy( how=How.XPATH, using="/*[@id="square-rda-vanilla"]/div/div[2]/div/a")
	@CacheLookup
	WbElement */
	}
	
	public void CustName(String cname)
	{
		txtcustomername.sendKeys(cname);
	}
	
	public void CustGender(String cgender)
	{
		rdgender.click();
	}
	
	public void custdob(String mm, String dd, String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	
	public void custaddress(String caddress)
	{
		txtaddress.sendKeys(caddress);
	}
	
	
	public void custcity(String ccity)
	{
		txtcity.sendKeys(ccity);
	}
	
	
	public void custstate(String cstate)
	{
		txtstate.sendKeys(cstate);
	}
	
	public void custpinno(String cpinno)
	{
		txtpinno.sendKeys(cpinno);
	}
	
	public void custtelephoneno(String ctelephoneno)
	{
		txttelephoneno.sendKeys(ctelephoneno);
}
	
	
	public void custemailid(String cemailid)
	{
		txtmailid.sendKeys(cemailid);
}	
	
	public void custpassword(String cpassword)
	{
		txtpassword.sendKeys(cpassword);
}	
	
	public void custsubmit()
	{
		btnSubmit.click();
}	
}
