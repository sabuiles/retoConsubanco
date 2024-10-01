package com.consubanco.demoblaze.tasks;

import com.consubanco.demoblaze.userinterfaces.PopUpComponent;
import com.consubanco.demoblaze.userinterfaces.TopMenuComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Map;

public class Login implements Task {
    private Map<String, String> datosUsuario;

    public Login(Map<String, String> datosUsuario) {
        this.datosUsuario = datosUsuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(TopMenuComponent.BTN_LOGIN),
                Enter.theValue(datosUsuario.get("usuario")).into(PopUpComponent.TXT_LOGIN_USERNAME),
                Enter.theValue(datosUsuario.get("clave")).into(PopUpComponent.TXT_LOGIN_PASSWORD),
                Click.on(PopUpComponent.BTN_LOGIN));
    }

    public static Login conDatosUsuario(Map<String, String> datosUsuario){
        return Tasks.instrumented(Login.class, datosUsuario);
    }
}
