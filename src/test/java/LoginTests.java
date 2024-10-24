import POM.POM.HomePage;
import POM.POM.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginValidEmailPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginPage.provideEmail("victoria.mereneanu@testpro.io");
        loginPage.providePassword("Testpro1234$");
        loginPage.clickSubmit();
        Assert.assertTrue(homepage.getUserAvatar());
    }

    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("victoria.mereneanu@testpro.io");
        loginPage.providePassword("Testpro1234$");
        loginPage.clickSubmit();
        homePage.play();
        Assert.assertTrue(homePage.isSongPlaying());
    }
}
