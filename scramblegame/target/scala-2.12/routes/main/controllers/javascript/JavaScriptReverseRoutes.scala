
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/thuy1/git/InceptionLab/scramblegame/conf/routes
// @DATE:Sat Sep 16 15:18:21 ICT 2017

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:11
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseScrambleGameController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def getCompoundWord: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ScrambleGameController.getCompoundWord",
      """
        function(word0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "scramblegame/compoundWord/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("word", word0))})
        }
      """
    )
  
    // @LINE:7
    def getNextGame: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ScrambleGameController.getNextGame",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "scramblegame/next"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ScrambleGameController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }


}
