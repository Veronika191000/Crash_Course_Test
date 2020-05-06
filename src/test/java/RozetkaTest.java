import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.RozetkaPage;

public class RozetkaTest extends WebDriverSettings {

    @DataProvider(name = "ChangeLanguage")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"UA", "Знайти"},
                {"RU", "Найти"}
        };
    }

  @Test(dataProvider = "ChangeLanguage")
  public void Test1(String language, String button) {
      RozetkaPage rozetkaPage = new RozetkaPage(driver);
      rozetkaPage.clickLanguageUA(language,button);
  }


}
