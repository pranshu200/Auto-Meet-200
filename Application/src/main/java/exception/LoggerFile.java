/**
 * 
 */
package exception;


import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;



/**
 * @author The Web Spyder
 *
 */
public class LoggerFile {
	
	private String message;
	
	public LoggerFile(String message) {	
		this.message = message;
		System.out.println("called");
		 
	}
	
	public static  void LogHandle(String message) { 
		
		try {

			FileHandler f = new FileHandler("JsonLogFile.log",true);
			
			SimpleFormatter formatter = new SimpleFormatter();
			f.setFormatter(formatter);
			Logger logger = Logger.getLogger("JsonLog"); 
			logger.addHandler(f);
			
			logger.info(message);
		
			f.close();
	    } catch(Exception e) {
	    	System.out.println("Error in Log file");
	    	} 

	}
}
