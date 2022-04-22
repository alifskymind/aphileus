package com.example.application.data.entity;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "temperatureBackup")
//@NamedQueries({
//		@NamedQuery(name = "Temperature.findAll", query = "select t from Temperature t")
//})
public class TemperatureBackup {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "deviceUUID")
	private String deviceUUID;
	@Column(name = "columnTwo")
	private String columnTwo;
	@Column(name = "unixTimeStamps")
	private Long unixTimeStamps;
	@Column(name = "dateTime")
	private String dateTime;
	@Column(name = "temperatureInC")
	private Double temperatureInC;

	public TemperatureBackup() {
	}

	public TemperatureBackup(Long id, String deviceUUID, String columnTwo, Long unixTimeStamps, String dateTime, Double temperatureInC) {
		this.id = id;
		this.deviceUUID = deviceUUID;
		this.columnTwo = columnTwo;
		this.unixTimeStamps = unixTimeStamps;
		this.dateTime = dateTime;
		this.temperatureInC = temperatureInC;
	}

	@Override
	public String toString() {
		return "Temperature{" +
				"id=" + id +
				", deviceUUID='" + deviceUUID + '\'' +
				", columnTwo='" + columnTwo + '\'' +
				", unixTimeStamps=" + unixTimeStamps +
				", dateTime='" + dateTime + '\'' +
				", temperatureInC=" + temperatureInC +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeviceUUID() {
		return deviceUUID;
	}

	public void setDeviceUUID(String deviceUUID) {
		this.deviceUUID = deviceUUID;
	}

	public String getColumnTwo() {
		return columnTwo;
	}

	public void setColumnTwo(String columnTwo) {
		this.columnTwo = columnTwo;
	}

	public Long getUnixTimeStamps() {
		return unixTimeStamps;
	}

	public void setUnixTimeStamps(Long unixTimeStamps) {
		this.unixTimeStamps = unixTimeStamps;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Double getTemperatureInC() {
		return temperatureInC;
	}

	public void setTemperatureInC(Double temperatureInC) {
		this.temperatureInC = temperatureInC;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		TemperatureBackup that = (TemperatureBackup) o;
		return id != null && Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}


}
