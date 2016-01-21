package dao

import anorm.{~, RowParser}
import anorm.SqlParser._
import domain.models.User

trait UserSQLParser {

  val rowParser: RowParser[User] =
    get[Long]("id") ~ get[String]("firstName") ~ get[String]("lastName") ~ get[String]("email") ~ get[Option[String]]("phone") map {
      case id ~ first ~ last ~ email ~ phone =>
        User(Some(id), first, last, email, phone)
    }
}
