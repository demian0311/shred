package controllers

import play.api.mvc.{Action, Controller}
import play.api.libs.json._
import akka.actor.ActorSystem


object Application extends Controller {

  val actorSystem = ActorSystem("shred")

  // not production ready
  var countMap: Map[String, Int] = Map()

  def index = Action {
    Ok(views.html.index("Hello Play Framework"))
  }

  def getNode(resource: String) = Action {
    val count: Int = countMap.getOrElse(resource, 0)

    Ok(Json.obj(
      "resource" -> resource,
      "count" -> count
    ))
  }

  def postNode(resource: String) = Action {
    val result: Option[Int] = countMap.get(resource)

    result match {
      case Some(value: Int) => {
        val newValue = value + 1
        countMap += (resource -> newValue)
        NoContent
      }
      case None => {
        countMap += (resource -> 1)
        Created(Json.obj( "resource" -> resource ))
      }
    }
  }

  def deleteNode(resource: String) = Action {
    countMap -= resource
    NoContent
  }
}