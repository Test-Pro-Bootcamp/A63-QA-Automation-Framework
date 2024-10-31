import PageFactory.HomePage;
import PageFactory.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.Attribute;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
public String url;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters ({"BaseURL"})
     public void launchClass(String BaseURL){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            url = BaseURL;
            navigateToPage();
        }
@AfterMethod
    public void navigateToPage() {
    driver.get(url);
}
public void closeBrowser(){
        driver.quit();
}
}