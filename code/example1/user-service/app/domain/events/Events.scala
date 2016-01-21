package domain.events

import domain.models.User

sealed trait Event {
  val name: String
  val timestamp: Long
}

case class UserAdded(user: User, timestamp: Long = new java.util.Date().getTime) extends Event {
  val name = "UserAdded"
}
