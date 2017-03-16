package TestUtil;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.TestBase;

public class Utility extends TestBase {
	public static ExtentTest test;
	// test suite is runnable
			public static boolean isSuiteRunnable(String suiteName, Xls_Reader xls){
				int rows = xls.getRowCount(Constant.SUITE_SHEET);
					for(int rNum=2;rNum<=rows;rNum++){
					String data = xls.getCellData(Constant.SUITE_SHEET, Constant.SUITENAME_COL, rNum);
					if(data.equals(suiteName)){
						String runmode = xls.getCellData(Constant.SUITE_SHEET, Constant.RUNMODE_COL, rNum);
						if(runmode.equals("Y"))
							return true;
						else
							return false;
					}
				}
				
				return false;
			}
			
			public static boolean isTestCaseRunnable(String testCase, Xls_Reader xls){
				int rows = xls.getRowCount(Constant.TESTCASES_SHEET);
				for(int rNum=2;rNum<=rows;rNum++){
					String testNameXls = xls.getCellData(Constant.TESTCASES_SHEET, Constant.TESTCASES_COL, rNum);
					if(testNameXls.equalsIgnoreCase(testCase)){
					String runmode = xls.getCellData(Constant.TESTCASES_SHEET, Constant.RUNMODE_COL, rNum);
					//System.out.println(testNameXls);
					if(runmode.equalsIgnoreCase(Constant.RUNMODE_YES))
						return true;
					else
						return false;
				    }
				}
				return false;// default		
			}
			
			public static Object[][]  getData(String testName, Xls_Reader xls){
				int rows = xls.getRowCount(Constant.DATA_SHEET);
				System.out.println("Total rows - "+ rows);
				
				// row number for testCase
				int testCaseRowNum=1;
				for(testCaseRowNum=1;testCaseRowNum<=rows;testCaseRowNum++){
					String testNameXls = xls.getCellData(Constant.DATA_SHEET, 0, testCaseRowNum);
					if(testNameXls.equalsIgnoreCase(testName))
						break;
				}
				System.out.println("Test Starts from row Number - "+ testCaseRowNum);
				int dataStartRowNum=testCaseRowNum+2;
				int colStartRowNum=testCaseRowNum+1;
				
				// rows of data
				int testRows=1;
				while(!xls.getCellData(Constant.DATA_SHEET, 0, dataStartRowNum+testRows).equals("")){
					testRows++;
				}
				System.out.println("Total rows of data are - "+testRows);
				
				// cols of data
				int testCols=0;
				while(!xls.getCellData(Constant.DATA_SHEET,testCols,colStartRowNum).equals("")){
					testCols++;
				}
				Object[][] data = new Object[testRows][1];
				int r=0;
				for(int rNum=dataStartRowNum;rNum<(dataStartRowNum+testRows);rNum++){
					Hashtable<String,String>table = new Hashtable<String,String>();
					for(int cNum=0;cNum<testCols;cNum++){
						//System.out.println(xls.getCellData(Constant.DATA_SHEET, cNum, rNum));
						//data[r][cNum]=xls.getCellData(Constants.DATA_SHEET, cNum, rNum);
						table.put(xls.getCellData(Constant.DATA_SHEET, cNum, colStartRowNum), xls.getCellData(Constant.DATA_SHEET, cNum, rNum));
						//System.out.print(xls.getCellData(Constant.DATA_SHEET, cNum, colStartRowNum));
					//System.out.println(xls.getCellData(Constant.DATA_SHEET, cNum, rNum));
					}
					data[r][0]=table;
					r++;
				}
				// 0,0 , 0,1
				// 1,0 , 1,1
				return data;

			}
			//store screenshot
			public static void takeScreenshot(String fileName) {
					//Date d=new Date();
					String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
					String filePath=Constant.REPORTS_PATH+"screenshots//"+screenshotFile;
					// store screenshot in that file
					File scrFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
					
					try {
						FileUtils.copyFile(scrFile, new File(filePath));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//test.log(LogStatus.INFO,test.addScreenCapture(filePath));
			
		}

	}




