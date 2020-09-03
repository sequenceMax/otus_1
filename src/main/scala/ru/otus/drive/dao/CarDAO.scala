package ru.otus.drive.dao

import ru.otus.base.dao.BaseDAO
import ru.otus.drive.models.Car

trait CarDAO extends BaseDAO {
  def carByName(name: String): Option[Car]
  var cars: List[Car]
}
