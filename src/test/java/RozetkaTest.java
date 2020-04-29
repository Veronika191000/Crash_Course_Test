import org.testng.Assert;
import org.testng.annotations.Test;

public class RozetkaTest extends  WebDriverSettings{

    private final String word = "Антисептики";

    @Test
    public void testPageHasTitle(){
        MainPage mainPage = new MainPage(driver);
        mainPage.enterSearchQuery(word);
        String verifyTitle =  mainPage.verifyThatTitleHasWord(word);
        Assert.assertEquals(word, verifyTitle);
        mainPage.takeTitles();

    }
}
