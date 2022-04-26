package com.example.application.view.table;

import com.example.application.data.entity.TemperaturePredicted;
import com.example.application.data.repository.TemperaturePredictedRepository;
import com.example.application.view.dashboard.MenubarView;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@PageTitle("Predicted Table")
@Route(value = "predictedTableView")
@PermitAll
public class PredictedTableView extends VerticalLayout {

	Grid<TemperaturePredicted> tableGrid = new Grid<>(TemperaturePredicted.class, false);
	TemperaturePredictedRepository service;

	public PredictedTableView(TemperaturePredictedRepository service) {

		MenubarView menu = new MenubarView();

		this.service = service;

		setSizeFull();
		configureTableGrid();
		add(menu, tableGrid);

	}

	private void configureTableGrid() {

		tableGrid.addColumn(TemperaturePredicted::getUnixTimeStamps).setHeader("Unix Timestamp").setSortable(true).setAutoWidth(true);
		tableGrid.addColumn(TemperaturePredicted::getDateTime).setHeader("Date Time").setSortable(true).setAutoWidth(true);
		tableGrid.addColumn(TemperaturePredicted::getTemperatureInC).setHeader("Temperature in Celsius").setSortable(true).setAutoWidth(true);

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
