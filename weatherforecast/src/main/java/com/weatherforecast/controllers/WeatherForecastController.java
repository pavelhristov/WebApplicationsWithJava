package com.weatherforecast.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WeatherForecastController {


	@RequestMapping(value = "/forecast", method = RequestMethod.GET)
	public String Forecast(){
		return "lonely nights";
	}
}
