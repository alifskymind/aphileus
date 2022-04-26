# Predict Temperature App

<!-- This project can be used as a starting point to create your own Vaadin application with Spring Boot.
It contains all the necessary configuration and some placeholder files to get you started. -->

Aphileus: a Predict the Temperature App

This is a web application that can be used to predict the future temperatures. It also shows the previous temperatures in a detailed charts.

## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

You can also import the project to your IDE of choice as you would with any
Maven project. Read more on [how to import Vaadin projects to different 
IDEs](https://vaadin.com/docs/latest/flow/guide/step-by-step/importing) (Eclipse, IntelliJ IDEA, NetBeans, and VS Code).

## Deploying to Production

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/predictweatherapp-1.0-SNAPSHOT.jar`

## Project structure

- `MainLayout.java` in `src/main/java` contains the navigation setup (i.e., the
  side/top bar and the main menu). This setup uses
  [App Layout](https://vaadin.com/components/vaadin-app-layout).
- `views` package in `src/main/java` contains the server-side Java views of your application.
- `views` folder in `frontend/` contains the client-side JavaScript views of your application.
- `themes` folder in `frontend/` contains the custom CSS styles.

## Useful links

- Read the documentation at [vaadin.com/docs](https://vaadin.com/docs).
- Follow the tutorials at [vaadin.com/tutorials](https://vaadin.com/tutorials).
- Watch training videos and get certified at [vaadin.com/learn/training](https://vaadin.com/learn/training).
- Create new projects at [start.vaadin.com](https://start.vaadin.com/).
- Search UI components and their usage examples at [vaadin.com/components](https://vaadin.com/components).
- View use case applications that demonstrate Vaadin capabilities at [vaadin.com/examples-and-demos](https://vaadin.com/examples-and-demos).
- Discover Vaadin's set of CSS utility classes that enable building any UI without custom CSS in the [docs](https://vaadin.com/docs/latest/ds/foundation/utility-classes). 
- Find a collection of solutions to common use cases in [Vaadin Cookbook](https://cookbook.vaadin.com/).
- Find Add-ons at [vaadin.com/directory](https://vaadin.com/directory).
- Ask questions on [Stack Overflow](https://stackoverflow.com/questions/tagged/vaadin) or join our [Discord channel](https://discord.gg/MYFq5RTbBn).
- Report issues, create pull requests in [GitHub](https://github.com/vaadin/platform).

## Screenshots

Main page

![image](https://user-images.githubusercontent.com/104175839/165236311-64e02a2f-77cd-4e17-bae0-9ce097f43981.png)

Login page

![image](https://user-images.githubusercontent.com/104175839/165236346-4f2befc8-e030-4445-8ad8-98eff0c6da06.png)

View all data in a grid

![image](https://user-images.githubusercontent.com/104175839/165236411-cffc3a07-348e-4532-a2f7-8b09ed2fd456.png)

Upload new data

![image](https://user-images.githubusercontent.com/104175839/165236495-980a6686-bde2-4752-ab73-fdaf8ccb42a6.png)

View chart for all devices

![image](https://user-images.githubusercontent.com/104175839/165236568-cff761d3-591f-42f3-bd36-1d3fb1b51769.png)

View chart for certain device

![image](https://user-images.githubusercontent.com/104175839/165236626-f753d815-9310-4af9-ab73-7f7ec9e15bad.png)

View predicted temperature in a grid

![image](https://user-images.githubusercontent.com/104175839/165236807-172f4b5d-1512-4140-b7ba-33e5015db66b.png)

View predicted temperature in a chart

![image](https://user-images.githubusercontent.com/104175839/165236841-5fb3606c-32be-413d-b5db-e324d08da45d.png)

Compares predicted temperatures and original temperatures

![image](https://user-images.githubusercontent.com/104175839/165236885-fee24da8-935d-4a44-8109-68225c40926c.png)
