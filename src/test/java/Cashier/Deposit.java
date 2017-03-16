package Cashier;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import TestUtil.Constant;
import TestUtil.TestDataProvider;

public class Deposit extends TestBase {
	
	
	
	
	@BeforeTest
	public void initLogs(){
		initLogs(this.getClass());
	}
	
		@Test(dataProviderClass=TestDataProvider.class,dataProvider="CashierDataProvider")
		public void Deposit(Hashtable<String,String>table) throws IOException, InterruptedException{
			validateRunmodes("Deposit",Constant.Money_Section, table.get(Constant.RUNMODE_COL));
			doDefaultLogin(table.get("Browser"));
			// Verify if user can make deposit less than £5
			// verify if user can make deposit with invalid bank card
			// verify if user can make deposit with invalid promocode
			
			click("hp_Deposit_xpath");// click on deposit button
			Thread.sleep(5000L);
			d.switchTo().frame("cashier-iframe").switchTo().frame(0);
			WebDriverWait wait= new WebDriverWait(d,30);
			input("cashier_Deposit_AmtToDeposit_xpath",table.get(Constant.AMOUNT_Col));
			//input("cashier_Deposit_Card_xpath",table.get(Constant.CARD_COL));
			Thread.sleep(2000);
			input("cashier_Deposit_Cvv2_xpath",table.get(Constant.CVV2_Col));// input your security code
			//input("cashier_Deposit_PromoCode_xpath",table.get(Constant.PROMOCODE_COL));
			Thread.sleep(2000L);
			//WebElement element=d.findElement(By.xpath("//*[@id='DCC_Submit']/tbody/tr/td[2]"));
			//JavascriptExecutor executor = (JavascriptExecutor) d;
			//executor.executeScript("arguments[0].click();", element);
			
			click("cashier_Deposit_DEPOSIT_xpath");
			Thread.sleep(3000L);
			// verify if user can make deposit
			String Text=getText("Cashier_CreditcardApprovedMessage_xpath");
			System.out.println(Text);
			Thread.sleep(2000L);
			if(Text.equalsIgnoreCase("Your credit card deposit has been approved and will be charged as NetPlayTV Grp.Thank you and good luck!"))
				System.out.println(Text);
			else
				System.out.println("Credit Card Not Approved for Payment");
			Thread.sleep(3000);
			if(table.get(Constant.Expectedresult).equals("FAILURE"))
			click("Cashier_CreditcardApprovedMessageOK_xpath");
			

}
		@AfterMethod//(enabled=false)
		public void close(){
			quit();
	
		}
			
}