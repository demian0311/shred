package actors

import org.joda.time.DateTime
import akka.actor.{Actor, ActorLogging}
import actors.ShredActor.TimerEvent

object ShredActor {
  case class TimerEvent(
    resource: String,
    time: DateTime,
    duration: Int)
}

class ShredActor extends Actor with ActorLogging{
  def receive = {
    case TimerEvent(resource, time, duration) => {
      // delegate to timer event actor?
      println("received a timer event: " + resource)
    }
    case _ => {
      println("received an unknown event")
    }
  }

}


