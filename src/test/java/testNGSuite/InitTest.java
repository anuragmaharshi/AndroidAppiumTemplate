package testNGSuite;

import org.testng.annotations.Test;

import utility.Log4jLogger;
import utility.generalUtility;

import org.testng.annotations.BeforeSuite;

import java.io.File;

import org.testng.annotations.AfterSuite;


public class InitTest {
  @Test
  public void f() {
	  System.out.println("Test 1");
  }
  @BeforeSuite
  public void beforeSuite() {
	  //init logger
	  utility.ReusableComponent.log4jFileAndConsole("hello");
	  
	//init logger
	  //setting log 4j folder path. This file will be used for logging.
	 
	  String strDefaultPath = "E:\\Log\\";
	  //Creating Log Folder at specified path

	  File folder = new File(strDefaultPath + "Logs_" + generalUtility.getDateString());
      if (!folder.exists()) {
    	  folder.mkdir();
      }
	  System.setProperty("logFolderPath", folder.getAbsolutePath()+"\\");
	  utility.ReusableComponent.log4jFileAndConsole("Starting Test");
	  Log4jLogger.LogInfoMessage("Start Test");
  }

  @AfterSuite
  public void afterSuite() {
  }

}
