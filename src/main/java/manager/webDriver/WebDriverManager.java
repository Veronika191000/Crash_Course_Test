package manager.webDriver;

import enums.EnumDriverType;
import org.openqa.selenium.WebDriver;
import factory.WebDriverFactory;

public class WebDriverManager {

    private WebDriver driver;

    public WebDriver get(){return driver;}

    public WebDriver createDriverFromFactory(EnumDriverType type){
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.createWebDriver(type);
        return driver;
    }

    public void manageWebDriver(){
        driver.manage().window().maximize();
    }

    public void Quit(boolean closeBrowser){
        if(closeBrowser){
            driver.quit();
        }
    }
}
