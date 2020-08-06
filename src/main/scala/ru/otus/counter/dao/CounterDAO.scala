package ru.otus.counter.dao

import ru.otus.base.dao.BaseDAO
import ru.otus.counter.model.CountCall

trait CounterDAO extends BaseDAO {
  def getCount: CountCall
  def setCount(newCount: CountCall): CountCall
}