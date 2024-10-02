package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

public class UtilityMethod {
	public String getDataFromProperty(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/main/resources/Files.test.properties");
		Properties property = new Properties();
		property.load(fis);
		return property.getProperty(key);
	}
	public String getSystemTime() {
		return LocalDateTime.now().toString().replace(":","-");
	}

}
