package com.webtrends.harness.component.spotifyapi.data

/**
 * Created by mgcuthbert on 5/26/2015.
 */
case class Artist(id:String,                          //The Spotify ID for the artist.
                  external_urls:Map[String, String],  //Known external URLs for this artist.
                  followers: Followers,               //Information about the followers of the artist.
                  genres:List[String],                //A list of the genres the artist is associated with. For example: "Prog Rock", "Post-Grunge". (If not yet classified, the array is empty.)
                  href:String,                        //A link to the Web API endpoint providing full details of the artist.
                  images:List[Image],                 //Images of the artist in various sizes, widest first.
                  name:String,                        //The name of the artist
                  popularity:Int,                     //The popularity of the artist. The value will be between 0 and 100, with 100 being the most popular. The artist's popularity is calculated from the popularity of all the artist's tracks.
                  uri:String                          //The Spotify URI for the artist.
) extends SpotifyObject

case class SimplifiedArtist(id:String,
                            external_urls:Map[String, String],
                            href:String,
                            name:String,
                            uri:String
) extends SpotifyObject