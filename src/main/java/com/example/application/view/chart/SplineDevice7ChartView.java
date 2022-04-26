package com.example.application.view.chart;

import com.example.application.data.controller.JsonDataFetcherController;
import com.example.application.view.dashboard.MenubarView;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@PageTitle("Chart for device 7")
@Route(value = "splineDevice7ChartView")
@PermitAll
public class SplineDevice7ChartView extends VerticalLayout {

	MenubarView menu = new MenubarView();

	public SplineDevice7ChartView() {

		Chart splineChart = new Chart(ChartType.SPLINE);
		splineChart.setTimeline(true);

		PlotOptionsSpline plotOptions = new PlotOptionsSpline();
		plotOptions.setTurboThreshold(1000);

		Configuration configuration = splineChart.getConfiguration();
		configuration.getTitle().setText("Device 7 1ebf74b0-a11d-11ec-a439-89feef661f3b Temperature");
		configuration.getTooltip().setEnabled(true);
		configuration.setPlotOptions(plotOptions);

		DataSeries dataSeries = new DataSeries();

		for (JsonDataFetcherController.TemperatureData  data: JsonDataFetcherController.fetchDevice7Temperature()) {
			DataSeriesItem item = new DataSeriesItem();
			item.setX(data.getDate());
			item.setY(data.getTemperature());
			dataSeries.add(item);
		}

		configuration.addSeries(dataSeries);

		RangeSelector rangeSelector = new RangeSelector();
		rangeSelector.setSelected(1);
		configuration.setRangeSelector(rangeSelector);

		add(menu, splineChart);

	}
}
