package factory;

import enums.EnumDriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import config.Configuration;

public class WebDriverFactory {
    public WebDriver createWebDriver(EnumDriverType type){
        WebDriver driver;
        switch (type){
            case CHROME :
                driver = createChromeDriver(); break;
            case EXPLORER :
                driver = createExplorerDriver(); break;
            case FIREFOX:
                driver = createFirefoxDriver(); break;
            default:
                throw new RuntimeException("Unknown web driver type.");
        }
    return driver;
    }
    protected  WebDriver createChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
    protected WebDriver createFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
    protected  WebDriver createExplorerDriver(){
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability("InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION", true);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        capabilities.setCapability("ignoreZoomSetting", true);
        capabilities.setCapability("ignoreProtectedModeSettings", true);
        capabilities.setCapability("initialBrowserUrl", Configuration.url);
        System.setProperty("webdriver.ie.driver", "src\\main\\resources\\IEDriverServer.exe");
        InternetExplorerDriver driver = new InternetExplorerDriver(capabilities);
        return driver;
    }
}
