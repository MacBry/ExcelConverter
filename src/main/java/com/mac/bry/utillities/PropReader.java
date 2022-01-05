package com.mac.bry.utillities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropReader {

	public static Properties properties() {
		Properties properties = new Properties();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream stream = classLoader.getResourceAsStream("app.properties");
		try {
			properties.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
