package com.weatherforecast.services.contracts;

public interface IWeatherService {

	String getForecast(String town) throws Exception;

}