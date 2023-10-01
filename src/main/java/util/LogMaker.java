package util;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 * @author Rogério Oliveira
 * class to implement log
 */

public class LogMaker {

	String message;
	Logger logger = Logger.getLogger("EmployeeControllerServlet");
	
	public LogMaker() {		
		
	}
		
	
	public void make(String logLevel, String msg) {
//		public void make(String logLevel, String msg, Object obj) {
		
		/** 
		 * @param logLevel: Nível de log: severe/warning/info
		 * @param msg: texto da mensagem do log
		 * @param obj: objeto com informação ex: entity.getName(), o qual será combinado na mensagem.
		 */
		
		try {
			// Caminho do arquivo de log
			String filePath = "C:\\dev\\temp\\logs\\testelog.log";

			FileHandler fileHandler = new FileHandler(filePath, true);
			logger.addHandler(fileHandler);

			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);

			switch (logLevel) {
				case "SEVERE": {
					logger.severe(msg);
					fileHandler.close();
					break;
				}
				case "WARNING": {
					logger.warning(msg);
					fileHandler.close();
					break;
				}
				case "INFO": {
					logger.info(msg);
					fileHandler.close();
					break;
				}
				default:
					throw new IllegalArgumentException("Nivel de log inesperado: " + logLevel);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
		
	}

	
/*		
	public void makeInfo(String msg) {
//		public void makeInfo(String msg, Object obj) {

//		message = msg + obj.toString();		
		try {
			// Caminho do arquivo de log
			String filePath = "C:\\dev\\temp\\logs\\testelog.log";

			FileHandler fileHandler = new FileHandler(filePath, true);
			logger.addHandler(fileHandler);

			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
			logger.info(msg);
			fileHandler.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	*/

}
