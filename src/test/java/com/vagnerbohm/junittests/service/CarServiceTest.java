package com.vagnerbohm.junittests.service;

import com.vagnerbohm.junittests.model.Car;
import com.vagnerbohm.junittests.repository.CarRepository;
import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {
    @InjectMocks
    CarService carService;

    @Mock
    CarRepository carRepository;

    @Test
    void getAllCars_success() {
        List<Car> cars = List.of(Car.builder()
                .brand("Opel")
                .manufactureYear(LocalDate.of(2021, Month.NOVEMBER, 23))
                .model("meriva")
                .numberOfSeats(3)
                .engineCapacity(5.2f)
                .build());

        when(carRepository.getAllCars())
                .thenReturn(cars);

        List<Car> actualResponse = carService.getAllCars();

        assertThat(actualResponse)
                .isEqualTo(cars);
    }

    @Test
    void addNewCar_success() {
        Car car = Car.builder()
                .brand("BMW")
                .manufactureYear(LocalDate.of(2021, Month.NOVEMBER, 23))
                .model("meriva")
                .numberOfSeats(3)
                .engineCapacity(5.2f)
                .build();

        when(carRepository.saveCar(car))
                .thenReturn(car);

        Car actualResponse = carService.addNewCar(car);

        assertThat(actualResponse)
                .isEqualTo(car);
    }

    @Test
    void addNewCar_unknownBrandError() {
        Car car = Car.builder()
                .brand("Opel")
                .manufactureYear(LocalDate.of(2021, Month.NOVEMBER, 23))
                .model("meriva")
                .numberOfSeats(3)
                .engineCapacity(5.2f)
                .build();


        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> carService.addNewCar(car))
                .withMessage("the brand of the car must be BMW, AUDI or MERCEDES");
    }

    @Test
    void addNewCar_numberOfSeatsError() {
        Car car = Car.builder()
                .brand("BMW")
                .manufactureYear(LocalDate.of(2021, Month.NOVEMBER, 23))
                .model("meriva")
                .numberOfSeats(13)
                .engineCapacity(5.2f)
                .build();


        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> carService.addNewCar(car))
                .withMessage("the car must not have more than 5 seats");
    }

}
