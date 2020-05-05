package LearningSerenity.questions;

import LearningSerenity.ui.ElementCaculator;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CalculatorResult implements Question {


    @Override
    public Object answeredBy(Actor actor) {
        WebElementFacade result = ElementCaculator.RESULT.resolveFor(actor);
        return result.getText();
    }

}
