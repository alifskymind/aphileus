package com.example.application.view.dashboard;

import com.example.application.view.addNewData.AddNewDataView;
//import com.example.application.view.chart.*;
import com.example.application.view.chart.*;
import com.example.application.view.prediction.CustomPrediction;
import com.example.application.view.table.PredictedTableView;
import com.example.application.view.table.TableView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import javax.annotation.security.PermitAll;

@PageTitle("Menubar")
@Route("menubarView")
@PermitAll
public class MenubarView extends VerticalLayout {

	private static final String LOGOUT_SUCCESS_URL = "/";

	public MenubarView() {

		MenuBar menuBar = new MenuBar();
		menuBar.setOpenOnHover(true);
		addItems(menuBar);
		//add(menuBar);

		Button logoutButton = new Button("Logout", click -> {
			UI.getCurrent().getPage().setLocation(LOGOUT_SUCCESS_URL);
			SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
			logoutHandler.logout(
					VaadinServletRequest.getCurrent().getHttpServletRequest(), null,
					null);
		});
		logoutButton.addThemeVariants(ButtonVariant.LUMO_ERROR);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		OAuth2AuthenticatedPrincipal principal = (OAuth2AuthenticatedPrincipal) authentication.getPrincipal();
		String picture = principal.getAttribute("picture");
		Image image = new Image(picture, "User Image");

		Avatar avatarImage = new Avatar();
		avatarImage.setImage(picture);

		HorizontalLayout logoutLayout = new HorizontalLayout();
		logoutLayout.add(avatarImage, logoutButton);
		logoutLayout.getStyle().set("margin-left", "auto");
		logoutLayout.setAlignItems(FlexComponent.Alignment.CENTER);

		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setAlignItems(FlexComponent.Alignment.CENTER);
		horizontalLayout.setWidthFull();
		//horizontalLayout.add(menuBar, logoutLayout);
		horizontalLayout.add(menuBar, avatarImage, logoutButton);
		add(horizontalLayout);

	}

	private void addItems(MenuBar menuBar) {

		MenuItem dataMenu = menuBar.addItem("View data in grid");
		SubMenu dataSubMenu = dataMenu.getSubMenu();
		MenuItem originalData = dataSubMenu.addItem("Original Data");
		originalData.addClickListener( e -> UI.getCurrent().navigate(TableView.class));
		MenuItem ownData = dataSubMenu.addItem("Add your own data");
		ownData.addClickListener( e -> UI.getCurrent().navigate(AddNewDataView.class));

		MenuItem chartMenu = menuBar.addItem("View charts");
		SubMenu chartSubMenu = chartMenu.getSubMenu();
		MenuItem allChart = chartSubMenu.addItem("View chart for all devices");
		allChart.addClickListener( e -> UI.getCurrent().navigate(SplineDeviceAllChartView.class));
		MenuItem individualChart = chartSubMenu.addItem("View chart for each device");
		SubMenu individualChartSubMenu = individualChart.getSubMenu();
		MenuItem device1 = individualChartSubMenu.addItem("Device 1");
		device1.addClickListener( e -> UI.getCurrent().navigate(SplineDevice1ChartView.class));
		MenuItem device2 = individualChartSubMenu.addItem("Device 2");
		device2.addClickListener( e -> UI.getCurrent().navigate(SplineDevice2ChartView.class));
		MenuItem device3 = individualChartSubMenu.addItem("Device 3");
		device3.addClickListener( e -> UI.getCurrent().navigate(SplineDevice3ChartView.class));
		MenuItem device4 = individualChartSubMenu.addItem("Device 4");
		device4.addClickListener( e -> UI.getCurrent().navigate(SplineDevice4ChartView.class));
		MenuItem device5 = individualChartSubMenu.addItem("Device 5");
		device5.addClickListener( e -> UI.getCurrent().navigate(SplineDevice5ChartView.class));
		MenuItem device6 = individualChartSubMenu.addItem("Device 6");
		device6.addClickListener( e -> UI.getCurrent().navigate(SplineDevice6ChartView.class));
		MenuItem device7 = individualChartSubMenu.addItem("Device 7");
		device7.addClickListener( e -> UI.getCurrent().navigate(SplineDevice7ChartView.class));
		MenuItem device8 = individualChartSubMenu.addItem("Device 8");
		device8.addClickListener( e -> UI.getCurrent().navigate(SplineDevice8ChartView.class));
		MenuItem device9 = individualChartSubMenu.addItem("Device 9");
		device9.addClickListener( e -> UI.getCurrent().navigate(SplineDevice9ChartView.class));
		MenuItem device10 = individualChartSubMenu.addItem("Device 10");
		device10.addClickListener( e -> UI.getCurrent().navigate(SplineDevice10ChartView.class));
		MenuItem device11 = individualChartSubMenu.addItem("Device 11");
		device11.addClickListener( e -> UI.getCurrent().navigate(SplineDevice11ChartView.class));
		MenuItem device12 = individualChartSubMenu.addItem("Device 12");
		device12.addClickListener( e -> UI.getCurrent().navigate(SplineDevice12ChartView.class));
		MenuItem device13 = individualChartSubMenu.addItem("Device 13");
		device13.addClickListener( e -> UI.getCurrent().navigate(SplineDevice13ChartView.class));
		MenuItem device14 = individualChartSubMenu.addItem("Device 14");
		device14.addClickListener( e -> UI.getCurrent().navigate(SplineDevice14ChartView.class));
		MenuItem device15 = individualChartSubMenu.addItem("Device 15");
		device15.addClickListener( e -> UI.getCurrent().navigate(SplineDevice15ChartView.class));
		MenuItem device16 = individualChartSubMenu.addItem("Device 16");
		device16.addClickListener( e -> UI.getCurrent().navigate(SplineDevice16ChartView.class));
		MenuItem device17 = individualChartSubMenu.addItem("Device 17");
		device17.addClickListener( e -> UI.getCurrent().navigate(SplineDevice17ChartView.class));
		MenuItem device18 = individualChartSubMenu.addItem("Device 18");
		device18.addClickListener( e -> UI.getCurrent().navigate(SplineDevice18ChartView.class));
		MenuItem device19 = individualChartSubMenu.addItem("Device 19");
		device19.addClickListener( e -> UI.getCurrent().navigate(SplineDevice19ChartView.class));
		MenuItem device20 = individualChartSubMenu.addItem("Device 20");
		device20.addClickListener( e -> UI.getCurrent().navigate(SplineDevice20ChartView.class));
		MenuItem device21 = individualChartSubMenu.addItem("Device 21");
		device21.addClickListener( e -> UI.getCurrent().navigate(SplineDevice21ChartView.class));
		MenuItem device22 = individualChartSubMenu.addItem("Device 22");
		device22.addClickListener( e -> UI.getCurrent().navigate(SplineDevice22ChartView.class));
		MenuItem device23 = individualChartSubMenu.addItem("Device 23");
		device23.addClickListener( e -> UI.getCurrent().navigate(SplineDevice23ChartView.class));
		MenuItem device24 = individualChartSubMenu.addItem("Device 24");
		device24.addClickListener( e -> UI.getCurrent().navigate(SplineDevice24ChartView.class));



		MenuItem predictionMenu = menuBar.addItem("Make predictions");
		SubMenu predictionSubMenu = predictionMenu.getSubMenu();
		MenuItem predictedGrid = predictionSubMenu.addItem("Predicted temperature in grid");
		predictedGrid.addClickListener( e -> UI.getCurrent().navigate(PredictedTableView.class));
		MenuItem predictedChart = predictionSubMenu.addItem("Predicted temperature in chart");
		predictedChart.addClickListener( e -> UI.getCurrent().navigate(SplinePredictedChartView.class));
		MenuItem comparedChart = predictionSubMenu.addItem("Comparing original temperatures and predicted temperatures");
		comparedChart.addClickListener( e -> UI.getCurrent().navigate(SplineComparedChartView.class));

		MenuItem customDate = predictionSubMenu.addItem("Choose custom date for temperature prediction");
		customDate.addClickListener( e -> UI.getCurrent().navigate(CustomPrediction.class));


		//menuBar.addItem("View");
		//menuBar.addItem("Edit");

		//MenuItem share = menuBar.addItem("Data");
		//SubMenu shareSubMenu = share.getSubMenu();
		//MenuItem onSocialMedia = shareSubMenu.addItem("On social media");
		//SubMenu socialMediaSubMenu = onSocialMedia.getSubMenu();
		//socialMediaSubMenu.addItem("Facebook");
		//socialMediaSubMenu.addItem("Twitter");
		//socialMediaSubMenu.addItem("Instagram");
		//shareSubMenu.addItem("By email");
		//shareSubMenu.addItem("Get Link");
		//
		//MenuItem move = menuBar.addItem("Move");
		//SubMenu moveSubMenu = move.getSubMenu();
		//moveSubMenu.addItem("To folder");
		//moveSubMenu.addItem("To trash");
		//
		//menuBar.addItem("Duplicate");
	}
}
