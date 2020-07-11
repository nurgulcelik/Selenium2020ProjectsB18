package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

   //we created properties object
    private static Properties properties = new Properties();
    static{
        // get the path and store in String, or directly pass into fileInputStream
        String path="configuration.properties";
        // we need to open the file
        try {
            FileInputStream file = new FileInputStream(path);
            //we need to load the File
        properties.load(file);
            //close the file
        file.close();
        }catch(IOException e){
            System.out.println("Properties file not found");
        }

    }
    public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);
    }
}
