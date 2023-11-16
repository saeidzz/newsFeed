package ir.jiring.assignment.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.jiring.assignment.exception.JsonConversionException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Util {
    private static final String[] allKeyWords = new String[]{"down", "bad", "failure", "low", "fall", "up", "rise", "good", "success", "high"};
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Random random = new Random();
    private static final Logger logger = Logger.getLogger("News");

    private Util() {

    }

    public static void log(Level level, String content, Object... params) {
        logger.log(level, content, params);
    }

    public static String toJson(Object of) {
        try {
            return mapper.writeValueAsString(of);
        } catch (JsonProcessingException e) {
            log(Level.WARNING, "Error occurred json conversion !");
            throw new JsonConversionException();
        }
    }

    public static int nextInt(int origin, int bound) {
        return random.nextInt(origin, bound);
    }

    public static String getRandomKeyword() {
        return allKeyWords[nextInt(0, 10)];
    }

    public static int getFrequency() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        try (InputStream resourceStream = loader.getResourceAsStream("application.properties")) {
            properties.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Integer.parseInt(properties.get("frequency").toString());
    }

}
