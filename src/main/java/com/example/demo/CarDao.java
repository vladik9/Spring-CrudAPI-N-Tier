package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarDao {

  UUID addCar(UUID id, Car car);

  default UUID addCar(Car car) {
    return addCar(UUID.randomUUID(), car);
  }

  List<Car> getCars();

  Optional<Car> getCar(UUID id);

  int deleteCar(UUID id);

  int updateCar(UUID id, Car car);
}
