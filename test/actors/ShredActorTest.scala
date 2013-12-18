package actors

import org.junit.Test
import akka.actor.{ActorSystem, Props}
import org.joda.time.DateTime
import actors.ShredActor.TimerEvent

class ShredActorTest {
  @Test def test(){
    println("hello world")

    val system = ActorSystem("testActorSystem")
    system.actorOf(Props[ShredActor]) ! TimerEvent("foo/bar", new DateTime(), 2)
  }
}
