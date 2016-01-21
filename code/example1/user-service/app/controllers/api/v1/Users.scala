package controllers.api.v1

import dao.UserDAO
import domain.models.User
import play.api.mvc._
import play.api.libs.json._

class Users extends Controller {

  def index = Action {
    Ok(Json.toJson(UserDAO.findAll()))
  }

  def create = Action { request =>
    request.body.asJson.map { json =>
      json.asOpt[User] match {
        case Some(user) =>
          UserDAO.create(user)
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
          Ok
        case None => BadRequest
      }
    } getOrElse BadRequest
  }

  def delete(id: Long) = Action {
    UserDAO.findOne(id) match {
      case Some(user) =>
        UserDAO.delete(id)
        Accepted
      case None =>
        NotFound
    }
  }
}
