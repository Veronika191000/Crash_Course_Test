package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@class='search-text-input']")
    private WebElement inpSearch;

    @FindBy(how = How.XPATH, using = "//input[@type='submit']")
    private WebElement btnSeach;

    @FindBy(how = How.XPATH, using = "//a[text() = \"Продукты и алкоголь        \"]")
    private WebElement btnProdAndAlc;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputSearchValue(String productName) {
        inpSearch.sendKeys(productName);
        btnSeach.click();
    }

    public void clickOnBtnProdAndAlc(){
        btnProdAndAlc.click();
    }
}
