/*
 * Copyright (c) 2014. Webtrends (http://www.webtrends.com)
 * @author cuthbertm on 11/20/14 12:23 PM
 */
package com.webtrends.harness.component.spotifyapi

import akka.actor._
import akka.pattern._
import com.webtrends.harness.app.HActor
import com.webtrends.harness.component.spotifyapi.SpotifyAPIActor.Messages._
import com.webtrends.harness.component.spotifyapi.SpotifyType.SpotifyType
import com.webtrends.harness.health.HealthComponent
import dispatch.host
import net.liftweb.json.JValue

import scala.concurrent.Future

object SpotifyAPIActor {
  def props = Props(classOf[SpotifyAPIActor])

  object Messages {
    case class GetAlbums(ids:List[String])
    case class GetAlbumTracks(id:String)
    case class GetArtists(ids:List[String])
    case class GetArtistAlbums(id:String)
    case class GetArtistTopTracks(id:String)
    case class GetArtistRelatedArtists(id:String)
    case class GetTracks(id:List[String])
    case class Search(`type`:SpotifyType, searchString:String, limit:Int, offset:Int)
  }

  val hostname = host("spotify.com")

  val PARAM_VERSION = "v1"
  val PARAM_ALBUMS = "albums"
  val PARAM_ARTISTS = "artists"
  val PARAM_TRACKS = "tracks"
}

class SpotifyAPIActor extends HActor {

  override def receive = super.receive orElse {
    case GetAlbums(ids) => pipe(getAlbums(ids)) to sender
    case GetAlbumTracks(id) =>
    case GetArtists(ids) =>
    case GetArtistAlbums(id) =>
    case GetArtistTopTracks(id) =>
    case GetArtistRelatedArtists(id) =>
    case GetTracks(id:List[String]) =>
    case Search(t, searchString, limit, offset) =>
  }

  private[spotifyapi] def spotifyService

  def getAlbums(ids:List[String]) : Future[JValue] = {
    val res:Future[Either[Throwable, JValue]] =
  }

  // This should probably be overriden to get some custom information about the health of this actor
  override protected def getHealth: Future[HealthComponent] = super.getHealth
}