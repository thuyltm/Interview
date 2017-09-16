
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/thuy1/git/InceptionLab/scramblegame/conf/routes
// @DATE:Sat Sep 16 15:18:21 ICT 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseScrambleGameController ScrambleGameController = new controllers.ReverseScrambleGameController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseScrambleGameController ScrambleGameController = new controllers.javascript.ReverseScrambleGameController(RoutesPrefix.byNamePrefix());
  }

}
