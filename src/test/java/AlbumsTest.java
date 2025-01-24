import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

public class AlbumsTest extends BaseTest{

    @Test
    public void testingAlbumsPage (){

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        navigateToPage();
        loginPage.provideEmail("natalia.kalinina@testpro.io");
        loginPage.providePassword("nkKoel24$");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.avatarIconDisplayed());
        homePage.clickAlbumsButton();
        homePage.hoverOverAlbum();
        // ger image url
        // get the album name
        // ger artist name
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
