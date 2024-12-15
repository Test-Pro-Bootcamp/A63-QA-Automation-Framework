import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class LoginNewPassword extends BaseTest{
    @Test
    public void loginNewPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("issam.kawtharani@testpro.io")
                .providePassword("Issam@testpro2")
                .clickSubmit();
        Assert.assertTrue(homePage.isAvatarDisplayed());
    }
}
