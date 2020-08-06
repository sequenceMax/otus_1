package ru.otus.greet.dao

import ru.otus.base.dao.BaseDAO

trait GreetingDao extends BaseDAO {
  def greetingPrefix: String
  def greetingPostfix: String
}
