package com.webtrends.harness.component.spotifyapi.data

import com.webtrends.harness.component.spotifyapi.data.AlbumType.AlbumType
import com.webtrends.harness.component.spotifyapi.data.DatePrecision.DatePrecision

/**
 * Created by mgcuthbert on 5/26/2015.
 */
object AlbumType extends Enumeration {
  type AlbumType = Value
  val album, single, compilation = Value
}

object DatePrecision extends Enumeration {
  type DatePrecision = Value
  val year, month, day = Value
}

case class Album(id:String,                           //The Spotify ID for the album.
                 album_type:AlbumType,                //The type of the album: one of "album", "single", or "compilation".
                 artists:List[SimplifiedArtist],      //The artists of the album. Each artist object includes a link in href to more detailed information about the artist.
                 available_markets:List[String],      //The markets in which the album is available: ISO 3166-1 alpha-2 country codes. Note that an album is considered available in a market when at least 1 of its tracks is available in that market.
                 copyrights:List[Copyright],          //The copyright statements of the album.
                 external_ids:Map[String, String],    //Known external IDs for the album.
                 external_urls:Map[String, String],   //Known external URLs for this album.
                 genres:List[String],                 //A list of the genres used to classify the album. For example: "Prog Rock", "Post-Grunge". (If not yet classified, the array is empty.)
                 href:String,                         //A link to the Web API endpoint providing full details of the album.
                 images:List[Image],                  //The cover art for the album in various sizes, widest first.
                 name:String,                         //The name of the album.
                 popularity:Int,                      //The popularity of the album. The value will be between 0 and 100, with 100 being the most popular. The popularity is calculated from the popularity of the album's individual tracks.
                 release_date:String,                 //The date the album was first released, for example "1981-12-15". Depending on the precision, it might be shown as "1981" or "1981-12".
                 release_date_precision:DatePrecision,//The precision with which release_date value is known: "year", "month", or "day".
                 tracks:List[Track],                  //The tracks of the album.
                 uri:String                           //The Spotify URI for the album.
) extends SpotifyObject

case class SimplifiedAlbum(id:String,
                           album_type:AlbumType,
                           available_markets:List[String],
                           external_urls:Map[String, String],
                           href:String,
                           images:List[Image],
                           name:String,
                           uri:String
) extends SpotifyObject

