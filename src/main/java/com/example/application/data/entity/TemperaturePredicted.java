package com.example.application.data.entity;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
//@Table(name = "temperature")
public class TemperaturePredicted {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "unix_time_stamps")
	private String unixTimeStamps;

	@Column(name = "date_time")
	private String dateTime;

	@Column(name = "temperature_in_c")
	private Double temperatureInC;

	public TemperaturePredicted() {
	}

	public TemperaturePredicted(String unixTimeStamps, String dateTime, Double temperatureInC) {
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
		TemperaturePredicted that = (TemperaturePredicted) o;
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
				"unixTimeStamps = " + unixTimeStamps + ", " +
				"dateTime = " + dateTime + ", " +
				"temperatureInC = " + temperatureInC + ")";
	}
}
