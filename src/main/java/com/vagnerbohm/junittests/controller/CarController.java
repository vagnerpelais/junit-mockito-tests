package com.vagnerbohm.junittests.controller;


import com.vagnerbohm.junittests.model.Car;
import com.vagnerbohm.junittests.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("app-name", "max-app");
        return new ResponseEntity<>(this.carService.getAllCars(), httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> addNewCar(@RequestBody @NonNull Car car) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.carService.addNewCar(car));
    }
}
