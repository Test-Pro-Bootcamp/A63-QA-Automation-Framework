import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedSuccessfulMsg = "Deleted playlist \"sprint 1.\"";
        navigateToPage();
        provideEmail("victoria.mereneanu@testpro.io");
        providePassword("Testpro1234$");
        clickLoginBtn();
        selectPlaylist();
        okToDelete();
        xPlaylist();
        Assert.assertEquals(expectedSuccessfulMsg, succesfulDeleteMsg());
    }



    public void selectPlaylist() {
        WebElement playlist = driver.findElement(By.xpath("//li[@class='playlist playlist'][3]"));
        playlist.click();
    }
    public void okToDelete() {
        WebElement okBtn = driver.findElement(By.xpath("//div[@class='alertify']//button[@class= 'ok']"));
        okBtn.click();
    }
    public void xPlaylist() {
        WebElement xPlaylistBtn = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        xPlaylistBtn.click();
    }
    public String succesfulDeleteMsg(){
        WebElement message = driver.findElement(By.cssSelector("div.success.show"));
        return message.getText();
    }
}
