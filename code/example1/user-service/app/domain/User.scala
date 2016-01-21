package domain

import play.api.libs.json._

case class User(id: Option[Long], firstName: String, lastName: String, email: String, phone: Option[String])

object User {
  implicit val format = Json.format[User]
}
