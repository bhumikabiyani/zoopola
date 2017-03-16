package Bingo_Core_SUITE;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import TestUtil.TestDataProvider;

public class PromotionsPage extends TestBase {
	
	
		@BeforeTest
		public void initLogs() throws FileNotFoundException{
			//initLogs(this.getClass());
			init();
		}
		
		@Test//(enabled=false)
		public void PromotionsMenutest() throws IOException, InterruptedException{
			//openBrowser(table.get(Constant.BROWSER_COL));
			// verifying that when Unauthenticated user navigated to the Promotions page , Welcome Promotions Submenu Tab is highlighted
			 openBrowser(prop.getProperty("browserType"));
			navigate("testsiteURL");
			Thread.sleep(2000);
			click("hp_promotionsVerticalTab_xpath");
			Thread.sleep(2000);
			Assert.assertEquals(d.getCurrentUrl(),"https://bingo.vernons.com/promotions-category/welcome-promotions");
			Thread.sleep(2000);
			click("promotion_weeklypromotion_xpath");
			Thread.sleep(2000);
			Assert.assertEquals(d.getCurrentUrl(),"https://bingo.vernons.com/promotions-category/weekly-promotions");// verify if clicking on weekly promotions the URL address is the same as expected
			Thread.sleep(2000);
			click("promotion_DailyPromotions_xpath");
			Thread.sleep(2000);
			Assert.assertEquals(d.getCurrentUrl(),"https://bingo.vernons.com/promotions-category/daily-promotions");// verify if clicking on weekly promotions the URL address is the same as expected
			Thread.sleep(2000);
			click("promotion_BingoJackpot_xpath");
			Thread.sleep(2000);
			Assert.assertEquals(d.getCurrentUrl(),"https://bingo.vernons.com/promotions-category/bingo-jackpots");// verify if clicking on weekly promotions the URL address is the same as expected
			Thread.sleep(2000);
			click("promotion_welcomePromotions_xpath");
			Thread.sleep(1000);
			//Verify if user click on Play Now button will navigate to Registration page
			// Verify that when user click on the More info button on any of the promo banner will take user to the game info page of that game promo banner
			
		}
			@Test//(enabled=false)
			public void PromotionsMenu1test() throws IOException, InterruptedException{
				//openBrowser(table.get(Constant.BROWSER_COL));
				// verifying that when authenticated user navigated to the Promotions page , weekly Promotions Submenu Tab is highlighted
				// openBrowser(prop.getProperty("browserType"));
				Thread.sleep(2000);
				doDefaultLogin(prop.getProperty("browserType"));// log-in
				Thread.sleep(2000);
				click("hp_promotionsVerticalTab_xpath");
				Thread.sleep(2000);
				Thread.sleep(1000L);
				 WebElement promo=d.findElement(By.cssSelector("div.view-promotions .view-content"));
				   List <WebElement> Promlist=promo.findElements(By.cssSelector("div.promo-wrapper"));
				   
				   System.out.println(Promlist.size());
				   
				   for(int i=0; i < Promlist.size(); i++) {
					   
					   System.out.println(i);
					   // Repolulate  the list of all the Elements on all the banner.
					    promo=d.findElement(By.cssSelector("div.view-promotions .view-content"));
					   Promlist = promo.findElements(By.cssSelector("div.promo-wrapper"));
					   WebElement promotion = Promlist.get(i);
							   
					   //get promotion title
					   String promotionTitle = promotion.findElement(By.cssSelector(".promotion-title a")).getText();
					   System.out.println(promotionTitle);
//					   
//					   //navigate
				 WebElement Button1=promotion.findElement(By.cssSelector("a.promo-more-info"));
				 	Button1.click();
		   		 //get page title
				 	String pagetitle=getText("titlePage_xpath");
				 	Thread.sleep(200);
				 	System.out.println(pagetitle);
				 	if(pagetitle.equalsIgnoreCase(promotionTitle)){
				 		System.out.println(true);
				 		
				 		Thread.sleep(1000);
				 		d.navigate().back();
				 	}else{
				 		System.out.println(false);
				 		return;

				 	}	
					   
					   
					   //compare
					   
					   
				   }
	
	
	
	
	
	

}
			@AfterMethod
			public void close(){
				quit();
			
				
}
}
