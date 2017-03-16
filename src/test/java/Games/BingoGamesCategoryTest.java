package Games;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class BingoGamesCategoryTest extends TestBase {

	@BeforeTest
	public void initLogs() throws FileNotFoundException {
		// initLogs(this.getClass());
		init();
	}

	@Test // (enabled=false)
	public void AllBingotest() throws IOException, InterruptedException {
		openBrowser(prop.getProperty("browserType"));
		// navigate("testsiteURL");
		Thread.sleep(2000);
		doDefaultLogin(prop.getProperty("defaultUsername"));
		Thread.sleep(2000);
		click("hp_bingoVerticalTab_xpath");
		Thread.sleep(20000);
		List<WebElement> Games = d.findElements(By.cssSelector("div.bingo-games .bingo-playtech-games .bingo-button"));
		System.out.println(Games.size());
		WebElement SecondGame = Games.get(3);
		SecondGame.click();
		click("hp_bingoGame_ChooseYourLobby_New_Selector");

	}

	@Test // (enabled=false)
	public void ball90test() throws IOException, InterruptedException {
		openBrowser(prop.getProperty("browserType"));
		// navigate("testsiteURL");
		Thread.sleep(2000);
		doDefaultLogin(prop.getProperty("defaultUsername"));
		Thread.sleep(2000);
		click("hp_bingoVerticalTab_xpath");
		Thread.sleep(2000);
		click("bingo_GameCategory90Ball_xpath");
		Thread.sleep(2000);
		List<WebElement> Games = d.findElements(By.cssSelector("div.bingo-games .bingo-playtech-games .bingo-button"));
		System.out.println(Games.size());
		WebElement SecondGame = Games.get(1);
		((JavascriptExecutor) d).executeScript("arguments[0].click();", SecondGame);
		// SecondGame.click();
		click("hp_bingoGame_ChooseYourLobby_Classic_Selector");

	}

	@Test // (enabled=false)
	public void ball80test() throws IOException, InterruptedException {
		openBrowser(prop.getProperty("browserType"));
		// navigate("testsiteURL");
		Thread.sleep(2000);
		doDefaultLogin(prop.getProperty("defaultUsername"));
		Thread.sleep(2000);
		click("hp_bingoVerticalTab_xpath");
		Thread.sleep(2000);
		click("bingo_GameCategory80Ball_xpath");
		Thread.sleep(2000);
		List<WebElement> Games = d.findElements(By.cssSelector("div.bingo-games .bingo-playtech-games .bingo-button"));
		System.out.println(Games.size());
		WebElement SecondGame = Games.get(1);
		((JavascriptExecutor) d).executeScript("arguments[0].click();", SecondGame);
		click("hp_bingoGame_ChooseYourLobby_Classic_Selector");

	}

	@Test // (enabled=false)
	public void ball75test() throws IOException, InterruptedException {
		openBrowser(prop.getProperty("browserType"));
		// navigate("testsiteURL");
		Thread.sleep(2000);
		doDefaultLogin(prop.getProperty("defaultUsername"));
		Thread.sleep(2000);
		click("hp_bingoVerticalTab_xpath");
		Thread.sleep(2000);
		click("bingo_GameCategory75Ball_xpath");
		Thread.sleep(2000);
		List<WebElement> Games = d.findElements(By.cssSelector("div.bingo-games .bingo-playtech-games .bingo-button"));
		System.out.println(Games.size());
		Thread.sleep(2000);
		WebElement SecondGame = Games.get(1);
		((JavascriptExecutor) d).executeScript("arguments[0].click();", SecondGame);
		click("hp_bingoGame_ChooseYourLobby_Classic_Selector");
	}

	@Test // (enabled=false)
	public void ball75patterntest() throws IOException, InterruptedException {
		openBrowser(prop.getProperty("browserType"));
		// navigate("testsiteURL");
		Thread.sleep(2000);
		doDefaultLogin(prop.getProperty("defaultUsername"));
		Thread.sleep(2000);
		click("hp_bingoVerticalTab_xpath");
		Thread.sleep(2000);
		click("bingo_GameCategory75BallPattern_xpath");
		Thread.sleep(2000);
		List<WebElement> Games = d.findElements(By.cssSelector("div.bingo-games .bingo-playtech-games .bingo-button"));
		System.out.println(Games.size());
		Thread.sleep(2000);
		WebElement SecondGame = Games.get(1);
		((JavascriptExecutor) d).executeScript("arguments[0].click();", SecondGame);
		
		click("hp_bingoGame_ChooseYourLobby_Classic_Selector");

	}

	@Test // (enabled=false)
	public void bingojackpottest() throws IOException, InterruptedException {
		openBrowser(prop.getProperty("browserType"));
		// navigate("testsiteURL");
		Thread.sleep(2000);
		doDefaultLogin(prop.getProperty("defaultUsername"));
		Thread.sleep(2000);
		click("hp_bingoVerticalTab_xpath");// click Bingo vertical tab
		Thread.sleep(2000);
		// click Jackpot game category
		click("bingo_GameCategoryBingoJackpot_xpath");
		Thread.sleep(2000);
		List<WebElement> Games = d.findElements(By.cssSelector("div.bingo-games .bingo-playtech-games .bingo-button"));
		System.out.println(Games.size());
		Thread.sleep(2000);
		WebElement SecondGame = Games.get(1);
		((JavascriptExecutor) d).executeScript("arguments[0].click();", SecondGame);
		click("hp_bingoGame_ChooseYourLobby_Classic_Selector");

	}

	@Test // (enabled=false)
	public void timetabletest() throws IOException, InterruptedException {
		openBrowser(prop.getProperty("browserType"));
		// navigate("testsiteURL");
		Thread.sleep(2000);
		doDefaultLogin(prop.getProperty("defaultUsername"));
		Thread.sleep(2000);
		click("hp_bingoVerticalTab_xpath");
		Thread.sleep(2000);
		click("bingo_GameCategoryTimeTable_xpath");
		Thread.sleep(3000);
		// SEARCH FOR GAMES
		input("bingo_TimeTable_AllRoom_xpath", "Millionaire");
		Thread.sleep(2000);
		input("bingo_TimeTable_FilterDay_xpath", "Sunday");
		Thread.sleep(2000);
		click("bingo_TimeTable_SEARCH_xpath");
		// the search Function is broken for now it needs fixing.
		Thread.sleep(2000);
		List<WebElement> Games = d.findElements(By.cssSelector("div.bingo-games .bingo-playtech-games .bingo-button"));
		System.out.println(Games.size());
		Thread.sleep(2000);
		WebElement SecondGame = Games.get(1);
		((JavascriptExecutor) d).executeScript("arguments[0].click();", SecondGame);
		click("hp_bingoGame_ChooseYourLobby_Classic_Selector");

	}

	@AfterMethod()
	public void close() {
		quit();

	}

}
