package utility;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class DynamicWait {
	static AndroidDriver<MobileElement> driver;
	
	
	public static void init(AndroidDriver<MobileElement> androidDriver , int defaultTimeOut) {
		driver = androidDriver;
		driver.manage().timeouts().pageLoadTimeout(defaultTimeOut, TimeUnit.SECONDS);
		ReusableComponent.log4jFileAndConsole("Initialising wait driver.");
	}
	
	  public static void waitForObjectToEnable(By by,int timeout){
		  ReusableComponent.log4jFileAndConsole("Waiting for object to be enabled" + by.toString());
		  //WebDriverWait waitNew = new WebDriverWait(dr, timeout);
		  int cnt = 0;
		  while(cnt < timeout){
			  if(getWaitElement(by) != null){
				  break;
			  }
			  cnt =cnt +1;
		  }
		  
	  }
     
     
     
     public  static WebElement getWaitElement(By locator){
     
     		  WebElement element = driver.findElement(locator);
              return (element != null && element.isDisplayed() && element.isEnabled()) ? element : null;
          }
 
     
     public static void waitForObjClickable(MobileBy by,int timeout){
    	 try{
    	ReusableComponent.log4jFileAndConsole("Waiting for object for it to be clickable "+ by.toString());
    	 WebDriverWait waitn =  new WebDriverWait(driver,timeout);
    	 waitn.until(ExpectedConditions.elementToBeClickable(by));
    	 }catch(Exception e){
    		 ReusableComponent.log4jFileAndConsole("Object not loaded "+ by.toString() + "till timeout " + timeout);
    	 }
     }
     
     public static void waitForObjLocated(MobileBy by,int timeout){
    	 try{
    	 ReusableComponent.log4jFileAndConsole("Waiting for object for it to be located "+ by.toString());
    	 WebDriverWait waitn =  new WebDriverWait(driver,timeout);
    	 waitn.until(ExpectedConditions.presenceOfElementLocated(by));
    	 }
    	 catch(TimeoutException e){
    		 ReusableComponent.log4jFileAndConsole("Object "+ by.toString() + " not located till timeout " + timeout);
    	 }
     }
     
     public static void waitForObjVisible(MobileBy by,int timeout){
    	 try{
    	 ReusableComponent.log4jFileAndConsole("Waiting for object for it to be visible "+ by.toString());
    	 WebDriverWait waitn =  new WebDriverWait(driver,timeout);
    	 waitn.until(ExpectedConditions.visibilityOfElementLocated(by));
    	 }
    	 catch(TimeoutException e){
    		 ReusableComponent.log4jFileAndConsole("Object "+ by.toString() + " not visible till timeout " + timeout);
    	 }
     }
     public static void waitForObjInvisible(MobileBy by,int timeout){
    	 try{
    	 ReusableComponent.log4jFileAndConsole("Waiting for object for it to be visible "+ by.toString());
    	 WebDriverWait waitn =  new WebDriverWait(driver,timeout);
    	 waitn.until(ExpectedConditions.invisibilityOfElementLocated(by));
    	 }
    	 catch(TimeoutException e){
    		 ReusableComponent.log4jFileAndConsole("Object "+ by.toString() + " not invisible till timeout " + timeout);
    	 }
     }
     
     public static void waitForObjStale(MobileBy by,int timeout){
    	 try{
    	 ReusableComponent.log4jFileAndConsole("Waiting for object for it to be stale "+ by.toString());
    	 WebDriverWait waitn =  new WebDriverWait(driver,timeout);
    	 waitn.until(ExpectedConditions.stalenessOf(ReusableComponent.getElement(driver, by)));
    	 }
    	 catch(TimeoutException e){
    		 ReusableComponent.log4jFileAndConsole("Object "+ by.toString() + " not stale till timeout " + timeout);
    	 }
    	 
     }
     
     public static void waitForActivity(String strActivity,int timeOut){
    	 for(int i = 0;i<timeOut;i++){
    		 if(driver.currentActivity().contains(strActivity))
        		 break;
    		else
    			try {
    				Thread.sleep(1000);
    			} catch (InterruptedException e) {

    			}
    	 }
    	 
     }
}