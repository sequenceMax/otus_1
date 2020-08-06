package ru.otus.drive.service.impl

import ru.otus.drive.dao.CarDAO
import ru.otus.drive.service.DriveService

class DriveServiceImpl(
  val dao: CarDAO
) extends DriveService {
  override def drive(carName: String): String = {
    dao
      .getCar(carName)
      .picture
  }
}
