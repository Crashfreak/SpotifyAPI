/*
 * Copyright (c) 2014. Webtrends (http://www.webtrends.com)
 * @author cuthbertm on 11/20/14 12:23 PM
 */
package com.webtrends.harness.component.spotifyapi

import akka.actor.ActorRef
import com.webtrends.harness.component.Component

trait SpotifyAPI { this: Component =>

  var SpotifyAPIRef:Option[ActorRef] = None

  def startSpotifyAPI : ActorRef = {
    SpotifyAPIRef = Some(context.actorOf(SpotifyAPIActor.props, SpotifyAPI.SpotifyAPIName))
    SpotifyAPIRef.get
  }
}

object SpotifyAPI {
  val SpotifyAPIName = "SpotifyAPI"
}