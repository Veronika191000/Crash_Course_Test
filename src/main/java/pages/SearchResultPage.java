package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.StringContains.containsString;

public class SearchResultPage {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//div[@class='catalog-block-head']/a")
    private List<WebElement> lstSearchResultTitles;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifySearchResult(String productName) {
        List<String> currentResult = new ArrayList<>();
        List<WebElement> actualResult = lstSearchResultTitles;

        for (WebElement listOfTitles : actualResult) {
            currentResult.add(listOfTitles.getText());
        }
        assertThat(currentResult, everyItem(containsString(productName)));
    }

}
