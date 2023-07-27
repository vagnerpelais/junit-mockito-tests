package com.vagnerbohm.junittests.repository;

import com.vagnerbohm.junittests.model.Car;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository {
    private ArrayList<Car> cars =
            new ArrayList<>(List.of(buildCar("MERCEDES", LocalDate.of(2023, Month.JANUARY, 1), "turbo", 4, 5.45F),
                    buildCar("AUDI", LocalDate.of(2022, Month.MAY, 12), "cheap", 5, 5.45F),
                    buildCar("BMW", LocalDate.of(2018, Month.DECEMBER, 23), "legacy", 4, 5.45F)));


    public List<Car> getAllCars() {
        return cars;
    }

    public Car saveCar(Car car) {
        cars.add(car);

        return car;
    }

    private Car buildCar(String brand, LocalDate manufactureYear, String model, Integer numberOfSeats, Float engineCapacity) {
        return Car.builder()
                .brand(brand)
                .manufactureYear(manufactureYear)
                .model(model)
                .numberOfSeats(numberOfSeats)
                .engineCapacity(engineCapacity).build();
    }
}
