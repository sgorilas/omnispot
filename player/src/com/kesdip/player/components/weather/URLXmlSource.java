package com.kesdip.player.components.weather;

import java.net.URL;
import java.net.URLConnection;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

public class URLXmlSource extends WeatherDataSource {
	
	private String url;

	@Override
	public Object getWeatherData() {
		try {
			URLConnection conn = new URL("http://weather.yahooapis.com/forecastrss?p=GRXX0004&u=c").openConnection();
			SAXReader sax = new SAXReader();
			Document doc = sax.read(conn.getInputStream());
			return doc.getRootElement();
			//BufferedReader in = new BufferedReader(new InputStreamReader());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
}