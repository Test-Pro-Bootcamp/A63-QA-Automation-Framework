import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist(){
        String expectedNofitication = "Updated playlist\"newNamePlaylist.\"";
        provideEmail("victoria.mereneanu@testpro.io");
        providePassword("Testpro1234$");
        clickLoginBtn();
        selectPlaylist();
        editPlaylist();
        Assert.assertEquals(expectedNofitication,successfulNewNameEditing());

    }

    public void selectPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='playlist playlist'][1]")));
        action.doubleClick(playlist).perform();
    }
public void editPlaylist() {
        WebElement newNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        newNameField.clear();
        newNameField.sendKeys("newNamePlaylist");
        newNameField.submit();
}
public String successfulNewNameEditing() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='alertify-logs top right']")));
                return notification.getText();
}




}
