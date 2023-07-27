package com.vagnerbohm.junittests.controller;

import com.vagnerbohm.junittests.model.Car;
import com.vagnerbohm.junittests.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarControllerTest {
    @InjectMocks
    CarController carController;

    @Mock
    CarService carService;

    @Test
    void addNewCar_success() {
        //GIVEN - data tha is mocked
        Car car = Car.builder()
                .brand("Audi")
                .manufactureYear(LocalDate.MIN)
                .model("a5")
                .numberOfSeats(4)
                .engineCapacity(1.3f)
                .build();

        when(carService.addNewCar(car))
                .thenReturn(car);

        //WHEN - actual call of the method that we want to unit test
        ResponseEntity<Car> actualResponse = carController.addNewCar(car);

        //THEN - assertions, checking - verify what we expect to happen
        assertThat(actualResponse.getStatusCode())
                .isEqualTo(HttpStatus.CREATED);

        assertThat(actualResponse.getBody())
                .isEqualTo(car);
    }

    @Test
    void getAllCars_success() {
        List<Car> cars = List.of(Car.builder()
                .brand("Opel")
                .manufactureYear(LocalDate.of(2021, Month.NOVEMBER, 23))
                .model("meriva")
                .numberOfSeats(3)
                .engineCapacity(5.2f)
                .build());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("app-name", "max-app");
        ResponseEntity<List<Car>> expectedResponse = new ResponseEntity<>(cars, httpHeaders, HttpStatus.OK);

        when(carService.getAllCars())
                .thenReturn(cars);

        ResponseEntity<List<Car>> actualResponse = carController.getAllCars();

        assertThat(actualResponse)
                .isEqualTo(expectedResponse);
    }

    @Test
    void getAllCars_success2() {
        List<Car> cars = List.of(Car.builder()
                .brand("Opel")
                .manufactureYear(LocalDate.of(2021, Month.NOVEMBER, 23))
                .model("meriva")
                .numberOfSeats(3)
                .engineCapacity(5.2f)
                .build());

        HttpHeaders expectedHttpHeaders = new HttpHeaders();
        expectedHttpHeaders.add("app-name", "max-app");

        when(carService.getAllCars())
                .thenReturn(cars);

        ResponseEntity<List<Car>> actualResponse = carController.getAllCars();

        assertThat(actualResponse.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        assertThat(actualResponse.getHeaders())
                .isEqualTo(expectedHttpHeaders);
        assertThat(actualResponse.getBody())
                .isEqualTo(cars);

    }
}
