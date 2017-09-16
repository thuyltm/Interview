
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/thuy1/git/InceptionLab/scramblegame/conf/routes
// @DATE:Sat Sep 16 15:18:21 ICT 2017

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:11
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def versioned(file:Asset): Call = {
      implicit val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:6
  class ReverseScrambleGameController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def getCompoundWord(word:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "scramblegame/compoundWord/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("word", word)))
    }
  
    // @LINE:7
    def getNextGame(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "scramblegame/next")
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }


}
