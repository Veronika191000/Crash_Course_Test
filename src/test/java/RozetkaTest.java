import org.testng.annotations.Test;
import pageObject.RozetkaPage;

public class RozetkaTest extends WebDriverSettings {


    @Test(dataProvider = "searchItems", dataProviderClass = DataProviderClass.class)
    public void verifySearchItems(String alcohol) {
        RozetkaPage rozetkaPage = new RozetkaPage(driver);
        rozetkaPage.verifySearchItems(alcohol);
    }
}
