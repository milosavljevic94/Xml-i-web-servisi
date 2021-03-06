package com.objava.naucnih.radova.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory.Authentication;

public class MarkLogicConfig {

	private static Properties props = loadProperties();
	
	public static String host = props.getProperty("host");
	
	public static int port = Integer.parseInt(props.getProperty("port"));

	public static String admin = props.getProperty("admin_user");
	
	public static String password = props.getProperty("admin_password");
	
	public static Authentication authType = Authentication.valueOf(
				props.getProperty("authentication_type").toUpperCase()
				);

	// get the configuration for the example
	private static Properties loadProperties() {		
	    try {
			String propsName = "application.properties";
			InputStream propsStream =
				MarkLogicConfig.class.getClassLoader().getResourceAsStream(propsName);
			if (propsStream == null)
				throw new IOException("Could not read config properties");

			Properties props = new Properties();
			props.load(propsStream);

			return props;

	    } catch (final IOException exc) {
	        throw new Error(exc);
	    }  
	}
}
