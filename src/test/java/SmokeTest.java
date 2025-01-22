import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

public class SmokeTest extends BaseTest{

    @Test
    public void loginValidCredentials (){

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        navigateToPage();
        loginPage.provideEmail("natalia.kalinina@testpro.io");
        loginPage.providePassword("nkKoel24$");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.avatarIconDisplayed());
    }

    @Test
    public void playSong (){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        navigateToPage();
        loginPage.provideEmail("natalia.kalinina@testpro.io");
        loginPage.providePassword("nkKoel24$");
        loginPage.clickSubmit();
        homePage.hoverOverNextSongButton();
        homePage.clickNextSongButton();
        homePage.clickPlayButton();
        homePage.validateSongIsPlaying();
        // homePage.hoverOverNextSongButton();
    }
}
