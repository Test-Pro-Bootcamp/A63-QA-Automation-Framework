import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderCredentials extends BaseTest {


    LoginPage loginPage = null;



    @Test(dataProvider = "incorrectCredentials")
    public void loginWithEmptyCredentials(String email, String password) {
        loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.getLogo().isDisplayed());
    }


    @DataProvider(name = "incorrectCredentials")
    public Object [][] provideIncorrectCredentials() {
        return new Object[][] {
                {"nazar@testpro.io", ""},
//                {"", "Pomidor2115"},
//                {"nazar@testpro.iom", "Pomidor2115"},
//                {"nazar@testpro.io", "Pomidor"},
//                {"nazar@testpro.iom", "Pomidor"},

        };
    }


}
