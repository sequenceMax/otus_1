package ru.otus.drive.models.request

import ru.otus.base.models.Request
import ru.otus.drive.models.{Car, Wheel}

case class RequestWithCar(
  requestMode: RequestMode,
  carO: Option[Car] = None,
  carNameO: Option[String] = None,
  wheels: List[Wheel] = List.empty
) extends Request
