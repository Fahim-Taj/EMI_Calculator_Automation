import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class emiCal {
	
	static AppiumDriver<MobileElement> driver;

	public static void main(String[] args) {
		
		try {
			emiCalculator();
			
		}catch(Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
		
	}
	
	public static void emiCalculator() throws Exception {
		
//		Capability set for connection
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName","android");
		dc.setCapability("appPackage","com.continuum.emi.calculator");
		dc.setCapability("appActivity","com.finance.emicalci.activity.Splash_screnn");
		dc.setCapability("adbExecTimeout","90000");
		
		
//		Server Connection
		
		URL url = new URL ("http://127.0.0.1:4723/wd/hub");
		
		driver = new AppiumDriver<MobileElement>(url,dc);
		
		System.out.println("Application Started");
		
//		Time
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//		Click on the EMI calculator start button
		MobileElement start = driver.findElement(By.id("com.continuum.emi.calculator:id/btnStart"));
		start.click();
		
//		Input Loan Amount
		MobileElement el3 = driver.findElement(By.id("com.continuum.emi.calculator:id/etLoanAmount"));
		el3.sendKeys("100000");
		
//		Input Interest
		MobileElement el4 = driver.findElement(By.id("com.continuum.emi.calculator:id/etInterest"));
		el4.sendKeys("9.0");
		
//		Input Time
		MobileElement el5 = driver.findElement(By.id("com.continuum.emi.calculator:id/etYears"));
		el5.sendKeys("5");
		
//		Input Fee
		MobileElement el6 = driver.findElement(By.id("com.continuum.emi.calculator:id/etFee"));
		el6.sendKeys("2.0");
		
//		Click on the Calculate Button
		MobileElement el7 = driver.findElement(By.id("com.continuum.emi.calculator:id/btnCalculate"));
		el7.click();
		
//		Monthley EMI Result Displayed
		MobileElement emiresult = driver.findElement(By.id("com.continuum.emi.calculator:id/monthly_emi_result"));
		String emr = emiresult.getText();
		System.out.println("\n EMI Result is: " +emr);
		
//		Total Interest Displayed
		MobileElement intresult = driver.findElement(By.id("com.continuum.emi.calculator:id/total_interest_result"));
		String intr = intresult.getText();
		System.out.println("\n Total Interest Result is: " +intr);
		
//		Processing Fee Displayed
		MobileElement pfeeresult = driver.findElement(By.id("com.continuum.emi.calculator:id/processing_fee_result"));
		String pfr = pfeeresult.getText();
		System.out.println("\n Processing Fee Result is: " +pfr);
		
//		Total Payment Displayed
		MobileElement tpayresult = driver.findElement(By.id("com.continuum.emi.calculator:id/total_payment_result"));
		String tpr = tpayresult.getText();
		System.out.println("\n Total Payment Result is: " +tpr);
		
//		Test Complete
		System.out.println("\n Completed.");
				
	}

}
