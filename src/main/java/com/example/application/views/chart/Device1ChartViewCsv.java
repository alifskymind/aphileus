package com.example.application.views.chart;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Device1ChartViewCsv extends VerticalLayout {

	public Device1ChartViewCsv() {

		InputStreamReader csvFileReader = new InputStreamReader(
				getClass().getClassLoader().getResourceAsStream("device1.xlsx"),
				StandardCharsets.UTF_8
		);
	}
}
