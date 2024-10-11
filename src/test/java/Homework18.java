<<<<<<< Updated upstream
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() {
        navigateToPage();
        provideEmail("victoria.mereneanu@testpro.io");
        providePassword("Testpro1234$");
        clickLoginBtn();
        nextSong();
        play();
        Assert.assertTrue(isSongPlaying());

    }
public void nextSong() {
    WebElement nextSongBtn = driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));
    nextSongBtn.click();
}
public void play() {
        WebElement playBtn = driver.findElement(By.cssSelector("div[class='side player-controls']"));
        playBtn.click();
}
 public boolean isSongPlaying() {
     WebElement pauseBtn = driver.findElement(By.cssSelector("span[class='pause']"));
     return pauseBtn.isDisplayed();
 }


}
