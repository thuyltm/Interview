package context;


import javax.inject.Inject;

import play.api.libs.concurrent.CustomExecutionContext;
import akka.actor.ActorSystem;

public class ScrambleGameExecutionContext extends CustomExecutionContext {
    @Inject
    public ScrambleGameExecutionContext(ActorSystem actorSystem) {
        super(actorSystem, "word.repository");
    }
}