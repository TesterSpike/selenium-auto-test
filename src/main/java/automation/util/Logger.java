package automation.util;

import org.slf4j.LoggerFactory;

public class Logger {
    private final org.slf4j.Logger logger;

    public Logger(Class<?> callingClass) {
        logger = LoggerFactory.getLogger(callingClass);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void debug(String message) {
        logger.debug(message);
    }
}
