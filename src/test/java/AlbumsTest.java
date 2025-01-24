import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

public class AlbumsTest extends BaseTest{

    @Test
    public void loginAndOpenAlbumsPage (){

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        navigateToPage();
        loginPage.provideEmail("natalia.kalinina@testpro.io");
        loginPage.providePassword("nkKoel24$");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        homePage.clickAlbumsButton();
        homePage.hoverOverAlbum2();
        homePage.getNameOnAlbum();
        // If Album cover is not existing standard Koel album cover should be present
        //Album name should be displayed
        //Artist name should be displayed
        //Songs count should be displayed and reflect the actual number of songs in the album
        //Shuffle icon should be present
        //Download icon should be present
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
