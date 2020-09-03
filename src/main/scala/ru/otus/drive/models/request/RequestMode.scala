package ru.otus.drive.models.request

sealed trait RequestMode

object RequestMode {
  case object Create extends RequestMode
  case object ReadOne extends RequestMode
  case object ReadAll extends RequestMode
  case object Update extends RequestMode
  case object Delete extends RequestMode
  case object UpdateWheelsOnTheCar extends RequestMode
}
