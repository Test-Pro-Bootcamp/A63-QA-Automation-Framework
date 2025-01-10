import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

public class PlayASong extends BaseTest{

    @Test
    public void playSong() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        navigateToPage();
        provideEmail("natalia.kalinina@testpro.io");
        providePassword("nkKoel24$");
        clickLoginButton();
        homePage.hoverOverNextSongButton();
        homePage.clickNextSongButton();
        homePage.clickPlayButton();
        homePage.validateSongIsPlaying();

    }

}
