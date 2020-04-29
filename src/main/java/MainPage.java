import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "search")
    private WebElement inpSearchBox;

    @FindBy(xpath = "//h1[text()=' Антисептики ']")
    private WebElement titleAntisept;

    @FindBy(xpath = "//span[@class = 'goods-tile__title' ]")
    private List<WebElement> lbTitle;

    @FindBy(xpath = "//div[contains(@class,'goods-tile__availability')]")
    private List<WebElement> availabilityProduct;

    @FindBy(xpath = "//div[@class='goods-tile__inner']")
    private List <WebElement> goods;




    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public void enterSearchQuery(String query) {
        inpSearchBox.click();
        inpSearchBox.sendKeys(query);
        inpSearchBox.sendKeys(Keys.ENTER);
    }

    public String verifyThatTitleHasWord(String query) {
        wait.until(ExpectedConditions.visibilityOfAllElements(lbTitle));
        String titleAnt = titleAntisept.getText();
        return titleAnt;
    }


    public void takeTitles() {
        wait.until(ExpectedConditions.visibilityOfAllElements(lbTitle));
        for(int i = 0; i < goods.size(); i++){
            System.out.println(lbTitle.get(i).getText() + " - " + availabilityProduct.get(i).getText());
        }
    }
}

