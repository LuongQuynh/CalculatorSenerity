package LearningSerenity.tasks;

import LearningSerenity.actions.Input;
import LearningSerenity.ui.ElementCaculator;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Caculate implements Task {
    public enum Operator{
        ADD,SUB,MUL,DIV;
    }
    private int firstNumber;
    private int secondNumber;
    private Operator operator;
    public static CaculateBuilder Add(){
        return new CaculateBuilder(Operator.ADD);
    }
    public static CaculateBuilder Subtract(){
        return new CaculateBuilder(Operator.SUB);
    }
    public static CaculateBuilder Multiple(){
        return new CaculateBuilder(Operator.MUL);
    }
    public static CaculateBuilder Divide(){
        return new CaculateBuilder(Operator.DIV);
    }
    public Caculate(int firstNumber,Operator operator,int secondNumber ){
        this.operator = operator;
        this.firstNumber=firstNumber;
        this.secondNumber=secondNumber;

    }



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Input.theNumber(this.firstNumber),
                //Click.on(ElementCaculator.GET_NUMBER(this.firstNumber)),
                Click.on(ElementCaculator.GET_OPERATOR(this.operator)),
                Input.theNumber(this.secondNumber)
                //Click.on(ElementCaculator.GET_NUMBER(this.secondNumber))
        );

    }

    public static class CaculateBuilder{
        private Operator operator;
        private int firstNumber;
        public CaculateBuilder(Operator operator){
            this.operator= operator;
        }
        public CaculateBuilder between(int firstNumber){
            this.firstNumber= firstNumber;
            return this;
        }
        public Caculate and(int secondNumber){
            return instrumented(Caculate.class,this.firstNumber,this.operator,secondNumber);
        }

    }
}
