package com.inetBanking.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
public ExtentHtmlReporter htmlreporter;
public ExtentReports extent;
public ExtentTest logger;

public void onStart(ITestContext textContext)
{
	String timestamp=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
	String repName="Test-Report-"+timestamp+".html";
	
	htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
	htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	
	extent=new ExtentReports();
	
	extent.attachReporter(htmlreporter);
	extent.setSystemInfo("Host name", "Localhost");
	extent.setSystemInfo("Environment", "QA");
	extent.setSystemInfo("user", "Monika");
	
	htmlreporter.config().setDocumentTitle("InetBanking Test Project");
	htmlreporter.config().setReportName("Functional Test Automation Report");
	//htmlreporter.config().setTestViewChartLocation(ChartLocation.Top);
	htmlreporter.config().setTheme(Theme.DARK);
	
}

public void onTestSuccess(ITestResult tr)
{
	logger=extent.createTest(tr.getName()); //create new entry in the report
	logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	
}

public void onTestFailure(ITestResult tr)
{
logger=extent.createTest(tr.getName());
logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
String screenshotpath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";

File f=new File(screenshotpath);

if(f.exists())
{
	try
	{
		logger.fail("Screenshot is below:"+logger.addScreenCaptureFromPath(screenshotpath));
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
}

}

public void onTestSkipped(ITestResult tr)
{
	logger=extent.createTest(tr.getName());
	logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
}

public void onFinish(ITestContext testContext)
{
	extent.flush();
}
}
