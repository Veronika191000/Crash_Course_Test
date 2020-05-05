import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProductsAndAlcoholPage;
import pages.SearchResultPage;
import pages.VinePage;

import java.util.Arrays;
import java.util.List;

public class SearchTest extends BaseTest {
    private MainPage mainPage;
    private SearchResultPage searchResultPage;
    private ProductsAndAlcoholPage productsAndAlcoholPage;
    private VinePage vinePage;
    private WebDriverWait wait;
    private static final String minPrice = "100";
    private static final String maxPrice = "1000";
    private static final String minPriceLett = "100data";
    private static final String maxPriceLett = "1000data";
    private static final String SEARCH_IPHONE_11 = "iPhone 11";
    private static final String[] prodAr = {"Сыры", "Молоко", "Рис", "Макаронные изделия", "Вяленое мясо", "Виски, бурбон",
            "Вино", "Вода", "Коньяк, бренди"};
    private static final List<String> products = Arrays.asList(prodAr);


    @BeforeTest
    public void initializePage() {
        mainPage = new MainPage(driver);
        searchResultPage = new SearchResultPage(driver);
        productsAndAlcoholPage = new ProductsAndAlcoholPage(driver);
        vinePage = new VinePage(driver, wait);
    }

    @Test(groups = "test")
    public void verifySearchResult() {
        mainPage.inputSearchValue(SEARCH_IPHONE_11);
        searchResultPage.verifySearchResult(SEARCH_IPHONE_11);
    }

    @Test(groups = "test")
    public void verifyListProducts() {
        mainPage.clickOnBtnProdAndAlc();
        productsAndAlcoholPage.listProductContainsNames(products);
    }

    @Test
    public void verifyProductsPrices()  {
        mainPage.clickOnBtnProdAndAlc();
        productsAndAlcoholPage.clickOnBtnVine();
        vinePage.priceFiltering(minPrice, maxPrice);
        vinePage.verifyFilterResult(minPrice, maxPrice);
    }

    @Test
    public void verifyProductPriceFields()  {
        mainPage.clickOnBtnProdAndAlc();
        productsAndAlcoholPage.clickOnBtnVine();
        vinePage.verifyPriceFields(minPriceLett, maxPriceLett);
    }

    @Test
    public void verifyEmptyFieldAfterClear() {
        mainPage.clickOnBtnProdAndAlc();
        productsAndAlcoholPage.clickOnBtnVine();
        vinePage.verifyEmptyFieldsAfterClear(minPrice, maxPrice);
    }

    @Test
    public void verifysortFromСheapToExpensive() {
        mainPage.clickOnBtnProdAndAlc();
        productsAndAlcoholPage.clickOnBtnVine();
        vinePage.sortFromСheapToExpensive();
    }

}
