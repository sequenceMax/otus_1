package ru.otus.drive.service

import ru.otus.base.service.BaseService

trait DriveService extends BaseService {
  def drive(name: String): String
}
