package com.webtrends.harness.component.spotifyapi.data

/**
 * Created by mgcuthbert on 7/11/2015.
 */
case class Followers(href:String, //A link to the Web API endpoint providing full details of the followers; null if not available. Please note that this will always be set to null, as the Web API does not support it at the moment.
                     total:Int    //The total number of followers.
)
