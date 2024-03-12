package day14;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

    public static void main(String[] args) {
        ExtentReports extentReports;
        ExtentTest extentTest;
        ExtentSparkReporter extentSparkReporter;

        extentReports = new ExtentReports();
        extentTest = extentReports.createTest("test 01");
        String sp =System.getProperty("file.separator");
        String path= System.getProperty("user.dir")
                +sp
                +"test-out-put"
                +sp
                +"reportTest";
        extentSparkReporter = new ExtentSparkReporter(path);
        extentReports.attachReporter(extentSparkReporter);
        extentReports.flush();

    }
}
