package com.example.application.views.login;


import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Login")
@Route(value = "login")
@RouteAlias(value = "login")
public class LoginView extends VerticalLayout {

	public LoginView() {

		LoginForm loginForm = new LoginForm();
		add(loginForm);


	}
}
