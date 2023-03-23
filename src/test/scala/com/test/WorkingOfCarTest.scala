package com.test
import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.Vehicle
import org.scalatest.matchers.must.Matchers.{an, be}
class WorkingOfCarTest extends AnyFlatSpec {

  val car = new Vehicle

  // moving car for the first time ==> remaining fuel will be 30 liters
  it should "run car first time and should return the remaining fuel 30 liters" in {
    val remainingFuel = car.move
    assert(remainingFuel == 30 )
  }

  // moving the car for the second time ==> remaining fuel will be 10 liters
  it should "run car second time and should return the remaining fuel 10 liters" in {
    val remainingFuel = car.move
    assert(remainingFuel == 10)
  }


  // As remaining is not sufficient to move the car, we should get an exception here
  it should "throw an exception of IllegalAccessException because fuel is low, need to refill" in {
    an [IllegalAccessException] should be thrownBy {
      car.move
    }
  }

  // refilling the fuel after moving second time ==> total fuel will be 50 liters
  it should "refill the fuel by 40 liters and return the total fuel = 50 liters" in {

    // 10 liter was remaining fuel after running for the second time in the above test case
    val totalFuel = car.fillFuel(40)
    assert(totalFuel == 50)
  }

  //moving the car third time
  it should "run car third time and should return the remaining fuel 30 liters" in {

    //after refilling the fuel, total fuel will be 50 and the running again the fuel will be 30 liters
    val remainingFuel = car.move
    assert(remainingFuel == 30)
  }

  /* we should get an exception while trying to refill the fuel after moving the Car for the third time because
     the fuel capacity of the car will be exceeded
   */
  it should "throw an exception because the total fuel capacity is 50 lites only" in {
    an [IllegalArgumentException] should be thrownBy {
      car.fillFuel(40)
    }
  }
}


