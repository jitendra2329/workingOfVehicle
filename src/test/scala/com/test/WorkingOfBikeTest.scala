package com.test
import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.Vehicle
import org.scalatest.matchers.must.Matchers.{an, be}
class WorkingOfBikeTest extends AnyFlatSpec {

  val bike = new Vehicle

  // moving bike for the first time ==> remaining fuel will be 30 liters
  it should "run bike first time and should return the remaining fuel 30 liters" in {
    val remainingFuel = bike.move
    assert(remainingFuel == 30 )
  }

  // moving the bike for the second time ==> remaining fuel will be 10 liters
  it should "run bike second time and should return the remaining fuel 10 liters" in {
    val remainingFuel = bike.move
    assert(remainingFuel == 10)
  }


  // As remaining is not sufficient to move the bike, we should get an exception here
  it should "throw an exception of IllegalAccessException because fuel is low" in {
    an [IllegalAccessException] should be thrownBy {
      bike.move
    }
  }

  // refilling the fuel after moving second time ==> total fuel will be 50 liters
  it should "refill the fuel by 40 liters and return the total fuel = 50 liters" in {

    // 10 liter was remaining fuel after running for the second time in the above test case,total fuel should be 50 liters
    val totalFuel = bike.fillFuel(40)
    assert(totalFuel == 50)
  }

  //moving the bike third time
  it should "run bike third time and should return the remaining fuel 30 liters" in {

    //after refilling the fuel, total fuel will be 50 and the running again the fuel will be 30 liters
    val remainingFuel = bike.move
    assert(remainingFuel == 30)
  }

  /* Should get an exception while trying to refill the fuel after moving for the third time because
     the fuel capacity of the bike will be exceeded
   */
  it should "throw an exception because the total fuel capacity is 50 lites only" in {
    an [IllegalArgumentException] should be thrownBy {
      bike.fillFuel(40)
    }
  }
}


