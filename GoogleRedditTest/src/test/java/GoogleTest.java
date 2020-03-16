import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class GoogleTest {
    static WebDriver driver;
    private final String url = "http://www.reddit.com/";
    private final String query = "world";
    private final By inpSearchBox = By.name("q");
    private final By searchResult = By.xpath("//*[@id=\"t3_dngued\"]/div[2]/div");

    @Test
    public void googleTest() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver(options);

        WebDriverWait webDriverWait = new WebDriverWait(driver,3);
        driver.manage().window().maximize();

        driver.navigate().to(url);
        driver.findElement(inpSearchBox).click();

        webDriverWait.until(d->d.findElement(inpSearchBox).isDisplayed());
        driver.findElement(inpSearchBox).sendKeys(query);
        driver.findElement(inpSearchBox).sendKeys(Keys.ENTER);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchResult));
        driver.findElement(searchResult).click();
        driver.getCurrentUrl().contains(query);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
