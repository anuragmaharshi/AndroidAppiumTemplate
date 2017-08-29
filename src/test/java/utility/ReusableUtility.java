package utility;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ReusableUtility {
	
	//initialize the set up object. This will return the driver.
	//This function must be called first.
	public static AndroidDriver<MobileElement> init(DesiredCapabilities cap){
		AndroidDriver<MobileElement> driver = null;
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			return driver;
		} catch (MalformedURLException e) {
			return driver;
		}
	}
	
	//return a mobile element.
	public static MobileElement getMobileElement(AndroidDriver<MobileElement> driver,MobileBy by){
		MobileElement element = null;
		try{
			element = driver.findElement(by);
			return element;
		}
		catch(Exception e){
			return element;
		}
	}
	
	//check if element exists
	public static boolean exists(AndroidDriver<MobileElement> driver,MobileBy by){
		if(driver.findElements(by).isEmpty())
			return false;
		else
			return true;
	}
	
	public static void clickMobileElement(MobileElement element){
		if(element!= null){
			element.click();
		}	
	}
	
	public static void clickMobileElement(AndroidDriver<MobileElement> driver,MobileBy by){
		MobileElement element = getMobileElement(driver,by);
		clickMobileElement(element);	
	}
	
	public static void setValueInTextBox(MobileElement element, String strText){
		if(element != null){
			element.setValue(strText);
		}
	}
	
	public static void setValueInTextBox(AndroidDriver<MobileElement> driver,MobileBy by,String strText){
		MobileElement element = getMobileElement(driver,by);
		setValueInTextBox(element,strText);
	}
	
}
