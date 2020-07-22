import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RozetkaMainPage;
import pages.SignIn;
import pages.SignUp;

public class RozetkaTests extends WebDriverSettings {
    protected RozetkaMainPage mainPage;
    protected SignIn signIn;

    @BeforeClass
    public void Initial() {
        driver.get("http://rozetka.com.ua/");
        mainPage = new RozetkaMainPage(driver);
    }

    @Test
    public void firstTest() {
        mainPage = new RozetkaMainPage(driver);
        mainPage.verifyRozetkaSearch("Ноутбук");
    }

    @Test
    public void secondTest() {
        mainPage = new RozetkaMainPage(driver);
        mainPage.checkingListOfItems("Ноутбук");
    }

    @Test
    public void incorrectAuthTest() {
        signIn = mainPage.goToSignIn();
        signIn.inputAllKeys("smt", "4g4h44ys");
        signIn.incorrectEmailField("#fee8e8");
    }

    @Test
    public void emptyPasswdTest() {
        signIn = mainPage.goToSignIn();
        signIn.inputAllKeys("smt", "");
        signIn.incorrectEmailField("#fee8e8");
    }

}
