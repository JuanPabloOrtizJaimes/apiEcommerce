package com.apexglobal.apiEcommerce.service;

public interface ClimaService {

	public String obtenerClimaPorCiudad(String ciudad, String leng);

	public String obtenerClimaPorCoordenadas(double lat, double lon, String leng);

}
