package Cashier;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestUtil.Constant;
import TestUtil.Utility;
import Base.TestBase;

public class AccountTest extends TestBase{
	
	
	

	@BeforeTest
	public void initLogs() throws FileNotFoundException{
		//initLogs(this.getClass());
		init();
	}
 @Test
  public void AccountMenutest() throws InterruptedException{
	// openBrowser(prop.getProperty("browserType"));
	//	navigate("testsiteURL");
		//Thread.sleep(2000);
		doDefaultLogin(prop.getProperty("browserType"));
		Thread.sleep(2000);
		//Verify if user can navigate to withdrwn page 
		String Xpath_Menu=Constant.AccountMenu;
		String Xpath_SubMenu=Constant.Withdrawn;
		WebElement Menu= d.findElement(By.xpath(Xpath_Menu));
		WebElement Submenu=d.findElement(By.xpath(Xpath_SubMenu));
		Actions move= new Actions(d);
		move.moveToElement(Menu).build().perform();
		Thread.sleep(1000);
		Submenu.click();
		Thread.sleep(3000L);	  
	    //d.switchTo().frame(0).switchTo().frame(0);
	    d.switchTo().frame("cashier-iframe").switchTo().frame("icashier");
	   // System.out.println(d.getPageSource());
	   // WebDriverWait wait= new WebDriverWait(d,15);
	    Thread.sleep(20000);
	    
	    boolean WithdrawnButton=this.isElementPresent("cashier_withdraw_Withdraw_xpath");
		if(isElementPresent("cashier_withdraw_Withdraw_xpath")){//  verify if user navigated to withdraw page
			System.out.println(true);
		//System.out.println(d.findElement(By.xpath("//*[@id='W_Submit']/tbody/tr/td[2]/span)")).getText());
	    }
		else
		{
			System.out.println(false);
			//System.out.println(d.findElement(By.xpath("//*[@id='W_Submit']/tbody/tr/td[2]/span")).getText());
		}
		d.switchTo().defaultContent();
		//System.out.println(d.getPageSource());
		//d.switchTo().defaultContent();
		click("cashier_closeIcon_xpath");
		// verify if user can navigate to My Account
		String Xpath_Menu1=Constant.AccountMenu;// navigate to account Menu
		String Xpath_SubMenu1=Constant.MyAccount;
		WebElement Menu1= d.findElement(By.xpath(Xpath_Menu1));
		WebElement Submenu1=d.findElement(By.xpath(Xpath_SubMenu1));
		Actions move1= new Actions(d);
		move1.moveToElement(Menu1).build().perform();
		Thread.sleep(1000);
		Submenu1.click();// click My Account form the Account Menu
		Thread.sleep(3000L);
		 d.switchTo().frame("cashier-iframe").switchTo().frame(0);
		    WebDriverWait wait1= new WebDriverWait(d,15);
		    boolean MyAccount=isElementPresent("cashier_MyAccount_xpath");
			if(!isElementPresent("cashier_MyAccount_xpath"))//verify if user navigated to My Account page in the cashier
				System.out.println(true);
			else
				System.out.println(false);
			Thread.sleep(1000);
			d.switchTo().defaultContent();
			click("cashier_closeIcon_xpath");
			String Xpath_Menu2=Constant.AccountMenu;// navigate to account Menu
			String Xpath_SubMenu2=Constant.History;
			WebElement Menu2= d.findElement(By.xpath(Xpath_Menu2));
			WebElement Submenu2=d.findElement(By.xpath(Xpath_SubMenu2));
			Actions move2= new Actions(d);
			move2.moveToElement(Menu2).build().perform();
			Thread.sleep(1000);
			Submenu2.click();// click My Account form the Account Menu
			Thread.sleep(3000L);
			 d.switchTo().frame("cashier-iframe").switchTo().frame(0);
			 WebDriverWait wait2= new WebDriverWait(d,15);
			  boolean History=isElementPresent("cashier_MyAccount_ViewHistory_xpath");
				if(!isElementPresent("cashier_MyAccount_ViewHistory_xpath"))//verify if View History is displayed when user navigate to History page in the cashier
					System.out.println(true);
				else
					System.out.println(false);
				Thread.sleep(1000);
				d.switchTo().defaultContent();
				click("cashier_closeIcon_xpath");
				String Xpath_Menu3=Constant.AccountMenu;// navigate to account Menu
				String Xpath_SubMenu3=Constant.PersonalDetails;
				WebElement Menu3= d.findElement(By.xpath(Xpath_Menu3));
				WebElement Submenu3=d.findElement(By.xpath(Xpath_SubMenu3));
				Actions move3= new Actions(d);
				move3.moveToElement(Menu3).build().perform();
				Thread.sleep(1000);
				Submenu3.click();// click My Account form the Account Menu
				Thread.sleep(3000L);
				try{
				   boolean PersonalDetails=isElementPresent("cashier_MyAccount_ViewHistory_xpath");
					if(!isElementPresent("cashier_MyAccount_ViewHistory_xpath"))//verify if Personal Details displayed when user navigate to History page in the cashier
						System.out.println(true);
					else
						System.out.println(false);
				}catch(Throwable t){
					t.getStackTrace();
					System.out.println(t);
				}
					Thread.sleep(1000);
					d.navigate().back();
					String Xpath_Menu4=Constant.AccountMenu;// navigate to account Menu
					String Xpath_SubMenu4=Constant.ChangePassword;
					WebElement Menu4= d.findElement(By.xpath(Xpath_Menu4));
					WebElement Submenu4=d.findElement(By.xpath(Xpath_SubMenu4));
					Actions move4= new Actions(d);
					move4.moveToElement(Menu4).build().perform();
					Thread.sleep(1000);
					Submenu4.click();// click My Account form the Account Menu
					Thread.sleep(3000L);
					try{
					   boolean PersonalDetails=isElementPresent("cashier_MyAccount_ViewHistory_xpath");
						if(isElementPresent("cashier_MyAccount_ViewHistory_xpath"))//verify if Personal Details displayed when user navigate to History page in the cashier
							System.out.println(true);
						else
							System.out.println(false);
					}catch(Throwable t){
						t.getStackTrace();
						System.out.println(t);
					}
						Thread.sleep(1000);
						d.navigate().back();
						Thread.sleep(2000);
						String Xpath_Menu6=Constant.Bal;
						String Xpath_SubMenu6=Constant.Cash;
						WebElement Menu6=d.findElement(By.cssSelector(Xpath_Menu6));
						WebElement Submenu6=d.findElement(By.xpath(Xpath_SubMenu6));
						Actions move6= new Actions(d);
						move6.moveToElement(Menu6).build().perform();// Move to Bal Menu
						Submenu6.click();// click on Cash Link within the 
						Thread.sleep(3000L);
						 d.switchTo().frame("cashier-iframe").switchTo().frame(0);
						 WebDriverWait wait3= new WebDriverWait(d,15);
						 boolean ConvertToMoney=isElementPresent("cashier_MyAccount_ConvertToMoney_xpath");
						 if(isElementPresent("cashier_MyAccount_ConvertToMoney_xpath"))// verify if convert to money button is present to ensure user navigated to the right page in the cashier
							 System.out.println(true);
						 else
							 System.out.println(false);
						 Thread.sleep(1000);
						 d.switchTo().defaultContent();
						click("cashier_closeIcon_xpath");
						//d.navigate().back();
						Thread.sleep(2000);
						String Xpath_Menu7=Constant.Bal;
						String Xpath_SubMenu7=Constant.Bonus;
						WebElement Menu7= d.findElement(By.cssSelector(Xpath_Menu7));
						WebElement Submenu7=d.findElement(By.xpath(Xpath_SubMenu7));
						Actions move7= new Actions(d);
						move7.moveToElement(Menu7).build().perform();
						Thread.sleep(1000);
						Submenu7.click();
						Thread.sleep(3000L);
						 d.switchTo().frame("cashier-iframe").switchTo().frame(0);
						 WebDriverWait wait4= new WebDriverWait(d,15);
						 boolean BonusesTab=isElementPresent("cashier_MyAccount_Bonuses_xpath");
						 if(isElementPresent("cashier_MyAccount_Bonuses_xpath"))
							 System.out.println(true);
						 else
							 System.out.println(false);
						 Thread.sleep(1000);
						 d.switchTo().defaultContent();
						click("cashier_closeIcon_xpath");
						//d.navigate().back();
						Thread.sleep(2000);
						String Xpath_Menu5=Constant.AccountMenu;// navigate to account Menu
						String Xpath_SubMenu5=Constant.Signout;
						WebElement Menu5= d.findElement(By.xpath(Xpath_Menu5));
						WebElement Submenu5=d.findElement(By.xpath(Xpath_SubMenu5));
						Actions move5= new Actions(d);
						move5.moveToElement(Menu5).build().perform();
						Thread.sleep(1000);
						Submenu5.click();
					
		
		
		
 }
 
 
 @AfterMethod
	public void close(){
		quit();
	
 }
}
