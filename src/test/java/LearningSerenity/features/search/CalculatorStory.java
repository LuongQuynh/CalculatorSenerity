package LearningSerenity.features.search;

import LearningSerenity.actions.Input;
import LearningSerenity.questions.CalculatorResult;
import LearningSerenity.tasks.Caculate;
import LearningSerenity.tasks.Caculate2;
import LearningSerenity.tasks.OpenCaculatorTool;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class CalculatorStory {
    Actor anna = Actor.named("anna");
    @Managed(uniqueSession = true)
    public WebDriver herBrowser;
    @Steps
    OpenCaculatorTool openCaculatorTool;

    @Before
    public void annaCanBrowserTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void show_result_of_additional_between_any_two_numbers() {
        givenThat(anna).wasAbleTo(openCaculatorTool);
        when(anna).attemptsTo(
                Caculate.Add().between(60).and(40)
        );
        then(anna).should(
                seeThat(new CalculatorResult(), endsWith("10"))
        );

    }

    @Test
    @Ignore
    public void show_result_of_additional_between_two_numbers() {
        givenThat(anna).wasAbleTo(openCaculatorTool);
        when(anna).attemptsTo(
                Caculate.Add().between(6).and(4)

        );
        then(anna).should(
                seeThat(new CalculatorResult(), endsWith("10"))
        );

    }

    @Test
    public void subtract_two_numbers() {
        givenThat(anna).wasAbleTo(openCaculatorTool);
        when(anna).attemptsTo(
                Caculate.Subtract().between(9).and(6)

        );
        then(anna).should(
                seeThat(new CalculatorResult(), endsWith("3"))
        );
    }

    @Test
    public void multiple_two_numbers() {
        givenThat(anna).attemptsTo(openCaculatorTool);
        when(anna).attemptsTo(
                Caculate.Multiple().between(3).and(4)
        );
        then(anna).should(
                seeThat(new CalculatorResult(), endsWith("12"))
        );
    }

    @Test
    public void divide_two_numbers() {
        givenThat(anna).attemptsTo(openCaculatorTool);
        when(anna).attemptsTo(
                Caculate.Divide().between(6).and(3)
        );
        then(anna).should(
                seeThat(new CalculatorResult(), endsWith("2"))
        );

    }


}
