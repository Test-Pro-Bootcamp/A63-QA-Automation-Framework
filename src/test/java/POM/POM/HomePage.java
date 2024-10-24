package POM.POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage  {
    public HomePage(WebDriver givendriver) {super(givendriver);}
        By userAvatarIcon = By.cssSelector("img[class='avatar']");
        public boolean getUserAvatar() {
            return findElement(userAvatarIcon).isDisplayed();
    }
    By nextSongBtn = By.cssSelector("i[data-testid='play-next-btn']");
    By playBtn = By.cssSelector("span[data-testid='play-btn']");
    By pauseBtn = By.cssSelector("span[class='pause']");

        public void nextSong() {
            findElement(nextSongBtn).click();
        }
        public void play() {
            findElement(playBtn).click();
        }

        public boolean isSongPlaying() {
            return findElement(pauseBtn).isDisplayed();
        }

}
