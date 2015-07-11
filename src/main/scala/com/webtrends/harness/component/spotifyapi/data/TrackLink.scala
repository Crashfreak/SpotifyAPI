package com.webtrends.harness.component.spotifyapi.data

/**
 * Created by mgcuthbert on 7/11/2015.
 */
case class TrackLink(external_urls:Map[String, String], //Known external URLs for this track.
                     href:String,                       //A link to the Web API endpoint providing full details of the track.
                     id:String,                         //The Spotify ID for the track.
                     uri:String                         //The Spotify URI for the track.
)
