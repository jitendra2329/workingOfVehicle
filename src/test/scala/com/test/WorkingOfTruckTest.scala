package com.test
import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.Vehicle
import org.scalatest.matchers.must.Matchers.{an, be}
class WorkingOfTruckTest extends AnyFlatSpec {

  val truck = new Vehicle

  // moving truck for the first time ==> remaining fuel will be 30
  it should "run truck first time and should return the remaining fuel 30 liters" in {
    val remainingFuel = truck.move
    assert(remainingFuel == 30 )
  }

  // moving the truck for the second time ==> remaining fuel will be 10
  it should "run truck second time and should return the remaining fuel 10 liters" in {
    val remainingFuel = truck.move
    assert(remainingFuel == 10)
  }


  // As remaining is not sufficient to move the truck, we should get an exception here
  it should "throw an exception of IllegalAccessException because fuel is low" in {
    an [IllegalAccessException] should be thrownBy {
      truck.move
    }
  }
  /*it should "run truck third time and should return the remaining fuel" in {

    //after refilling the fuel, total fuel will be 50 and the running again the fuel will be 30
    val remainingFuel = truck.move
    assert(remainingFuel == 30)
  */

  // refilling the fuel after moving second time ==> total fuel will be 50
  it should "refill the fuel by 40 liters and return the total fuel = 50 liters" in {

    // 10 liter was remaining fuel after running for the second time in the above test case
    val totalFuel = truck.fillFuel(40)
    assert(totalFuel == 50)
  }

  //moving the truck third time
  it should "run truck third time and should return the remaining fuel 30 liters" in {
    //after refilling the fuel, total fuel will be 50 and the running again the fuel will be 30
    val remainingFuel = truck.move
    assert(remainingFuel == 30)
  }

  /* Should get an exception while trying to refill the fuel after moving for the third time because
     the fuel capacity of the truck will be exceeded
   */
  it should "throw an exception because the total fuel capacity is 50 lites only" in {
    an [IllegalArgumentException] should be thrownBy {
      truck.fillFuel(40)
    }
  }
}


