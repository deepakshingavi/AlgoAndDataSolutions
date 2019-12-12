package com.training

object Result {

  def fizzBuzz(n: Int) {
    for(i <- 1 to n) {
      println({
        if ((i%3==0) && (i%5==0)) "FizzBuzz"
        else if (i%3==0 && i%5!=0) "Fizz"
        else if (i%3!=0 && i%5==0) "Buzz"
        else  i
      })
    }
  }

  def main(args: Array[String]): Unit = {
//    fizzBuzz(3)
    fizzBuzz(5)
//    fizzBuzz(15)
//    fizzBuzz(4)
  }

}
