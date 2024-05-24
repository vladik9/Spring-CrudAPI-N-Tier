package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

// TODO: this will act as db itself, need to replace it with real DB
@Repository("carDao")
public class CarDataAccessService implements CarDao {

  private final static List<Car> DB = new ArrayList<>();

  // get one
  @Override
  public Optional<Car> getCar(UUID id) {
    return DB.stream()
        .filter(car -> car.getId().equals(id))
        .findFirst();
  }

  // get all
  @Override
  public List<Car> getCars() {
    return DB;

  }

  // add one car
  @Override
  public UUID addCar(UUID id, Car car) {
    DB.add(new Car(id, car.getBrand(), car.getYear(), car.getColor()));
    return id;
  }

  // delete one car
  @Override
  public int deleteCar(UUID id) {
    Optional<Car> carOptional = getCar(id);
    if (!carOptional.isPresent()) {
      return 0;
    }
    DB.remove(carOptional.get());
    return 1;
  }

  // update a car
  @Override
  public int updateCar(UUID id, Car car) {
    return getCar(id).map(carToUpdate -> {
      int indexOfCarToUpdate = DB.indexOf(carToUpdate);
      if (indexOfCarToUpdate >= 0) {
        DB.set(indexOfCarToUpdate, new Car(id, car.getBrand(), car.getYear(), car.getColor()));
        return 1;
      }
      return 0;
    }).orElse(0);
  }
}
