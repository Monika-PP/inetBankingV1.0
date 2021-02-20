package com.inetBanking.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
//import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
//import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.Utilities.Readconfig;

//import io.github.bonigarcia.wdm.WebDriverManager;
//import lombok.AccessLevel;
//import lombok.Getter;

public class Baseclass {
	
Readconfig readconfig=new Readconfig();
	
public String baseURL=readconfig.getapplicationURL();
public String username=readconfig.getUsername();
public String password=readconfig.getpassword();

//@Getter(AccessLevel.PUBLIC)
//private static WebDriver driver;
public static WebDriver driver;
//private Capabilities capabilities;


public static org.apache.log4j.Logger Logger;

@Parameters("browser")
@BeforeClass
public void setup(String br)
{
	Logger=Logger.getLogger("ebanking");
	PropertyConfigurator.configure("Log4j.properties");
	BasicConfigurator.configure();
	
	
//this.getDriver();



	if(br.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
		driver=new ChromeDriver();
		
		//driver=new ChromeDriver();
		
		//WebDriverManager.chromedriver().setup();

		/*ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        chromeOptions.addArguments("start-maximized");*/

        //driver = new ChromeDriver(chromeOptions);
      //  capabilities = ((RemoteWebDriver) driver).getCapabilities();





		driver.manage().window().maximize();
	}

	else if(br.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver",readconfig.getfirefoxpath());

		driver=new FirefoxDriver();
		//WebDriverManager.firefoxdriver().setup();
	}

	else if(br.equals("ie"))
	{
		System.setProperty("webdriver.ie.driver",readconfig.getiepath());

		driver=new InternetExplorerDriver();
	}
	driver.get(baseURL);
}

public void CaptureScreen(WebDriver driver, String tname) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
	FileUtils.copyFile(source, target);
	System.out.println("ScreenShot Taken");
	
}

@AfterClass
public void tearDown()
{
	driver.close();
driver.quit();	
}

	
}
