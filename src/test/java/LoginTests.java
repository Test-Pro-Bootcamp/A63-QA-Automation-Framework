import org.testng.Assert;
import org.testng.annotations.Test;
import PageFactory.LoginPage;
import PageFactory.HomePage;

public class LoginTests extends BaseTest {
 @Test
 public void loginValidEmailPassword() {
     LoginPage loginPage = new LoginPage(getDriver());
     HomePage homePage = new HomePage(getDriver());

     loginPage.provideEmail("victoria.mereneanu@testpro.io")
             .providePassword("Testpro1234$")
             .clickSubmit();
     Assert.assertTrue(homePage.isAvatarDisplayed());
 }
@Test
    public void createNewPlaylistname(){
    LoginPage loginPage = new LoginPage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    loginPage.provideEmail("victoria.mereneanu@testpro.io")
            .providePassword("Testpro1234$")
            .clickSubmit();
    homePage.chooseNewPlaylist().choosePlaylistType().addNewName("Vicka2024");
    Assert.assertTrue(homePage.isPlaylistCreated());




}
}
