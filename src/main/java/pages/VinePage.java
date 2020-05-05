package pages;

import core.DriverInitializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Test(groups = { "ClassTestVine" })
public class VinePage {
    WebDriver driver;
    WebDriverWait wait;

    public VinePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DriverInitializer.getExplicityWait());
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@id='price-min']")
    private WebElement minPrice;

    @FindBy(how = How.XPATH, using = "//input[@id='price-max']")
    private WebElement maxPrice;

    @FindBy(how = How.XPATH, using = "//a[@id='buttonPrice']")
    private WebElement btnPrice;

    @FindBy(how = How.XPATH, using = "//div[@class='catalog-block-head']/following-sibling::a[@class='price']/span/strong")
    private List<WebElement> listPrices;

    @FindBy(how = How.XPATH, using = "//li[@class='menu-right']/a[@title='Очистить фильтр']")
    private WebElement btnClearFilter;

    @FindBy(how = How.XPATH, using = "//li[@class='dropdown dropdown-sorting']/a[text()='Популярность']")
    private WebElement btnSortBy;

    @FindBy(how = How.XPATH, using = "//li[@class='dropdown dropdown-sorting active']/ul/li[2]")
    private WebElement btnFromCheap;

    public void priceFiltering(String priceMin, String priceMax) {
        if (Integer.parseInt(priceMax) < Integer.parseInt(priceMin))
            System.out.println("Bad boy or girl!!!:((");
        else {
            minPrice.sendKeys(priceMin);
            maxPrice.sendKeys(priceMax);
            btnPrice.click();
        }
    }

    public void verifyFilterResult(String priceMin, String priceMax) {
        int priceMinInt = Integer.parseInt(priceMin);
        int priceMaxInt = Integer.parseInt(priceMax);
        List<String> currentResult = new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOfAllElements(listPrices));
        List<WebElement> actualResult = listPrices;
        int i = 0;
        for (WebElement listOfTitles : actualResult) {
            currentResult.add(removeLastCharRegexOptional(listOfTitles.getText()));
            Assert.assertTrue(Integer.parseInt(currentResult.get(i)) <= priceMaxInt &&
                    Integer.parseInt(currentResult.get(i)) >= priceMinInt);
            i++;
        }
    }

    public static String removeLastCharRegexOptional(String s) {
        return Optional.ofNullable(s)
                .map(str -> str.replaceAll(" грн$", ""))
                .orElse(s);
    }

    public void verifyPriceFields(String priceMin, String priceMax) {
        minPrice.sendKeys(priceMin);
        maxPrice.sendKeys(priceMax);
        Assert.assertTrue(isNumeric(minPrice.getAttribute("value")) && isNumeric(maxPrice.getAttribute("value")));
    }

    public void verifyEmptyFieldsAfterClear(String priceMin, String priceMax) {
        priceFiltering(priceMin, priceMax);
        wait.until(ExpectedConditions.visibilityOfAllElements(listPrices));
        btnClearFilter.click();
        wait.until(ExpectedConditions.invisibilityOf(btnClearFilter));
        Assert.assertTrue(minPrice.getAttribute("value").isEmpty() && maxPrice.getAttribute("value").isEmpty());
    }

    public static boolean isNumeric(String strNum) {
        return strNum.matches("[0-9]+");
    }

    public void sortFromСheapToExpensive() {
        boolean sorted = false;
        btnSortBy.click();
        wait.until(ExpectedConditions.invisibilityOf(btnFromCheap));
        btnFromCheap.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(listPrices));
        List<String> currentResult = new ArrayList<>();
        List<WebElement> actualResult = listPrices;
        for (WebElement listOfTitles : actualResult) {
            currentResult.add(removeLastCharRegexOptional(listOfTitles.getText()));
        }
        for (int k = 0; k < currentResult.size() - 1; k++) {
            if (Integer.parseInt(currentResult.get(k)) <= Integer.parseInt(currentResult.get(k + 1)))
                sorted = true;
        }
        Assert.assertTrue(sorted);
    }

}
