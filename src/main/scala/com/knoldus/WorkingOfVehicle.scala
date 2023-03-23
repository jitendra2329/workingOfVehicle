package com.knoldus

object WorkingOfVehicle
class  Vehicle{

  val fuelCapacity: Int = 50
  var currentFuel: Int = fuelCapacity

  def move: Int = {
    if(currentFuel < 20) throw new IllegalAccessException("low fuel!")
    else {
      currentFuel = currentFuel - 20
      currentFuel
    }
  }


  def fillFuel(fuelAmount: Int): Int = {

    if ((currentFuel + fuelAmount) <= fuelCapacity) {
        currentFuel = currentFuel + fuelAmount
        currentFuel
    }
    else throw new IllegalArgumentException(fuelAmount.toString)
  }
}