package com.example.application.view.table;

import com.example.application.data.entity.Temperature;
import com.example.application.data.repository.TemperatureRepository;
import com.example.application.view.dashboard.MenubarView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.VaadinServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import javax.annotation.security.PermitAll;

@PageTitle("Table")
@Route(value = "tableView")
@PermitAll
public class TableView extends VerticalLayout {

	Grid<Temperature> tableGrid = new Grid<>(Temperature.class, false);
	TemperatureRepository service;

	public TableView(TemperatureRepository service) {

		MenubarView menu = new MenubarView();

		this.service = service;

		setSizeFull();
		configureTableGrid();
		add(menu, tableGrid);

	}

	private void configureTableGrid() {

		tableGrid.addColumn(Temperature::getDeviceUUID).setHeader("Device UUID").setSortable(true).setAutoWidth(true);
		tableGrid.addColumn(Temperature::getDataType).setHeader("Data Type (9 for Temperature)").setSortable(true).setAutoWidth(true).setTextAlign(ColumnTextAlign.END);
		tableGrid.addColumn(Temperature::getUnixTimeStamps).setHeader("Unix Timestamp").setSortable(true).setAutoWidth(true);
		tableGrid.addColumn(Temperature::getDateTime).setHeader("Date Time").setSortable(true).setAutoWidth(true);
		tableGrid.addColumn(Temperature::getTemperatureInC).setHeader("Temperature in Celsius").setSortable(true).setAutoWidth(true);

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
