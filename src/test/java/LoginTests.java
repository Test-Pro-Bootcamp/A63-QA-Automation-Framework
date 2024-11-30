import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test (description = "Check if user login with correct credentials", groups = "Smoke")
    public void loginWithCorrectCredentials() {
        login("nazar@testpro.io", "Pomidor2115");
        WebElement avatar = driver.findElement(By.cssSelector("#userBadge img"));
        Assert.assertTrue(avatar.isDisplayed()); //true
    }

    @Test (groups = "Regression")
    public void loginWithEmptyCredentials() {
        WebElement logo = driver.findElement(By.cssSelector(".logo"));
        login("nazar@testpro.io", "");
        Assert.assertTrue(logo.isDisplayed());
    }
}
