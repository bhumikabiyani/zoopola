package Bingo_Core_SUITE;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import TestUtil.Constant;
import TestUtil.TestDataProvider;

public class HomePage  extends TestBase{
	
		@BeforeTest
		public void initLogs() throws FileNotFoundException{
			initLogs(this.getClass());
			//init();
		}
		
		@Test(dataProviderClass=TestDataProvider.class,dataProvider="Bingo_Core_SUITEDataProvider")
		public void Headertest(Hashtable<String,String>table) throws IOException, InterruptedException{
			test=extent.startTest("HomePage");
			//openBrowser(table.get(Constant.BROWSER_COL));
			 openBrowser(prop.getProperty("browserType"));// lunch the browser
			navigate("testsiteURL");
			Thread.sleep(2000);
			// Verify if all Methods of Vernons Logo is displayed within theHeader
			boolean Logo=isElementPresent("hp_VernonsBingoLogo_xpath");
			if(!isElementPresent("hp_VernonsBingoLogo_xpath"))//  verify if element is not present
				System.out.println(false);
			else
				click("hp_VernonsBingoLogo_xpath");// click on the Vernons Logo
				//System.out.println();
			Thread.sleep(2000);
			String relativeURL = TestBase.getRelativeUrl(d.getCurrentUrl());
			Assert.assertEquals(relativeURL,"/");
			Thread.sleep(2000);
			/*click("hp_HeaderHelpicon_xpath");
			Thread.sleep(3000);
			Assert.assertEquals(d.getCurrentUrl(),"https://bingo.release.vernons.com/contact");
			d.navigate().back();
			Thread.sleep(2000);
			boolean Chat=isElementPresent("hp-HeaderChatIcon_xpath");
			if(!isElementPresent("hp-HeaderChatIcon_xpath"))//  verify if element is not present
				System.out.println(false);
			else
			*/
			click("hp-HeaderChatIcon_xpath");
			Thread.sleep(2000);
			// Verify if Chat Box is lunch
			Set <String> Windowids2 = d.getWindowHandles();
			Iterator<String>it2 = Windowids2.iterator();
			String MainWindowids2 = it2.next();
			String tabbedWindowId2 = it2.next();
			System.out.println(MainWindowids2);
			System.out.println(tabbedWindowId2);
			while(it2.hasNext());
			//System.out.println(it.next());
			d.switchTo().window(tabbedWindowId2);
			boolean Chatbox=isElementPresent("chat_TextBox_xpath");
			if(!isElementPresent("chat_TextBox_xpath"))//  verify if Chat Box is lunched
				System.out.println(false);
			else
			input("chat_TextBox_xpath", "Hello fine lady, i love you");// type Hello into the chat box 
			d.findElement(By.xpath("//*[@id='main_panel']/div[4]/div[1]/textarea")).sendKeys(Keys.ENTER);// then Press Enter Key
						
		}
		
		@Test(dataProviderClass=TestDataProvider.class,dataProvider="Bingo_Core_SUITEDataProvider")
			public void BingoVertcalMenutest(Hashtable<String,String>table) throws IOException, InterruptedException{
				//openBrowser(table.get(Constant.BROWSER_COL));
				test=extent.startTest("HomePage");
				 openBrowser(prop.getProperty("browserType"));
				navigate("testsiteURL");
				Thread.sleep(2000);
				click("hp_bingoVerticalTab_xpath");
				Thread.sleep(2000);
				String relativeURLY = TestBase.getRelativeUrl(d.getCurrentUrl());
				Thread.sleep(2000);
				System.out.println(relativeURLY );
				Assert.assertEquals(relativeURLY,"/bingo");// verify bingo Vertical tab link navigate to the right url
				//Thread.sleep(1000);
				//d.navigate().back();
				Thread.sleep(5000);
					//Thread.sleep(3000);
				String Xpath_Menu=Constant.BingoVerticalTab;
				String Xpath_SubNenu=Constant.BingoVerticalDropdown_Playnow;
				WebElement Menu=d.findElement(By.xpath(Xpath_Menu));
				WebElement SubMenu=d.findElement(By.xpath(Xpath_SubNenu));
				Actions act= new Actions(d);
				act.moveToElement(Menu).build().perform();
				WebDriverWait wait= new WebDriverWait(d,30);
				wait.until(ExpectedConditions.elementToBeClickable(SubMenu));
				//Thread.sleep(5000);
				SubMenu.click();// click on play now link
				Thread.sleep(2000);
				String relativeURL0 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals( relativeURL0,"/bingo");// 
				Thread.sleep(1000);
				//d.navigate().back();
				click("hp_bingoGame_chooseYourLobby_closeIcon_Selector");
				Thread.sleep(3000);
				String Xpath_Menu1=Constant.BingoVerticalTab;
				String Xpath_SubNenu1=Constant.BingoVerticalDropdown_Timetable;
				WebElement Menu1=d.findElement(By.xpath(Xpath_Menu1));
				WebElement SubMenu1=d.findElement(By.xpath(Xpath_SubNenu1));
				Actions act1= new Actions(d);
				act.moveToElement(Menu1).build().perform();
				Thread.sleep(1000);
				SubMenu1.click();
				Thread.sleep(2000);
				String relativeURL1 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals(relativeURL1,"/timetable");// check if current url is the same as the expected
				Thread.sleep(2000);
				d.navigate().back();
				Thread.sleep(2000);
				String Xpath_Menu2=Constant.BingoVerticalTab;
				String Xpath_SubNenu2=Constant.BingoVerticalDropdown_GuideToBingo;
				WebElement Menu2=d.findElement(By.xpath(Xpath_Menu2));
				WebElement SubMenu2=d.findElement(By.xpath(Xpath_SubNenu2));
				Actions act2= new Actions(d);
				act2.moveToElement(Menu2).build().perform();
				Thread.sleep(2000);
				SubMenu2.click();
				Thread.sleep(2000);
				String relativeURL2 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals(relativeURL2,"/bingo-guide");// verify if the both URL are equal
				Thread.sleep(2000);
				d.navigate().back();
				Thread.sleep(2000);
				click("hp_GamesVerticalTab_xpath");// click Games tab link
				Thread.sleep(2000);
				String relativeURL3 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals(relativeURL3,"/games");
				
				

			}
			@Test(dataProviderClass=TestDataProvider.class,dataProvider="Bingo_Core_SUITEDataProvider")
			public void PromotionsVertcalMenutest(Hashtable<String,String>table) throws IOException, InterruptedException{
				test=extent.startTest("HomePage");
				 openBrowser(prop.getProperty("browserType"));
				navigate("testsiteURL");
				Thread.sleep(2000);
				click("hp_promotionsVerticalTab_xpath");// click on promotion vertical tab link
				System.out.println(d.getCurrentUrl());
				Thread.sleep(2000);
				String relativeURL3 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals(relativeURL3,"/promotions-category/welcome-promotions");
				d.navigate().back();
				Thread.sleep(2000);
				click("hp_VIPVerticalTab_xpath");
				Thread.sleep(2000);
				String title=getText("VIPClub_Title_Selector");
				if(title.equalsIgnoreCase("VIP Club"))
					System.out.println(true);
					else
				System.out.println("Wrong title page displayed.");
				// Verify if the Casino VerticalTab link will navigate to Casino Homepage
				d.navigate().back();
				Thread.sleep(2000);
				click("hp_casinoVerticalTab_Selector");
				Thread.sleep(2000);
				Assert.assertEquals(d.getCurrentUrl(), "https://casino.vernons.com/");
				d.navigate().back();
					d.close();
				

}
			@Test(dataProviderClass=TestDataProvider.class,dataProvider="Bingo_Core_SUITEDataProvider")
			public void HelpVertcalMenutest(Hashtable<String,String>table) throws IOException, InterruptedException{
				test=extent.startTest("HomePage");
				 openBrowser(prop.getProperty("browserType"));
				navigate("testsiteURL");
				Thread.sleep(2000);
				click("hp_HelpVerticalTab_xpath");// click help vertical tab link
				Thread.sleep(2000);
				String relativeURL3 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals(relativeURL3,"/contact");
				d.navigate().back();
				Thread.sleep(2000);
			    String Xpath_Menu6=Constant.HelpVerticalTab;
				String Xpath_SubNenu6=Constant.HelpDropdown_GettingStarted;
				WebElement Menu6=d.findElement(By.xpath(Xpath_Menu6));
				WebElement SubMenu6=d.findElement(By.xpath(Xpath_SubNenu6));
				Actions act6= new Actions(d);
				act6.moveToElement(Menu6).build().perform();
				Thread.sleep(3000);
				SubMenu6.click();// click on  point link
				Thread.sleep(2000);
				String relativeURL4 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals( relativeURL4 ,"/help/getting-started");// verify if the both URL are equal
				Thread.sleep(2000);
				d.navigate().back();
				Thread.sleep(2000);
				String Xpath_Menu7=Constant.HelpVerticalTab;
				String Xpath_SubNenu7=Constant.HelpDropdown_Banking;
				WebElement Menu7=d.findElement(By.xpath(Xpath_Menu7));
				WebElement SubMenu7=d.findElement(By.xpath(Xpath_SubNenu7));
				Actions act7= new Actions(d);
				act7.moveToElement(Menu7).build().perform();
				WebDriverWait wait= new WebDriverWait(d,45);
				wait.until(ExpectedConditions.elementToBeClickable(SubMenu7));
				SubMenu7.click();// click on  point link
				Thread.sleep(2000);
				String relativeURL5 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals(relativeURL5 ,"/banking");// verify if the both URL are equal
				Thread.sleep(2000);
				d.navigate().back();
				Thread.sleep(2000);
				String Xpath_Menu8=Constant.HelpVerticalTab;
				String Xpath_SubNenu8=Constant.HelpDropdown_IsMyDepositSafe;
				WebElement Menu8=d.findElement(By.xpath(Xpath_Menu8));
				WebElement SubMenu8=d.findElement(By.xpath(Xpath_SubNenu8));
				Actions act8= new Actions(d);
				act8.moveToElement(Menu8).build().perform();
				Thread.sleep(2000);
				SubMenu8.click();// click on  point link
				Thread.sleep(2000);
				String relativeURL6 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals(relativeURL6,"/help/is-my-deposit-safe");// verify if the both URL are equal
				Thread.sleep(2000);
				d.navigate().back();
				Thread.sleep(2000);
				String Xpath_Menu9=Constant.HelpVerticalTab;
				String Xpath_SubNenu9=Constant.HelpDropdown_BonusUse;
				WebElement Menu9=d.findElement(By.xpath(Xpath_Menu9));
				WebElement SubMenu9=d.findElement(By.xpath(Xpath_SubNenu9));
				Actions act9= new Actions(d);
				act9.moveToElement(Menu9).build().perform();
				Thread.sleep(2000);
				SubMenu9.click();// click on  point link
				Thread.sleep(2000);
				String relativeURL7 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals(relativeURL7,"/help/bonus-use");// verify if the both URL are equal
				Thread.sleep(2000);
				d.navigate().back();
				Thread.sleep(2000);
				String Xpath_Menu10=Constant.HelpVerticalTab;
				String Xpath_SubNenu10=Constant.HelpDropdown_Depositing;
				WebElement Menu10=d.findElement(By.xpath(Xpath_Menu10));
				WebElement SubMenu10=d.findElement(By.xpath(Xpath_SubNenu10));
				Actions act10= new Actions(d);
				act10.moveToElement(Menu10).build().perform();
				Thread.sleep(2000);
				SubMenu10.click();// click on  point link
				Thread.sleep(2000);
				String relativeURL8 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals(relativeURL8 ,"/help/depositing");// verify if the both URL are equal
				Thread.sleep(2000);
				d.navigate().back();
				Thread.sleep(2000);
				String Xpath_Menu11=Constant.HelpVerticalTab;
				String Xpath_SubNenu11=Constant.HelpDropdown_Prebuy;
				WebElement Menu11=d.findElement(By.xpath(Xpath_Menu11));
				WebElement SubMenu11=d.findElement(By.xpath(Xpath_SubNenu11));
				Actions act11= new Actions(d);
				act11.moveToElement(Menu11).build().perform();
				Thread.sleep(1000);
				SubMenu11.click();// click on  point link
				Thread.sleep(2000);
				String relativeURL9 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals(relativeURL9,"/help/prebuy");// verify if the both URL are equal
				Thread.sleep(2000);
				d.navigate().back();
				Thread.sleep(2000);
				String Xpath_Menu12=Constant.HelpVerticalTab;
				String Xpath_SubNenu12=Constant.HelpDropdown_MeetTheChatMan;
				WebElement Menu12=d.findElement(By.xpath(Xpath_Menu12));
				WebElement SubMenu12=d.findElement(By.xpath(Xpath_SubNenu12));
				Actions act12= new Actions(d);
				act12.moveToElement(Menu12).build().perform();
				Thread.sleep(1000);
				SubMenu12.click();// click on  point link
				Thread.sleep(2000);
				String relativeURL10 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals(relativeURL10,"/help/chat-hosts");// verify if the both URL are equal
				Thread.sleep(2000);
				d.navigate().back();
				Thread.sleep(2000);
				String Xpath_Menu13=Constant.HelpVerticalTab;
				String Xpath_SubNenu13=Constant.HelpDropdown_Mobile;
				WebElement Menu13=d.findElement(By.xpath(Xpath_Menu13));
				WebElement SubMenu13=d.findElement(By.xpath(Xpath_SubNenu13));
				Actions act13= new Actions(d);
				act13.moveToElement(Menu13).build().perform();
				Thread.sleep(1000);
				SubMenu13.click();// click on  point link
				Thread.sleep(2000);
				try{
					String relativeURL14 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals(relativeURL14 ,"/mobile");// verify if the both URL are equal
				}catch(Throwable t){
					t.getStackTrace();
					System.out.println(t);
				}
				Thread.sleep(2000);
				d.navigate().back();
				Thread.sleep(2000);
				String Xpath_Menu14=Constant.HelpVerticalTab;
				String Xpath_SubNenu14=Constant.HelpDropdown_FAQ;
				WebElement Menu14=d.findElement(By.xpath(Xpath_Menu14));
				WebElement SubMenu14=d.findElement(By.xpath(Xpath_SubNenu14));
				Actions act14= new Actions(d);
				act14.moveToElement(Menu14).build().perform();
				Thread.sleep(1000);
				SubMenu14.click();// click on  point link
				Thread.sleep(2000);
				String relativeURL11 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals(relativeURL11 ,"/help/faq");// verify if the both URL are equal
				Thread.sleep(2000);
				d.navigate().back();
				Thread.sleep(2000);
				String Xpath_Menu16=Constant.HelpVerticalTab;
				String Xpath_SubNenu16=Constant.HelpDropdown_ContactUs;
				WebElement Menu16=d.findElement(By.xpath(Xpath_Menu16));
				WebElement SubMenu16=d.findElement(By.xpath(Xpath_SubNenu16));
				Actions act16= new Actions(d);
				act16.moveToElement(Menu16).build().perform();
				Thread.sleep(1000);
				SubMenu16.click();// click on  point link
				Thread.sleep(2000);
				String relativeURL12 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals(relativeURL12,"/contact");// verify if the both URL are equal
				Thread.sleep(2000);
				//d.navigate().back();
				
	
				
				}
			@Test(dataProviderClass=TestDataProvider.class,dataProvider="Bingo_Core_SUITEDataProvider")
			public void Footertest(Hashtable<String,String>table) throws IOException, InterruptedException{
				test=extent.startTest("HomePage");
				 openBrowser(prop.getProperty("browserType"));
				navigate("testsiteURL");
				Thread.sleep(2000);
				click("hp_FooterAboutUs_xpath");// click About us link in the footer and then navigate to the page
				Thread.sleep(2000);
				String relativeURL12 = TestBase.getRelativeUrl(d.getCurrentUrl());
				System.out.println(relativeURL12);
				//Assert.assertEquals( relativeURL12 ,"/about-us");// verify if the both URL are equal
				Thread.sleep(2000);
				d.navigate().back();
				Thread.sleep(2000);
				click("hp_FooterAffiliates_xpath");// click affiliate link 
				Thread.sleep(1000);
				Set <String> Windowids = d.getWindowHandles();
				Iterator<String> it = Windowids.iterator();
				String MainWindowids = it.next();
				String tabbedWindowId = it.next();
				System.out.println(MainWindowids);
				System.out.println(tabbedWindowId);
				while(it.hasNext());
				//System.out.println(it.next());
				d.switchTo().window(tabbedWindowId);// switch to the affiliates window
				Assert.assertEquals(d.getCurrentUrl(),"http://www.netplayaffiliates.com/");// verify if the both URL are equal
				Thread.sleep(1000);
				d.switchTo().window(MainWindowids);// switch back to the main window
				Thread.sleep(1000);
				click("hp_FooterContactUs_xpath");
				Thread.sleep(2000);
				String relativeURL13 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals(relativeURL13,"/contact");// verify if the both URL are equal
				Thread.sleep(2000);
				d.navigate().back();
				Thread.sleep(2000);
				click("hp_FooterResponsibleGambling_Selector");
				try{
				Thread.sleep(2000);
				String relativeURL14 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals(relativeURL14,"/enjoy-responsibly");// verify if the both URL are equal
				}catch(Throwable t){
					t.getStackTrace();
					 System.out.println(t);
				}
				Thread.sleep(2000);
				d.navigate().back();
				Thread.sleep(2000);
				click("hp_FooterFAQ_Selector");
				Thread.sleep(2000);
				String relativeURL15 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals(relativeURL15,"/help/faq");// verify if the both URL are equal
				Thread.sleep(2000);
				d.navigate().back();
				Thread.sleep(2000);
				click("hp_FooterPrivacyPolicy_xpath");
				Thread.sleep(2000);
				String relativeURL16 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals(relativeURL16 ,"/privacy-policy");// verify if the both URL are equal
				Thread.sleep(2000);
				d.navigate().back();
				Thread.sleep(2000);
				click("hp_FooterTerms&Conditions_xpath");
				Thread.sleep(2000);
				String relativeURL17 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals(relativeURL17,"/terms-and-conditions");// verify if the both URL are equal
				Thread.sleep(2000);
				d.navigate().back();
				Thread.sleep(2000);
				// Verify if all Methods of payment icons are displayed within the the footer
				boolean paypal=isElementPresent("hp_FooterPayPalIcon_Selector");
				System.out.println(paypal);
				Thread.sleep(2000);
				boolean Visa=isElementPresent("hp_FooterVisaIcon_Selector");
				System.out.println(Visa);
				Thread.sleep(2000);
				boolean Mastercard=isElementPresent("hp_FooterMastercardIcon_Selector");
				System.out.println(Mastercard);
				Thread.sleep(2000);
				boolean Delta=isElementPresent("hp_FooterDeltaIcon_Selector");
				System.out.println(Delta);
				Thread.sleep(2000);
				boolean VisaElectron=isElementPresent("hp_FooterVisaElectronIcon_Selector");
				System.out.println(VisaElectron);
				Thread.sleep(2000);
				boolean PaysafeCard=isElementPresent("hp_FooterPaySafeCardIcon_Selector");
				System.out.println( PaysafeCard);
				Thread.sleep(2000);
				boolean Skrill=isElementPresent("hp_FooterSKrillIcon_Selector");
				System.out.println(Skrill);
				Thread.sleep(2000);
				boolean Neteller=isElementPresent("hp_FooterNetellerIcon_Selector");
				System.out.println(Neteller);
				Thread.sleep(2000);
				boolean footertext=isElementPresent("hp_footerUKGCtext_Selector");// VERIFY IF UKGC TEXT IS PRESENT WITHIN THE FOOTER
				System.out.println(footertext);
				
				
			}
			@Test(dataProviderClass=TestDataProvider.class,dataProvider="Bingo_Core_SUITEDataProvider")
			public void netplaytvicontest(Hashtable<String,String>table) throws IOException, InterruptedException{
				test=extent.startTest("HomePage");
				 openBrowser(prop.getProperty("browserType"));
				navigate("testsiteURL");
				Thread.sleep(2000);
				click("hp_footerNetplaytvIcon_Selector");
				Thread.sleep(2000);
				Set <String> Windowids1 = d.getWindowHandles();
				Iterator<String> it1 = Windowids1.iterator();
				String MainWindowids1 = it1.next();
				String tabbedWindowId1 = it1.next();
				System.out.println(MainWindowids1);
				System.out.println(tabbedWindowId1);
				while(it1.hasNext());
				//System.out.println(it.next());
				d.switchTo().window(tabbedWindowId1);// switch to the affiliates window
				Assert.assertEquals(d.getCurrentUrl(),"http://www.netplaytv.com/");// verify if the both URL are equal
				Thread.sleep(2000);
				d.switchTo().window(MainWindowids1);// switch back to the main window
				Thread.sleep(2000);
				click("hp_footer18+Icon_Selector");
				Thread.sleep(2000);
				try{
					String relativeURL18 = TestBase.getRelativeUrl(d.getCurrentUrl());
				Assert.assertEquals( relativeURL18,"/responsible-gambling");// verify if the both URL are equal
				
				}catch(Throwable t){
					t.getStackTrace();
					System.out.println(t);
				}
				Thread.sleep(2000);
				
				
			}	
			@Test(dataProviderClass=TestDataProvider.class,dataProvider="Bingo_Core_SUITEDataProvider")
			public void GamecareIcontest(Hashtable<String,String>table) throws IOException, InterruptedException{
				test=extent.startTest("HomePage");
				 openBrowser(prop.getProperty("browserType"));
				navigate("testsiteURL");
				Thread.sleep(2000);
				click("hp_footerGamcareIcon_Selector");// alderney
				Thread.sleep(2000);
				Set <String> Windowids2 = d.getWindowHandles();
				Iterator<String>it2 = Windowids2.iterator();
				String MainWindowids2 = it2.next();
				String tabbedWindowId2 = it2.next();
				System.out.println(MainWindowids2);
				System.out.println(tabbedWindowId2);
				while(it2.hasNext());
				//System.out.println(it.next());
				d.switchTo().window(tabbedWindowId2);// switch to the affiliates window
				Thread.sleep(2000);
				try{
				Assert.assertEquals(d.getCurrentUrl(),"https://www.gamblingcontrol.org/");
				}catch(Throwable t){
					t.getStackTrace();
					System.out.println(t);
				}
				Thread.sleep(2000);
				d.switchTo().window(MainWindowids2);// switch back to the main window
				Thread.sleep(2000);
			
			}
			@Test(dataProviderClass=TestDataProvider.class,dataProvider="Bingo_Core_SUITEDataProvider")
			public void GamblingCommsionIcontest(Hashtable<String,String>table) throws IOException, InterruptedException{
				test=extent.startTest("HomePage");
				 openBrowser(prop.getProperty("browserType"));
				navigate("testsiteURL");
				Thread.sleep(2000);
				click("hp_footerGamblingCommissionIcon_Selector");
				Thread.sleep(2000);
				Set <String> Windowids3 = d.getWindowHandles();
				Iterator<String> it3 = Windowids3.iterator();
				String MainWindowids3 = it3.next();
				String tabbedWindowId3 = it3.next();
				System.out.println(MainWindowids3);
				System.out.println(tabbedWindowId3);
				while(it3.hasNext());
				//System.out.println(it.next());
				d.switchTo().window(tabbedWindowId3);// switch to the affiliates window
				try{
				Assert.assertEquals(d.getCurrentUrl(),"https://secure.gamblingcommission.gov.uk/gccustomweb/PublicRegister/PRAccountDetails.aspx?accountNo=39144");// verify if the both URL are equal
				Thread.sleep(2000);
				}catch(Throwable t){
					t.getStackTrace();
					System.out.println(t);
				}
				d.switchTo().window(MainWindowids3);// switch back to the main window
				Thread.sleep(2000);
			
			}
			
			@Test(enabled=false,dataProviderClass=TestDataProvider.class,dataProvider="Bingo_Core_SUITEDataProvider")
			public void GamblingwareIcontest(Hashtable<String,String>table) throws IOException, InterruptedException{
				test=extent.startTest("HomePage");
				 openBrowser(prop.getProperty("browserType"));
				navigate("testsiteURL");
				Thread.sleep(2000);
				click("hp_footerGameWareIcon_xpath");
				Thread.sleep(2000);
				Set <String> Windowids3 = d.getWindowHandles();
				Iterator<String> it3 = Windowids3.iterator();
				String MainWindowids3 = it3.next();
				String tabbedWindowId3 = it3.next();
				System.out.println(MainWindowids3);
				System.out.println(tabbedWindowId3);
				while(it3.hasNext());
				//System.out.println(it.next());
				d.switchTo().window(tabbedWindowId3);// switch to the affiliates window
				Assert.assertEquals(d.getCurrentUrl(),"http://www.gambleaware.co.uk/");// verify if the both URL are equal
				Thread.sleep(2000);
				d.switchTo().window(MainWindowids3);// switch back to the main window
			
			
			}
			@Test(enabled=false,dataProviderClass=TestDataProvider.class,dataProvider="Bingo_Core_SUITEDataProvider")
			public void AlderneyIcontest(Hashtable<String,String>table) throws IOException, InterruptedException{
				test=extent.startTest("HomePage");
				 openBrowser(prop.getProperty("browserType"));
				navigate("testsiteURL");
				Thread.sleep(2000);
				click("hp_footerAlderneyIcon_Selector");
				Thread.sleep(2000);
				Set <String> Windowids3 = d.getWindowHandles();
				Iterator<String> it3 = Windowids3.iterator();
				String MainWindowids3 = it3.next();
				String tabbedWindowId3 = it3.next();
				System.out.println(MainWindowids3);
				System.out.println(tabbedWindowId3);
				while(it3.hasNext());
				//System.out.println(it.next());
				
				// switch to the affiliates window
				d.switchTo().window(tabbedWindowId3);
				
				// verify if the both URL are equal
				Assert.assertEquals(d.getCurrentUrl(),"https://www.gamblingcontrol.org/");
				Thread.sleep(2000);
				
				// switch back to the main window
				d.switchTo().window(MainWindowids3);
			
			}
			@Test(enabled=false,dataProviderClass=TestDataProvider.class,dataProvider="Bingo_Core_SUITEDataProvider")
			public void PlaytechIcontest(Hashtable<String,String>table) throws IOException, InterruptedException{
				test=extent.startTest("HomePage");
				 openBrowser(prop.getProperty("browserType"));
				navigate("testsiteURL");
				Thread.sleep(2000);
				click("hp_footerPlaytechIcon_xpath");
				Thread.sleep(2000);
				Set <String> Windowids3 = d.getWindowHandles();
				Iterator<String> it3 = Windowids3.iterator();
				String MainWindowids3 = it3.next();
				String tabbedWindowId3 = it3.next();
				System.out.println(MainWindowids3);
				System.out.println(tabbedWindowId3);
				while(it3.hasNext());
				//System.out.println(it.next());
				// switch to the affiliates window
				d.switchTo().window(tabbedWindowId3);
				// verify if the both URL are equal
				Assert.assertEquals(d.getCurrentUrl(),"http://www.playtech.com/");
				Thread.sleep(2000);
				// switch back to the main window
				d.switchTo().window(MainWindowids3);
			
			}

			@AfterMethod
			public void close(){
//				if(extent!=null){
//				extent.endTest(test);
//				extent.flush();
    			quit();
			
			
				
}


}
