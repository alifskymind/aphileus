package com.example.application.views.chart;

import com.example.application.data.controller.JsonDataFetcherController;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "splineDevice13ChartView")
public class SplineDevice13ChartView extends VerticalLayout {

	public SplineDevice13ChartView() {

		Chart splineChart = new Chart(ChartType.SPLINE);
		splineChart.setTimeline(true);

		PlotOptionsSpline plotOptions = new PlotOptionsSpline();
		plotOptions.setTurboThreshold(1000);

		Configuration configuration = splineChart.getConfiguration();
		configuration.getTitle().setText("Device 13 75b31b60-7da9-11ec-a439-89feef661f3b Temperature");
		configuration.getTooltip().setEnabled(true);
		configuration.setPlotOptions(plotOptions);

		DataSeries dataSeries = new DataSeries();

		for (JsonDataFetcherController.TemperatureData  data: JsonDataFetcherController.fetchDevice13Temperature()) {
			DataSeriesItem item = new DataSeriesItem();
			item.setX(data.getDate());
			item.setY(data.getTemperature());
			dataSeries.add(item);
		}

		configuration.addSeries(dataSeries);

		RangeSelector rangeSelector = new RangeSelector();
		rangeSelector.setSelected(1);
		configuration.setRangeSelector(rangeSelector);

		add(splineChart);

	}
}
