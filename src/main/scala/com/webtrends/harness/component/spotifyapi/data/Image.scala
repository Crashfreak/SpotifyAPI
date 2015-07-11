package com.webtrends.harness.component.spotifyapi.data

/**
 * Created by mgcuthbert on 7/11/2015.
 */
case class Image(height:Int,  //The image height in pixels. If unknown: null or not returned.
                  url:String, //The source URL of the image.
                  width:Int   //The image width in pixels. If unknown: null or not returned.
)
