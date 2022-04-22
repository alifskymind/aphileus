package com.example.application.views.addNewData;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
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
import java.util.List;

//@PageTitle("Add New Data")
@Route(value = "addNewData")
//@RouteAlias(value = "addNewData")
public class AddNewDataView extends VerticalLayout {

	private Grid<String[]> newCsvGrid = new Grid<>();

	public AddNewDataView() {

		MemoryBuffer buffer = new MemoryBuffer();
		Upload upload = new Upload(buffer);
		upload.setAcceptedFileTypes(".csv");
		upload.addSucceededListener(e -> {
			displayCsv(buffer.getInputStream());
		});
		add(upload, newCsvGrid);

	}

	private void displayCsv(InputStream resourceAsStream) {

		// Change the separator if needed to something else (for example, to ',').
		CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
		CSVReader reader =
				new CSVReaderBuilder(new InputStreamReader(resourceAsStream)).withCSVParser(parser).build();
		try {
			List<String[]> entries = reader.readAll();
			String[] headers = entries.get(0);
			newCsvGrid.removeAllColumns();

			for (int i = 0; i < headers.length; i++) {
				int colIndex = i;
				newCsvGrid.addColumn(row -> row[colIndex])
						.setHeader(SharedUtil.camelCaseToHumanFriendly(headers[colIndex]))
						.setSortable(true).setAutoWidth(true);
			}

			newCsvGrid.setItems(entries.subList(1, entries.size()));
			newCsvGrid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
		} catch (IOException | CsvException e) {
			e.printStackTrace();
		}
	}
}
