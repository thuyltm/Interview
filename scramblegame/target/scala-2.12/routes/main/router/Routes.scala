
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/thuy1/git/InceptionLab/scramblegame/conf/routes
// @DATE:Sat Sep 16 15:18:21 ICT 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  ScrambleGameController_1: controllers.ScrambleGameController,
  // @LINE:11
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    ScrambleGameController_1: controllers.ScrambleGameController,
    // @LINE:11
    Assets_0: controllers.Assets
  ) = this(errorHandler, ScrambleGameController_1, Assets_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ScrambleGameController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.ScrambleGameController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """scramblegame/next""", """controllers.ScrambleGameController.getNextGame"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """scramblegame/compoundWord/""" + "$" + """word<[^/]+>""", """controllers.ScrambleGameController.getCompoundWord(word:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_ScrambleGameController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_ScrambleGameController_index0_invoker = createInvoker(
    ScrambleGameController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ScrambleGameController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_ScrambleGameController_getNextGame1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("scramblegame/next")))
  )
  private[this] lazy val controllers_ScrambleGameController_getNextGame1_invoker = createInvoker(
    ScrambleGameController_1.getNextGame,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ScrambleGameController",
      "getNextGame",
      Nil,
      "GET",
      this.prefix + """scramblegame/next""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_ScrambleGameController_getCompoundWord2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("scramblegame/compoundWord/"), DynamicPart("word", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ScrambleGameController_getCompoundWord2_invoker = createInvoker(
    ScrambleGameController_1.getCompoundWord(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ScrambleGameController",
      "getCompoundWord",
      Seq(classOf[String]),
      "GET",
      this.prefix + """scramblegame/compoundWord/""" + "$" + """word<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned3_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_ScrambleGameController_index0_route(params) =>
      call { 
        controllers_ScrambleGameController_index0_invoker.call(ScrambleGameController_1.index)
      }
  
    // @LINE:7
    case controllers_ScrambleGameController_getNextGame1_route(params) =>
      call { 
        controllers_ScrambleGameController_getNextGame1_invoker.call(ScrambleGameController_1.getNextGame)
      }
  
    // @LINE:8
    case controllers_ScrambleGameController_getCompoundWord2_route(params) =>
      call(params.fromPath[String]("word", None)) { (word) =>
        controllers_ScrambleGameController_getCompoundWord2_invoker.call(ScrambleGameController_1.getCompoundWord(word))
      }
  
    // @LINE:11
    case controllers_Assets_versioned3_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned3_invoker.call(Assets_0.versioned(path, file))
      }
  }
}
