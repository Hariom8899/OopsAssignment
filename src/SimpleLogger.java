import java.util.logging.*;

public class SimpleLogger {
    private static final Logger logger = Logger.getLogger(SimpleLogger.class.getName());

    public static void main(String[] args) {
        try {
            FileHandler fileHandler = new FileHandler("myLog.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

            logger.info("Application started.");
            logger.warning("This is a warning message.");
            logger.severe("This is an error message.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
