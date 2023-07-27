# JUnit Tests - Car Service and Controller

This repository contains a simple Java Spring Boot application that demonstrates how to write unit tests using JUnit 5 and Mockito for the CarService and CarController classes.

## Project Structure

The project consists of the following main components:

- `controller`: Contains the CarController class, which handles incoming HTTP requests related to cars.

- `model`: Defines the Car class, which represents a car entity with various attributes.

- `repository`: Contains the CarRepository class, which simulates a database repository and stores car data in an ArrayList.

- `service`: Contains the CarService class, which provides business logic for car-related operations.

- `controller.CarControllerTest`: Contains JUnit 5 tests for the CarController class.

- `service.CarServiceTest`: Contains JUnit 5 tests for the CarService class.

## Running the Tests

To run the tests, you can use your favorite Java IDE or run them directly from the command line using Maven:

```bash
mvn clean test
```

## Test Coverage

The tests provide extensive coverage for the CarService and CarController classes, including success scenarios and error cases. The tests verify that the business logic behaves correctly and that the controller returns the expected HTTP responses.

## Dependencies

The project uses the following major dependencies:

- `Spring Boot`: Framework for building Spring applications.

- `JUnit 5`: The latest version of the JUnit framework for unit testing.

- `Mockito`: A powerful mocking framework for Java that simplifies unit testing.