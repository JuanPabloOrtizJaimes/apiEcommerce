package com.apexglobal.apiEcommerce.serviceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apexglobal.apiEcommerce.service.ClimaService;

@Service
public class ClimaServiceImpl implements ClimaService {

	@Value("${openweather.api.key}")
	private String apiKey;

	@Value("${openweather.url}")
	private String apiUrl;

	private final RestTemplate restTemplate;

	public ClimaServiceImpl(RestTemplate restTemplate) {

		this.restTemplate = restTemplate;
	}

	@Override
	public String obtenerClimaPorCiudad(String ciudad, String leng) {
		String url = String.format("%s?q=%s&appid=%s&units=metric&lang=%s", apiUrl, ciudad, apiKey, leng);
		return restTemplate.getForObject(url, String.class);
	}

	@Override
	public String obtenerClimaPorCoordenadas(double lat, double lon, String leng) {
		String url = String.format("%s?lat=%s&lon=%s&appid=%s&units=metric&lang=%s", apiUrl, lat, lon, apiKey, leng);
		return restTemplate.getForObject(url, String.class);
	}

}
