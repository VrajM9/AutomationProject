package com.Listeners;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.OrangeHRMTC.Baseclass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestListeners extends Baseclass implements ITestListener, ISuiteListener {
	ExtentSparkReporter sparkReport;
	ExtentReports extentReports;
	
	public void onStart(ISuite suite)
	{
		String reportFolderPath=System.getProperty("user.dir")+"/ExtentReport";
		createFolder(reportFolderPath);
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm");
		String dateTime=formatter.format(LocalDateTime.now());
		String reportPath="ExcecutionReport_"+dateTime;
		executionReports=reportFolderPath+"/"+reportPath;
		createFolder(executionReports);	
        sparkReport=new ExtentSparkReporter(reportFolderPath+"/"+reportPath+"/AutomationReport.html");
        extentReports=new ExtentReports();
        extentReports.attachReporter(sparkReport);
        extentReports.setSystemInfo("System", "Windows10");
        extentReports.setSystemInfo("User", "Viraj");
        extentReports.setSystemInfo("Env", "TestEnv");
	}	
	public void onFinish(ISuite suite)
	{
		System.out.println("this is OnFinish suite method....");
	}
	public void onStart(ITestContext context)
	{
		System.out.println("this is onTest Start method...."+context.getName());
	}
	public void onFinish(ITestContext context)
	{
		System.out.println("this is onTest finish method...."+context.getName());
	}
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test execution started for :"+result.getName());
		Logger=extentReports.createTest(result.getName());
		methodName=result.getName();
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Excecution complete successfully for :"+result.getName());
		Logger.pass(result.getName());
	}
	public void onTestFailure(ITestResult result)
	{
		System.out.println("method execution failed for: "+result.getName());
		System.out.println("failure reason: "+result.getThrowable());
		Logger.fail(result.getName()+":"+result.getThrowable());
		String filePath=executionReports+"/"+methodName+".png";
		takeScreenShot(filePath);
		Logger.addScreenCaptureFromBase64String(filePath);	
	}
	public void OnTestSkipped(ITestResult result)
	{
		System.out.println("method skipped : "+result.getName());
	}

	public  void createFolder(String reportPath) {
	   File file=new File(reportPath);
	   if(!file.exists())
	   {
		   file.mkdir();
	   }
		
	}

}
