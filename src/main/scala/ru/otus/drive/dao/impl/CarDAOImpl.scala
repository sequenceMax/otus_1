package ru.otus.drive.dao.impl

import ru.otus.drive.dao.CarDAO
import ru.otus.drive.models._

class CarDAOImpl extends CarDAO {
  override def carByName(name: String): Option[Car] = cars.find(_.name == name)

  override var cars: List[Car] = Car.initData
}
