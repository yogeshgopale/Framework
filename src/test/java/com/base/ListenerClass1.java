package com.base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utility.PropertiesRead;

public class ListenerClass1 implements  ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	PropertiesRead read;
	BaseClass base;
	
	public void configureReport() {

		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "Batch45Framework-" + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
        read=new PropertiesRead();
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		reports.setSystemInfo("Machine:", "acer");
		reports.setSystemInfo("OS", "windows 10");
		reports.setSystemInfo("browser:", read.browser());
		reports.setSystemInfo("username:", "Yogesh Gopale");

		// configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("This is reports of Batch45 ");
		htmlReporter.config().setReportName("Reports of Batch45 Framework Project");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Name of test method started:" + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of test method sucessfully executed:" + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the passed test case is: " + result.getName(), ExtentColor.GREEN));
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of test method failed:" + result.getName() );  		
		test = reports.createTest(result.getName());//create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + result.getName() ,ExtentColor.RED));
		
		base=new BaseClass();
		try {
			base.captureScreenShot(BaseClass.driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		System.out.println("Name of test method skipped:" + result.getName() );  		

		test = reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + result.getName() ,ExtentColor.YELLOW));
	}

	@Override
	public void onStart(ITestContext context) {
		configureReport();
		System.out.println("On Start method invoked....");
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
		System.out.println("On Finished method invoked....");
	}

	
	
	
	
	
	
	
}
