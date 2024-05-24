package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CarService {

  private final CarDao carDao;

  @Autowired
  public CarService(@Qualifier("carDao") CarDao carDao) {
    this.carDao = carDao;
  }

  List<Car> getCars() {
    return carDao.getCars();
  }

  public Optional<Car> getCarById(UUID id) {
    return carDao.getCar(id);
  }

  public UUID createNewCar(Car car) {
    return carDao.addCar(car);
  }

  public void deleteCarById(UUID id) {
    carDao.deleteCar(id);
  }

  public void updateCarById(UUID id, Car car) {
    carDao.updateCar(id, car);
  }
}
