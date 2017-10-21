package com.elmenus.assignment.q5.serializer


import java.sql.Timestamp

import org.json4s.CustomSerializer
import org.json4s.JsonAST.{JInt, JNull}

/**
  * Created by Tarek Ottey on 10/21/2017.
  */

object CustomSerializers {
  val all = List(CustomTimestampSerializer)
}

case object CustomTimestampSerializer extends CustomSerializer[Timestamp](format =>
  ({
    case JInt(x) => new Timestamp(x.longValue * 1000)
    case JNull => null
  },
    {
      case date: Timestamp => JInt(date.getTime / 1000)
    }))
