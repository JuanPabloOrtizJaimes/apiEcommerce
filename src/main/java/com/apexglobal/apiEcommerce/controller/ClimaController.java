package com.apexglobal.apiEcommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apexglobal.apiEcommerce.service.ClimaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/clima")
@Tag(name = "CLIMA", description = "Seccion para consultar clima por ciudad y coordenadas")
public class ClimaController {

	@Autowired
	private ClimaService climaService;

	@Operation(summary = "Obtener el clima actual", description = "Obtiene información del clima actual según la ciudad")
	@GetMapping
	public ResponseEntity<String> obtenerClimaPorCiudad(@RequestParam(required = true) String ciudad,
			@RequestParam(defaultValue = "es") String leng) {
		if (ciudad != null) {
			String climaCiudad = climaService.obtenerClimaPorCiudad(ciudad, leng);

			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(climaCiudad);

		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
					.body("Error: Proporcione una ciudad");
		}

	}

	@Operation(summary = "Obtener el clima actual", description = "Obtiene información del clima actual según las coordenadas")
	@GetMapping("/coordenadas")
	public ResponseEntity<String> obtenerClimaPorCoordenadas(@RequestParam(required = true) Double lat,
			@RequestParam(required = true) Double lon, @RequestParam(defaultValue = "es") String leng) {

		if (lat != null && lon != null) {
			String climaCoordenadas = climaService.obtenerClimaPorCoordenadas(lat, lon, leng);
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(climaCoordenadas);

		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
					.body("Error: Proporcione las coordenadas (latitud y longitud).");
		}
	}
}
