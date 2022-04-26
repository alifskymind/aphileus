package com.example.application.view.chart;

import com.example.application.data.controller.JsonDataFetcherController;
import com.example.application.view.dashboard.MenubarView;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@PageTitle("Chart for all device")
@Route(value = "splineComparedChartView")
@PermitAll
public class SplineComparedChartView extends VerticalLayout {

	MenubarView menu = new MenubarView();

	public SplineComparedChartView() {

		Chart splineChart = new Chart(ChartType.SPLINE);
		splineChart.setTimeline(true);

		PlotOptionsSpline plotOptions = new PlotOptionsSpline();
		plotOptions.setTurboThreshold(1000);

		Configuration configuration = splineChart.getConfiguration();
		configuration.getTitle().setText("Comparison Original and Predicted Temperatures");
		configuration.getTooltip().setEnabled(true);
		configuration.setPlotOptions(plotOptions);

		DataSeries dataSeriesOriginal = new DataSeries();

		for (JsonDataFetcherController.TemperatureData  data: JsonDataFetcherController.fetchPredictedTemperature()) {
			DataSeriesItem item = new DataSeriesItem();
			item.setX(data.getDate());
			item.setY(data.getTemperature());
			dataSeriesOriginal.add(item);
		}

		DataSeries dataSeriesPredicted = new DataSeries();

		for (JsonDataFetcherController.TemperatureData  data: JsonDataFetcherController.fetchDeviceAllTemperature()) {
			DataSeriesItem item = new DataSeriesItem();
			item.setX(data.getDate());
			item.setY(data.getTemperature());
			dataSeriesPredicted.add(item);
		}

		configuration.setSeries(dataSeriesOriginal, dataSeriesPredicted);

		RangeSelector rangeSelector = new RangeSelector();
		rangeSelector.setSelected(1);
		configuration.setRangeSelector(rangeSelector);

		//splineChart.setHeight("600px");

		add(menu, splineChart);

	}
}
