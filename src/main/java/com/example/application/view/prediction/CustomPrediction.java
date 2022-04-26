package com.example.application.view.prediction;

import com.example.application.aiModel.PredictNewTemperature;
import com.example.application.view.dashboard.MenubarView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;
import java.io.IOException;

@PageTitle("Custom Prediction")
@Route("customPrediction")
@PermitAll
public class CustomPrediction extends VerticalLayout {

	MenubarView menu = new MenubarView();
	PredictNewTemperature predictNewTemperature = new PredictNewTemperature();
	ListSeries series = new ListSeries("Temperature", 0);

	public CustomPrediction() {

		add(menu);

		setSizeFull();
		setDefaultHorizontalComponentAlignment(Alignment.CENTER);
		getStyle().set("text-align", "center");

		//DateTimePicker dateTimePicker = new DateTimePicker();
		//dateTimePicker.setLabel("Choose custom date and time to predict the temperature.");
		//dateTimePicker.setHelperText("Format: DD/MM/YYYY and HH:MM");
		//dateTimePicker.setDatePlaceholder("Date");
		//dateTimePicker.setTimePlaceholder("Time");
		//dateTimePicker.getValue();
		//add(dateTimePicker);

		// add button
		// button listener click run method from class return double set gauge

		//Button predictButton = new Button("Predict temperature", (e) -> {
		//	Integer newValue = new Integer(tf.getValue());
		//	series.updatePoint(0, newValue);
		//});
		//predictButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		// add button

		//add(predictButton);
		
		// textfield untuk letak unix timestamp

		final TextField tf = new TextField("Enter a new unix timestamp");
		add(tf);

		Button predictButton = new Button("Predict temperature", (e) -> {
			//Integer newValue = new Integer(tf.getValue());
			Double newValue = null;
			try {
				newValue = predictNewTemperature.predict(Long.valueOf(tf.getValue()));
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			series.updatePoint(0, newValue);
		});

		predictButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		add(predictButton);

		// add gauge

		Chart chart = new Chart(ChartType.GAUGE);

		// gauge configuration

		Configuration conf = chart.getConfiguration();
		conf.setTitle("Predicted Temperature in Celsius");
		conf.getPane().setStartAngle(-135);
		conf.getPane().setEndAngle(135);

		YAxis yaxis = new YAxis();
		yaxis.setTitle("°C");

		// The limits are mandatory
		yaxis.setMin(0);
		yaxis.setMax(100);

		// Other configuration
		yaxis.getLabels().setStep(1);
		yaxis.setTickInterval(10);
		yaxis.setTickLength(10);
		yaxis.setTickWidth(1);
		yaxis.setMinorTickInterval("1");
		yaxis.setMinorTickLength(5);
		yaxis.setMinorTickWidth(1);

		PlotBand blue = new PlotBand(0, 20, null);
		blue.setClassName("blue");

		PlotBand green = new PlotBand(20, 30, null);
		green.setClassName("green");

		PlotBand red = new PlotBand(30, 100, null);
		red.setClassName("red");

		yaxis.setPlotBands(blue, green, red);

		conf.addyAxis(yaxis);

		// gauge listener change event


		// add gauge
		add(chart);

		conf.addSeries(series);

		



	}
}
