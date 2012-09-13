package controllers

import play.api._
import libs.iteratee._
import play.api.libs.json._
import play.api.libs.json.Json._
import play.api.mvc._

object Application extends Controller {

    var state = true

    def index = Action {
        Ok( views.html.index() )
    }

    def check = Action {
        var event = ""

        if( state ) {
            state = false
            event = "event: init\ndata: \n\n"
        } else {
            state = true
            event = "event: ok\ndata: \n\n"
        }

        println( "test event : " + event )

        Ok( event ).as( "text/event-stream" )
    }

    def initBuild( idBuild: String ) = Action {
        Ok( idBuild )
    }
    
    def endBuild( urlXmlResult: String ) = Action {
        Ok( urlXmlResult )
    }
}