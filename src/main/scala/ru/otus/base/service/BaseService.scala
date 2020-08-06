package ru.otus.base.service

import ru.otus.base.dao.BaseDAO

trait BaseService {
  val dao: BaseDAO
}