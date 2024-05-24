package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

  private final CarService carService;

  @Autowired
  public CarController(CarService carService) {
    this.carService = carService;
  }

  @GetMapping
  public List<Car> getCars() {
    return carService.getCars();
  }

  @GetMapping(path = "{id}")
  public Car getCarById(@RequestParam UUID id) {
    return carService.getCarById(id).orElse(null);
  }

  @PostMapping
  public UUID createNewCar(@NotNull @Valid @RequestBody Car car) {
    return carService.createNewCar(car);
  }

  @DeleteMapping(path = "{id}")
  public void deleteCarById(@PathVariable("id") UUID id) {
    carService.deleteCarById(id);
  }

  @PutMapping(path = "{id}")
  public void updateCarById(@PathVariable("id") UUID id, @Valid @RequestBody Car carToUpdate) {
    carService.updateCarById(id, carToUpdate);
  }

}
