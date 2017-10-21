package com.elmenus.assignment.q5.service

import com.elmenus.assignment.q5.entities.{Data, DataUpdate, Restaurant}

import scala.concurrent.{ExecutionContext, Future}
/**
  * Created by Tarek Ottey on 10/21/2017.
  */

class RestaurantService(implicit val executionContext: ExecutionContext) {

  var restaurants = Vector.empty[Restaurant]

  def createRestaurant(restaurant: Restaurant): Future[Option[String]] = Future {
    restaurants.find(_.uuid == restaurant.uuid) match {
      case Some(q) => None // Conflict! id is already taken
      case None =>
        restaurants = restaurants :+ restaurant
        Some(restaurant.uuid)
    }
  }

  def getRestaurant(uuid: String): Future[Option[Restaurant]] = Future {
    restaurants.find(_.uuid == uuid)
  }

  def getRestaurants(queryString: String): Future[Vector[Restaurant]] = Future {
    if(!queryString.isEmpty)
      restaurants.filter(!_.data.closed)
    else
      restaurants
  }

  def updateRestaurant(uuid: String, update: DataUpdate): Future[Option[Restaurant]] = {

    def updateEntity(restaurant: Restaurant): Restaurant= {
      
      val enName =  update.enName.getOrElse(restaurant.data.enName)
      val arName =  update.arName.getOrElse(restaurant.data.arName)
      val state =  update.state.getOrElse(restaurant.data.state)
      val routingMethod =  update.routingMethod.getOrElse(restaurant.data.routingMethod)
      val logo =  update.logo.getOrElse(restaurant.data.logo)
      val coverPhoto =  update.coverPhoto.getOrElse(restaurant.data.coverPhoto)
      val enDescription =  update.enDescription.getOrElse(restaurant.data.enDescription)
      val arDescription =  update.arDescription.getOrElse(restaurant.data.arDescription)
      val shortNumber =  update.shortNumber.getOrElse(restaurant.data.shortNumber)
      val facebookLink =  update.facebookLink.getOrElse(restaurant.data.facebookLink)
      val twitterLink =  update.twitterLink.getOrElse(restaurant.data.twitterLink)
      val youtubeLink =  update.youtubeLink.getOrElse(restaurant.data.youtubeLink)
      val website =  update.website.getOrElse(restaurant.data.website)
      val onlinePayment =  update.onlinePayment.getOrElse(restaurant.data.onlinePayment)
      val client =  update.client.getOrElse(restaurant.data.client)
      val pendingInfo =  update.pendingInfo.getOrElse(restaurant.data.pendingInfo)
      val pendingMenu =  update.pendingMenu.getOrElse(restaurant.data.pendingMenu)
      val closed =  update.closed.getOrElse(restaurant.data.closed)

      Restaurant(uuid, Data(enName, arName, state, routingMethod, logo,coverPhoto,
      enDescription, arDescription, shortNumber, facebookLink,
      twitterLink, youtubeLink, website, onlinePayment, client,
      pendingInfo, pendingMenu, closed))
    }

    getRestaurant(uuid).flatMap { maybeRestaurant =>
      maybeRestaurant match {
        case None => Future { None } // No restaurant found, nothing to update
        case Some(restaurant) =>
          val updatedRestaurant = updateEntity(restaurant)
          deleteRestaurant(uuid).flatMap { _ =>
            createRestaurant(updatedRestaurant).map(_ => Some(updatedRestaurant))
          }
      }
    }
  }

  def deleteRestaurant(uuid: String): Future[Unit] = Future {
    restaurants = restaurants.filterNot(_.uuid== uuid)
  }


}
