package ru.otus.drive.service

import ru.otus.base.service.BaseService
import ru.otus.drive.models.{Car, Wheel}

trait DriveService extends BaseService {
  def cars: List[Car]

  def byName(name: String): Option[Car]

  def updateOrCreate(car: Car): Car

  def delete(carName: String): Unit

  def updateWheelsOnTheCar(wheels: List[Wheel], carName: String): Either[String, Car]

  def create(car: Car): Car

  def withCruiseControl: List[Car]
}
