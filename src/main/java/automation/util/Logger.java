package automation.util;

import org.apache.logging.log4j.LogManager;

public class Logger {
    private final org.apache.logging.log4j.Logger logger;

    public Logger(Class<?> callingClass) {
        logger = LogManager.getLogger(callingClass.getName());
    }

    public void error(String message, Exception exception) {
        logger.atError().log("{}", message, exception);
    }

    public void info(String message) {
        logger.atInfo().log(message);
    }

    public void debug(String message) {
        logger.atDebug().log(message);
    }
}
