package Bingo_Core_SUITE;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import TestUtil.Constant;
import TestUtil.TestDataProvider;
import Base.TestBase;

public class RegistrationTest  extends TestBase{
	
	@BeforeTest
	public void initLogs(){
		initLogs(this.getClass());
	}
	
		@Test(dataProviderClass=TestDataProvider.class,dataProvider="Bingo_Core_SUITEDataProvider")
		public void RegistrationTest(Hashtable<String,String>table) throws IOException, InterruptedException{
		// verify if user can register with incorrect data 
		// verify if user can register with correct data 
		// verify if user will be taking to welcome page after successfully completed the form and click submit
			test=extent.startTest("RegistrationTest");
			String consValue = Constant.First_Suite;
			String tableValue = table.get(Constant.RUNMODE_COL);
			validateRunmodes("RegistrationTest",consValue,tableValue);
			openBrowser(table.get(Constant.BROWSER_COL));
			navigate("testsiteURL");
			Thread.sleep(2000);
			click("hp_JoinNow_xpath");// click join now button 
			Thread.sleep(3000);
			//Generating Dynanic username
			String Username = table.get(Constant.REGUSERNAME_COL).toString();
			System.out.println(Username);
			if (Username.equals("{generator}")) {
				Username=generateStringWithAllobedSplChars(20,"");
			}
			input("register_username_xpath", Username);//
			input("register_password_xpath", table.get(Constant.REGPASSWORD_COL));
			input("register_ConfirmPassword_xpath", table.get(Constant.CONFPASSWORD_COL));
			input("register_e-mail_xpath", table.get(Constant.EMAIL_COL));
			input("register_title_xpath", table.get(Constant.TITLE_COL)); //select your title
			input("register_firstname_xpath", table.get(Constant.FIRSTNAME_COL));
			input("register_surname_xpath", table.get(Constant.LASTNAME_COL));
			input("register_DOBDay_xpath", TestBase.formatIntegerToString(table.get(Constant.DAY_COL)));
			input("register_DOBMonth_xpath", table.get(Constant.MONTH_COL));
			input("register_DOBYear_xpath", table.get(Constant.YEAR_COL));
			Thread.sleep(2000L);
			click("register_EnterAddressManually_xpath");
			Thread.sleep(2000L);
			input("register_Address_xpath",table.get(Constant.ADDRESS_COL));
			input("register_Town/City_xpath",table.get(Constant.CITY_COL));
			input("register_County_xpath",table.get(Constant.COUNTY_COL));
			input("register_PostCode_xpath",table.get(Constant.POSTCODE_COL));
			input("register_ContactNumber_xpath",table.get(Constant.CONTACTNUMBER_COL));
			//input("regPromoCode_xpath",table.get(Constant.PROMOCODE_COL));
			Thread.sleep(2000);
			click("register_checkbox2_xpath");
			Thread.sleep(3000);
			String RegText=getText("register_RegulationTextsBelowTheSubmitButton_xpath");
			if(isElementPresent("register_RegulationTextsBelowTheSubmitButton_xpath"))
				// APPLICATION_LOG.debug(RegText);
				//System.out.println(RegText);
				test.log(LogStatus.PASS, RegText);
			else
				test.log(LogStatus.FAIL, "Test Not Displayed");
				//APPLICATION_LOG.debug("Texts Message not displayed");
				//System.out.println(false);
				Thread.sleep(3000);
			click("register_Submit_xpath");//click on submit button
			Thread.sleep(3000L);
			// verify if user will be taking to welcome page after successfully completed the register form.
			boolean result=isElementPresent("register_error_Selector");
			 String actualResult=null;
		    if(result)
				actualResult="FAILURE";
			else
				actualResult="SUCCESS";
		     Assert.assertEquals(table.get(Constant.EXPECTEDRESULT_COL),actualResult);
		    if(table.get(Constant.EXPECTEDRESULT_COL).equals("SUCCESS")){
			// verify if user can login with invalid data 
			boolean result1=isElementPresent("userNameHolder_xpath");
			 String actualResult1=null;
		    if(result1)
				actualResult1="SUCCESS";
			  else 
				actualResult1="FAILURE";
		 	Assert.assertEquals(table.get(Constant.EXPECTEDRESULT_COL), actualResult1);
//		 		
			
		    }
					
//			
			
				Thread.sleep(3000);
}

		@AfterMethod//(enabled=false)
		public void close(){
//			if(extent!=null){
//				extent.endTest(test);
//				extent.flush();
//			}
			quit();
}



	
	

}
