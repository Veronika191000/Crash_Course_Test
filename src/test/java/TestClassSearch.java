import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestClassSearch {

    private final By title  = By.xpath("//h3[contains(@class, 'LC20lb')]");
    static WebDriver driver;

    @Test
    public void testClassSearch() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys(new CharSequence[]{"softserve"});
        driver.findElement(By.name("q")).sendKeys(new CharSequence[]{Keys.ENTER});

        List<WebElement> lblTitle = driver.findElements(title);
        lblTitle.get(0).click();

        boolean trueURL = driver.getCurrentUrl().contains("softserve");
        Assert.assertEquals(trueURL,true);

        driver.quit();
    }
}
