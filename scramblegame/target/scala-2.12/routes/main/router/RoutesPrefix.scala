
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/thuy1/git/InceptionLab/scramblegame/conf/routes
// @DATE:Sat Sep 16 15:18:21 ICT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
