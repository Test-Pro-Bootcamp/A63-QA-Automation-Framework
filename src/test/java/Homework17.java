import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
@Test
    public void addSongToPlaylist(){
    String expectedSuccesMsg = "Added 1 song into 'VICTORIA2023'";
    navigateToPage();
    provideEmail("victoria.mereneanu@testpro.io");
    providePassword("Testpro1234$");
    clickLoginBtn();
    search("Lament");
    viewAll();
    selectFirstSong();
    addTo();
    selectPlaylist();
    Assert.assertEquals(addtoplaylistMsg(),expectedSuccesMsg);


}
    public void search(String song)  {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.sendKeys(song);
    }
    public void viewAll()  {
        WebElement view = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        view.click();
    }

    public void selectFirstSong()  {
        WebElement firstSong = driver.findElement(By.xpath("//ul[@data-v-16e3e9ac]/article[@data-v-49903d9b]"));
                 firstSong.click();
    }
    public void addTo() {
        WebElement addToBtn = driver.findElement(By.cssSelector("li[class='has-sub']"));
        addToBtn.click();
    }
    public void selectPlaylist()  {
        WebElement playlist = driver.findElement(By.xpath("//li[@class='has-sub']//li[@class='playlist'][1]"));
        playlist.click();
    }
    public String addtoplaylistMsg() {
        WebElement message = driver.findElement(By.cssSelector("div[class='alertify-logs top right']"));
        return message.getText();
    }

}
