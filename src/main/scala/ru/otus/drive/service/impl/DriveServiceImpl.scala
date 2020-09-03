package ru.otus.drive.service.impl

import ru.otus.drive.dao.CarDAO
import ru.otus.drive.models.{Car, Wheel}
import ru.otus.drive.service.DriveService

class DriveServiceImpl(
  val dao: CarDAO
) extends DriveService {
  def cars: List[Car] = dao.cars

  def byName(name: String): Option[Car] = dao.carByName(name)

  def updateOrCreate(car: Car): Car = {
    dao.cars = car :: cars.dropWhile(_.name == car.name)
    car
  }

  def delete(carName: String): Unit = {
    dao.cars = cars.dropWhile(_.name == carName)
  }

  def create(car: Car): Car = {
    dao.cars = car :: dao.cars
    car
  }

  def updateWheelsOnTheCar(wheels: List[Wheel], carName: String): Either[String, Car] = {
    byName(carName)
      .map { car =>
        cars.dropWhile(_.name == carName)
        val newCar = car.withWheels(wheels)
        dao.cars = newCar :: cars
        newCar
      }
      .toRight("Car not found")
  }

  def withCruiseControl: List[Car] = {
    cars.filter(_.onBoardComputerO.exists(_.cruiseControl))
  }
}
