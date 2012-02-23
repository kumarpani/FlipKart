package com.example.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {

	private Properties props = null;

	public PropertyFileReader(String name) {
		try {
			props = loadProperties(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		return props.getProperty(key);
	}

	private static Properties loadProperties(String name) throws IOException {
		Properties defaultProps = new Properties();
		InputStream in = PropertyFileReader.class.getClassLoader()
				.getResourceAsStream(name);
		defaultProps.load(in);
		in.close();
		return defaultProps;
	}
}
