package com.example.application.view.home;

//import com.example.application.views.login.LoginView;
//import com.example.application.views.register.RegisterView;
import com.example.application.view.login.LoginView;
import com.example.application.view.register.RegisterView;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.shared.ui.LoadMode;

@PageTitle("Home")
@AnonymousAllowed
@Route(value = "")
public class HomeView extends VerticalLayout {

    private static final String OAUTH_URL = "/oauth2/authorization/google";

    public HomeView() {

        Image image = new Image("src/main/resources/META-INF/resources/images/thunder.jpg", "thunder.jpg");
        add(image);

        VerticalLayout verticalLayout = new VerticalLayout();

        addClassName("homeView");

        H1 title = new H1("Aphileus: a Predict the Weather App");

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");


        //Button register = new Button("Create new account");
        //register.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        //register.addClickListener( e -> UI.getCurrent().navigate(RegisterView.class));

        //Button login = new Button("Log in");
        //login.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        //login.addClickListener( e -> UI.getCurrent().navigate(LoginView.class));

        Anchor loginLink = new Anchor(OAUTH_URL, "Login with Google");

        // Set router-ignore attribute so that Vaadin router doesn't handle the login request
        loginLink.getElement().setAttribute("router-ignore", true);
        getStyle().set("padding", "200px");
        setAlignItems(FlexComponent.Alignment.CENTER);

        add(
                title,
                loginLink
        );


    }


}
