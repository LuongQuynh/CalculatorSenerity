package LearningSerenity.actions;

import LearningSerenity.ui.ElementCaculator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Input implements Interaction {
    int value;
    public Input(int value)
    {
        this.value=value;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        String strNumber = String.valueOf(this.value);
        for(int i=0; i< strNumber.length(); i++)
        {
            //ElementCaculator.NUMBER.of(String.valueOf(strNumber.charAt(i))).resolveFor(actor).click();
            actor.attemptsTo(
                    Click.on(ElementCaculator.NUMBER.of(String.valueOf(strNumber.charAt(i))))
            );

        }
    }

    public static Interaction theNumber(int value)
    {
        return instrumented(Input.class, value);
    }
}
