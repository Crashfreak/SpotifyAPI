package com.webtrends.harness.component.spotifyapi.data

/**
 * Created by mgcuthbert on 5/26/2015.
 */
case class Track(id:String,                             //The Spotify ID for the track.
                 album:SimplifiedAlbum,                 //The album on which the track appears. The album object includes a link in href to full information about the album.
                 artists:List[Artist],                  //The artists who performed the track. Each artist object includes a link in href to more detailed information about the artist.
                 available_markets:List[String],        //A list of the countries in which the track can be played, identified by their ISO 3166-1 alpha-2 code.
                 disc_number:Int,                       //The disc number (usually 1 unless the album consists of more than one disc).
                 duration_ms:Int,                       //The track length in milliseconds.
                 explicit:Boolean,                      //Whether or not the track has explicit lyrics (true = yes it does; false = no it does not OR unknown).
                 external_ids:Map[String, String],      //Known external IDs for the track.
                 external_urls:Map[String, String],     //Known external URLs for this track.
                 href:String,                           //A link to the Web API endpoint providing full details of the track.
                 is_playable:Boolean,                   //Part of the response when Track Relinking is applied. If true, the track is playable in the given market. Otherwise false.
                 linked_from:TrackLink,                 //Part of the response when Track Relinking is applied, and the requested track has been replaced with different track. The track in the linked_from object contains information about the originally requested track.
                 name:String,                           //The name of the track.
                 popularity:Int,                        //The popularity of the track. The value will be between 0 and 100, with 100 being the most popular.
                                                        // The popularity of a track is a value between 0 and 100, with 100 being the most popular.
                                                        // The popularity is calculated by algorithm and is based, in the most part, on the total number of plays
                                                        // the track has had and how recent those plays are. Generally speaking, songs that are being played a lot
                                                        // now will have a higher popularity than songs that were played a lot in the past. Duplicate tracks
                                                        // (e.g. the same track from a single and an album) are rated independently. Artist and album popularity is
                                                        // derived mathematically from track popularity. Note that the popularity value may lag actual popularity
                                                        // by a few days: the value is not updated in real time.
                 preview_url:String,                    //A link to a 30 second preview (MP3 format) of the track.
                 track_number:Int,                      //The number of the track. If an album has several discs, the track number is the number on the specified disc.
                 uri:String                             //The Spotify URI for the track.
) extends SpotifyObject

case class SimplifiedTrack(id:String,
                           artists:List[Artist],
                           available_markets:List[String],
                           disc_number:Int,
                           duration_ms:Int,
                           explicit:Boolean,
                           external_urls:Map[String, String],
                           href:String,
                           is_playable:Boolean,
                           linked_from:TrackLink,
                           name:String,
                           preview_url:String,
                           track_number:Int,
                           uri:String
) extends SpotifyObject
