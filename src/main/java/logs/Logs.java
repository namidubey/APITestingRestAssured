package logs;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Logs {

	static Logger logger = Logger.getLogger(Logs.class);

	private static Logs logs;

	private Logs() {}

	public static Logs getInstance() {
		if(logs==null) {
			logs = new Logs();
			DOMConfigurator.configure("log4j.xml");
		}
		DOMConfigurator.configure("log4j.xml");
		return logs;
	}

	public void debugLog(Object log) {
		logger.debug(log);
	}

	public void infoLog(Object log) {
		logger.info(log);
	}

	public void infoWarn(Object log) {
		logger.warn(log);
	}

	public void infoError(Object log) {
		logger.error(log);
	}
}
