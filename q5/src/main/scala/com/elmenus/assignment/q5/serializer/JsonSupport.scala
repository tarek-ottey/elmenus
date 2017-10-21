package com.elmenus.assignment.q5.serializer

import java.text.SimpleDateFormat

import org.json4s.ext.JodaTimeSerializers
import org.json4s.{DefaultFormats, Formats}
import spray.httpx.Json4sSupport

/**
  * Created by Tarek Ottey on 10/21/2017.
  */

trait JsonSupport extends Json4sSupport {

  implicit def json4sFormats: Formats = customDateFormat ++ JodaTimeSerializers.all ++ CustomSerializers.all

  val customDateFormat = new DefaultFormats {
    override def dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
  }

}
