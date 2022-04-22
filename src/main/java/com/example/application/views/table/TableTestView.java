package com.example.application.views.table;

import com.example.application.data.entity.Person;
import com.example.application.data.entity.Temperature;
import com.example.application.data.repository.TemperatureRepository;
import com.example.application.data.service.TemperatureService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Route("tableTestView")
public class TableTestView extends VerticalLayout {

	Grid<Temperature> grid = new Grid<>(Temperature.class, false);
	//TemperatureService service;
	TemperatureRepository service;



	//private Collection<Temperature> temperatures;
	//ListDataProvider<Temperature> dataProvider = DataProvider.ofCollection(temperatures);

	//DataProvider<Person, Void> dataProvider = DataProvider.ofItems()



	public TableTestView(TemperatureRepository service) {
	//public TableTestView(@Autowired TemperatureRepository service) {
	//public TableTestView() {

		this.service = service;
		setSizeFull();

		//Binder<Temperature> binder = new Binder<>(Temperature.class);
		//binder.bindInstanceFields(this);
		//TextField deviceUUID = new TextField("test");

		grid.addColumn(Temperature::getDeviceUUID).setHeader("Device UUID");
		grid.addColumn(Temperature::getColumnTwo).setHeader("Column Two");
		grid.addColumn(Temperature::getUnixTimeStamps).setHeader("Unix timestamps");
		grid.addColumn(Temperature::getDateTime).setHeader("Date Time");
		grid.addColumn(Temperature::getTemperatureInC).setHeader("Temperature in C");

		grid.setSizeFull();
		grid.getColumns().forEach(col -> col.setAutoWidth(true));

		//List<Temperature> people = TemperatureService.findAllTemperature();
		//List<Temperature> temperatures = service.findAllTemperature();
		//grid.setItems(service.findAllTemperature());
		//grid.setItems(new Temperature("test", "test", "test", "test", 1.4));
		//grid.setItems(service.findAllTemperature());
		//grid.setDataProvider(dataProvider);
		grid.setItems(service.findAll());


		add(grid);
	}
}
