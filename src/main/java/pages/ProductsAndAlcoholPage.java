package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsAndAlcoholPage {
    private WebDriver driver;

    public ProductsAndAlcoholPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(how = How.XPATH, using = "//div[@class='popular-category']//a/small")
    private List<WebElement> lstSearchResultProducts;

    @FindBy(how = How.XPATH, using = "//div[@class='popular-category']//small[contains(text(), \"Вино\")]")
    private WebElement btnVine;

    public void listProductContainsNames(List<String> lProd) {
        List<String> currentResult = new ArrayList<>();
        List<WebElement> actualResult = lstSearchResultProducts;
        for (WebElement listOfProducts : actualResult) {
            currentResult.add(listOfProducts.getText());
        }
        currentResult.removeAll(Arrays.asList("", null));
        Assert.assertTrue(lProd.equals(currentResult));
    }

    public void clickOnBtnVine(){
        btnVine.click();
    }
}
