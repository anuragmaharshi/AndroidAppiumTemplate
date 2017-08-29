package utility;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public  class Log4jLogger {

	public static class Log4jConfig{
		private  static Logger _logger;
		private static final String fileName = "defaultlog";
		private static final String dateAndTimeFormat = "MM-dd-yyyy_hh.mm.ss";
		private static final String logProperttFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\log4j.properties";
		private static final String folderPath =System.getProperty("logFolderPath") ;// for same directory use "targets/logs"
		
		private static void setUp(){
			try {
		    	Date date = new Date();
		    	DateFormat dateFormat = new SimpleDateFormat(dateAndTimeFormat);
		        //String dateTime = DateAndTime.getFormattedCurrentDateAndTime(dateAndTimeFormat);
		        String dateTime =dateFormat.format(date);
		        String FileName = fileName + "-" + dateTime + ".log";
		        System.out.println(FileName);
		    	if(System.getProperty("logFolderPath")!=null)
		    		System.setProperty("filename4j",folderPath + FileName);	
		    	else
		    		System.setProperty("filename4j",System.getProperty("user.dir") + "\\"+FileName);
		        File file = new File(System.getProperty("filename4j"));
		        if (file.createNewFile()) {
		        
		        	System.out.println(System.getProperty("filename4j"));
		            PropertyConfigurator.configure(logProperttFilePath);

		        }
		    } catch (IOException ex) {
		        ex.printStackTrace();
		        System.out.print("IO Exception in static method of Logger Class. "
		                + ex.getMessage());
		        System.exit(-1);
		    }
		}
		
		 static  {
		    if (_logger == null) {
		    	setUp();
		        _logger = LogManager.getLogger(Log4jLogger.class);
		    }
		 }

	}
 
	public static void LogInfoMessage(String strMessage){
		
		Log4jConfig._logger.info(strMessage);
	}
	
    public static void LogWarningMessage(String strMessage){
		
		Log4jConfig._logger.warn(strMessage);
	}
	
    public static void LogErrorMessage(String strMessage){
		
		Log4jConfig._logger.error(strMessage);
	}
}


