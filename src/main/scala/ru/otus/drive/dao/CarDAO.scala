package ru.otus.drive.dao

import ru.otus.base.dao.BaseDAO
import ru.otus.drive.models.Car

trait CarDAO extends BaseDAO {
  val getCar: String => Car
}
