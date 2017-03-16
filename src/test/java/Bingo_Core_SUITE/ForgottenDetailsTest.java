package Bingo_Core_SUITE;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.TestBase;
import TestUtil.Constant;
import TestUtil.TestDataProvider;

public class ForgottenDetailsTest extends TestBase {
	
	@BeforeTest
	public void initLogs(){
		initLogs(this.getClass());
	}
	
	 @Test(dataProviderClass=TestDataProvider.class,dataProvider="Bingo_Core_SUITEDataProvider")
		public void ForgottenDetailstest(Hashtable<String,String>table)throws IOException, InterruptedException{
		 test=extent.startTest("ForgottenDetailsTest");
			validateRunmodes("ForgottenDetailsTest",Constant.First_Suite,table.get(Constant.RUNMODE_COL));
			openBrowser(table.get(Constant.BROWSER_COL));
			//openBrowser(prop.getProperty("browserType"));
			navigate("testsiteURL");
			Thread.sleep(2000);
			click("hp-forgottenPassword_xpath");
			Thread.sleep(2000);
			// Verify if Bingo Vernons Logo is displayed on the forgotten details Pop-up box
			boolean FdLogo=isElementPresent("ForgottenDetails_PopupBox_VernonsLogo_xpath");
			if(!isElementPresent("ForgottenDetails_PopupBox_VernonsLogo_xpath")){
				System.out.println(true);
			}else{
				System.out.println(false);
				Thread.sleep(2000);
			}
				// verifying if the help text is dis played on the Forgooten deatils pop-up box
			String helptext=getText("forgottenDetails_PopUpBox_Text_xpath");// contact information text
				//boolean textmessage=isElementPresent("forgottenDetails_PopUpBox_Text_xpath");
			if(!isElementPresent("forgottenDetails_PopUpBox_Text_xpath")){
				System.out.println(true);
			}else{
					System.out.println(helptext);
			}
					Thread.sleep(2000);
					input("forgottenDetails_PopUpBox_Username_xpath",table.get(Constant.USERNAME_COL));
					input("forgottenDetils_PopUpBox_Email_xpath",table.get(Constant.EMAIL_COL));
					Thread.sleep(4000);
					click("forgottenDetails_PopUpBox_DOB_Day_xpath");
					Thread.sleep(2000);
					
						//day
					String Xpath_Menu= OR.getProperty("FD_select_xpath");
					int day = (int) Double.parseDouble(table.get(Constant.DAY_COL));
					Xpath_Menu = Xpath_Menu.replace("{0}", String.valueOf(day));
					//System.out.println(Xpath_Menu);
					clickByXpath(Xpath_Menu);
					Thread.sleep(1000);
					//month
					click("forgottenDetails_PopUpBox_DOB_Month_xpath");
					Thread.sleep(1000);
					String Xpath_Menu2= OR.getProperty("forgottenDetails_PopUpBox_DOB_MonthSelect_xpath");
					int Month= (int)Double.parseDouble(table.get(Constant.MONTH_COL));
					Xpath_Menu2 = Xpath_Menu2.replace("{0}",String.valueOf(Month));
					//System.out.println(Xpath_Menu2);
					clickByXpath(Xpath_Menu2);
					Thread.sleep(1000);
					//year
					click("forgottenDetails_PopUpBox_Year_xpath");
					Thread.sleep(1000);
					String Xpath_Menu3= OR.getProperty("forgottenDetails_PopUpBox_YearSelect_xpath");
					int Year= (int)Double.parseDouble(table.get(Constant.YEAR_COL));
					Xpath_Menu3 = Xpath_Menu3.replace("{0}",String.valueOf(Year));
					//System.out.println(Xpath_Menu3);
					Thread.sleep(500);
					clickByXpath(Xpath_Menu3);
					Thread.sleep(2000);
					click("forgottenDetails_PopUpBox_SUBMIT_xpath");
					Thread.sleep(1000);
					System.out.println("Before Condition"+table.get(Constant.Result));
					if(table.get(Constant.Result).equals("Correct")){
					System.out.println("After Condition"+table.get(Constant.Result));
					Thread.sleep(2000);
					input("forgottenDetails_ResetPassword_NewPassword_xpath",table.get(Constant.NEWPASSWORD_COL));
					input("forgottenDetails_ResetPassword_ConfirmPassword_xpath",table.get(Constant.CONFIRMPASSWORDr_COL));
					click("forgottenDetails_ResetPassword_SUBMIT_xpath");
					Thread.sleep(1000);
					//verify if user has successfully updated his or her details
					String ResetMessage=getText("forgottenDetails_ResetPassword_Title_xpath");// contact information text
					//boolean textmessage=isElementPresent("forgottenDetails_PopUpBox_Text_xpath");
				if(isElementPresent("forgottenDetails_ResetPassword_Title_xpath")){
					System.out.println(true);
					//test.log(LogStatus.PASS,ResetMessage);
				}else
						System.out.println(ResetMessage);
					//test.log(LogStatus.FAIL,"Element not displayed");
				}
				}

						
					
					

					
					
					/* click("forgottenDetails_PopUpBox_DOB_Month_xpath");
					 click("forgottenDetails_PopUpBox_DOB_OCT_xpath");
					 Thread.sleep(1000);
					 click("forgottenDetails_PopUpBox_Year_xpath");
					 click("forgottenDetails_PopUpBox_1980_xpath");
					*
	
	
		
		
		
					//input("forgottenDetails_PopUpBox_DOB_Day_xpath", "3");
					/*int Day = Integer.parseInt(table.get(Constant.DAY_COL));
					String DayString = String.valueOf(Day);
					System.out.println(DayString);
					*/
					/*input("forgottenDetails_PopUpBox_DOB_Month_xpath",table.get(Constant.MONTH_COL));
					input("forgottenDetails_PopUpBox_Year_xpath",table.get(Constant.YEAR_COL));
					click("forgottenDetails_PopUpBox_SUBMIT_xpath");
					*/
				



			@AfterMethod
			public void close(){
//				if(extent!=null){
//					extent.endTest(test);
//					extent.flush();
//				}
				quit();
}
}