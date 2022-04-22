package com.example.application.data.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class JsonDataFetcherController {

	public static final String UTF8_BOM = "\uFEFF";

	private static String removeUTF8BOM(String s) {
		if (s.startsWith(UTF8_BOM)) {
			s = s.substring(1);
		}
		return s;
	}


	protected static class TimeData {

		private long date;

		private TimeData(long date) {
			this.date = date;
		}

		public long getDate() {
			return date;
		}
	}

	public static class TemperatureData extends TimeData {

		private double temperatureInC;

		private TemperatureData(long date, double temperatureInC) {
			super(date);
			this.temperatureInC = temperatureInC;
		}

		public double getTemperature() {
			return temperatureInC;
		}
	}

	public static class JsonData {
		private Number[][] data;

		public Number[][] getData() {
			return data;
		}

		public void setData(Number[][] data) {
			this.data = data;
		}
	}

	public static List<TemperatureData> fetchDevice1Temperature() {
		List<TemperatureData> data = readValueData("device1.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice2Temperature() {
		List<TemperatureData> data = readValueData("device2.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice3Temperature() {
		List<TemperatureData> data = readValueData("device3.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice4Temperature() {
		List<TemperatureData> data = readValueData("device4.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice5Temperature() {
		List<TemperatureData> data = readValueData("device5.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice6Temperature() {
		List<TemperatureData> data = readValueData("device6.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice7Temperature() {
		List<TemperatureData> data = readValueData("device7.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice8Temperature() {
		List<TemperatureData> data = readValueData("device8.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice9Temperature() {
		List<TemperatureData> data = readValueData("device9.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice10Temperature() {
		List<TemperatureData> data = readValueData("device10.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice11Temperature() {
		List<TemperatureData> data = readValueData("device11.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice12Temperature() {
		List<TemperatureData> data = readValueData("device12.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice13Temperature() {
		List<TemperatureData> data = readValueData("device13.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice14Temperature() {
		List<TemperatureData> data = readValueData("device14.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice15Temperature() {
		List<TemperatureData> data = readValueData("device15.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice16Temperature() {
		List<TemperatureData> data = readValueData("device16.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice17Temperature() {
		List<TemperatureData> data = readValueData("device17.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice18Temperature() {
		List<TemperatureData> data = readValueData("device18.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice19Temperature() {
		List<TemperatureData> data = readValueData("device19.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice20Temperature() {
		List<TemperatureData> data = readValueData("device20.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice21Temperature() {
		List<TemperatureData> data = readValueData("device21.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice22Temperature() {
		List<TemperatureData> data = readValueData("device22.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice23Temperature() {
		List<TemperatureData> data = readValueData("device23.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDevice24Temperature() {
		List<TemperatureData> data = readValueData("device24.json");
		return Collections.unmodifiableList(data);
	}

	public static List<TemperatureData> fetchDeviceAllTemperature() {
		List<TemperatureData> data = readValueData("deviceAll.json");
		return Collections.unmodifiableList(data);
	}

	private static List<TemperatureData> readValueData(String filename) {

		//JsonData jsonData = readJsonDataFrom(filename);
		JsonData jsonData = readJsonDataFrom(removeUTF8BOM(filename.replace("\uFEFF", "")));

		List<TemperatureData> data = new ArrayList<>();
		for(int i = 0; i < jsonData.data.length; ++i) {
			Number[] row = jsonData.data[i];
			data.add(new TemperatureData(row[0].longValue(), row[1].doubleValue()));
		}

		return data;
	}

	private static JsonData readJsonDataFrom(String filename) {
		try {
			ObjectMapper mapper = new ObjectMapper();

			//return mapper.readValue(
			//		new InputStreamReader(
			//				JsonDataFetcherController.class.getResourceAsStream(
			//						filename)), JsonData.class);

			return mapper.readValue(
					new InputStreamReader(
							JsonDataFetcherController.class.getClassLoader().getResourceAsStream(
									filename), StandardCharsets.UTF_8), JsonData.class);

			//return mapper.readValue(new InputStreamReader(JsonDataFetcherController.class.getClassLoader().getResourceAsStream("temperature-v2.csv"),
			//		JsonData.class
			//);

		} catch (IOException e) {
			throw new RuntimeException("Cannot read data from " + filename, e);
		}
	}




}
