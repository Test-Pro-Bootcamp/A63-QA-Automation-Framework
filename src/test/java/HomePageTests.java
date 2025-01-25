import org.testng.Assert;
import org.testng.annotations.Test;
import PageFactory.LoginPage;
import PageFactory.HomePage;

public class HomePageTests extends BaseTest {
    @Test
    public void isRecentlyPlayedDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("victoria.mereneanu@testpro.io")
                .providePassword("Testpro4321$")
                .clickSubmit();
        homePage.viewRecentlyPlayed();
        Assert.assertTrue(homePage.isPlaylistDisplayed());
    }
}