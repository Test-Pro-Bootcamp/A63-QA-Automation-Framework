import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest {


    @Test
    public void changeProfileNameTest() throws InterruptedException {
        String newName = UUID.randomUUID().toString();
        login("nazar@testpro.io", "Pomidor2115");
        WebElement avatar = driver.findElement(By.cssSelector("#userBadge, [class=profile]"));
        avatar.click();
        WebElement currentPasswordField = driver.findElement(By.cssSelector("#inputProfileCurrentPassword"));
        currentPasswordField.sendKeys("Pomidor2115");
        WebElement nameInput = driver.findElement(By.cssSelector("#inputProfileName"));
        nameInput.clear();
        nameInput.sendKeys(newName);
        WebElement saveBtn = driver.findElement(By.cssSelector(".btn-submit"));
        saveBtn.click();
        Thread.sleep(3000);
        WebElement userNameLabel = driver.findElement(By.cssSelector("#userBadge span[class=name]"));
        Assert.assertEquals(newName, userNameLabel.getText());
    }
}
