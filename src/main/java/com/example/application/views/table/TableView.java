package com.example.application.views.table;

import com.example.application.data.entity.Temperature;
import com.example.application.data.entity.TemperatureBackup;
import com.example.application.data.repository.TemperatureRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Table")
@Route(value = "tableView")
@RouteAlias(value = "tableView")
public class TableView extends VerticalLayout {

	Grid<Temperature> tableGrid = new Grid<>(Temperature.class, false);
	TemperatureRepository service;

	public TableView(TemperatureRepository service) {

		this.service = service;

		setSizeFull();
		configureTableGrid();
		add(tableGrid);

	}

	private void configureTableGrid() {

		//tableGrid.setColumns("Device UUID", "Column Two", "Unix Timestamp", "Date Time", "Temperature in Celsius");
		//tableGrid.addColumn(Temperature::getDeviceUUID).setHeader("Device UUID");
		//tableGrid.setColumns("deviceUUID", "columnTwo", "unixTimeStamps", "dateTime", "temperatureInC");

		tableGrid.addColumn(Temperature::getDeviceUUID).setHeader("Device UUID").setSortable(true).setAutoWidth(true);;
		tableGrid.addColumn(Temperature::getColumnTwo).setHeader("Column Two").setSortable(true).setAutoWidth(true);;
		tableGrid.addColumn(Temperature::getUnixTimeStamps).setHeader("Unix Timestamp").setSortable(true).setAutoWidth(true);;
		tableGrid.addColumn(Temperature::getDateTime).setHeader("Date Time").setSortable(true).setAutoWidth(true);;
		tableGrid.addColumn(Temperature::getTemperatureInC).setHeader("Temperature in Celsius").setSortable(true).setAutoWidth(true);;

		tableGrid.getColumns().forEach(col -> col.setAutoWidth(true));
		tableGrid.setSizeFull();

		tableGrid.setItems(service.findAll());

	}

	//private HorizontalLayout getToolbar() {
	//	stringFilter.setPlaceholder("Filter by name...");
	//	stringFilter.setClearButtonVisible(true);
	//	stringFilter.setValueChangeMode(ValueChangeMode.LAZY);
	//
	//	Button addTemperatureButton = new Button("Add contact");
	//
	//	HorizontalLayout toolbar = new HorizontalLayout(stringFilter, addTemperatureButton);
	//	return toolbar;
	//}
}
