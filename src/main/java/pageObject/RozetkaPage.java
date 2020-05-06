package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RozetkaPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public RozetkaPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.XPATH, using = "//input[@name = 'search']")
    private WebElement strSearch;
    ////////////////////////////////////wait
    @FindBy(how = How.XPATH, using = " //div[@class = 'goods-tile__inner']")
    private List<WebElement> listItems;


    public void verifySearchItems(String item) {
        strSearch.sendKeys(item);
        strSearch.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfAllElements(listItems));
    }

}