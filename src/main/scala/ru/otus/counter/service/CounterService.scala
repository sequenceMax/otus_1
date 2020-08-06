package ru.otus.counter.service

import ru.otus.base.service.BaseService
import ru.otus.counter.model.CountCall

trait CounterService extends BaseService {
  def getCount(): CountCall
}
