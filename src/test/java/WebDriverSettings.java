import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WebDriverSettings {

    static WebDriver driver;
    static WebDriverWait webDriverWait;
    private final String url = "http://www.reddit.com/";

    @BeforeTest
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver(options);
        webDriverWait = new WebDriverWait(driver,3);
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
