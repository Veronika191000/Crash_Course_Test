package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GooglePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement inpSearchBox;

    @FindBy(xpath = "//div[contains(@class, '_2XDITKxlj4y')]")
    private List<WebElement> lblTitle;

    @FindBy(xpath = "//table[contains(@class, 'MRH-njmSb5ZTkfb1o')]")
    private  List<WebElement> table ;

    public GooglePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public void enterSearchQuery(String query) {
        inpSearchBox.click();
        inpSearchBox.sendKeys(query);
        inpSearchBox.sendKeys(Keys.ENTER);
    }

    public boolean verifyThatResultHasWord(String query){
        wait.until(ExpectedConditions.visibilityOfAllElements(lblTitle));
        lblTitle.get(0).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(table));
        boolean trueURL = driver.getCurrentUrl().contains(query);
        return trueURL;
    }
}
