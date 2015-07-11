package com.webtrends.harness.component.spotifyapi.data

import com.webtrends.harness.component.spotifyapi.data.CopyrightType.CopyrightType

/**
 * Created by mgcuthbert on 7/11/2015.
 */
object CopyrightType extends Enumeration {
  type CopyrightType = Value
  val C, P = Value
}

case class Copyright(text:String,           //The copyright text for this album.
                     `type`:CopyrightType   //The type of copyright: C = the copyright, P = the sound recording (performance) copyright.
)