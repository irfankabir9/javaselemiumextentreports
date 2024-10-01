package zlistenerextentproject.zlistenerextentproject;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//making the note for the changes to push
public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter; // UI of the report
    public ExtentReports extent; //populate common info on the report
    public ExtentTest test; // creating test case entries in the report and update status of the test methods
    
    public void onStart(ITestContext context) {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");//speci
        sparkReporter.config().setDocumentTitle("Automation Report"); // Title of report
        sparkReporter.config().setReportName("Functional Testing"); // name of the report
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Computer Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", "irfan");
        extent.setSystemInfo("os", "Windows10");
        extent.setSystemInfo("Browser name", "Chrome");
        
        System.out.println("test start in start method");

    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName()); // create a new enty in the report
        test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s
        System.out.println("test in sucess");
    }

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
        System.out.println("test started in on teststart");

		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getName()); // create a new enty in the report
        test.log(Status.FAIL, "Test case PASSED is:" + result.getName());
        System.out.println("test  in fail");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getName()); // create a new enty in the report
        test.log(Status.SKIP, "Test case PASSED is:" + result.getName());
        System.out.println("test  in skip");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
}
