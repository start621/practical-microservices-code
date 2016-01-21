package controllers.api.v1

import dao.UserDAO
import domain.models.User
import play.api.mvc._
import play.api.libs.json._

class Users extends Controller {

  def index = Action {
    Ok(Json.toJson(UserDAO.findAll()))
  }

  def create = Action {
   NotImplemented
  }

  def show(id: Long) = Action {
    UserDAO.findOne(id) match {
      case Some(user) => Ok(Json.toJson(user))
      case None => NotFound
    }
  }

  def update(id: Long) = Action {
   NotImplemented
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
