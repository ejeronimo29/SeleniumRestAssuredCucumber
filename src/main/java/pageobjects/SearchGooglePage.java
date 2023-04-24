package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchGooglePage extends PageFactory {
    private WebDriver driver = null;
    private WebDriverWait wait = null;
    @FindBy(name = "q")
    private WebElement searchGoogle; // Search Google textbox

    public SearchGooglePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver,this);
    }

    public ResultGoogleSearchPage searchText(String textSearch) {
        wait.until(ExpectedConditions.elementToBeClickable(searchGoogle));
        searchGoogle.sendKeys(textSearch);
        searchGoogle.submit();
        return new ResultGoogleSearchPage(driver);
    }

}
