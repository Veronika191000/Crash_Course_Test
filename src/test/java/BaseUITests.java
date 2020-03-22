import config.Configuration;
import manager.webDriver.WebDriverManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Screenshot;

import java.time.LocalDate;

//import java.time.LocalDate;

public class BaseUITests {

protected WebDriverManager driverManager;

    @BeforeTest
    public void setUp() {
        driverManager = new WebDriverManager();
        driverManager.createDriverFromFactory(Configuration.type);
        driverManager.manageWebDriver();
        driverManager.get().navigate().to(Configuration.url);
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        if (!result.isSuccess()) {
            Screenshot.takeScreenshot(driverManager.get(),
                    result.getName() + "[" + LocalDate.now() + "][" + System.currentTimeMillis() + "].png");
        }
    }

    @AfterTest
    public void tearDown() {
        driverManager.Quit(true);
    }
}
