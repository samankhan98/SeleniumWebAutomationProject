package Utility.Listeners;

import Utility.DriverClass;

import Utility.ExtentReport.ExtentManager;
import Utility.ExtentReport.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Utility.ExtentReport.ExtentTestManager.getTest;

public class TestListener extends DriverClass implements ITestListener {
    String dateName = new SimpleDateFormat("MM-dd-yyyy-[HH-mm-ss]").format(new Date());

    public void onStart(ITestContext context) {
        System.out.println("*** Test Suite " + context.getName() + " started ***");
    }

    public void onFinish(ITestContext context) {
        System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }

    public void onTestStart(ITestResult result) {
        System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
        ExtentTestManager.startTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
        getTest().log(Status.PASS, "Test passed: " +result.getName());
        try {
            //Screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String destination = System.getProperty("user.dir") + "/Screenshot/PassTests/"+result.getName()+"_"+dateName+".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);
            //Attach Screenshot in Report
            getTest().addScreenCaptureFromPath(destination);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
       try {
            //Screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String destination = System.getProperty("user.dir") + "/Screenshot/FailedTests/"+result.getName()+dateName+".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);
            //Attach Screenshot in Report
            getTest().log(Status.FAIL, "Test Failed: " +result.getName());
            getTest().log(Status.FAIL, "Test Failed: " +result.getThrowable());
            getTest().addScreenCaptureFromPath(destination);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
        getTest().log(Status.SKIP, "Test Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
    }

}
