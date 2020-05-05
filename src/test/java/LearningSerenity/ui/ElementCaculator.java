package LearningSerenity.ui;

import LearningSerenity.tasks.Caculate;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ElementCaculator {

    // NUMBER
    public static Target NUMBER = Target.the("the number {0}")
            .locatedBy("//span[@aria-label='{0}']");

    //OPERATOR
    public static Target MUL_OPERATOR = Target.the("mul").located(By.xpath("//span[@aria-label='Times']"));
    public static Target ADD_OPERATOR = Target.the("add").located(By.xpath("//span[@aria-label='Plus']"));
    public static Target SUB_OPERATOR = Target.the("sub").located(By.xpath("//span[@aria-label='Minus']"));
    public static Target DIV_OPERATOR = Target.the("div").located(By.xpath("//span[@aria-label='Divide']"));

    // RESULT
    public static Target RESULT = Target.the("operand result")
            .located(By.cssSelector("div.dcg-basic-expression-value .dcg-mq-root-block"));

    // GET OPERATOR

    public static Target GET_OPERATOR(Caculate.Operator operator){
        switch (operator){
            case ADD:
            return ADD_OPERATOR;
            case SUB:
                return SUB_OPERATOR;
            case MUL:
                return MUL_OPERATOR;
            default:
                return DIV_OPERATOR;

        }
    }
    public static Target GET_NUMBER(int number){
       // return Target.the("number {0}").locatedBy("//div[@aria-label='equals {0}']");
        return Target.the("the number #"+ number)
                .located(By.xpath("//*[@dcg-command=\""+number+"\"]"));
    }




}
