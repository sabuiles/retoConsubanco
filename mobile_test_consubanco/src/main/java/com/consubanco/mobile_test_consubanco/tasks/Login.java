package com.consubanco.mobile_test_consubanco.tasks;


import com.consubanco.mobile_test_consubanco.interactions.WaitToDissapear;
import com.consubanco.mobile_test_consubanco.userinterface.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.Map;

public class Login implements Task {

    private Map<String,String> credenciales;

    public Login(Map<String, String> credenciales) {
        this.credenciales = credenciales;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(credenciales.get("usuario")).into(LoginPage.TXT_USERNAME),
                Enter.theValue(credenciales.get("clave")).into(LoginPage.TXT_CLAVE),
                Click.on(LoginPage.BTN_INICIAR_SESION),
                WaitToDissapear.theTarget(LoginPage.LOADER));
    }

    public static Login conCredenciales(Map<String, String> credenciales){
        return Tasks.instrumented(Login.class, credenciales);
    }
}
