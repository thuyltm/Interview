
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object scramblegame extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<style>
    ul """),format.raw/*7.8*/("""{"""),format.raw/*7.9*/("""
        """),format.raw/*8.9*/("""list-style: circle;
    """),format.raw/*9.5*/("""}"""),format.raw/*9.6*/("""
"""),format.raw/*10.1*/("""</style>
<body>
    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container-fluid">
                <a id="titleLink" class="brand" href="/"></a>
            </div>
        </div>
    </div>
    <div id="content" class="container">
    </div>

    <div id="word-list">
    </div>

    <script type="text/template" id="game_content">
        <button id="getNextGame">Next</button>
        <button id="showResult">Show Result</button>
        <label>Correct <%- correctAnswers %>/ <%- totalAnswers %></label>
        <div class="well">
            <h1><%- value %></h1>
        </div>
    </script>

  <script type="text/template" id="item-template">
     <label><%- value %></label>
  </script>

  <script id="guess_word_template" type="text/template">
     <label <%= correct ? 'style="color:green;"' : '' %> ><%= value %></label>
  </script>


    <script type="text/javascript" src=""""),_display_(/*43.42*/routes/*43.48*/.Assets.versioned("lib/jquery/jquery.js")),format.raw/*43.89*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*44.42*/routes/*44.48*/.Assets.versioned("lib/underscorejs/underscore.js")),format.raw/*44.99*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*45.42*/routes/*45.48*/.Assets.versioned("lib/backbonejs/backbone.js")),format.raw/*45.95*/(""""></script>
    <script type="text/javascript" src=""""),_display_(/*46.42*/routes/*46.48*/.Assets.versioned("javascripts/main.js")),format.raw/*46.88*/(""""></script>
</body>
</html>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Sep 16 15:27:25 ICT 2017
                  SOURCE: /home/thuy1/git/InceptionLab/scramblegame/app/views/scramblegame.scala.html
                  HASH: 72bcf923eca5f44ed48e52a1611d3afaf09a9dd2
                  MATRIX: 1037->0|1136->73|1163->74|1198->83|1248->107|1275->108|1303->109|2267->1046|2282->1052|2344->1093|2424->1146|2439->1152|2511->1203|2591->1256|2606->1262|2674->1309|2754->1362|2769->1368|2830->1408
                  LINES: 33->1|39->7|39->7|40->8|41->9|41->9|42->10|75->43|75->43|75->43|76->44|76->44|76->44|77->45|77->45|77->45|78->46|78->46|78->46
                  -- GENERATED --
              */
          