package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    public static Properties initializeProperties() {
        Properties prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/test/resources/config.properties");
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("LOG: config.properties not found, using System properties or defaults.");
        }
        return prop;
    }
}