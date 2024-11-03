import POM.HomePage;
import POM.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    String url = "https://qa.koel.app/";
    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        //Testing Jenkins
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("dhivya.sankaran@testpro.io").providePassword("v5eUH9H2").clickLoginBtn();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);

    }
    @Test
    public void loginEmptyEmailPassword() throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("").providePassword("v5eUH9H2").clickLoginBtn();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);

    }
}
