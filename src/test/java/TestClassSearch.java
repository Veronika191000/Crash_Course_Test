import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClassSearch {
    @Test
    public void testClassSearch() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys(new CharSequence[]{"softserve"});
        driver.findElement(By.name("q")).sendKeys(new CharSequence[]{Keys.ENTER});

        String searchXpath = ".//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div/div[2]/input";
        WebElement search = driver.findElement(By.xpath(searchXpath));

        String resultInputSearch = search.getAttribute("value");
        Assert.assertTrue(resultInputSearch.equals("softserve"));

        driver.quit();
    }
}
