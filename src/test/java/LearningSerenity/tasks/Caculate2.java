package LearningSerenity.tasks;


import LearningSerenity.actions.Input;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class Caculate2 implements Task {
    int firsNumber;
    int secondNumber;
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Input.theNumber(firsNumber)
        );
    }
}
