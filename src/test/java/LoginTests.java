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
                .providePassword("Testpro4321$")
                .clickSubmit();
        Assert.assertTrue(homePage.isAvatarDisplayed());
    }
    @Test
    public void logout(){
        HomePage homepage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail("victoria.mereneanu@testpro.io")
                .providePassword("Testpro4321$")
                .clickSubmit();
        homepage.logoutUser();
        Assert.assertTrue(loginPage.isKoelLogoDisplayed());
    }
}