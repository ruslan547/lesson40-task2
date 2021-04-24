package by.itClass.db;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class PropertiesManager {
    public Properties getProperties(String filename) {
        Properties properties = new Properties();

        try (Reader reader = new FileReader(filename)) {
           properties.load(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
