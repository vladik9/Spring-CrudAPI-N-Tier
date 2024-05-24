package com.example.demo;

import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Car {

  private final UUID id;
  @NotBlank

  private final String brand;

  @NotBlank
  @Min(2)
  private final Integer year;

  @NotBlank
  private final String color;

  public Car(UUID id, String brand, Integer year, String color) {
    this.id = id;
    this.brand = brand;
    this.year = year;
    this.color = color;
  }

  public UUID getId() {
    return id;
  }

  public String getBrand() {
    return brand;
  }

  public Integer getYear() {
    return year;
  }

  public String getColor() {
    return color;
  }

}
