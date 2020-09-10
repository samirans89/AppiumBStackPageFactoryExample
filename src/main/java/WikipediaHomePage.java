import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class WikipediaHomePage {

    private AndroidDriver<AndroidElement> driver;

    public WikipediaHomePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Search Wikipedia")
    private AndroidElement search_wiki;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/search_src_text")
    private AndroidElement insert_element;

    @AndroidFindBy(className = "android.widget.TextView")
    private List<AndroidElement> list_elements;

    private void clickSearchWikipediaFld() {

        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(search_wiki));
        searchElement.click();
    }

    private void typeTextWikipediaFld(String text) {

        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(insert_element));
        insertTextElement.sendKeys(text);
    }

    private void checkSearchResults() {

        List<AndroidElement> allProductsName = list_elements;
        assertTrue(allProductsName.size() > 0);
    }


    public void performActions () {

        clickSearchWikipediaFld();
        typeTextWikipediaFld("BrowserStack");
        checkSearchResults();

    }
}

