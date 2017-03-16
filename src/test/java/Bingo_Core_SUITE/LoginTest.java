package Bingo_Core_SUITE;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.TestBase;
import TestUtil.Constant;
import TestUtil.TestDataProvider;

public class LoginTest extends TestBase {
	@BeforeTest
	public void initLogs(){
		initLogs(this.getClass());
	}
	
		@Test(dataProviderClass=TestDataProvider.class,dataProvider="Bingo_Core_SUITEDataProvider")
		public void logintest(Hashtable<String,String>table) throws IOException, InterruptedException{
			test=extent.startTest("LoginTest");
			validateRunmodes("LoginTest", Constant.First_Suite, table.get(Constant.RUNMODE_COL));
			doLogin(table.get(Constant.BROWSER_COL),table.get(Constant.USERNAME_COL),table.get(Constant.PASSWORD_COL));
			boolean result=isElementPresent("LoginErrorTextPopup_box_Selector");
			 String actualResult=null;
		    if(result)
				actualResult="FAILURE";
			else
				actualResult="SUCCESS";
		    
		   Assert.assertEquals(table.get(Constant.EXPECTEDRESULT_COL), actualResult);
		    if(table.get(Constant.EXPECTEDRESULT_COL).equals("SUCCESS")){
			// verify if user can login with invalid data 
			boolean result1=isElementPresent("userNameHolder_xpath");
			 System.out.println("Looking for error");
			 String actualResult1=null;
		    if(result1)
				actualResult1="SUCCESS";
			  else 
				actualResult1="FAILURE";
		 	Assert.assertEquals(table.get(Constant.EXPECTEDRESULT_COL), actualResult1);
//		 		
		 		}
		 				


		}
			@AfterMethod
			public void close(){
//				if(extent!=null){
//					extent.endTest(test);
//					extent.flush();
//				}
				quit();
}
}