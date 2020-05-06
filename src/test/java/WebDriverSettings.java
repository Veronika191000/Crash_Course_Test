import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WebDriverSettings {

    static WebDriver driver;
    static WebDriverWait webDriverWait;
    private final String url = "https://rozetka.com.ua/ua/";

    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        webDriverWait = new WebDriverWait(driver, 4);
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
