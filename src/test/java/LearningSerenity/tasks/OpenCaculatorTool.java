package LearningSerenity.tasks;

import LearningSerenity.ui.CaculatorOnlinePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenCaculatorTool implements Task{




    CaculatorOnlinePage caculatorOnlinePage;
    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(caculatorOnlinePage)
        );
    }
}
