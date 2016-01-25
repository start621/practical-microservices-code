package controllers.api.v1

import dao.UserDAO
import domain.events.{ Event, RabbitMQProducer }
import domain.models.User
import play.api.mvc._
import play.api.libs.json._

class Users extends Controller {

  val messagingClient = new RabbitMQProducer("192.168.99.100", "user.service")

  private def publishUserEvent(name: String, user: User) =
    messagingClient.publish(Event(name, Some(Json.stringify(Json.toJson(user)))))

  def index = Action {
    Ok(Json.toJson(UserDAO.findAll()))
  }

  def create = Action { request =>
    request.body.asJson.map { json =>
      json.asOpt[User] match {
        case Some(user) =>
          UserDAO.create(user)
          publishUserEvent("user.created", user)
          Created
        case None => BadRequest
      }
    } getOrElse BadRequest
  }

  def show(id: Long) = Action {
    UserDAO.findOne(id) match {
      case Some(user) => Ok(Json.toJson(user))
      case None => NotFound
    }
  }

  def update(id: Long) = Action { request =>
    request.body.asJson.map { json =>
      json.asOpt[User] match {
        case Some(user) =>
          UserDAO.update(user.copy(id = Some(id)))
          publishUserEvent("user.updated", user)
          Ok
        case None => BadRequest
      }
    } getOrElse BadRequest
  }

  def delete(id: Long) = Action {
    UserDAO.findOne(id) match {
      case Some(user) =>
        UserDAO.delete(id)
        publishUserEvent("user.deleted", user)
        Accepted
      case None =>
        NotFound
    }
  }
}
