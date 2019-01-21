package bean;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.*;
public class TraceLogger {

		private static final Logger logger = LogManager.getLogger("traceLog");
		 
	    private TraceLogger() {
	    	
	    }
	  
	    public static void info(String message){
	    	logger.info(message);
	    }
	 
	    public static void info(String format,Object... arguments){
	    	logger.info(format, arguments);
	    }
}

