package Games;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class GamesCategoryTest extends TestBase {

	@BeforeTest
	public void initLogs() throws FileNotFoundException {
		// initLogs(this.getClass());
		init();
	}

	@Test()
	public void Featuretest() throws IOException, InterruptedException {
		openBrowser(prop.getProperty("browserType"));
		// navigate("testsiteURL");
		Thread.sleep(2000);
		doDefaultLogin(prop.getProperty("defaultUsername"));
		Thread.sleep(2000);
		click("hp_GamesVerticalTab_xpath");
		Thread.sleep(2000);
		List<WebElement> Games = d.findElements(By.cssSelector("div.playtech-games .game_overlay"));
		System.out.println(Games.size());
		WebElement SecondGame = Games.get(3);
		SecondGame.click();

	}

	@Test()
	public void Slotstest() throws IOException, InterruptedException {
		openBrowser(prop.getProperty("browserType"));
		// navigate("testsiteURL");
		Thread.sleep(2000);
		doDefaultLogin(prop.getProperty("defaultUsername"));
		Thread.sleep(2000);
		click("hp_GamesVerticalTab_xpath");// navigate to Games Home Page
		Thread.sleep(2000);
		click("game_GameCategorySlotTab_xpath");// click Slot Tab Games
												// catergory
		Thread.sleep(20000);
		List<WebElement> Games = d.findElements(By.cssSelector("div.playtech-games .game_overlay"));
		System.out.println(Games.size());
		WebElement SecondGame = Games.get(3);
		SecondGame.click();

	}

	@Test // (enabled=false)
	public void Arcadetest() throws IOException, InterruptedException {
		openBrowser(prop.getProperty("browserType"));
		// navigate("testsiteURL");
		Thread.sleep(2000);
		doDefaultLogin(prop.getProperty("defaultUsername"));
		Thread.sleep(2000);
		click("hp_GamesVerticalTab_xpath");
		click("game_GameCategoryArcadeTab_xpath");// click Arcade Tab Games
													// catergory
		Thread.sleep(20000);
		List<WebElement> Games = d.findElements(By.cssSelector("div.playtech-games .game_overlay"));
		System.out.println(Games.size());
		WebElement SecondGame = Games.get(3);
		((JavascriptExecutor) d).executeScript("arguments[0].click();", SecondGame);
		// SecondGame.click();

	}

	@Test // (enabled=false)
	public void Scracthcardtest() throws IOException, InterruptedException {
		openBrowser(prop.getProperty("browserType"));
		// navigate("testsiteURL");
		Thread.sleep(2000);
		doDefaultLogin(prop.getProperty("defaultUsername"));
		Thread.sleep(2000);
		click("hp_GamesVerticalTab_xpath");
		Thread.sleep(2000);
		// click Scratch card  Tab Games catergory
		click("game_GameCategoryScratchCardsTab_xpath");
								
		Thread.sleep(20000);
		List<WebElement> Games = d.findElements(By.cssSelector("div.playtech-games .game_overlay"));
		System.out.println(Games.size());
		WebElement SecondGame = Games.get(3);
		((JavascriptExecutor) d).executeScript("arguments[0].click();", SecondGame);
		//SecondGame.click();

	}

	@Test()
	public void Progressivetest() throws IOException, InterruptedException {
		openBrowser(prop.getProperty("browserType"));
		// navigate("testsiteURL");
		Thread.sleep(2000);
		doDefaultLogin(prop.getProperty("defaultUsername"));
		Thread.sleep(2000);
		click("hp_GamesVerticalTab_xpath");
		Thread.sleep(2000);
		// click Progressive Tab Games catergory
		click("game_GameCategoryProgressiveTab_xpath");
					
		Thread.sleep(20000);
		// Launch any game from the Games menu 
		List<WebElement> Games = d.findElements(By.cssSelector("div.playtech-games .game_overlay"));
		System.out.println(Games.size());
		WebElement SecondGame = Games.get(3);
		((JavascriptExecutor) d).executeScript("arguments[0].click();", SecondGame);

	}

	@Test()
	public void AllGamestest() throws IOException, InterruptedException {
		openBrowser(prop.getProperty("browserType"));
		Thread.sleep(2000);
		doDefaultLogin(prop.getProperty("defaultUsername"));
		Thread.sleep(2000);
		click("hp_GamesVerticalTab_xpath");
		Thread.sleep(2000);
		click("game_GameCategoryAll_xpath");// click All Tab Games catergory
		Thread.sleep(5000);
		List<WebElement> Games = d.findElements(By.cssSelector("div.playtech-games .game_overlay"));
		System.out.println(Games.size());
		WebElement SecondGame = Games.get(3);
		SecondGame.click();

	}

	@AfterMethod // (enabled=false)
	public void close() {
		quit();

	}
}