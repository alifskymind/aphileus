package com.example.application.view.login;


import com.example.application.view.home.HomeView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("Login")
@Route(value = "login")
@AnonymousAllowed
public class LoginView extends VerticalLayout {

	private static final String OAUTH_URL = "/oauth2/authorization/google";

	public LoginView() {

		addClassName("login");

		Anchor loginLink = new Anchor(OAUTH_URL, "Login with Google");

		// Set router-ignore attribute so that Vaadin router doesn't handle the login request
		loginLink.getElement().setAttribute("router-ignore", true);
		add(loginLink);
		getStyle().set("padding", "200px");
		setAlignItems(FlexComponent.Alignment.CENTER);

		//LoginForm loginForm = new LoginForm();
		//loginForm.setForgotPasswordButtonVisible(false);
		//add(loginForm);

		Button loginButton = new Button("Login with Google");
		loginButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		loginButton.addClickListener( e -> UI.getCurrent().navigate(OAUTH_URL));
		add(loginButton);

		Button homeButton = new Button("Back to home page");
		homeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
		homeButton.addClickListener( e -> UI.getCurrent().navigate(HomeView.class));
		add(homeButton);

		setSizeFull();
		//setJustifyContentMode(JustifyContentMode.CENTER);
		//setDefaultHorizontalComponentAlignment(Alignment.CENTER);
		//getStyle().set("text-align", "center");

	}
}
