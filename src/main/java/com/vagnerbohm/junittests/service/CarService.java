package com.vagnerbohm.junittests.service;

import com.vagnerbohm.junittests.model.Car;
import com.vagnerbohm.junittests.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public List<Car> getAllCars() {
        return this.carRepository.getAllCars();
    }

    public Car addNewCar(Car car) {
        if(!"BMW".equals(car.getBrand()) && !"AUDI".equals(car.getBrand()) && !"MERCEDES".equals(car.getBrand())) {
            throw new IllegalArgumentException("the brand of the car must be BMW, AUDI or MERCEDES");
        }

        if(car.getNumberOfSeats() > 5) {
            throw new IllegalArgumentException("the car must not have more than 5 seats");
        }

        return this.carRepository.saveCar(car);
    }
}
