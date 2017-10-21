package com.elmenus.assignment.q5.resource

import com.elmenus.assignment.q5.entities.{DataUpdate, Restaurant}
import com.elmenus.assignment.q5.routing.MyHttpService
import com.elmenus.assignment.q5.service.RestaurantService
import spray.routing._

/**
  * Created by Tarek Ottey on 10/21/2017.
  */

trait RestaurantResource extends MyHttpService {

  val restaurantService: RestaurantService = new RestaurantService()

  def restaurantRoutes: Route = pathPrefix("api") {
    pathPrefix("restaurant") {
      pathEnd {
        post {
          entity(as[Restaurant]) { restaurant =>
            restaurant.uuid = java.util.UUID.randomUUID().toString()
            completeWithLocationHeader(
              resourceId = restaurantService.createRestaurant(restaurant),
              ifDefinedStatus = 201, ifEmptyStatus = 409)
          }
        }~get{
          parameter("closed"?) { query =>
            complete(restaurantService.getRestaurants(query.getOrElse("")))
          }
        }
      } ~
        path(Segment) { uuid =>
          get {
            complete(restaurantService.getRestaurant(uuid))
          } ~
            put {
              entity(as[DataUpdate]) { update =>
                complete(restaurantService.updateRestaurant(uuid, update))
              }
            } ~
            delete {
              complete(204, restaurantService.deleteRestaurant(uuid))
            }
        }
    }
  }
}