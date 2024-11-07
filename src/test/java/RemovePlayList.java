import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class Homework19 extends BaseTest  {

    @Test
    public void removePlaylist() {
        // Page Factory
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

  //===========POM==========================================
              /*  LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);


        navigateToPage();
        provideEmail("natalia.kalinina@testpro.io");
        providePassword("nkKoel24$");
        clickLoginButton();
        homePage.createNewPlaylist();
        homePage.clickNewPlaylist();
        homePage.typePlaylistName("NK_PL2");
        homePage.clickOnPlaylist();
        homePage.clickDeleteButton();
        homePage.deletedPlaylistNotification();*/
    }

}

