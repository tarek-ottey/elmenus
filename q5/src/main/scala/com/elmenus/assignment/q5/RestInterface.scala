package com.elmenus.assignment.q5

/**
  * Created by Tarek Ottey on 10/21/2017.
  */

import com.elmenus.assignment.q5.resource.RestaurantResource
import com.elmenus.assignment.q5.service.RestaurantService
import spray.routing._

import scala.concurrent.ExecutionContext
import scala.language.postfixOps

class RestInterface(implicit val executionContext: ExecutionContext) extends HttpServiceActor with Resources {

  def receive = runRoute(routes)

  val resturantService = new RestaurantService

  val routes: Route = restaurantRoutes

}

trait Resources extends RestaurantResource
