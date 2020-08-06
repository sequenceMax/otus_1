package ru.otus.counter.model

case class CountCall(
  count: Int = 0
){
  def plus(step: Int) = copy(
    count = count + step
  )
}
