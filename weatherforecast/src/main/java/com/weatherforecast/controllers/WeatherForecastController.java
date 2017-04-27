package com.weatherforecast.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weatherforecast.services.contracts.IUserService;
import com.weatherforecast.services.contracts.IWeatherService;

@RestController
@RequestMapping("/api")
public class WeatherForecastController {
	private IWeatherService weatherService;
	private IUserService userService;

	@Autowired
	public WeatherForecastController(IWeatherService weatherService, IUserService userService) {
		this.weatherService = weatherService;
		this.userService = userService;
	}

	// GET /api/forecast/TOWN_NAME -> forecast for the town
	@RequestMapping(value = "/forecast/{town}", method = RequestMethod.GET)
	public String Forecast(@PathVariable(value = "town") String town, HttpServletRequest request) {
		String errorMessage = "error";

		if (town.isEmpty() || town == null) {
			return errorMessage;
		}

		String forecast;
		try {
			forecast = this.weatherService.getForecast(town);
		} catch (Exception e) {
			e.printStackTrace();
			forecast = errorMessage;
		}

		String userIP = request.getRemoteAddr();

		this.userService.saveUserSearchData(userIP, town);

		return forecast;
	}
}
