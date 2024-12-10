package airfield.utilities;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtil {

    private static final Logger rootLogger = Logger.getLogger("");


    static {
        try {
            FileHandler fileHandler = new FileHandler("airport_logs.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            rootLogger.addHandler(fileHandler);

/*            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new SimpleFormatter());
            rootLogger.addHandler(consoleHandler);
            rootLogger.setUseParentHandlers(false);*/

        } catch (Exception e) {
            System.err.println("Failed to initialize logging: " + e.getMessage());
        }

    }
    public static Logger getLogger(Class<?>clazz){
        return Logger.getLogger(clazz.getName());
    }
}
