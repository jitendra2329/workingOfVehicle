package com.knoldus

object WorkingOfVehicle

class Vehicle {

  val fuelCapacity: Int = 50
  var currentFuel: Int = fuelCapacity

  def move: Int = {
    if (currentFuel < 20) throw new IllegalAccessException("low fuel!")
    else {
      currentFuel = currentFuel - 20
      currentFuel
    }
  }


  def fillFuel(fuelToFill: Int): Int = {

    if ((currentFuel + fuelToFill) <= fuelCapacity && fuelToFill > 0) {
      currentFuel = currentFuel + fuelToFill
      currentFuel
    }
    else throw new IllegalArgumentException(fuelToFill.toString)
  }
}