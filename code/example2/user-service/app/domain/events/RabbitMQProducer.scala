package domain.events

import com.rabbitmq.client.{Connection, ConnectionFactory}
import play.api.libs.json._
import java.util.Date

case class Event(name: String, payload: Option[String] = None, timestamp: Long = new Date().getTime)

object Event {
  implicit val eventFormat = Json.format[Event]
}

class RabbitMQProducer(host: String, queue: String) {

  private def getConnection(host: String): Connection = {
    val factory = new ConnectionFactory()
    factory.setHost(host)
    factory.newConnection()
  }

  private val connection = getConnection(host)

  private def getChannel = {
    val channel = connection.createChannel()
    channel.queueDeclare(queue, false, false, false, null)
    channel
  }

  private val channel = getChannel

  def publish(event: Event) = {
    val eventJson = Json.stringify(Json.toJson(event))
    channel.basicPublish("", queue, null, eventJson.getBytes())
  }
}
