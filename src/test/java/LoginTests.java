import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageFactory.LoginPage;
import PageFactory.HomePage;

public class LoginTests extends BaseTest {
    @Test
    public void loginValidEmailPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("victoria.mereneanu@testpro.io")
                .providePassword("Testpro1234$")
                .clickSubmit();
        Assert.assertTrue(homePage.isAvatarDisplayed());

    }
}
