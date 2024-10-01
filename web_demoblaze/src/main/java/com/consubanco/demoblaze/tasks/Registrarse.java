package com.consubanco.demoblaze.tasks;

import com.consubanco.demoblaze.userinterfaces.PopUpComponent;
import com.consubanco.demoblaze.userinterfaces.TopMenuComponent;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Map;

public class Registrarse implements Task {
    private Map<String, String> datosUsuario;

    public Registrarse(Map<String, String> datosUsuario) {
        this.datosUsuario = datosUsuario;
    }

    @Step("{0} se registra con los datos de usuario #datosUsuario")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(TopMenuComponent.BTN_SIGN_UP),
                Enter.theValue(datosUsuario.get("usuario")).into(PopUpComponent.TXT_SIGNUP_USERNAME),
                Enter.theValue(datosUsuario.get("clave")).into(PopUpComponent.TXT_SIGNUP_PASSWORD),
                Click.on(PopUpComponent.BTN_SIGN_UP),
                WaitUntil.the(ExpectedConditions.alertIsPresent()).forNoMoreThan(Duration.ofSeconds(3)));
    }

    public static Registrarse conDatosUsuario(Map<String, String> datosUsuario){
        return Tasks.instrumented(Registrarse.class, datosUsuario);
    }
}
