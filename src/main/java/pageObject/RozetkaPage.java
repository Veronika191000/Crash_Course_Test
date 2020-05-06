package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RozetkaPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public RozetkaPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//ul[@class='header-topline__language js-rz-lang']/li[2]/a")
    private WebElement btnLanguageUA;

    @FindBy(how = How.XPATH, using = "//ul[@class='header-topline__language js-rz-lang']/li[1]/a")
    private WebElement btnLanguageRU;

    @FindBy(how = How.XPATH, using = " //div[contains(@class, 'header-search')]//button[contains(@class, 'button_color_green')]")
    private WebElement btnSearch;

    //////////////////////////////////wait
    @FindBy(how = How.XPATH, using = " //ul[@class='main-slider__pagination']/li")
    private WebElement btnStock;


    public void clickLanguageUA(String language, String button) {
        if (language.equals("UA")) {
            btnLanguageUA.click();
            wait.until(ExpectedConditions.visibilityOf(btnStock));
            checkButtunText(language, button);
        } else {
            btnLanguageRU.click();
            wait.until(ExpectedConditions.visibilityOf(btnStock));
            checkButtunText(language, button);
        }
    }

    public void checkButtunText(String language, String button) {
        String buttonText = btnSearch.getText();
        System.out.println(buttonText);
        Assert.assertEquals(buttonText, button);
    }

}