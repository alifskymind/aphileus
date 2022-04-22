package com.example.application.data.service;

import com.example.application.data.entity.Temperature;
import com.example.application.data.entity.TemperatureBackup;
import com.example.application.data.repository.TemperatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureService {

	private TemperatureRepository temperatureRepository;

	public TemperatureService() {
	}

	public TemperatureService(TemperatureRepository temperatureRepository) {
		this.temperatureRepository = temperatureRepository;
	}

	//public List<Temperature> findAllTemperature(String stringFilter) {
	//	if (stringFilter == null || stringFilter.isEmpty()) {
	//		return temperatureRepository.findAll();
	//	} else {
	//		return temperatureRepository.search(stringFilter);
	//	}
	//}

	public List<Temperature> findAllTemperature() {
		return temperatureRepository.findAll();
	}

	public long countTemperature() {
		return temperatureRepository.count();
	}

	public void deleteTemperature(Temperature temperature) {
		temperatureRepository.delete(temperature);
	}

	public void saveTemperature(Temperature temperature) {
		if (temperature == null) {
			System.err.println("Contact is null. Are you sure you have connected your form to the application?");
			return;
		}
		temperatureRepository.save(temperature);
	}
}
