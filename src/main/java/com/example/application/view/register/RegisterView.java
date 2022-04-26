package com.example.application.view.register;

import com.example.application.view.home.HomeView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import javax.annotation.security.PermitAll;

@PageTitle("Register")
@Route(value = "register")
@RouteAlias(value = "register")
@PermitAll
public class RegisterView extends VerticalLayout {

	public RegisterView() {

		add(new H2("Create new account"));

		TextField nameField = new TextField();
		nameField.setLabel("Name");
		nameField.setRequiredIndicatorVisible(true);
		nameField.setRequired(true);
		nameField.setClearButtonVisible(true);
		add(nameField);

		EmailField emailField = new EmailField();
		emailField.setLabel("Email address");
		emailField.setRequiredIndicatorVisible(true);
		emailField.setClearButtonVisible(true);
		add(emailField);

		PasswordField passwordField = new PasswordField();
		passwordField.setLabel("Password");
		passwordField.setRevealButtonVisible(true);
		passwordField.setRequiredIndicatorVisible(true);
		passwordField.setRequired(true);
		passwordField.setClearButtonVisible(true);
		add(passwordField);

		Button registerButton = new Button("Register");
		registerButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		add(registerButton);

		Button homeButton = new Button("Back to home page");
		homeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
		homeButton.addClickListener( e -> UI.getCurrent().navigate(HomeView.class));
		add((homeButton));

		setSizeFull();
		setJustifyContentMode(JustifyContentMode.CENTER);
		setDefaultHorizontalComponentAlignment(Alignment.CENTER);
		getStyle().set("text-align", "center");

	}
}
