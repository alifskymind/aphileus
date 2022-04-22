package com.example.application.views.tableCsv;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.shared.util.SharedUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@PageTitle("Table Csv View")
@Route(value = "tableCsvView")
@RouteAlias(value = "tableCsvView")
public class TableCsvView extends VerticalLayout {

	public TableCsvView() {

		InputStreamReader csvFileReader = new InputStreamReader(
				//getClass().getClassLoader().getResourceAsStream("temperature-v2.csv"),
				getClass().getClassLoader().getResourceAsStream("temperature-v5-timestamp-betul.xlsx"),
				StandardCharsets.UTF_8
		);

		CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
		CSVReader reader = new CSVReaderBuilder(csvFileReader).withCSVParser(parser).build();

		Grid<String[]> grid = new Grid<>();

		try {
			List<String[]> entries = reader.readAll();
			// Assume the first row contains headers
			String[] headers = entries.get(0);

			// Setup a grid with random data
			for (int i = 0; i < headers.length; i++) {
				final int columnIndex = i;
				String header = headers[i];
				String humanReadableHeader = SharedUtil.camelCaseToHumanFriendly(header);
				grid.addColumn(str -> str[columnIndex]).setHeader(humanReadableHeader).setSortable(true).setAutoWidth(true);
			}
			grid.setItems(entries.subList(1, entries.size()));
			grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
			add(grid);
		} catch (IOException | CsvException e) {
			grid.addColumn(nop -> "Unable to load CSV: " + e.getMessage()).setHeader("Failed to import CSV file");
		}
	}


}
