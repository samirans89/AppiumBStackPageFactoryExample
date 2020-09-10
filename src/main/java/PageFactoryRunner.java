import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class PageFactoryRunner {

    public static String userName = "<BROWSERSTACK_USERNAME>";
    public static String accessKey = "<BROWSERSTACK_ACCESS_KEY>";
    public static AndroidDriver<AndroidElement> driver;


    public static void main(String[] args) throws Exception {

        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability("device", "Samsung Galaxy S8 Plus");
        caps.setCapability("os_version", "7.0");
        caps.setCapability("project", "PageFactory Project");
        caps.setCapability("build", "PageFactory Build");
        caps.setCapability("name", "Bstack-[Java] Sample Page Factory Test");
        caps.setCapability("app", "<app_url_OR_custom_id>");

        driver = new AndroidDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
        driver.resetApp();
        WikipediaHomePage wikiPageObj = new WikipediaHomePage(driver);
        wikiPageObj.performActions();

        System.out.println("Test completed successfully");
        // Close session
        driver.quit();
    }
}