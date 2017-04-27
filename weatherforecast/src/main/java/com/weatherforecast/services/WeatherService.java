package com.weatherforecast.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.weatherforecast.services.contracts.IWeatherService;

@Service
public class WeatherService implements IWeatherService {
	private final String USER_AGENT = "Mozilla/5.0";
	private final String BASE_URL = "https://api.apixu.com/v1/current.json?key=c52ed2e654c04c94b7b65221172704&q=";
	
	@Override
	public String getForecast(String town) throws Exception{
		
		String url = this.BASE_URL + town;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		
		return response.toString();
	}
}
