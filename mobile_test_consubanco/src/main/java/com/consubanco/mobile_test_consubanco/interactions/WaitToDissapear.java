package com.consubanco.mobile_test_consubanco.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;

public class WaitToDissapear implements Interaction {
    private Target target;

    public WaitToDissapear(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Wait.until(
                WebElementQuestion.the(target) , WebElementStateMatchers.isNotVisible()
        ).forNoMoreThan(30).seconds());
    }

    public static WaitToDissapear theTarget(Target target){
        return Tasks.instrumented(WaitToDissapear.class, target);
    }
}
