package Bingo_Core_SUITE;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.TestBase;
import TestUtil.TestDataProvider;

public class GamesTest  extends TestBase{
	
	
	
	
	@BeforeTest
	public void initLogs() throws FileNotFoundException{
		//initLogs(this.getClass());
		init();
	}
	
	@Test(enabled=false)
	public void Headertest() throws IOException, InterruptedException{
		//openBrowser(table.get(Constant.BROWSER_COL));
		test=extent.startTest("GamesTest");
		 openBrowser(prop.getProperty("browserType")); // lunch the browser
		//navigate("testsiteURL"); // go to the website
		Thread.sleep(2000);
		doDefaultLogin(prop.getProperty("defaultUsername"));
		Thread.sleep(2000);
		// Verify if you can lunch Game from the Game Info page.
		//click("hp_PopularGames_PixiesOfTheForest_xpath");// click Pixies of the Forest
		//Thread.sleep(2000);
		
		
		
		
		
		
		
		

}
	@AfterMethod// (enabled=false)
	public void close(){
//		if(extent!=null){
//			extent.endTest(test);
//			extent.flush();
//		}
		quit();
	
		
}
}