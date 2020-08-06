package ru.otus.drive.dao.impl

import ru.otus.drive.dao.CarDAO
import ru.otus.drive.models.{Car, Lada, Toyota}

class CarDAOImpl extends CarDAO {
  override val getCar: String => Car = {
    case Toyota.name =>  Toyota
    case Lada.name => Lada
  }
}
