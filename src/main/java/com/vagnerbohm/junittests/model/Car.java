package com.vagnerbohm.junittests.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class Car {
    private String brand;
    private LocalDate manufactureYear;
    private String model;
    private Integer numberOfSeats;
    private Float engineCapacity;

    public void setNumberOfSeats(Integer numberOfSeats) {
        if(numberOfSeats < 7) {
            this.numberOfSeats = numberOfSeats;
        }
    }
}
