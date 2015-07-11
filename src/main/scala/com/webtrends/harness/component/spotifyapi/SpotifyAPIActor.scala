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
import com.webtrends.harness.component.spotifyapi.data.{Track, Artist, Album}
import com.webtrends.harness.health.HealthComponent
import dispatch._, Defaults._
import net.liftweb.json._
import net.liftweb.json.Extraction._

import scala.concurrent.{Promise, Future}
import scala.util.{Success, Failure}

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
  val PARAM_ALBUMS = "albums"
  val PARAM_ARTISTS = "artists"
  val PARAM_TRACKS = "tracks"
}

class SpotifyAPIActor(apiVersion:String="v1") extends HActor {

  val apiPrefix = SpotifyAPIActor.hostname / apiVersion

  override def receive = super.receive orElse {
    case GetAlbums(ids) => pipe(getAlbums(ids)) to sender
    case GetAlbumTracks(id) =>
    case GetArtists(ids) => pipe(getArtists(ids)) to sender
    case GetArtistAlbums(id) =>
    case GetArtistTopTracks(id) =>
    case GetArtistRelatedArtists(id) =>
    case GetTracks(ids:List[String]) => pipe(getTracks(ids)) to sender
    case Search(t, searchString, limit, offset) =>
  }

  private[spotifyapi] def service[T](req:Req, key:Option[String]=None) : Future[List[T]] = {
    val p = Promise[List[T]]()
    Http(req OK as.String).either onComplete {
      case Success(s) => s match {
        case Right(resp) => p success objectExtraction[T](resp, key)
        case Left(t) => p failure t
      }
      case Failure(f) => p failure f
    }
    p.future
  }

  private[spotifyapi] def objectExtraction[T](resp:String, key:Option[String]=None) : List[T] = {
    val json = parse(resp)
    key match {
      case Some(k) => extract[List[T]](json \ k)
      case None => List(extract[T](json))
    }
  }

  def getAlbums(ids:List[String]) : Future[List[Album]] = _get[Album](ids, SpotifyAPIActor.PARAM_ALBUMS)

  def getArtists(ids:List[String]) : Future[List[Artist]] = _get[Artist](ids, SpotifyAPIActor.PARAM_ARTISTS)

  def getTracks(ids:List[String]) : Future[List[Track]] = _get[Track](ids, SpotifyAPIActor.PARAM_TRACKS)

  private[spotifyapi] def _get[T](ids:List[String], key:String) : Future[List[T]] = {
    if (ids == null || ids.length == 0) {
      Future.failed(new IllegalArgumentException("Minimum one id required"))
    } else {
      val albumsReq = apiPrefix / key
      val reqVals = ids.length match {
        case 1 => (albumsReq / ids.head, None)
        case _ => (albumsReq <<? Map("ids" -> ids.mkString(",")), Some(key))
      }
      service[T](reqVals._1, reqVals._2)
    }
  }

  // This should probably be overriden to get some custom information about the health of this actor
  override protected def getHealth: Future[HealthComponent] = super.getHealth
}