package ru.otus

import ru.otus.base.models.{Request, Response}
import ru.otus.base.service.BaseService
import ru.otus.counter.dao.impl.CounterDAOImpl
import ru.otus.counter.model.{RequestWithCounter, ResponseWithCounter}
import ru.otus.counter.service.CounterService
import ru.otus.counter.service.impl.CounterServiceImpl
import ru.otus.drive.dao.impl.CarDAOImpl
import ru.otus.drive.models.{RequestWithCar, ResponseWithCar}
import ru.otus.drive.service.DriveService
import ru.otus.drive.service.impl.DriveServiceImpl
import ru.otus.echo.model.{RequestWithEcho, ResponseWithEcho}
import ru.otus.greet.dao.impl.GreetingDaoImpl
import ru.otus.greet.model.{GreetRequest, GreetResponse}
import ru.otus.greet.service.GreetingService
import ru.otus.greet.service.impl.GreetingServiceImpl

trait App[T <: Request, R <: Response] {
  def route(request: T): R
}

trait AppController[T <: Request, R <: Response] extends App[T, R] {
  val service: BaseService
}

/**
 * Пример запуска:
 *
 * import ru.otus.AppGreat
 * val appGreat = AppGreat()
 * import ru.otus.greet.model.GreetRequest
 * val greetRequest = GreetRequest("Alex", false)
 * appGreat.route(greetRequest)
 */
object AppGreat {
  private class AppGreetImpl(val service: GreetingService) extends AppController[GreetRequest, GreetResponse] {
    override def route(request: GreetRequest): GreetResponse = service.greet(request)
  }

  def apply(): AppController[GreetRequest, GreetResponse] = {
    val greetingDao     = new GreetingDaoImpl
    val greetingService = new GreetingServiceImpl(greetingDao)
    new AppGreetImpl(greetingService)
  }
}

/**
 * Пример запуска:
 * import ru.otus.AppDrive
 * val appDrive = AppDrive()
 * import ru.otus.drive.models.RequestWithCar
 * val driveRequest = RequestWithCar("toyota")
 * appDrive.route(driveRequest)
 */
object AppDrive {
  private class AppDriveImpl(val service: DriveService) extends AppController[RequestWithCar, ResponseWithCar] {
    override def route(request: RequestWithCar): ResponseWithCar = {
      val driving = service.drive(request.carName)
      ResponseWithCar(driving)
    }
  }

  def apply(): AppController[RequestWithCar, ResponseWithCar] = {
    val carDao       = new CarDAOImpl
    val driveService = new DriveServiceImpl(carDao)
    new AppDriveImpl(driveService)
  }
}

/**
 * Пример запуска:
 * import ru.otus.AppCounter
 * val appCounter = AppCounter()
 * import ru.otus.counter.model.RequestWithCounter
 * val requestWithCounter = RequestWithCounter()
 * appCounter.route(requestWithCounter)
 */
object AppCounter {
  private class AppCounterImpl(
    val service: CounterService
  ) extends AppController[RequestWithCounter, ResponseWithCounter] {
    override def route(request: RequestWithCounter): ResponseWithCounter = {
      ResponseWithCounter(service.getCount())
    }
  }

  def apply(): AppController[RequestWithCounter, ResponseWithCounter] = {
    val counterDao     = new CounterDAOImpl
    val counterService = new CounterServiceImpl(counterDao)
    new AppCounterImpl(counterService)
  }
}

/**
 * Пример запуска:
 * import ru.otus.AppEcho
 * val appEcho = AppEcho()
 * import ru.otus.echo.model.RequestWithEcho
 * val requestWithEcho = RequestWithEcho("ping")
 * appEcho.route(requestWithEcho)
 */
object AppEcho {
  private class AppEchoImpl extends App[RequestWithEcho, ResponseWithEcho] {
    override def route(request: RequestWithEcho): ResponseWithEcho = {
      ResponseWithEcho(request.value)
    }
  }

  def apply(): App[RequestWithEcho, ResponseWithEcho] = {
    new AppEchoImpl()
  }
}
