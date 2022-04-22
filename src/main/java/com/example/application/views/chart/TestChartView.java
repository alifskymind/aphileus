package com.example.application.views.chart;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "testChartView")
public class TestChartView extends VerticalLayout {

	public TestChartView() {

		Chart chart = new Chart();
		//chart.getConfiguration().getChart().setType(ChartType.COLUMN);
		Configuration conf = chart.getConfiguration();
		conf.getChart().setType(ChartType.COLUMN);
		conf.setTitle("Reindeer Kills by Predators");
		conf.setSubTitle("Kills Grouped by Counties");

		// Disable markers from lines
		PlotOptionsLine plotOptions = new PlotOptionsLine();
		plotOptions.setMarker(new Marker(false));
		conf.setPlotOptions(plotOptions);

		ListSeries series = new ListSeries("Diameter");
		series.setData(4900,  12100,  12800,
				6800,  143000, 125000,
				51100, 49500);
		conf.addSeries(series);


		add(chart);
	}
}
