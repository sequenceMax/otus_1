package ru.otus.drive.models

case class Car(
  name: String,
  onBoardComputerO: Option[OnBoardComputer],
  wheels: List[Wheel]
) {
  def withWheels(wheels: List[Wheel]): Car = copy(
    wheels = wheels
  )
}

object Car {
  def initData: List[Car] = {
    List(
      Car(
        name = "toyota",
        onBoardComputerO = Some(
          OnBoardComputer(
            cruiseControl = true,
            fuelСonsumption = true
          )
        ),
        wheels = List(
          Wheel(name = "Wheel1"),
          Wheel(name = "Wheel5"),
          Wheel(name = "Wheel2"),
          Wheel(name = "Wheel3")
        )
      ),
      Car(
        name = "lada",
        onBoardComputerO = Some(
          OnBoardComputer(
            cruiseControl = false,
            fuelСonsumption = true
          )
        ),
        wheels = List(
          Wheel(name = "Wheel1"),
          Wheel(name = "Wheel3"),
          Wheel(name = "Wheel1"),
          Wheel(name = "Wheel3")
        )
      ),
      Car(
        name = "mazda",
        onBoardComputerO = Some(
          OnBoardComputer(
            cruiseControl = true,
            fuelСonsumption = false
          )
        ),
        wheels = List(
          Wheel(name = "Wheel4"),
          Wheel(name = "Wheel2"),
          Wheel(name = "Wheel5"),
          Wheel(name = "Wheel2")
        )
      ),
      Car(
        name = "ford",
        onBoardComputerO = None,
        wheels = List.empty
      )
    )
  }
}
