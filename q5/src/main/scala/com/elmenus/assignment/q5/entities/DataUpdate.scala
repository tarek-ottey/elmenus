package com.elmenus.assignment.q5.entities

/**
  * Created by Tarek Ottey on 10/21/2017.
  */
case class DataUpdate(enName: Option[String], arName: Option[String], state: Option[String], routingMethod: Option[String], logo: Option[String], coverPhoto: Option[String],
                      enDescription: Option[String], arDescription: Option[String], shortNumber: Option[String], facebookLink:Option[String],
                      twitterLink: Option[String], youtubeLink: Option[String], website: Option[String], onlinePayment: Option[Boolean], client: Option[Boolean],
                      pendingInfo: Option[Boolean], pendingMenu: Option[Boolean], closed: Option[Boolean])