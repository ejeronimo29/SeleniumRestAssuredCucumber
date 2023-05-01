package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchGooglePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final String HOME_PAGE_URL = "https://www.google.com";
    @FindBy(name = "q")
    private WebElement searchGoogle; // Search Google textbox

    public SearchGooglePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        initElements();
    }

    public void initElements(){
        PageFactory.initElements(driver,this);
    }

    public void navigateWebpage(){
        driver.get(HOME_PAGE_URL);
    }
    public ResultGoogleSearchPage searchText(String textSearch) {
        wait.until(ExpectedConditions.elementToBeClickable(searchGoogle));
        searchGoogle.sendKeys(textSearch);
        searchGoogle.submit();
        return new ResultGoogleSearchPage(driver);
    }


}
