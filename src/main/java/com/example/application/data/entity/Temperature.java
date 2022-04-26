package com.example.application.data.entity;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
//@Table(name = "temperature")
public class Temperature {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "device_uuid")
	private String deviceUUID;

	@Column(name = "data_type")
	private String dataType;

	@Column(name = "unix_time_stamps")
	private String unixTimeStamps;

	@Column(name = "date_time")
	private String dateTime;

	@Column(name = "temperature_in_c")
	private Double temperatureInC;

	public Temperature() {
	}

	public Temperature(String deviceUUID, String dataType, String unixTimeStamps, String dateTime, Double temperatureInC) {
		this.deviceUUID = deviceUUID;
		this.dataType = dataType;
		this.unixTimeStamps = unixTimeStamps;
		this.dateTime = dateTime;
		this.temperatureInC = temperatureInC;
	}

	public Double getTemperatureInC() {
		return temperatureInC;
	}

	public void setTemperatureInC(Double temperatureInC) {
		this.temperatureInC = temperatureInC;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getUnixTimeStamps() {
		return unixTimeStamps;
	}

	public void setUnixTimeStamps(String unixTimeStamps) {
		this.unixTimeStamps = unixTimeStamps;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDeviceUUID() {
		return deviceUUID;
	}

	public void setDeviceUUID(String deviceUUID) {
		this.deviceUUID = deviceUUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Temperature that = (Temperature) o;
		return id != null && Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" +
				"id = " + id + ", " +
				"deviceUUID = " + deviceUUID + ", " +
				"dataType = " + dataType + ", " +
				"unixTimeStamps = " + unixTimeStamps + ", " +
				"dateTime = " + dateTime + ", " +
				"temperatureInC = " + temperatureInC + ")";
	}
}
