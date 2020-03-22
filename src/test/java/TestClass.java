import config.Configuration;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class TestClass extends BaseUITests{

    private final By inpSearchBox = By.name("q");
    private final By lblTitle = By.xpath("//h3[contains(@class, 'LC20lb')]");
    private final By firstReference = By.xpath("//h3[contains(text(),\"SoftServe: Home\")]");

    @Test
    public void testClass() {

        WebDriver dr = driverManager.get();
        WebElement element = dr.findElement(inpSearchBox);

        element.click();
        element.sendKeys(Configuration.searchRequest);

        element.sendKeys(Keys.ENTER);
        boolean count = dr.findElements(lblTitle).stream().anyMatch(x -> x.getText().contains(Configuration.wordContains));

        Assertions.assertThat(count).isTrue();
        dr.findElement(firstReference).click();

        boolean containsSoftServe =  dr.getCurrentUrl().contains("softserve");
        Assertions.assertThat(containsSoftServe).isTrue();
    }
}