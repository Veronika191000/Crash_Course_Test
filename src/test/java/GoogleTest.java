
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.*;

public class GoogleTest extends WebDriverSettings {

    private final String query = "world";

    @Test
    public void googleTest() {
          GooglePage googlePage = PageFactory.initElements(driver, GooglePage.class);
          googlePage.enterSearchQuery(query);

          boolean trueUrl =  googlePage.verifyThatResultHasWord(query);
          Assert.assertEquals(trueUrl, true);

    }


}
