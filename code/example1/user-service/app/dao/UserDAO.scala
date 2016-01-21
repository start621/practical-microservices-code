package dao

import anorm._
import domain.User
import play.api.Play.current
import play.api.db.DB._

object UserDAO extends UserSQLParser {

  def findAll(): List[User] = withConnection { implicit c =>
    SQL("select * from users").as(rowParser.*)
  }

  def findOne(id: Long): Option[User] = withConnection { implicit c =>
    SQL("select * from users where id = {id}").on('id -> id).as(rowParser.singleOpt)
  }

  def create(user: User) = withConnection { implicit c =>
    SQL(s"INSERT INTO Users (firstName, lastName, email, phone) VALUES ({firstName}, {lastName}, {email}, {phone})")
      .on('firstName -> user.firstName, 'lastName    -> user.lastName, 'email -> user.email, 'phone  -> user.phone)
      .executeInsert()
  }

  def update(user: User): Boolean = {
    user.id match {
      case Some(uid) =>
        SQL("UPDATE Users SET firstName = {firstName}, lastName = {lastName}, email = {email}, phone = {phone} WHERE id = {id}")
          .on('firstName -> user.firstName, 'lastName -> user.lastName, 'email -> user.email, 'phone -> user.phone, 'id -> uid)
          .executeUpdate()
        true
      case None => false
    }
  }

  def delete(id: Long) = withConnection { implicit c =>
    SQL("DELETE FROM Users WHERE id = {id}").on('id -> id).execute()
  }
}
