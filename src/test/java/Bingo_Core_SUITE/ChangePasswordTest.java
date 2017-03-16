package Bingo_Core_SUITE;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import TestUtil.Constant;
import TestUtil.TestDataProvider;

public class ChangePasswordTest extends TestBase {
	
	@BeforeTest
	public void initLogs(){
		initLogs(this.getClass());
	}
	
	 @Test(enabled=false,dataProviderClass=TestDataProvider.class,dataProvider="Bingo_Core_SUITEDataProvider")
		public void ChangePasswordtest(Hashtable<String,String>table)throws IOException, InterruptedException{
			validateRunmodes("ChangePasswordTest",Constant.First_Suite,table.get(Constant.RUNMODE_COL));
			doDefaultLogin(table.get("Browser"));
			Thread.sleep(2000);
			// move to Account Menu and click Change Password link
			String Xpath_Menu=Constant.AccountMenu;
			String Xpath_SubMenu=Constant.ChangePassword;
			WebElement Menu= d.findElement(By.xpath(Xpath_Menu));
			WebElement Submenu=d.findElement(By.xpath(Xpath_SubMenu));
			Actions move= new Actions(d);
			move.moveToElement(Menu).build().perform();
			Thread.sleep(1000);
			Submenu.click();

}
	 @AfterMethod
		public void close(){
//			if(extent!=null){
//				extent.endTest(test);
//				extent.flush();
//			}
			quit();
}
}