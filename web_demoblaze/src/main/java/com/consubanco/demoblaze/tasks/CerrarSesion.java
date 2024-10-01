package com.consubanco.demoblaze.tasks;

import com.consubanco.demoblaze.userinterfaces.TopMenuComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

public class CerrarSesion implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(TopMenuComponent.BTN_LOG_OUT),
                Ensure.that(TopMenuComponent.BTN_LOG_OUT).isNotDisplayed());
    }

    public static CerrarSesion actual(){
        return Tasks.instrumented(CerrarSesion.class);
    }
}
